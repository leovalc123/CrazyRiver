package crazyriverride;

import Basico.ListaSimple;
import java.awt.Image;
import java.util.Random;

public class Puente {
    
    private int vida;
    private int x,y;
    private static ListaSimple <Puente> puentes = new ListaSimple();
    private static ListaSimple <Image> puentesG = new ListaSimple();
    
    /**
     * Metodo constructor de Puente
     */
    public Puente(){
        Random random = new Random();
        //La vida aleatoria con una media de 15
        vida = (int)(15 + 2*random.nextGaussian());
    }//Fin del constructor
    
    /**
     * Metodo devuelve la lista de puentes
     * @return puentes
     */
    public static ListaSimple getLista(){
        return puentes;
    }//Fin de getLista
    
    /**
     * Metodo devuelve la lista grafica de puentes
     * @return puentesG
     */
    public static ListaSimple getListaGrafica(){
        return puentesG;
    }//Fin de getLista
    
    /**
     * Metodo define el daño al puente
     * @param daño 
     */
    public void setVida(int daño){
        vida = vida - daño;
        if(vida <= 0){
            //DESTRUIR PUENTE
        }//Fin del if
    }//Fin de setVida
    
    
    /**
     * Devuelve la vida del puente
     * @return vida
     */
    public int getVida(){
        return vida;
    }//Fin de getVida
    
}//Fin de Puente
