import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.*;


public class Blaster extends base{
    int mouseX,mouseY;
    public Blaster(){
        loadImage("images/Centipede_blaster.png");
        dx = 1;
        dy = 1;
        System.out.println("here");
        Game.screen.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                System.out.println("moved!");
                mouseX = e.getX();
                mouseY = e.getY();

                System.out.println("x: "+mouseX+"y: "+mouseY);
            }
        });
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
