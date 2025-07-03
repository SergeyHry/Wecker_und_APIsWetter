package TestFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.io.File;
import java.time.*;
public class RemindeMe extends Application {
	private LocalTime timegesetzt = null;
	private MediaPlayer mediaPlayer;


	
	
	
	@Override
	
	public void start(Stage primaryStage) throws Exception {
		//so wird Stage Erstellt: 
		Stage gifStage = new Stage();
		gifStage.initStyle(StageStyle.TRANSPARENT); //Fenster wird Transporent
		Image gif = new Image("file:///C:/Users/Student/Downloads/wake.gif"); //Pfad zum Bild
		ImageView imageView = new ImageView(gif); //Methode um das Bild zu zeigen
		imageView.setFitWidth(500); //Größe von Bild setzen
		

		StackPane gifRoot = new StackPane(imageView); //root erstellung. (da werden Knoten rein)
		gifRoot.setStyle("-fx-background-color: transparent;"); //die Scene wird ebenfals Transporent 
		
		
		
		
		
		Scene gifScene = new Scene(gifRoot, 400, 400);	//Scene Erstellen (root und größe von Fenster angeben)
		gifScene.setFill(Color.TRANSPARENT); 
		gifStage.setScene(gifScene); //die Scene wird  inizialisiert
		String bild = "C:/Users/Student/Downloads/wecker.png"; //Bild für Icon prinzip wie bei MediaPlayer
        Image img = new Image(new File(bild).toURI().toString()); 

		HBox root = new HBox();	//noch ein root aber HBox (Horizontale Box)
		Scene scene = new Scene (root, 400, 110);
		
		root.setSpacing(10); // Abstand von erstellten Knoten
		

		Spinner<Integer> stunden = new Spinner(0,23,12); //Spinner ein möglicher  Interface für Zeit Umstellen
		Spinner<Integer> minuten = new Spinner(0,59,0,1);
		stunden.setPrefSize(100, 20); //setPrefSize setzt die Breite und Höhe von Spinner
		minuten.setPrefSize(100, 20);
		Button button1  = new Button("Click me");
		root.getChildren().addAll(stunden,minuten,button1); //getChildren fügt Elemente in Root hinzu (muss noch ad/addAll() rein)
	
		button1.setOnAction(e->{										//setOnAction für Clickbare funktionierende Taste und benutzt Lambda. (mit dem Click werden die Werte von Spinner mit Methode spinner.getValue() geholt. 
			this.timegesetzt =  LocalTime.of(stunden.getValue(),minuten.getValue());
			if(button1.getText().equals("Click me")) {
			button1.setText("Done!");}
			else {
				button1.setText("Click me");
			}
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
			alertStage.getIcons().add(img);
			alert.setTitle("Info");
			alert.setContentText("der Weker ist auf " + this.timegesetzt +" umgestellt" );
			alert.showAndWait();
			
			
		System.out.println("Alarm gesetzt: " +this.timegesetzt);});	 //timegesetzt ist LocalTime type der als Instanz Variable deklariert wurde also braucht auch this. damit Compiler weißt welche Variable gemeint ist 
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> { //TimeLine um echtzeit die Uhrzeit zu prüfen 
		    LocalTime now = LocalTime.now();	
		    if (this.timegesetzt != null &&
		        now.getHour() == this.timegesetzt.getHour() &&
		        now.getMinute() == this.timegesetzt.getMinute()) {	//Bedienung für das Programm
		    	
		    	String musicFile =  "C:/Users/Student/Downloads/sound.wav";     // Music Pfad im String MediaPlayer ist ebenfals im Instanz anders das Song wird in kürze Abgebrochen :c 

				Media sound = new Media(new File(musicFile).toURI().toString());	//String in Media übergenem 
				 mediaPlayer = new MediaPlayer(sound);
		    	  mediaPlayer.play();
		        System.out.println("⏰ Zeit erreicht!");
		        this.timegesetzt = null; //die Zeit wird auf Null wert gesetzt 
		        //

			
		        gifStage.show();
		      
		      
		    }
		}));

	        timeline.setCycleCount(Timeline.INDEFINITE); //Timeline wird gestartet und läuft bis zum Schluss von Programm
	        timeline.play();

	        primaryStage.setTitle("Wake-Me-Up"); //Title Text auf dem Fenster
	        
	        primaryStage.getIcons().add(img); //getIcon holt sich das Iconbild
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        
	

	scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	
		
		}
	
	
public static void main (String[] args) {
	Application.launch(args); //ohne launch wir 
}
}
