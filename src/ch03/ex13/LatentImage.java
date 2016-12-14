package ch03.ex13;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {

	private Image in;
    private List<ColorTransformer> pendingOperations;

    protected LatentImage(Image in) {
        this.in = in;
        pendingOperations = new LinkedList<>();
    }

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (ColorTransformer f : pendingOperations) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                	Color c = in.getPixelReader().getColor(x, y);
                    out.getPixelWriter().setColor(x, y, f.apply(x, y, c));
                }
            }
        }
        return out;
    }
}
