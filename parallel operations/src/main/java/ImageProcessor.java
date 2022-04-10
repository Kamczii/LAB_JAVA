import org.apache.commons.lang3.tuple.Pair;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class ImageProcessor {

    public static void  save(Pair<Path, BufferedImage> pathBufferedImagePair) {
        try {
            ImageIO.write(pathBufferedImagePair.getRight(),"jpg",pathBufferedImagePair.getLeft().toFile());
        } catch (IOException e) {
            System.out.println("Problem z zapisem");
        }

    }

    public static Pair<Path, BufferedImage>  transofrm(Pair<Path, BufferedImage> pathBufferedImagePair) {
        BufferedImage original = pathBufferedImagePair.getRight();

        BufferedImage image = new BufferedImage(original.getWidth(),
                original.getHeight(),
                original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {
                int rgb = original.getRGB(i, j);
                Color color = new Color(rgb);
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                Color outColor = new Color(red, blue, green);
                int outRgb = outColor.getRGB();
                image.setRGB(i,j,outRgb);
            }
        }

        Path path = Path.of("copies", pathBufferedImagePair.getLeft().getFileName().toString());

        return Pair.of(path, image);
    }

    public static Pair<Path, BufferedImage> getPair(Path path) {
        try {
            return Pair.of(path.getFileName(), ImageIO.read(path.toFile()));
        } catch (IOException e) {
            System.out.println("Problem z utworzeniem pary");
        }
        return null;
    }
}
