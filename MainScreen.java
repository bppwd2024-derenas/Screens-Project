import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class MainScreen {

    private String title; 
    protected Color color;

    public MainScreen(String t, Color c){
        title=t;
        color= c;
    }

    public abstract void update();

    public void draw(Graphics pen) {
        pen.setFont(new Font("Arial",1,80));
        pen.setColor(color);
        pen.drawString(title, 200, 240);
        pen.setFont(new Font("Arial",1,40));
        pen.drawRect(0,0, 782, 760);
        
    }    

    public abstract void keyTyped(KeyEvent ke);
    public abstract boolean keyPressed(KeyEvent ke);
    public abstract void keyReleased(KeyEvent ke);
    public abstract boolean mouseClicked(MouseEvent ke);
    public abstract void mousePressed(MouseEvent me);
    public abstract void mouseReleased(MouseEvent me);
    public abstract void mouseEntered(MouseEvent me);
    public abstract void mouseExited(MouseEvent me);
    public abstract void mouseDragged(MouseEvent me);
    public abstract void mouseMoved(MouseEvent me);
}
