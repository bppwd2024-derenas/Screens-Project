import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PressButton extends MenuClass{

    Color saveColor; 

    public PressButton(String text, int x, int y, Color box) {
        super(text, x, y, box);
        saveColor= box;
        
    }

    public void update(){

    }

    public void draw(Graphics pen) {
       super.draw(pen);
    }


    public void keyTyped(KeyEvent ke){}

    public void keyPressed(KeyEvent ke){}

    public void keyReleased(KeyEvent ke){}

    public boolean mouseClicked(MouseEvent me){
        int mouseX= me.getX();
        int mouseY=me.getY();

        if(mouseX >= x+8 && mouseX<=x+208){
            if(mouseY >= y+30 && mouseY<= y+110){
                return(true);
            }
            else{
                return(false);
            }
        }
        return(false);
    }

    public void lightUp(){ 
        box= new Color(225,195, 203, 127);
        textC= Color.BLUE;
    }

    public void shutDown(){
        box= saveColor;
        textC= Color.WHITE;
    }
    
    public void mousePressed(MouseEvent me){}

    public void mouseReleased(MouseEvent me){}

    public void mouseEntered(MouseEvent me){}

    public void mouseExited(MouseEvent me){}

    public void mouseDragged(MouseEvent me){}

    public void mouseMoved(MouseEvent me){
        int mouseX= me.getX();
        int mouseY=me.getY();

        if(mouseX >= x+8 && mouseX<=x+208){
            if(mouseY >= y+30 && mouseY<= y+110){
                box= new Color(225,244, 184, 127);
                textC= Color.BLUE;
            }
            else{
                box= saveColor;
                textC= Color.WHITE;
            }
        }
        else{
            box= saveColor;
            textC= Color.WHITE;

        }
    }

}