import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Game extends JFrame{
    public JFrame window;
    public static JPanel screen;
    public JButton start_btn;
    public JLabel lab;
    int mouseX,mouseY;

    public Game(){

        window = new JFrame("main window");
        window.setVisible(true);
        window.setSize(600,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen = new JPanel(new CardLayout());

        window.add(screen);

        Logic logic = new Logic();
        screen.add(logic);

    }

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game game = new Game();
            }
        });
    }
}
