package TestFactory;


	import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.stage.Stage;

	public class test extends Application {
	    @Override
	    public void start(Stage stage) {
	        Label label = new Label("JavaFX läuft!");
	        stage.setScene(new Scene(label, 300, 100));
	        stage.setTitle("Test");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}


