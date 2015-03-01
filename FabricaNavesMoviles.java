/*
 * Clase para fabricar naves constantemente. 
 * La produción puede detenerse indeterminadamaente.
 */
package pruebasproyecdiagnostico;


import crazyriverride.NavesMoviles;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author jonnaro14
 */
public class FabricaNavesMoviles extends Thread{
    
    //Cantidad de objetos y los segundos entre cada nave
    private int cant, seg;
    //Hilo es para detener el Thread, y ciclo para detener la creacion
    // de naves indeterminadamente
    private boolean ciclo, hilo; 
    
    /**
     * Metodo constructor de FabricaNavesMoviles
     */
    public FabricaNavesMoviles(){
       cant += 1;
       ciclo = true;
       hilo = true;
       seg = 20;
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
    */
    public void setSegundos(int seg){ 
        this.seg = seg;
    }//Fin de setSegundos
    
    
    @Override
    public void run(){
        try {
            Thread.sleep (10*1000);
        } catch (Exception e) {}
        
        while(hilo){
            while(ciclo){
                NavesMoviles nave = new NavesMoviles();
                Image avionContrario = new ImageIcon(this.getClass().getResource("/Imagenes/avion2.jpeg")).getImage();
                MovimientoObjeto.navesMov.insertarAlFrente(nave);
                MovimientoObjeto.navesMovG.insertarAlFrente(avionContrario);

                //g.drawImage(avioncontrario, vrsX, vrsY, null);
                Random r = new Random();
                int s = seg + r.nextInt(10);

                try {
                Thread.sleep (s*1000);
                } catch (Exception e) {}    
            }//Fin del while 
        }//Fin del while 
        
        
    }//Fin de run
    
}//Fin de la FabricaNavesMoviles
