import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

public class Logic extends JPanel{
    public Blaster blaster;
    private int point;

    public Logic(){
        blaster = new Blaster();
        System.out.println("here lalalal");
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(BackGround.bgimage,0,0,null);
        Font myFont = new Font("Serif",Font.BOLD,15);
        Game.screen.setBackground(Color.BLACK);
        g.setFont(myFont);
        g.setColor(Color.red);

        g.drawString("Score",100,20);

    }
}
