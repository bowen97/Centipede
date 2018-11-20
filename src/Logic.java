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
    int mouseX,mouseY;
    int life;
    public ArrayList<Gun> gun_list;

    public Logic(){
        life = 5;
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
        g.drawString("Score: "+score+" HP: "+life,100,15);

        g.drawImage(blaster.getImage(), blaster.getX(),blaster.getY(),blaster.getWidth(),blaster.getHeight(), null);


        //make the blaster to follow with mouse
        Game.screen.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                mouseX = e.getX();
                mouseY = e.getY();
                if(mouseX>blaster.x && blaster.x< 600){
                    //while(blaster.x<600) {
                        blaster.x += blaster.dx;
                    //}
                }
                else if(mouseX<blaster.x && blaster.x>0){
                    blaster.x-=blaster.dx;
                }
                if(mouseY>blaster.y && blaster.y< 800){
                    blaster.y+=blaster.dy;
                }
                else if(mouseY<blaster.y && blaster.y>0){
                    blaster.y-=blaster.dy;
                }

                //System.out.println("x: "+mouseX+"y: "+mouseY);
            }
        });


//        Game.screen.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mousePressed(e);
//                //gunFly(g);
//                System.out.println("pressed!");
//            }
//        });
        repaint();
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    private void gunFly(Graphics g){
        Gun gun = new Gun();
        g.drawImage(gun.getImage(),blaster.getX(),blaster.getY(),gun.getWidth(),gun.getHeight(),null);
        gun_list.add(gun);
    }

    private void crateBlaster(){
        blaster = new Blaster();
        blaster.visibility = true;
        blaster.setX(300);
        blaster.setY(750);
    }
}
