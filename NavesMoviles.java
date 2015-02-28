/*
 * Clase para modelar las naves moviles. Extiende de la clase NaveSimple
 * dado que son practicamente iguales.
 */

package crazyriverride;

/**
 *
 * @author jonnaro14
 */
public class NavesMoviles extends NaveSimple {
    
    //Variable para manejar el movimiento de la nave en el eje x
    private int origenX, derIzq;
    
    
    public NavesMoviles(){
        super();
        origenX = super.getX();
        derIzq = 1;
    }//Fin del constructor
    
    /**
     * Devuelve el valor de x en el que aparecio la nave en un inicio
     * @return origenX
     */
    public int getOrigenX(){return origenX;}
    
    /**
     * Devuelve el valor de x en el que aparecio la nave en un inicio
     * @return origenX
     */
    public int getDerIzq(){return derIzq;}
    
    
    /**
     * Cambia la variable derIzq. Si es 1, lo pasa a 0 y viceversa
     */
    public void cambiarDerIzq(){
        if(derIzq == 1){
            derIzq = 0;
        }else{
            derIzq = 1;
        }
    }//Fin del metodo

}//Fin de la clase
