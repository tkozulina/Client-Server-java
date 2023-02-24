
package javaapplication18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaApplication18 {
//client
    public static void main(String[] args) throws IOException {
      
        
        Socket sock= new Socket("localhost", 30333);
        
        BufferedWriter writer = new BufferedWriter(
         new OutputStreamWriter(sock.getOutputStream()));
          BufferedReader reader = new BufferedReader (
        new InputStreamReader(sock.getInputStream()));
        String str;
        Scanner scan = new Scanner (System.in);//write data
        
        
      while (true){ //цикл для того чтобы передавалось несколько сообщений
            str=  scan.nextLine();
            writer.write(str);
            writer.newLine();//new Line
            writer.flush();

        //check
            if ("exit".equals(str)) break;//finish work, if I write exit//выход из цикла

            str= reader.readLine();
            System.out.println ("server sent : " + str);//read from socket
           
      
      }
    
    }
    
}
