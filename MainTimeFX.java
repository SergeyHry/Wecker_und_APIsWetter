package TestFactory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class MainTimeFX extends Application {

    private TextArea outputArea = new TextArea();
    private Countries selectedCountry;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        // Input
        TextField regionInput = new TextField();
        regionInput.setPromptText("Region eingeben: Europe/Amerika");

        TextField cityInput = new TextField();
        cityInput.setPromptText("Stadt eingeben[]");

        Button startButton = new Button("Start");

        outputArea.setEditable(false);
        outputArea.setWrapText(true);

        VBox root = new VBox(10, regionInput, cityInput, startButton, outputArea);
        root.setStyle("-fx-padding: 20;");

        startButton.setOnAction(e -> {
            String region = regionInput.getText();
            String city = cityInput.getText();

            FactoryMethod factory;
            if (region.equals("Europe")) {
                factory = new Europe();
            } else if (region.equals("Amerika")) {
                factory = new America();
            } else {
                outputArea.setText("Ungültige Region");
                return;
            }

            selectedCountry = factory.createCountriesBy(city);
            startUpdates();
        });

        primaryStage.setScene(new Scene(root, 400, 300));
    	root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Wetter & Zeit Info");
        primaryStage.show();
    }

    private void startUpdates() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> updateInfo()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateInfo() {
        if (selectedCountry == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append("Info: ").append(selectedCountry.getCity()).append("\n");
        sb.append("Wetter: ").append(WeatherService.getWeather(selectedCountry.getCity())).append("\n");
        selectedCountry.time();
        sb.append("Zeit: "+ selectedCountry.time());
        

        outputArea.setText(sb.toString());
    }
}






	



