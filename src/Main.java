import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by edwinfinch on 14-11-06.
 */
public class Main {
    static public void main(String args[]){

        JFrame frame = new JFrame();
        
        StartScreen start = new StartScreen();
        
        frame.setContentPane(start);
        frame.setSize(200, 175);
        frame.setVisible(true);
    }
}
