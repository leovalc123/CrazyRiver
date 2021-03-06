/*
 * Clase para fabricar naves constantemente. 
 * La produción puede detenerse indeterminadamaente
 */

package pruebasproyecdiagnostico;

import crazyriverride.NaveSimple;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;


public class FabricaNaves extends Thread {
    
    //Cantidad de objetos y los segundos entre cada nave
    private int cant, seg;
    //Hilo es para detener el Thread, y ciclo para detener la creacion
    // de naves
    private boolean ciclo, hilo; 
    
    /**
     * Metodo constructor de FabricaNaves
     */
    public FabricaNaves(){
       cant += 1;
       ciclo = true;
       hilo = true;
       seg = 13;
    }//Fin del constructor
    
    /**
     * Metodo devuelve la cantidad de objetos de se han creado.
     * @return cant
     */
    public int getCant(){
        return cant;
    }//Fin de getCant
    
    
    /**
     * Metod detiene el hilo que se encarga de la creación de naves. 
     */
    public void stopThread(){ 
        hilo = false;
    }//Fin de stopThread
    
    
    /**
    * Metodo establece el valor de la variable ciclo.
    * @param m
    * Sirve para detener un lapso de tiempo la creacion de naves, o bien
    * restablecerla.
    */
    public void setCiclo(boolean m){ 
        ciclo = m;
    }//Fin de setCiclo
    
    
    /**
     * Metodo establece los segundos minimos entre una nave y otra
     * @param seg
    */
    public void setSegundos(int seg){ 
        this.seg = seg;
    }//Fin de setSegundos
    
    
    @Override
    public void run(){
        while(hilo){
            while(ciclo){
                NaveSimple nave = new NaveSimple();
                Image avionContrario = new ImageIcon(this.getClass().getResource("/Imagenes/Nave enemiga.jpg")).getImage();
                MovimientoObjeto.naves.insertarAlFrente(nave);
                MovimientoObjeto.navesG.insertarAlFrente(avionContrario);

                //g.drawImage(avioncontrario, vrsX, vrsY, null);
                Random r = new Random();
                int s = seg + r.nextInt(6);

                try {
                Thread.sleep (s*1000);
                } catch (Exception e) {}    
            }//Fin del while 
        }//Fin del while 
        
        
    }//Fin de run
    
}//Fin de la FabricaNaves
