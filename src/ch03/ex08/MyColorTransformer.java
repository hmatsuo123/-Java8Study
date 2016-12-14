package ch03.ex08;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyColorTransformer extends Application {

	private final String imageFilePath = "file:" + "src" + File.separator + "ch03" + File.separator + "ex05" + File.separator + "penguin.jpeg";

	public static Image transform(Image in, ColorTransformer f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));

        return out;
    }

	@Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(imageFilePath);
        Image image2 = transform(image, createBorder(image, 15, Color.AQUAMARINE));
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
        stage.show();
    }

	public static ColorTransformer createBorder(Image image, int size, Color color) {
        return (x, y, c) -> x < size || x > image.getWidth() - size || y < size || y > image.getHeight() - size ? color : c;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
