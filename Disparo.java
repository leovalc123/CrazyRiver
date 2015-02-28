/*
 * Representa un disparo
 */

package crazyriverride;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 
 */
public class Disparo {
    
    private int x,y;
    private String nombre;
    private Image imagen;
    
    /**
     * Metodo constructor de disparo 
     * @param nombre El parametro es la dirreccion de la imagen
     */
    public Disparo(String nombre){
        this.nombre = nombre;
        imagen = new ImageIcon(this.getClass().getResource(nombre)).getImage();
    }//Fin del constructor
    
    /**
     * Metodo devuelve la imagen.
     * @return imagen
     */
    public Image getImagen(){
        return imagen;
    }//Fin de getImagen
    
    /**
     * Metodo devuelve la ubicacion de la imagen como un string.
     * @return nombre Ubicacion de la imagen
     */
    public String getNombre(){ 
        return nombre;
    }//Fin de getNombre
    
    
    /**
     * Metodo establece la coordenada x del disparo.
     * @param x Coordenada x
     */
    public void setX(int x){ 
        this.x = x;
    }//Fin de setX
    
    
    /**
     * Metodo devuelve la coordenada x del disparo
     * @return x Coordenada x
     */
    public int getX(){ 
        return this.x;
    }//Fin de getX
    
    
    /**
     * Metodo establece la coordenada y del disparo.
     * @param y Coordenada y
     */
    public void setY(int y){ 
        this.y = y;
    }//Fin de setY
    
    
    /**
     * Devuelve la coordenada y del disparo
     * @return y Coordenada y
     */
    public int getY(){ 
        return this.y;
    }//Fin de getY
    
}//Fin de Disparo
