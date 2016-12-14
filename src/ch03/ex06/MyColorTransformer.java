package ch03.ex06;

import java.io.File;
import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyColorTransformer extends Application {

	private final String imageFilePath = "file:" + "src" + File.separator + "ch03" + File.separator + "ex06" + File.separator + "penguin.jpeg";

	public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));

        return out;
    }

	@Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(imageFilePath);
        Image image2 = transform(image, (color, factor) -> color.deriveColor(0, 1, factor, 1) , 1.2);
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
        stage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}
}
