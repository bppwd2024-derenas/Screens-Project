import java.net.*;
import java.io.*;

public class Client extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private RobotController robot;

    private String currentCommand;

    public Client(){
        robot = new RobotController();
    }

    public void startConnection(String ip, int port) {
        try{
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                if(inputLine == "forward") robot.forward();
                if(inputLine == "backward") robot.backward();
                if(inputLine == "left") robot.left();
                if(inputLine == "right") robot.right();

                if(inputLine == "unforward" && currentCommand == "forward") robot.stop();
                if(inputLine == "unbackward" && currentCommand == "backward") robot.stop();
                if(inputLine == "unleft" && currentCommand == "left") robot.stop();
                if(inputLine == "unright" && currentCommand == "right") robot.stop();

                currentCommand = inputLine;
            }
        }
        catch(IOException e){
            System.out.println(e);
            robot.stop();
        }
    }

    public String sendMessage(String msg) {
        try{
            out.println(msg);
            String resp = in.readLine();
            return resp;
        }
        catch(IOException e){
            System.out.println(e);
            return "Error Occured";
        }
    }

    public void stopConnection() {
        try{
            in.close();
            out.close();
            if(clientSocket != null) clientSocket.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        while (true){
            client.startConnection("10.45.76.113", 6666);
        }
    }
}