package ch03.ex13;

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
		Image image2 = LatentImage.from(image).transform(MyColorTransformer.createBlur(image)).toImage();
		Image image3 = LatentImage.from(image).transform(MyColorTransformer.createEdge(image)).toImage();
		stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2), new ImageView(image3))));
		stage.show();
	}

	public static ColorTransformer createBlur(Image image) {
		return (x, y, c) -> {
			int width = (int)image.getWidth();
			int height= (int)image.getHeight();
			if ( ( 0 == x ) || ( 0 == y ) || ( x == ( width - 1 ) ) || ( y == ( height - 1 ) ) ) {
				// (x,y)が画像の外枠の場合、元の画像の色を取得
				return c;
			}
			else {
				double sumr = 0;
				double sumg = 0;
				double sumb = 0;
				for (int dy = -1; dy <= 1; ++dy) {
					for (int dx = -1; dx <= 1; ++dx) {
						Color color = image.getPixelReader().getColor(x + dx, y + dy);
						sumr += color.getRed();
						sumg += color.getGreen();
						sumb += color.getBlue();
					}
				}
				return Color.color(sumr / 9, sumg / 9, sumb / 9);
			}
		};
	}

	public static ColorTransformer createEdge(Image image) {
		return (x, y, c) -> {
			int width = (int)image.getWidth();
			int height= (int)image.getHeight();
			if ( ( 0 == x ) || ( 0 == y ) || ( x == ( width - 1 ) ) || ( y == ( height - 1 ) ) ) {
				// (x,y)が画像の外枠の場合、元の画像の色を取得
				return c;
			}
			else {
				@SuppressWarnings("restriction")
				Color north = image.getPixelReader().getColor(x, y - 1);
				Color east = image.getPixelReader().getColor(x + 1, y);
				Color south = image.getPixelReader().getColor(x, y + 1);
				Color west = image.getPixelReader().getColor(x - 1, y);

				double r = 4 * c.getRed() - north.getRed() - east.getRed() - south.getRed() - west.getRed();
				double g = 4 * c.getGreen() - north.getGreen() - east.getGreen() - south.getGreen() - west.getGreen();
				double b = 4 * c.getBlue() - north.getBlue() - east.getBlue() - south.getBlue() - west.getBlue();

				return Color.color(r < 0 ? 0 : r > 1 ? 1 : r,
						g < 0 ? 0 : g > 1 ? 1 : g,
						b < 0 ? 0 : b > 1 ? 1 : b);
			}
		};
	}

	public static void main(String[] args) {
		launch(args);
	}
}
