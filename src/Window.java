import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Edwin on 11/6/2014.
 */
public class Window extends JFrame{
    public DrawPane panel;
    private int windowSize = 600;
    public int runs = 0;
    public boolean[][] clickedDots = {
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
            {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            },
    };
    
    public Window(int size){
        windowSize = size;
        if(windowSize%16 != 0){
            windowSize = windowSize-(windowSize%16);
        }
        panel = new DrawPane();
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowSize, windowSize+22);
        setVisible(true);
        
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                panel.repaint();
                runs++;
            }
        }, 50, 50);
    }
    
    public void setClickedArray(boolean[][] clicked){
        clickedDots = clicked;
    }

    class DrawPane extends JPanel{
        public void paintComponent(Graphics g){
            for(int j = 0; j < 16; j++){
                for(int i = 0; i < 16; i++){
                    int fix = windowSize/16;
                    g.drawRect(i*fix, j*fix, fix, fix);
                    if(clickedDots[i][j] == true){
                        g.fillRect(i*fix, j*fix, fix, fix);
                    }
                }
            }
        }
    }
}
