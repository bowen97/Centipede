import java.awt.*;

public class Centipede extends base {
    Image head;
    Image body;
    public  String direction;


    public Centipede(int nx,int ny){
        //head = loadImage("src/images/Centipede_head.png");
        //body =
        loadImage("src/images/Centipede_body.png");
        x=nx;
        y=ny;
        direction="left";
        life=2;//die after hit twice



    }

}
