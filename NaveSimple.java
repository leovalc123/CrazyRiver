package crazyriverride;

import Basico.ListaSimple;
import java.util.Random;


public class NaveSimple {
    
    private int vida;
    private int x,y, ancho, largo; //coordenadas de la nave
    private int tipoDeNave;
    private static ListaSimple naves;
    
    /**
     * Metodo constructor de NaveSimple
     */
    public NaveSimple(){
        Random random = new Random();
        //La vida aleatoria con una media de 3
        vida = (int)(3 + 0.7*random.nextGaussian());
        y = 0;
        int posicion = random.nextInt(6) + 1;
        //int tipoDeNave = random.nextInt(2);
        int tipoDeNave = 1;
        
        switch(tipoDeNave){ //Escoge el tipo de enemigo
            case 0:
                x = 200;
                break;
            case 1:
                    switch(posicion){ //Posicion en x
                case 1:
                    x = 210;
                    break;
                case 2:
                    x = 270;
                    break;
                case 3:
                    x = 350;
                    break;
                case 4:
                    x = 410;
                    break;
                case 5:
                    x = 470;
                    break;
                case 6:
                    x = 530;
                    break;
                
        }//Fin del switch

        }//Fin del switch
    }//Fin del constructor
    
    /**
     * Metodo devuelve la lista de naves
     * @return naves
     */
    public static ListaSimple getNaves (){
        return naves;
    }//Fin del metodo
    
    
    /**
     * Metodo baja la vida lo que indique el daño.
     * @param daño 
     */
    public void setVida(int daño){
        if(daño > 0){
            vida = vida - daño;
            if(vida < 0)
                vida = 0;
        }else{
            System.out.println("Metodo setVida en NaveSimple:\n"
                    + "el daño a la nave no puede ser negativo");
        }//Fin del else
    }//Fin de setVida
    
    
    /**
     * Metodo devuelve la vida.
     * @return vida
     */
    public int getVida(){
        return vida;
    }//Fin de getVida
    
    
    /**
     * Metodo define un valor a la coordenada x de la nave
     * @param x 
    */
    public void setX(int x){
        this.x = x;
    }//Fin de setX
    
    
    /**
     * Metodo devuelve la posicion en x 
     * @return x
     */
    public int getX(){ 
        return x;
    }//Fin de getX
    
    
    /**
     * Metodo devuelve el ancho de la nave (x).
    */
    public int getAncho(){
        return ancho;
    }//Fin de getAncho
    
    
    /**
     * Metodo devuelve el largo de la nave
     * @return largo
     */
    public int getLargo(){ 
        return largo;
    }//Fin de getLargo
    
    
    /**
     * Metodo devuelve el tipo de enemigo (avion o barco)
     */
    public int getTipoDeNave(){
        return tipoDeNave;
    }//Fin de getTipoDeNave
    
    
    /**
     * Metodo define un valor a la coordenada y
     * @param y
    */
    public void setY(int y){
        this.y = y;
    }//Fin de setY
    
    
    /**
     * Metodo devuelve la posicion en y 
     * @return y
     */
    public int getY(){ 
        return y;
    }//Fin de getY
    
    
    /**
     * Metodo imprime la informacion.
     */
    public void imprimirKamikaze(){
        System.out.println();
        System.out.println("La vida del kamikaze: " + vida);
        System.out.println();
    }//Fin de imprimirNaveSimple
    
}//Fin de la NaveSimple
