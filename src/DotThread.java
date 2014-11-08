import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * Created by edwinfinch on 14-11-06.
 */
public class DotThread {
    private int x_c, y_c;
    private boolean clicked = false;

    public DotThread(int x, int y){
        setDot(x, y);
    }
    public void setDot(int x, int y){
        x_c = x;
        y_c = y;
    }
    public void pulseDot(){
        try{
            AudioInputStream audioInputStream;
            audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/sounds/" + y_c + ".wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void clicked(){
        clicked = !clicked;
    }
    public boolean isClicked(){
        return clicked;
    }
    public int getX(){
        return x_c;
    }
    public int getY(){
        return y_c;
    }
}
