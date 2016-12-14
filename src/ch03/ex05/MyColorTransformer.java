package ch03.ex05;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// 参考：http://closedunbounded.hatenablog.com/entry/2015/06/15/201812
public class MyColorTransformer extends Application {

	private final String imageFilePath = "file:" + "src" + File.separator + "ch03" + File.separator + "ex05" + File.separator + "penguin.jpeg";

	/*public MyColorTransformer(String filePath) {
		imageFilePath = filePath;
	}*/

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
        Image image2 = transform(image, (x, y, c) ->
                x < 15 || x > image.getWidth() - 15 || y < 15 || y > image.getHeight() - 15 ? Color.AQUAMARINE : c);
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(image2))));
        stage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}
}
