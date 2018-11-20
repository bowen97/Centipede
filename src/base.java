import java.awt.*;
import javax.swing.*;

public class base {
    public Image image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int dx;
    public int dy;
    public boolean visibility = false;

    public base () {
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void loadImage (String location){
        ImageIcon icon = new ImageIcon(location);
        image = icon.getImage();
        width = Math.round(image.getWidth(null));
        height = Math.round(image.getHeight(null));
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



    public void setWidth(float wid) {
        width = Math.round(wid);
    }

    public void setHeight(float hei) {
        height = Math.round(hei);
    }

    public boolean chkvisible() {
        return visibility;
    }

    public void getvisible(boolean see) {
        visibility = see;
    }
}
