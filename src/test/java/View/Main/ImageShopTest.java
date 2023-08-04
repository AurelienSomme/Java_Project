package View.Main;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;
public class ImageShopTest {

    //this test show if the image move
    @Test
    public void move() {
        int width = 10;
        int height = 10;
        int imageType = BufferedImage.TYPE_INT_ARGB;
        BufferedImage img = new BufferedImage(width, height, imageType);
        ImageShop imageShop = new ImageShop(img, 0);
        imageShop.setPositionX(250);
        imageShop.move();
        int result = imageShop.getPositionX() - 250;
        assertEquals(1, result);
    }


    //this test show if the setter work
    @Test
    public void setPositionX() {
        int width = 10;
        int height = 10;
        int imageType = BufferedImage.TYPE_INT_ARGB;
        BufferedImage img = new BufferedImage(width, height, imageType);
        ImageShop imageShop = new ImageShop(img, 0);

        int newX = 500;
        imageShop.setPositionX(newX);
        assertEquals(newX, imageShop.getPositionX());
    }
}