import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.*;


public class Blaster extends base{

    public static Image blasterImg;
    public Blaster(){
        if(image == null){
            System.out.println("NULL");
        }
        loadImage("src/images/Centipede_blaster.png");


        dx = 1;
        dy = 1;


        Game.screen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("pressed!");
            }
        });

    }


    public void move(){
        x += dx;
        y+= dy;

    }
}
