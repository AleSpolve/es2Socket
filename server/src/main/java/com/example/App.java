package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.plaf.TreeUI;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
        boolean a=true;
        
        while(a){
          
        Socket s = ss.accept();
        
        ClientHandler ch=new ClientHandler(s);

        ch.start();
        
        
      }

      ss.close();
        
    }
}
