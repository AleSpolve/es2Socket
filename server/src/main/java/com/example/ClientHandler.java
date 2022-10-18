package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    Socket s;
    static int x = 1;

    public ClientHandler(Socket s){
        this.s=s;
    } 

    public void run(){

        try {
            
        System.out.println("Client connesso");

        // per parlare
        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
          
        // per ascoltare
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.println(br.readLine()); // ricevo: Eccomi
        pr.println("Ciao, come ti chiami?"); // invio messaggio
        String nome = br.readLine(); // ricevo il nome
        System.out.println("nome ricevuto");
        System.out.println(nome.toUpperCase());//converto il nome in maiuscolo
        
        System.out.println("Benvenuto " + nome + " sei l'utente numero: " + x);
        System.out.println(br.readLine()); // leggo il saluto finale e lo metto in console
        
        x++;
        s.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
      
    }

}
