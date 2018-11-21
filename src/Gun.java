import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

public class Gun extends base {
    public Gun() {
        loadImage("src/images/1_gun.png");
        dy = 6;
        y -= dy;
        visibility = true;
        if(y <= 1) {
            visibility = false;
        }
    }

//    public void fly() {
//
//    }
}
