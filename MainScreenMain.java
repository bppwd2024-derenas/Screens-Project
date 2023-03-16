import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class MainScreenMain extends MainScreen {   
   
    private  MenuClass upButton; 
    private  MenuClass downButton; 
    private  MenuClass powerButton;
    private  MenuClass leftButton; 
    private  MenuClass rightButton;
    private  MenuClass tiltLeftButton;
    private  MenuClass tiltRightButton;   

    public MainScreenMain(String title, Color color){
        super(title, color);
        upButton= new PressButton("Up", 300, 200, Color.RED);
        downButton= new PressButton("Down", 300, 400, Color.RED);
        powerButton= new PressButton("⏻", 300, 300, Color.RED);
        leftButton= new PressButton("Left", 80, 300, Color.RED);
        rightButton= new PressButton("Right", 520, 300, Color.RED);
        tiltLeftButton= new PressButton("Tilt Left", 80, 200, Color.RED);
        tiltRightButton= new PressButton("Tilt Right", 520, 200, Color.RED);
    }


    public void update() {}
    
        
    

    public void draw(Graphics pen) {
         pen.setColor(super.color);
         pen.drawRect(0,0, 782, 760);
         upButton.draw(pen);
         downButton.draw(pen);
         powerButton.draw(pen);
         leftButton.draw(pen);
         rightButton.draw(pen);
         tiltLeftButton.draw(pen);
         tiltRightButton.draw(pen);

    }


    public void keyTyped(KeyEvent ke){}

    public boolean keyPressed(KeyEvent ke){
        //W key 
        if(ke.getKeyCode() == 87){upButton.lightUp();}

        //A key
        if(ke.getKeyCode() == 65){leftButton.lightUp();}

        //S key 
        if(ke.getKeyCode() == 83){downButton.lightUp();}

        //D key 
        if(ke.getKeyCode() == 68){rightButton.lightUp();}

        //Q key 
        if(ke.getKeyCode() == 81){tiltLeftButton.lightUp();}

        //E key
        if(ke.getKeyCode() == 69){tiltRightButton.lightUp();}

        //Enter key 
        if(ke.getKeyCode() == 10){powerButton.lightUp();}

        //Exit Ket 
        if(ke.getKeyCode() == 27){return(true);}

        return(false);

    }


    public void keyReleased(KeyEvent ke){
        if(ke.getKeyCode() == 87){upButton.shutDown();}
        if(ke.getKeyCode() == 65){leftButton.shutDown();} 
        if(ke.getKeyCode() == 83){downButton.shutDown();}
        if(ke.getKeyCode() == 68){rightButton.shutDown();}
        if(ke.getKeyCode() == 81){tiltLeftButton.shutDown();}
        if(ke.getKeyCode() == 69){tiltRightButton.shutDown();}
        if(ke.getKeyCode() == 10){powerButton.shutDown();}
    }

    public boolean mouseClicked(MouseEvent ke){
        return(false);
    }

    public void mousePressed(MouseEvent me){}

    public void mouseReleased(MouseEvent me){}

    public void mouseEntered(MouseEvent me){}

    public void mouseExited(MouseEvent me){}

    public void mouseDragged(MouseEvent me){}

    public void mouseMoved(MouseEvent me){
        upButton.mouseMoved(me);
        downButton.mouseMoved(me);
        leftButton.mouseMoved(me);
        rightButton.mouseMoved(me);
        powerButton.mouseMoved(me);
        tiltLeftButton.mouseMoved(me);
        tiltRightButton.mouseMoved(me);
    }
}