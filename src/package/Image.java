import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Image extends JPanel {
    private Point position;
    int wFrame=0;
    int hFrame=0;
    public Image(final JFrame parent){
        wFrame=this.getWidth();
        hFrame=this.getHeight();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
                position=e.getPoint();
                getComponentAt(position);


            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int thisX=parent.getLocation().x;
                int thisY=parent.getLocation().y;
                int xMoved=(thisX + e.getX())-(thisX + position.x);
                int yMoved=(thisY + e.getY())-(thisY + position.y);
                int X=thisX+xMoved;
                int Y=thisY+yMoved;
                parent.setBounds(X,Y,parent.getWidth(),parent.getHeight());

            }
        });
        setOpaque(false);
    }
}
