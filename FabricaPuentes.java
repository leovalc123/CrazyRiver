/*
 * Clase para fabricar puentes constantemente. 
 * La produción puede detenerse indeterminadamaente.
 */
package pruebasproyecdiagnostico;

import crazyriverride.Kamikaze;
import crazyriverride.Puente;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author jonnaro14
 */
public class FabricaPuentes extends Thread{
    
    //Cantidad de objetos y los segundos entre cada objeto
    private int cant, seg;
    //Hilo es para detener el Thread, y ciclo para detener la creacion
    // de kamikaze
    private boolean ciclo, hilo; 
    
    public FabricaPuentes(){
       cant += 1;
       ciclo = true;
       hilo = true;
       seg = 20;
    }//Fin del constructor
    
    /**
     * Devuelve la cantidad de objetos de se han creado.
     * @return cant
     */
    public int getCant(){return cant;}
    
    
    /**
     * Detiene el hilo que se encarga de la creación de naves. 
     */
    public void stopThread(){ hilo = false;}
    
    
    /**
    * Establece el valor de m a la variable ciclo.
    * Sirve para detener un lapso de tiempo la creacion de objetos, o bien
    * restablecerla.
    */
    public void setCiclo(boolean m){ ciclo = m;}
    
    
    /**
     * Establece los segundos minimos entre un objeto y otro
    */
    public void setSegundos(int seg){ this.seg = seg;}
    
    
    @Override
    public void run(){
        
        try {
            Thread.sleep (10*1000);
        } catch (Exception e) {} 
        
        while(hilo){
            while(ciclo){
                Puente puente = new Puente();
                Image puent = new ImageIcon(this.getClass().getResource("/Imagenes/avion enemigo.jpg")).getImage();
                MovimientoObjeto.puentes.insertarAlFrente(puente);
                MovimientoObjeto.puentesG.insertarAlFrente(puent);

                //g.drawImage(avioncontrario, vrsX, vrsY, null);
                Random r = new Random();
                int s = seg + r.nextInt(5);

                try {
                Thread.sleep (s*1000);
                } catch (Exception e) {}    
            }//Fin del while 
        }//Fin del while 
    }//Fin del run
    
}//Fin de la clase
