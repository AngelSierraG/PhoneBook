package Administrador;

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
        String peticion = null; 
        String mensaje[] = null;
        int action = 0;
        String strChating = "";





        try {
            b = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            p = new PrintStream(sc.getOutputStream());
            //Escribo en canal de escritura el mismo mensaje recibido
            peticion = b.readLine();//peticion
        } catch (IOException ex) {
            Logger.getLogger(RoomServer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (peticion != null) {
            System.out.println("Petition(hilo:" + i + "): " + peticion);

// split mensaje
           


            mensaje =  peticion.split(",");
            action = Integer.parseInt(mensaje[0]);

            /**
             *****************************************************************************************************************
             *******************************************Listar_Marcas(action=1)***********************************************
             *****************************************************************************************************************
                 */
                GestorMarcas gm = new GestorMarcas();
                 
                if (action == 1) {

                  
                    
                    
                    p.println(""+ gm.listaMarcas());
                    System.out.println("answer:" +"listaMarcas() succesfull");

                } /**
                 ***********************************************************************************************************
                 *******************************************Crear_Marcas(action=2)*************************************************
                 * **********************************************************************************************************
                 */
                else if (action == 2) {

                  
                  
                    
                    
                    p.println(""+ mensaje[1]+","+ mensaje[2]);
                    System.out.println("answer:" +"crearMarcas() succesfull");

                }/**
                 ***********************************************************************************************************
                 *******************************************Crear_Marcas(action=3)*************************************************
                 * **********************************************************************************************************
                 */
                else if (action == 3) {

                  
                    
                    
                    p.println(""+ gm.listaMarcas());
                    System.out.println("answer:" +"editarMarcas() succesfull");

                }/**
                 ***********************************************************************************************************
                 *******************************************Crear_Marcas(action=4)*************************************************
                 * **********************************************************************************************************
                 */
                else if (action == 4) {

                  
                    
                    
                    p.println(""+ gm.listaMarcas());
                    System.out.println("answer:" +"eliminarMarca() succesfull");

                }
                
                
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
