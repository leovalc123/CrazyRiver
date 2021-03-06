/*
 * Clase para fabricar tanques de combustible constantemente. 
 * La produción puede detenerse indeterminadamaente
 */

package pruebasproyecdiagnostico;

import crazyriverride.NaveSimple;
import crazyriverride.TanqueCombustible;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;


public class FabricaCombustible extends Thread {
    
    //Cantidad de objetos y los segundos entre cada nave
    private int cant, seg;
    //Hilo es para detener el Thread, y ciclo para detener la creacion
    // de naves
    private boolean ciclo, hilo; 
    
    /**
     * Metodo constructor de FabricaCombustible
     */
    public FabricaCombustible(){
       cant += 1;
       ciclo = true;
       hilo = true;
       seg = 5;
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
    * Metodo establece la variable ciclo.
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
                TanqueCombustible tanque = new TanqueCombustible();
                tanque.printtanque();
                Image ImaTanque = new ImageIcon(this.getClass().getResource("/Imagenes/Gasolina.jpg")).getImage();
                MovimientoObjeto.combustibles.insertarAlFrente(tanque);
                MovimientoObjeto.combustiblesG.insertarAlFrente(ImaTanque);

                //g.drawImage(avioncontrario, vrsX, vrsY, null);
                Random r = new Random();
                int s = seg + r.nextInt(6);

                try {
                Thread.sleep (s*1000);
                } catch (Exception e) {}    
            }//Fin del while 
        }//Fin del while 
        
        
    }//Fin de run
    
}//Fin de FabricaCombustible
