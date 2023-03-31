import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StartScreenMain extends MainScreen{

    private MenuClass startButton; 

    public StartScreenMain(String title, Color color){
        super(title, color);
        startButton= new PressButton("Start Program", 300, 300, Color.GREEN);
    }

    public void update() {}
    
    public void draw(Graphics pen) {
        super.draw(pen);
        startButton.draw(pen);

    }

    public void keyTyped(KeyEvent ke){}
    public boolean keyPressed(KeyEvent ke){return(false);}
    public void keyReleased(KeyEvent ke){}
    public boolean mouseClicked(MouseEvent me){
        startButton.mouseClicked(me);
        if (startButton.mouseClicked(me) == true){
            return(true);
        }
        return(false);
    }

    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    public void mouseDragged(MouseEvent me){}
    public void mouseMoved(MouseEvent me){
        startButton.mouseMoved(me);
    }
}