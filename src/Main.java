import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

public class Main {
    public static void crtContour(String title,String imgName) throws InterruptedException {
        frameImage app = new frameImage(title, imgName);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgName));
        } catch (IOException e) {
        }

        if (img == null) {
            System.out.println("ERROR");
        }

        app.setShape(contour(img));
        app.setVisible(true);
        Thread.sleep(3000);
        app.dispose();
    }

    private static Shape contour(BufferedImage img) {
        final int w = img.getWidth();
        final int h = img.getHeight();
        final Area s = new Area(new Rectangle(w, h));
        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                Color color = new Color(img.getRGB(x, y));
                if (color.getRed() == 255 & color.getGreen() == 255 & color.getBlue() == 255) {
                    Rectangle r = new Rectangle(x, y, 1, 1);
                    s.subtract(new Area(r));
                }
            }
        }
        return s;
    }
    static void visibleTrueFrame(String title,String imgName){
        frameImage app = new frameImage(title, imgName);
        app.setVisible(true);
    }
    static void visibleFalseFrame(String title,String imgName){
        frameImage app = new frameImage(title, imgName);
        app.setVisible(false);
    }
    public static void main(String[] args) throws InterruptedException {
        while(true){
            crtContour("Image","test.png");
            crtContour("Image","test2.png");
        }

    }
}