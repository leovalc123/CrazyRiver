/*
 * Clase para representar a los kamikaze
 */

package crazyriverride;

import java.util.Random;

/**
 *
 * @author jonnaro14
 */
public class Kamikaze {
    
    private int vida;
    private int x,y; //coordenadas de la nave
    
    /**
     * Metodo constructor de Kamikaze
     */
    public Kamikaze(){
        Random random = new Random();
        //La vida aleatoria con una media de 3
        vida = 1;
        int posicion = random.nextInt(5) + 1;
        y = 0;
        switch(posicion){
            case 1:
                x = 200;
                break;
            case 2:
                x = 260;
                break;
            case 3:
                x = 340;
                break;
            case 4:
                x = 400;
                break;
            case 5:
                x = 460;
                break;
        }//Fin del switch
    }//Fin del constructor
    
    
    /**
     * Baja la vida de la nave  lo que indique el daño.
     * @param daño 
     */
    public void setVida(int daño){
        if(daño > 0){
            vida = vida - daño;
        }else{
            System.out.println("Metodo setVida en Kamikaze:\n"
                    + "el daño a la nave no puede ser negativo");
        }//Fin del else
    }//Fin de setVida
    
    
    /**
     * Devuelve la vida del kamikaze.
     * @return vida
     */
    public int getVida(){
        return vida;
    }//Fin de getVida
    
    
    /**
     * Metodo define un valor a la coordenada x del kamikaze
     * @param x El parametro es la coordenada x
    */
    public void setX(int x){
        this.x = x;
    }//Fin de setX
    
    
    /**
     * Metodo devuelve la posicion en x del Kamikaze.
     * @return x
     */
    public int getX(){ 
        return x;
    }//Fin del getY
    
    
    /**
     * Metodo define un valor a la coordenada y del Kamikaze
     * @param y El parametro es la coordenada y
    */
    public void setY(int y){
        this.y = y;
    }//Fin de setY
    
    
    /**
     * Metodo devuelve la posicion en y del kamikaze.
     * @return y
     */
    public int getY(){ 
        return y;
    }//Fin de getY
    
    
    /**
     * Metodo imprime la informacion del kamikaze.
     */
    public void imprimirKamikaze(){
        System.out.println();
        System.out.println("La vida del kamikaze: " + vida);
        System.out.println();
    }//Fin de imprimirNaveSimple
    
}//Fin de la clase
