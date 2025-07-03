package TestFactory;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.net.URI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class NewApp extends Application {
@Override
public void start(Stage primaryStage) throws Exception {
primaryStage.setTitle("My Apps");
MenuItem menu1 = new MenuItem("Option 1");
MenuItem menu2 = new MenuItem("Option 2");
MenuItem menu3 = new MenuItem("Option 3");
RadioButton r = new RadioButton("Radio");
MenuButton menu = new MenuButton("Options: ", null, menu1, menu2,menu3);
Text text = new Text("Wofür ist hier ein Text? ");
TextField tf= new TextField();
TextField tf2 = new TextField();
text.setFont(Font.font("Arial", FontWeight.BOLD,26));
Text text2 = new Text("Zweiter Text");
text2.setFont(Font.font("Arial", 26));
text2.setFill(Color.BLUE);
Hyperlink link = new Hyperlink("https://www.youtube.com/");
link.setText("Hier ist ein Link");
link.setTextFill(Color.RED);
link.setOnAction(e -> {
    try {
        Desktop.getDesktop().browse(new URI("https://www.youtube.com/"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
});



GridPane v = new GridPane();
Scene sc = new Scene(v, 400,200);
v.addRow(0,text,tf);
v.addRow(1, text2, tf2);
v.addRow(3, link, menu);
v.addRow(4, r);



primaryStage.setScene(sc);
primaryStage.show();

	
}
public static void main(String[] args) {
	Application.launch();
	
}
}

