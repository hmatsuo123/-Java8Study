package ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJavaFx extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        String message = "Hello, JavaFX!";
        Label label = new Label(message);
        label.setFont(new Font(100));
        TextField textField = new TextField(message);
        label.textProperty().bind(textField.textProperty());
        textField.textProperty().addListener(s -> stage.sizeToScene());
        stage.setScene(new Scene(new VBox(label, textField)));
        stage.setTitle("Hello");
        stage.show();
    }

    public static void main(String[] args) {
    	HelloJavaFx.launch();
    }
}
