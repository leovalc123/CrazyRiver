package crazyriverride;

import java.util.Random;

/**
 *
 * @author jeja
 */
public class PaqueteMedico {
    
    private int vida;
    private int x, y;
    
    
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
    }
    
    
    
    public void setVida(int cant){
        this.vida += cant;
    }
    
    /**
     * Devuelve el vida del tanque
     * @return combustible
     */
    public int getVida(){
        return vida;
    }
    
    public void setPosX(int x){
        this.x = x;
    }
    
    public int getPosX (){
        return x;
    }
    
    public void setPosY(int y){
        this.y = y;
    }
    
    public int getPosY (){
        return y;
    }
    
    public void printPaqMed(){
        System.out.println("Vida: " + this.vida);
    }
}
