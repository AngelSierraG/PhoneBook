package ServerAdmin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Angel Sierra
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomServer2 extends Thread {
    
   
     private Socket sc; //Socket cliente
     private PrintStream p; //Canal de escritura
     private BufferedReader b; //Canal de Lectura
     private  int i;
   
     

    private RoomServer2(Socket sc, int i) {
    this.sc = sc; 
    this.i = i; 
    
    
    }
   
    public void run() {
        
        String mensaje = null;
        int action = 0;
        String strChating = "";





        try {
            b = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            p = new PrintStream(sc.getOutputStream());
            //Escribo en canal de escritura el mismo mensaje recibido
            mensaje = b.readLine();//peticion
        } catch (IOException ex) {
            Logger.getLogger(RoomServer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mensaje != null) {
            System.out.println("Petition(hilo:" + i + "): " + mensaje);

// split mensaje
           



            action = Integer.parseInt(mensaje);

            /**
             ***********************************************************************************************************
             *******************************************Chating(action=1)***********************************************
                 * **********************************************************************************************************
                 */
                if (action == 1) {

                  
                    
                    
                    p.println("Lista");
                    System.out.println("answer:" +"Lista");

                } /**
                 ***********************************************************************************************************
                 *******************************************Login(action=2)*************************************************
                 * **********************************************************************************************************
                 */
        
                
            }
        

        
       
    }

    public static void main(String[] args) {
        ServerSocket s; //Socket servidor
        Socket sc; //Socket cliente
        PrintStream p = null; //Canal de escritura
        BufferedReader b = null; //Canal de Lectura
        int i=0;
        System.out.println("Server Running");
        try {
            //Escribo en canal de escritura el mismo mensaje recibido
            s = new ServerSocket(1112);
            System.out.println("ServerSocket Started in port 1112 ");
            



//Creo el socket server


//Invoco el metodo accept del socket servidor, me devuelve una referencia al socket cliente

//Obtengo una referencia a los canales de escritura y lectura del socket cliente


            while (true) {

                sc = s.accept();
              
                new Thread(new RoomServer2(sc, i)).start();
//Leo lo que escribio el socket cliente en el canal de lectura

i++;
            }
        } catch (IOException ex) {
            System.out.println("the socket wasn´t created");
            Logger.getLogger(RoomServer2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
