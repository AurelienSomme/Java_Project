package View;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    private ImageShop[] imageShops = new ImageShop[6];
    private int actualNumber;
    private JFrame frame;

    public Footer(ImageShop[] imageShops, JFrame frame){
        this.imageShops = imageShops;
        this.frame = frame;
        actualNumber = 0;
    }
    public void paint(Graphics g){
        super.paint(g);

        imageShops[actualNumber].draw(g);
    }

    public void setImageActual(int x){
        imageShops[actualNumber].setPositionX(x);
    }

    public void setActualNumber(int actualNumber) {
        this.actualNumber = actualNumber;
    }
}
