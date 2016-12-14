package ch03.ex11;

import java.io.File;
import java.util.function.UnaryOperator;

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
		Image image2 = transform(image, compose(createColorTransformer(Color::brighter),
				(x, y, c) -> x < 15 || x > image.getWidth() - 15
				|| y < 15 || y > image.getHeight() - 15 ? Color.AQUAMARINE : c));
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
		stage.show();
	}

	public static ColorTransformer compose(ColorTransformer f1, ColorTransformer f2) {
		return (x, y, c) -> f2.apply(x, y, f1.apply(x, y, c));
	}

	// x, y座標を無視
	public static ColorTransformer createColorTransformer(UnaryOperator<Color> f) {
		return (x, y, c) -> f.apply(c);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
