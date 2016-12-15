package ch04.ex08;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloApp extends Application {

	@FXML
	private Label messageLabel;

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Hello.fxml"));
			//messageLabel.setText("test!");
			Scene scene = new Scene(root, 200, 100);
			stage.setScene( scene );
			stage.show();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HelloApp.launch(args);
	}
}
