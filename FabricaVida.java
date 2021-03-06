/*
 * Clase para fabricar paquetes medicos constantemente. 
 * La produción puede detenerse indeterminadamaente
 */

package pruebasproyecdiagnostico;

import crazyriverride.NaveSimple;
import crazyriverride.PaqueteMedico;
import crazyriverride.TanqueCombustible;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;


public class FabricaVida extends Thread {
    
    //Cantidad de objetos y los segundos entre cada nave
    private int cant, seg;
    //Hilo es para detener el Thread, y ciclo para detener la creacion
    // de naves
    private boolean ciclo, hilo; 
    
    /**
     * Metodo constructor de FabricaVida
     */
    public FabricaVida(){
       cant += 1;
       ciclo = true;
       hilo = true;
       seg = 15;
    }//Fin del constructor
    
    /**
     * Metodo devuelve la cantidad de objetos de se han creado.
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
    * Medoto establece el valor de la variable ciclo.
    * @param m
    * Sirve para detener un lapso de tiempo la creacion de naves, o bien
    * restablecerla.
    */
    public void setCiclo(boolean m){ 
        ciclo = m;
    }//Fin de setCiclo
    
    
    /**
     * Establece los segundos minimos entre una nave y otra
    */
    public void setSegundos(int seg){ 
        this.seg = seg;
    }//Fin de setSegundos
    
    
    @Override
    public void run(){
        while(hilo){
            while(ciclo){
                PaqueteMedico paquete = new PaqueteMedico();
                Image ImaPaquete = new ImageIcon(this.getClass().getResource("/Imagenes/vida.jpeg")).getImage();
                MovimientoObjeto.paquetesMed.insertarAlFrente(paquete);
                MovimientoObjeto.paquetesMedG.insertarAlFrente(ImaPaquete);

                //g.drawImage(avioncontrario, vrsX, vrsY, null);

                try {
                Thread.sleep (seg*1000);
                } catch (Exception e) {}    
            }//Fin del while 
        }//Fin del while 
    }//Fin de run
}//Fin de la FabricaVida
