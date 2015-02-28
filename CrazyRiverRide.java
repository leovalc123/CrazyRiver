package crazyriverride;

import java.applet.AudioClip;
import java.io.*;
import java.util.Random;
import menu.Menu;
import sun.audio.*;

public class CrazyRiverRide {

    public static void main(String[] args) throws Exception {
        //Jugador m = new Jugador();
        Random r = new Random();
        
        String s = "a";
        
        for(int i = 0; i <= 5; i++){
            
            System.out.println((int)(r.nextInt(5)));
        }//Fin
        Menu.main(args);
      
        /*for(int i = 0; i <= 30; i++){
            System.out.println((int)(3 + 0.7*r.nextGaussian()));
        }
        
        //m.setMunicion(2, 9);
        //m.setMunicion(3, 8);
        //m.setMunicion(98, -2);
        //m.imprimirJugador();
        
        /*String nombre = "C:/Users/kenneth/Desktop/My Shared Folder/indian moonshine.mp3";
        InputStream in = new FileInputStream (nombre);
        AudioStream sonido = new AudioStream(in);
        AudioPlayer.player.start(sonido);*/
        
        /*long n = System.currentTimeMillis();
        System.out.println(n/100000000);
        try {
            Thread.sleep (10*1000);
        } catch (Exception e) {

        }
        System.out.println((System.currentTimeMillis() - n)/1000);*/
        
    }//Fin del main
    
}//Fin de la clase
