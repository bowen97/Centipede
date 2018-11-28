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
    public static int score=0;
    private int point;
    int mouseX,mouseY;
    int life;
    private ArrayList<Integer> mush_list_pos;
    private Timer timer;
    private int amount;
    //public static ArrayList<Mushroom> mush_list;
    public static ArrayList<Mushroom> mush_list_final;
    public static ArrayList<Centipede> cent_list;
    private ArrayList<MushCoord> Mushposition;




    public Logic() {
        timer = new Timer(10, this);
        timer.start();
        life = 5;
        bgimage = new BackGround();
        createNewMush();
        crateBlaster();
        createCentipede();



    }


    private void createCentipede(){
        cent_list = new ArrayList<Centipede>();
        cent_list.add(new Centipede(160,0));
        for(int i=1;i<6;i++){
            Centipede prv = cent_list.get(i-1);
            int new_x = prv.getX();
            int new_y = prv.getY();

            cent_list.add(new Centipede(new_x+40,new_y));

        }
    }

    private void createNewMush(){
        MushCoord[][] mush_matrix =new MushCoord[14][13];
        ArrayList<Mushroom> mush_list = new ArrayList<Mushroom>();
        mush_list_final = new ArrayList<Mushroom>();





        int coX,coY;
        for (int i = 0; i < 14; i++) {

            for (int j = 0; j < 13; j++) {
                mush_matrix[i][j]=new MushCoord(i*40+40,j*40+40);
                Mushroom temp= new Mushroom();
                temp.y = mush_matrix[i][j].x;
                temp.x = mush_matrix[i][j].y;
                mush_list.add(temp);

                //mush_matrix[i][j].print();

            }
            //System.out.println();
        }

        num_mush();
        mush_list_pos = new ArrayList<Integer>();
        Mushposition = new ArrayList<MushCoord>();

        for(int i =0;i<amount;i++){
            Random rand = new Random();

            int n = rand.nextInt(182) + 0;
            mush_list_pos.add(n);
            mush_list_final.add(mush_list.get(n));
            Mushposition.add(new MushCoord(mush_list.get(n).getX(),mush_list.get(n).getY()));

        }


//        for (int i=0;i<Mushposition.size();i++){
//            System.out.println(Mushposition.get(i).y);
//            //Mushposition.get(i).print();
//        }



    }


    public void num_mush() {
        amount = 0;
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
                amount = 20;
            }
            else if(arr[0].equals("low")){
                amount = 10;
            }
            else{
                throw new IllegalArgumentException("Level of mushrooms can only be high, medium or low");
            }

        }catch (IOException e){
            e.printStackTrace();
        }


//        return amount;
    }
    public void actionPerformed(ActionEvent e){

        blasterAction();
        gunAction();
        centipedeAction();
        repaint();
    }
    private void centipedeAction(){

        for (int i=0;i<cent_list.size();i++){
            Centipede centEle = cent_list.get(i);
            MushCoord centCoord = new MushCoord(centEle.getX(),centEle.getY());
//            if(Mushposition.contains(centCoord)){
//                System.out.println("meet!!");
//            }

                if (centEle.x == 0 || centEle.x == 580||Mushposition.contains(centCoord)) {
                    centEle.y += 40;
                    if (centEle.direction.equals("left")) {
                        centEle.direction = "right";
                    } else if (centEle.direction.equals("right")) {
                        centEle.direction = "left";
                    }

                }
//            }


            if(centEle.direction.equals("left")) {
                centEle.x -= 4;
            }
            else if(centEle.direction.equals("right")){
                centEle.x+=4;
            }

        }
    }
    public void gunAction(){//should implement every destroy here
        for(int i =0; i<Blaster.gun_list.size();i++) {
            Gun gun_ele = Blaster.gun_list.get(i);
            gun_ele.y -=5;


        }
        for(int i =0; i<Blaster.gun_list.size();i++) {
            Gun gun_ele = Blaster.gun_list.get(i);
            for(int i_m = 0;i_m<mush_list_final.size();i_m++){
                Mushroom mush_ele = mush_list_final.get(i_m);
                if(gun_ele.visibility && mush_ele.visibility) {
                    if ((mush_ele.getX() - 15 < gun_ele.getX() && mush_ele.getX() + 19 > gun_ele.getX()) && (mush_ele.getY() - 15 < gun_ele.getY() && mush_ele.getY() + 19 > gun_ele.getY())) {//add y constraint
                        mush_ele.life-=1;
                        mush_ele.picChange(mush_ele.life);
                        score+=1;
                        if(mush_ele.visibility==false){
                            Mushposition.remove(i_m);
                        }
                        gun_ele.visibility=false;
                        break;
                    }
                }
            }

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



        g.drawImage(blaster.getImage(), blaster.getX(),blaster.getY(),blaster.getWidth(),blaster.getHeight(), null);





        for(int i =0; i<Blaster.gun_list.size();i++){


            if(Blaster.gun_list.get(i).visibility){

                g.drawImage(Blaster.gun_list.get(i).getImage(),Blaster.gun_list.get(i).getX()+3,Blaster.gun_list.get(i).getY()-10,Blaster.gun_list.get(i).getWidth(),Blaster.gun_list.get(i).getHeight(),null);


            }
        }
        //try rows for mush
        //g.drawImage(mush_list.get(0).m_f_img,10,0,null);
        for(int i =0;i<amount;i++) {
            if(mush_list_final.get(i).visibility) {
                g.drawImage(mush_list_final.get(i).getImage(), mush_list_final.get(i).getX(), mush_list_final.get(i).getY(), null);
            }
        }
        for(int i=0;i<cent_list.size();i++){
            Centipede oneCent = cent_list.get(i);
            if(oneCent.visibility){
                g.drawImage(oneCent.getImage(),oneCent.getX(),oneCent.getY(),null);

            }
        }


        g.drawString("Score: "+score+" HP: "+life,100,15);
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
