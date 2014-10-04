import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;

/**
 * This is the turtle and all of its methods.
 * @author Rica
 *
 */
public class Turtle {
    private Turtle myTurtle;
    
    public Turtle() {
        myTurtle = new Turtle();
        Turtle.width = width;
        Turtle.height = height;
        myTurtle.setTitle("Turtle Graphics");
        myTurtle.setResizable(false);
        myTurtle.setVisible(true);

        // re-adjust the size of the frame so that we don't lose space for insets
        insets = turtle.getInsets();
        turtle.setSize(new Dimension(width  + insets.left + insets.right,
                                     height + insets.top  + insets.bottom));

        // create double buffered image and graphics handle
        offscreenImage = turtle.createImage(width, height);
        offscreen = (Graphics2D) offscreenImage.getGraphics();
    }

}
