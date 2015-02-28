package crazyriverride;

import Basico.ListaSimple;
import java.util.Random;


public class NaveSimple {
    
    private int vida;
    private int x,y, ancho, largo; //coordenadas de la nave
    private int tipoDeNave;
    private static ListaSimple naves;
    
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
    
    
    public static ListaSimple getNaves (){
        return naves;
    }//Fin del metodo
    
    
    /**
     * Baja la vida lo que indique el daño.
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
     * Devuelve la vida.
     * @return vida
     */
    public int getVida(){
        return vida;
    }//Fin de getVida
    
    
    /**
     * Asigna un valor a la coordenada x de la nave
    */
    public void setX(int x){
        this.x = x;
    }//Fin de setX
    
    
    /**
     * Posicion en x 
     * @return x
     */
    public int getX(){ return x;}
    
    
    /**
     * DEVUELVE el ancho de la nave (x).
    */
    public int getAncho(){
        return ancho;
    }//Fin de setX
    
    
    /**
     * Largo de y 
     * @return largo
     */
    public int getLargo(){ return largo;}
    
    
    /**
     * Devuelve el tipo de enemigo (avion o barco)
     */
    public int getTipoDeNave(){return tipoDeNave;}
    
    
    /**
     * Asigna un valor a la coordenada y 
    */
    public void setY(int y){
        this.y = y;
    }//Fin de setY
    
    
    /**
     * Posicion en y 
     * @return y
     */
    public int getY(){ return y;}
    
    
    /**
     * Imprime la informacion.
     */
    public void imprimirKamikaze(){
        System.out.println();
        System.out.println("La vida del kamikaze: " + vida);
        System.out.println();
    }//Fin de imprimirNaveSimple
    
}//Fin de la clase
