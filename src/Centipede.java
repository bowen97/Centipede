import java.awt.*;

public class Centipede extends base {

    public boolean head;//detect if it's the head
    public  String direction;


    public Centipede(int nx,int ny,boolean if_head){
        head=if_head;
        loadImage("src/images/Centipede_body.png");
        x=nx;
        y=ny;
        direction="left";
        life=2;//die after hit twice



    }

}
