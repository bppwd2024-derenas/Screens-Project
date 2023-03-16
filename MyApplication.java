
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyApplication extends RunApp  {
    public static final String TITLE = "MyGame";
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 800;
    static MainScreen activeScreen; 
    MainScreen startScreen;
    MainScreen mainScreen; 
    // declare variables here

    public MyApplication() {
        // initialize variables here
        startScreen= new StartScreenMain("Welcome", Color.GREEN);
        mainScreen= new MainScreenMain("Main Application", Color.RED);
        activeScreen=startScreen;
    }
    
    public void update() {
        activeScreen.update();
        // updating logic

    }
    
    public void draw(Graphics pen) {
      activeScreen.draw(pen);
    }
        
    @Override
    public void keyTyped(KeyEvent ke) {activeScreen.keyTyped(ke);}

    @Override
    public void keyPressed(KeyEvent ke) { 
        activeScreen.keyPressed(ke);
        if(activeScreen.keyPressed(ke) == true){
            activeScreen=startScreen;
        }
    
    }

    @Override
    public void keyReleased(KeyEvent ke) {activeScreen.keyReleased(ke);}

    @Override
    public void mouseClicked(MouseEvent me) {
        activeScreen.mouseClicked(me);
        if(activeScreen.mouseClicked(me) == true){
            activeScreen=mainScreen;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {activeScreen.mousePressed(me);}
    
    @Override
    public void mouseReleased(MouseEvent me) {activeScreen.mouseReleased(me);}

    @Override
    public void mouseEntered(MouseEvent me) {activeScreen.mouseEntered(me);}

    @Override
    public void mouseExited(MouseEvent me) {activeScreen.mouseExited(me);}
    
    @Override
    public void mouseDragged(MouseEvent me) {activeScreen.mouseDragged(me);}
    
    @Override
    public void mouseMoved(MouseEvent me){activeScreen.mouseMoved(me);}
        
    //Launches the Game
    public static void main(String[] args) { new MyApplication().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }



   
}