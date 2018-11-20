import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

public class Logic extends JPanel{
    public Blaster blaster;
    public BackGround bgimage;
    private int score;
    private int point;

    public Logic(){

        bgimage = new BackGround();
        crateBlaster();


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgimage.bgimage,0,0,null);
        Font myFont = new Font("Serif",Font.BOLD,15);
        Game.screen.setBackground(Color.BLACK);
        g.setFont(myFont);
        g.setColor(Color.red);
        score = 0;
        g.drawString("Score: "+score,100,15);

        g.drawImage(blaster.getImage(), blaster.getX(),blaster.getY(), null);


    }

    private void crateBlaster(){
        blaster = new Blaster();
        blaster.visibility = true;
        blaster.setX(300);
        blaster.setY(750);
    }
}
