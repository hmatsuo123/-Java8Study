package ch04.ex05;

import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyApplication  extends Application{

	private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 100;
    private static final int DEFAULT_VALUE = 50;
    private double progress;

	@Override
    public void start(Stage stage) {
		progress = 0.0;
        Button smaller = new Button("Smaller");
        Button larger = new Button("Larger");
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(progress);
        Pane pane = new Pane();
        pane.getChildren().addAll(progressBar);
        smaller.setOnAction(event -> {
        	progress -= 0.1;
        	progress = progress < 0.0 ? 0.0 : progress;
        	progressBar.setProgress(progress);});
        larger.setOnAction(event -> {
        	progress += 0.1;
        	progress = progress > 1.0 ? 1.0 : progress;
        	progressBar.setProgress(progress);});

        smaller.disableProperty().bind(observe(
                t -> progressBar.getProgress() <= 0.0,
                progressBar.progressProperty()));
        larger.disableProperty().bind(observe(
        		t -> progressBar.getProgress() >= 1.0,
                progressBar.progressProperty()));

        HBox box = new HBox(10, smaller, pane, larger);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.show();
    }

	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		return Bindings.createObjectBinding(() -> f.apply(t.getValue()), t);
	}

	public static void main(String[] args) {
		MyApplication.launch();
    }
}
