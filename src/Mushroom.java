import java.awt.*;

public class Mushroom extends base{
    //public static Image m_img;
//    public static Image m_1_img;
//    public static Image m_2_img;


    public Mushroom() {
        life = 3;
        visibility=true;

        loadImage("src/images/Centipede_mushroom_damage0.png");
//        m_1_img=loadImage("src/images/Centipede_mushroom_damage2.png");
//        m_2_img=loadImage("src/images/Centipede_mushroom_damage3.png");
    }
    public void picChange(int m_life){
        if(m_life==2) {
            loadImage("src/images/Centipede_mushroom_damage2.png");

        }
        else if(m_life ==1){
           loadImage("src/images/Centipede_mushroom_damage3.png");
        }
        else if(m_life == 0){
            visibility = false;
        }
    }
}
