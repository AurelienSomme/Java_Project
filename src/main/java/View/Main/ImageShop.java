package View.Main;

import java.awt.*;

public class ImageShop {
    private int positionX;
    private int positionY;
    private Image image;
    private int direction;


    public ImageShop(Image image, int direction){
        this.image = image;
        this.direction = direction;
        this.positionY = 0;
    }

    public void draw(Graphics g){
        g.drawImage(image, positionX, positionY, null);
    }

    public void move(){
        if(direction == 0) {
            positionX++;
        }
        else if(direction == 1) {
            positionX--;
        }
    }

    public int getPositionX(){
        return positionX;
    }

    public void setPositionX(int x){
        positionX = x;
    }

    public int getDirection(){
        return direction;
    }
}
