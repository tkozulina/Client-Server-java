
package javaapplication17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


public class ClientThread implements Runnable{
    //поток для нескольких клиентов
    private Socket sock;
    private Thread self;
    private static int counter; //counter of clients
    private final int id;// id of client
    private BufferedReader reader;
    private BufferedWriter writer;
    private ArrayList <ClientThread> clients;
          
    public ClientThread(Socket sock, ArrayList<ClientThread> clients) throws IOException { //constructor
    this.sock=sock;
    this.clients=clients;
    self= new Thread(this);
    id=counter++;
     this.writer=writer;
         
    }

     public void startProcessing () throws IOException{
    reader=new BufferedReader(
                new InputStreamReader(sock.getInputStream()));//read a file
    writer = new BufferedWriter (
                new OutputStreamWriter (sock.getOutputStream()));//write
    self.start();//start thread
 
    
     }

    @Override
    public void run() {//method run
        String str;
        try {
        while(true){
           
            str= reader.readLine(); 
           System.out.println("client " + id +" sent " + str);
         for(ClientThread client:clients){
    
            client.writer.append(str);
                writer.newLine();

            }
            
        if ("exit".equals(str))break;//check
   
       writer.write(" accepted\n");
       writer.flush();//no messages
            }
        }
        catch (IOException ex){
            System.out.println (ex.getMessage());
        }
        
        System.out.println("client-" +id + " disconnected");
    }
    
    
//    private void show(String msg) throws IOException{
//    
//    for(ClientThread client:clients){
//    
//    writer.write( msg);
//     writer.newLine();
//
//            }
        
    }
    

    
   
    

 
    
    

