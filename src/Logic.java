import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

public class Logic extends JPanel implements ActionListener{
    public Blaster blaster;
    public BackGround bgimage;
    private int score;
    private int point;
    int mouseX,mouseY;
    int life;
    private Timer timer;


    public Logic(){
        timer = new Timer(10, this);
        timer.start();
        life = 5;
        bgimage = new BackGround();
        crateBlaster();


    }
    public void actionPerformed(ActionEvent e){

        blasterAction();
        gunAction();
        repaint();
    }
    public void gunAction(){
        for(int i =0; i<Blaster.gun_list.size();i++) {
            Blaster.gun_list.get(i).y -=3;
        }
    }
    public void blasterAction(){
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


            }
        });
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





        for(int i =0; i<Blaster.gun_list.size();i++){


            if(Blaster.gun_list.get(i).visibility){

                g.drawImage(Blaster.gun_list.get(i).getImage(),Blaster.gun_list.get(i).getX()+3,Blaster.gun_list.get(i).getY()-10,Blaster.gun_list.get(i).getWidth(),Blaster.gun_list.get(i).getHeight(),null);


            }
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    private void crateBlaster(){
        blaster = new Blaster();
        blaster.visibility = true;
        blaster.setX(300);
        blaster.setY(750);
    }
}
