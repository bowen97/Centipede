import java.awt.*;

public class Mushroom extends base{



    public Mushroom() {
        life = 3;
        visibility=true;

        loadImage("src/images/Centipede_mushroom_damage0.png");

    }
    public void picChange(int m_life){
        if(m_life==3){
            loadImage("src/images/Centipede_mushroom_damage0.png");
        }
        else if(m_life==2) {
            loadImage("src/images/Centipede_mushroom_damage2.png");

        }
        else if(m_life ==1){
           loadImage("src/images/Centipede_mushroom_damage3.png");
        }
        else if(m_life == 0){
            visibility = false;
            Logic.score+=5;
        }
    }
}
