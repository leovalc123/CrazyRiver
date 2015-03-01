package crazyriverride;

import java.util.Random;

/**
 *
 * @author jeja
 */
public class PaqueteMedico {
    
    private int vida;
    private int x, y;
    
    /**
     * Metodo constructor de Paquete Medico
     */
    public PaqueteMedico(){
        Random random = new Random();
        //La vida aleatoria con una media de 30
        this.vida = (int) (30 + 2*random.nextGaussian());
        int posicion = random.nextInt(5) + 1;
        y = 0;
        switch(posicion){
            case 1:
                x = 300;
                break;
            case 2:
                x = 400;
                break;
            case 3:
                x = 360;
                break;
            case 4:
                x = 250;
                break;
            case 5:
                x = 390;
                break;
        }//Fin del switch
    }//Fin del constructor
    
    
    /**
     * Metodo define la vida que vuelve a adquirir el jugador
     * @param cant 
     */
    public void setVida(int cant){
        this.vida += cant;
    }//Fin de setVida
    
    /**
     * Metodo devuelve la cantidad vida 
     * @return vida
     */
    public int getVida(){
        return vida;
    }//Fin de getVida
    
    /**
     * Metodo define la posicion en x
     * @param x 
     */
    public void setPosX(int x){
        this.x = x;
    }//Fin de setPosX
    
    /**
     * Metodo devuelve la posicion en x
     * @return x
     */
    public int getPosX (){
        return x;
    }//Fin de getPosY
    
    /**
     * Metodo define la posicion en y
     * @param y 
     */
    public void setPosY(int y){
        this.y = y;
    }//Fin de setPosY
    
    /**
     * Metodo devuelve la posicion en y
     * @return y
     */
    public int getPosY (){
        return y;
    }//Fin de getPosY
    
    /**
     * Metodo imprime el paquete medico
     */
    public void printPaqMed(){
        System.out.println("Vida: " + this.vida);
    }//Fin de printPaqMed
}//Fin de Paquete Medico
