import java.io.IOException;

class RobotController {
  Runtime runTime;

  public RobotController(){
    try{
      runTime = Runtime.getRuntime();
      runTime.exec("gpio mode 1 pwm");
      runTime.exec("gpio pwm-ms");
      runTime.exec("gpio pwmc 192");
      runTime.exec("gpio pwmr 2000");
    }
    catch(IOException e){
      System.out.println(e);
    }
  }

  public void forward(){
    try{
      runTime.exec("gpio pwm 1 152");
    }
    catch(IOException e){
      System.out.println(e);
    }
  }

  public void backward(){
    
  }

  public void left(){
    try{
      runTime.exec("gpio pwm 1 200");
    }
    catch(IOException e){
      System.out.println(e);
    }
  }

  public void right(){
    try{
      runTime.exec("gpio pwm 1 100");
    }
    catch(IOException e){
      System.out.println(e);
    }
  }

  public void stop(){
    try{
      runTime.exec("gpio pwm 1 0");
    }
    catch(IOException e){
      System.out.println(e);
    }
  }
    
}