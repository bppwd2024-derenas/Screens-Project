import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class MainScreenMain extends MainScreen {   
   
    private  MenuClass upButton; 
    private  MenuClass downButton; 
    private  MenuClass leftButton; 
    private  MenuClass rightButton; 
    
    private Server server = new Server();

    public MainScreenMain(String title, Color color){
        super(title, color);
        upButton= new PressButton("Up", 300, 200, Color.RED);
        downButton= new PressButton("Down", 300, 300, Color.RED);
        leftButton= new PressButton("Left", 80, 300, Color.RED);
        rightButton= new PressButton("Right", 520, 300, Color.RED);

        server.startServer(6666);
    }


    public void update() {}
    
        
    

    public void draw(Graphics pen) {
         pen.setColor(super.color);
         pen.drawRect(0,0, 782, 760);
         upButton.draw(pen);
         downButton.draw(pen);
         leftButton.draw(pen);
         rightButton.draw(pen);
    }


    public void keyTyped(KeyEvent ke){}

    public boolean keyPressed(KeyEvent ke){
        //W key 
        if(ke.getKeyCode() == 87){upButton.lightUp();
            server.sendMessage("forward");
        }

        //A key
        if(ke.getKeyCode() == 65){leftButton.lightUp();
            server.sendMessage("left");
        }

        //S key 
        if(ke.getKeyCode() == 83){downButton.lightUp();
            server.sendMessage("backward");
        }

        //D key 
        if(ke.getKeyCode() == 68){rightButton.lightUp();
            server.sendMessage("right");
        }

        //Exit Ket 
        if(ke.getKeyCode() == 27){return(true);}

        return(false);

    }


    public void keyReleased(KeyEvent ke){
        if(ke.getKeyCode() == 87){upButton.shutDown();
            server.sendMessage("unforward");}
        if(ke.getKeyCode() == 65){leftButton.shutDown();
            server.sendMessage("unleft");} 
        if(ke.getKeyCode() == 83){downButton.shutDown();
            server.sendMessage("unbackward");}
        if(ke.getKeyCode() == 68){rightButton.shutDown();
            server.sendMessage("unright");}
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
    }
}