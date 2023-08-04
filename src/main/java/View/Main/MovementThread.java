package View.Main;

import javax.swing.*;

public class MovementThread extends Thread{

    private ImageShop[] imageShops;
    private Footer footer;
    private JFrame frame;

    private int actualNumber;

    public MovementThread(ImageShop[] imageShops, Footer footer, JFrame frame){
        super("Mouvement Thread Magasin");
        this.imageShops = imageShops;
        this.footer = footer;
        this.frame = frame;
        this.actualNumber = 0;
    }

    public void run(){

        while(true){
            try{
                sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(!borderReach(imageShops[actualNumber])){
                imageShops[actualNumber].move();
                footer.repaint();

            }
            else{
                actualNumber++;
                if(actualNumber >= 6)
                    actualNumber = 0;
                footer.setActualNumber(actualNumber);
                footer.setImageActual((actualNumber % 2  == 0) ? 0 : frame.getSize().width - 80);
                footer.repaint();
            }
        }
    }



    public boolean borderReach(ImageShop image){

        int width = frame.getSize().width;
        if(image.getDirection() == 0){
            return image.getPositionX() >= width - 80;
        }
        else if(image.getDirection() == 1){
            return image.getPositionX() <= 0;
        }
        else{
            return false;
        }
    }

}
