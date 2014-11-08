/**
 * Created by edwinfinch on 14-11-06.
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class Master {
    private int waitLength, interval;
    final Window frame;
    private int windowSize;

    final DotThread dots[][] = {
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
            {
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
            },
    };
    public boolean[][] amountClicked = {
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

    public Master(int threadLength, int size){
        frame = new Window(size);
        windowSize = size;
        frame.panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                areaClicked(x, y);
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        waitLength = threadLength;
        interval = threadLength/16;
        Timer timer = new Timer();
        final int[] fixed_x = {0};

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i < 16; i++) {
                    if(dots[fixed_x[0]][i].isClicked()) {
                        dots[fixed_x[0]][i].pulseDot();
                    }
                }
                fixed_x[0]++;
                if(fixed_x[0] > 15){
                    fixed_x[0] = 0;
                }
            }
        }, interval, interval);
        
        Timer setClicked = new Timer();
        
        setClicked.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i < 16; i++){
                    for(int j = 0; j < 16; j++){
                        amountClicked[i][j] = dots[i][j].isClicked();
                    }
                }
                frame.setClickedArray(amountClicked);
            }
        }, 50, 50);
        
        for(int x = 0; x < 16; x++){
            for(int y = 0; y < 16; y++){
                dots[x][y] = new DotThread(x, y);
                System.out.println("initializing dot: " + x + ", " + y);
            }
        }
        
    }
    public void areaClicked(int x, int y){
        for(int x_ = 0; x_ < 16; x_++){
            for(int y_ = 0; y_ < 16; y_++){
                if(dots[x_][y_].getX() == x/(windowSize/16) && dots[x_][y_].getY() == y/(windowSize/16)){
                    System.out.println("valid click " + x + ", " + y);
                    dots[x_][y_].clicked();
                    return;
                }
            }
        }
    }
}
