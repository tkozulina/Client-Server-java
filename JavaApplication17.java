
package javaapplication17;

//import com.sun.jmx.snmp.daemon.ClientHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class JavaApplication17 {
//server// принимает несколько сообщений
    
    private static ArrayList<ClientThread> clients = new ArrayList<>();
    public static void main(String[] args) throws IOException {
       
        ServerSocket server= new ServerSocket(30333);
        
        while (true){//бесконечный цикл
        Socket sock= server.accept();//wait for connection
          System.out.println("client " +
                  sock.getInetAddress().getCanonicalHostName() + " connected");//check
       
          ClientThread clientThread = new ClientThread(sock,clients);
        //new ClientThread(sock, clients).startProcessing();//clients work
          clients.add(clientThread);
          clientThread.startProcessing();
        }        
    }
    
}
