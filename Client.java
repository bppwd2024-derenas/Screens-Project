import java.net.*;
import java.io.*;

public class Client extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try{
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
        }
        catch(IOException e){
            System.out.println(e);
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
            client.startConnection("127.0.0.1", 6666);
        }
    }
}