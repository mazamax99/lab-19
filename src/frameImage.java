import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class frameImage extends JFrame  {

    frameImage(String title,String imgName){
        super(title);
        ImageIcon Img=new ImageIcon((imgName));
        final int w = Img.getIconWidth();
        final int h = Img.getIconHeight();
        //Shape myShape= new Ellipse2D.Double(0,0,200,200);
        this.setBounds(200,200,w,h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        Image image=new Image(this);
        image.setLayout(new BorderLayout());
        JLabel label=new JLabel(Img);
        label.setOpaque(false);
        image.add(label);
        this.setBackground(new Color(255,255,255,255));
        this.add(image);
        this.pack();

        //this.setShape(myShape);
    }

}
