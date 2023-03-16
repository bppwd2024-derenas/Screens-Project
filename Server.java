import java.net.*;
import java.io.*;

public class Server{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startServer(int port) {
        try{
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public void sendMessage(String m){
        out.println(m);
    }

    public void stopServer() {
        try{
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Server server=new Server();
        server.startServer(6666);
    }
}