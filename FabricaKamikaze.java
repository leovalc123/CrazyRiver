/*
 * Clase para fabricar kamikaze constantemente. 
 * La produción puede detenerse indeterminadamaente
 */

package pruebasproyecdiagnostico;

import crazyriverride.Kamikaze;
import crazyriverride.NaveSimple;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author jonnaro14
 */
public class FabricaKamikaze extends Thread {
    
     //Cantidad de objetos y los segundos entre cada objeto
    private int cant, seg;
    //Hilo es para detener el Thread, y ciclo para detener la creacion
    // de kamikaze
    private boolean ciclo, hilo; 
    
    /**
     * Metodo constructor de FabricaKamikaze
     */
    public FabricaKamikaze(){
       cant += 1;
       ciclo = true;
       hilo = true;
       seg = 30;
    }//Fin del constructor
    
    
    /**
     * Metodoe dvuelve la cantidad de objetos de se han creado.
     * @return cant
     */
    public int getCant(){
        return cant;
    }//Fin de getCant
    
    
    /**
     * Metodo detiene el hilo que se encarga de la creación de naves. 
     */
    public void stopThread(){ 
        hilo = false;
    }//Fin de stopThread
    
    
    /**
    * Metodo establece el valor la variable ciclo.
    * @param m
    * Sirve para detener un lapso de tiempo la creacion de objetos, o bien
    * restablecerla.
    */
    public void setCiclo(boolean m){ 
        ciclo = m;
    }//Fin de setCiclo
    
    
    /**
     * Metodo establece los segundos minimos entre un objeto y otro
     * @param seg
    */
    public void setSegundos(int seg){ 
        this.seg = seg;
    }//Fin de setSegundos
    
    
    @Override
    public void run(){
        try {
            Thread.sleep (15*1000);
        } catch (Exception e) {}
        
        while(hilo){
            while(ciclo){
                Kamikaze nave = new Kamikaze();
                Image kamika = new ImageIcon(this.getClass().getResource("/Imagenes/kamikaze.jpeg")).getImage();
                MovimientoObjeto.kamikaze.insertarAlFrente(nave);
                MovimientoObjeto.kamikazeG.insertarAlFrente(kamika);

                //g.drawImage(avioncontrario, vrsX, vrsY, null);
                Random r = new Random();
                int s = seg + r.nextInt(10);

                try {
                Thread.sleep (s*1000);
                } catch (Exception e) {}    
            }//Fin del while 
        }//Fin del while 
        
    }//Fin de run
    
    
}//Fin de FabricaKamikaze
