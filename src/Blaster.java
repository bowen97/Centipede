import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Blaster extends base{
    public static ArrayList<Gun> gun_list;
    public static Image blasterImg;
    public Blaster(){
        if(image == null){
            System.out.println("NULL");
        }
        loadImage("src/images/Centipede_blaster.png");


        dx = 1;
        dy = 1;
        gun_list = new ArrayList<Gun>();
        Game.screen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                Gun gun = new Gun();
                gun.visibility=true;
                gun.x = x;
                gun.y = y;
                gun_list.add(gun);
                System.out.println("size:"+gun_list.size());
                System.out.println("pressed!");
            }
        });


    }



    public void move(){
        x += dx;
        y+= dy;

    }
}
