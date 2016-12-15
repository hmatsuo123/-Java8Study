package ch04.ex09;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetAnimation extends Application {

	private final int WIDTH = 500;
    private final int HEIGHT = 350;
    private final int RADIUS_X = 220;
    private final int RADIUS_Y = 140;

	@Override
    public void start(Stage stage) throws Exception {
        Circle earth = new Circle(20);
        earth.setFill(Color.BLUE);
        earth.centerXProperty().bind(Bindings.divide(stage.widthProperty(), 2));
        earth.centerYProperty().bind(Bindings.divide(stage.heightProperty(), 2));

        Circle moon = new Circle(10);
        moon.setFill(Color.YELLOW);
        moon.centerXProperty().bind(Bindings.divide(stage.widthProperty(), 2));
        moon.centerYProperty().bind(Bindings.divide(stage.heightProperty(), 2));

        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(WIDTH / 2);
        ellipse.setCenterY(HEIGHT / 2);
        ellipse.setRadiusX(RADIUS_X);
        ellipse.setRadiusY(RADIUS_Y);

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(3000));
        pathTransition.setNode(moon);
        pathTransition.setPath(ellipse);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.play();

        Scene scene = new Scene(new Pane(earth, moon), WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

	public static void main(String[] args) {
		PlanetAnimation.launch();
    }
}
