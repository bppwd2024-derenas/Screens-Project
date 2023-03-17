import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class MenuClass{
    String text;
    int x;
    int y;
    Color box;
    Color textC;
    boolean change; 

    public MenuClass (String t, int x, int y, Color b){
        box= b;
        textC= Color.WHITE; 
        text=t; 
        this.x=x;
        this.y=y;
        change= false;
    }

    public abstract void update();

    public void draw(Graphics pen) {
        pen.setColor(box);
        pen.fillRect(x, y, 200, 80);
        pen.setColor(Color.BLACK);
        pen.drawRect(x,y, 200, 80);
        pen.setColor(textC);
        pen.setFont(new Font("Arial",1, 25));
        pen.drawString(text, x + (200 / 2) - (pen.getFontMetrics().stringWidth(text) / 2), y + (80 / 2)+ 5);
        
    }
    
    public abstract void lightUp();
    public abstract void shutDown();
    public abstract void keyTyped(KeyEvent ke);
    public abstract void keyPressed(KeyEvent ke);
    public abstract void keyReleased(KeyEvent ke);
    public abstract boolean mouseClicked(MouseEvent ke);
    public abstract void mousePressed(MouseEvent me);
    public abstract void mouseReleased(MouseEvent me);
    public abstract void mouseEntered(MouseEvent me);
    public abstract void mouseExited(MouseEvent me);
    public abstract void mouseDragged(MouseEvent me);
    public abstract void mouseMoved(MouseEvent me);

}
