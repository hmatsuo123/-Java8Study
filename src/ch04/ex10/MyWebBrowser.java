package ch04.ex10;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyWebBrowser extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Button backButton = new Button("戻る");
		TextField urlText = new TextField("https://google.com");
		urlText.minWidth(500);
		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();
		engine.load(urlText.getText());
		backButton.setOnAction(e -> {
			WebHistory history = engine.getHistory();
			int historyIdx = history.getCurrentIndex();
			ObservableList<WebHistory.Entry> entries = history.getEntries();
			if (historyIdx != 0) {
				history.go(-1);
				urlText.setText(entries.get(historyIdx - 1).getUrl());
			}
		});
		urlText.setOnAction(e -> {
			engine.load(urlText.getText());
		});
		engine.getLoadWorker().stateProperty().addListener((o, oldValue, newValue) -> {
			if (newValue == Worker.State.SUCCEEDED) {
				urlText.setText(engine.getLocation());
			}
		});
		HBox toolBar = new HBox(backButton, urlText);
		VBox wrapper = new VBox(toolBar, webView);
		stage.setScene(new Scene(wrapper));
		stage.show();
	}

    public static void main(String[] args) {
    	MyWebBrowser.launch();
    }
}
