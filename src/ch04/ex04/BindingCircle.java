package ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BindingCircle extends Application {

	@Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle();
        circle.setFill(Color.YELLOW);
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane);
        circle.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
        circle.centerYProperty().bind(Bindings.divide(scene.heightProperty(), 2));
        circle.radiusProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).divide(2));
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Full Moon");
        stage.show();
    }

	public static void main(String[] args) {
		BindingCircle.launch();
    }
}
