package Test;

import View.Main.Footer;
import View.Main.ImageShop;
import View.Main.MovementThread;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class MovementThreadTest {

    @Before
    public void setUp() throws Exception {
    }


    //This test show if an image reach the left border
    @Test
    public void borderReach() {
        ImageShop[] imageShops = new ImageShop[0];
        JFrame frame = new JFrame();
        Footer footer = new Footer(imageShops, frame);
        MovementThread movementThread = new MovementThread(imageShops, footer, frame);
        int width = 10;
        int height = 10;
        int imageType = BufferedImage.TYPE_INT_ARGB;
        BufferedImage img = new BufferedImage(width, height, imageType);
        ImageShop imageShop = new ImageShop(img, 1);
        imageShop.setPositionX(0);
        boolean isReached = movementThread.borderReach(imageShop);
        assertEquals(true, isReached);
    }
}