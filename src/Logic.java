import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.Random;

public class Logic extends JPanel implements ActionListener{
    public Blaster blaster;
    public BackGround bgimage;
    private int score;
    private int point;
    int mouseX,mouseY;
    int life;
    private Timer timer;
    public static ArrayList<Mushroom> mush_list;




    public Logic() {
        timer = new Timer(10, this);
        timer.start();
        life = 5;
        bgimage = new BackGround();
        createNewMush();
        crateBlaster();
        int temp = num_mush();


    }

    public void createNewMush(){
        MushCoord[][] mush_matrix =new MushCoord[16][13];
        mush_list = new ArrayList<Mushroom>();

        int amount = num_mush();
        for(int i =0;i<amount;i++){
            Random rand = new Random();

            int n = rand.nextInt(208) + 0;
            System.out.println(n);
        }


        int coX,coY;
        for (int i = 0; i < 16; i++) {

            for (int j = 0; j < 13; j++) {
                mush_matrix[i][j]=new MushCoord(i*40+40,j*40+40);
                Mushroom temp= new Mushroom();
                temp.y = mush_matrix[i][j].x;
                temp.x = mush_matrix[i][j].y;
                mush_list.add(temp);

                //mush_matrix[i][j].print();

            }
            System.out.println();
        }


//        for(int i =0; i<10;i++){
//            Mushroom temp= new Mushroom();
//            mush_list.add(temp);
//        }

    }
    public int num_mush() {
        int amount = 0;
        try {
            File file = new File("src/images/mush_num.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            st = br.readLine();

            String arr[] = st.split(" ");


            if(arr[0].equals("high")){
                amount = 30;
            }
            else if(arr[0].equals("medium")){
                amount = 60;
            }
            else if(arr[0].equals("low")){
                amount = 90;
            }
            else{
                throw new IllegalArgumentException("Level of mushrooms can only be high, medium or low");
            }

        }catch (IOException e){
            e.printStackTrace();
        }


        return amount;
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
        //try rows for mush
        //g.drawImage(mush_list.get(0).m_f_img,10,0,null);
        for(int i =0;i<208;i++) {
            g.drawImage(mush_list.get(i).m_f_img,mush_list.get(i).getX(), mush_list.get(i).getY(), null);
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
