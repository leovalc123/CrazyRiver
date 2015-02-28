package crazyriverride;

import Basico.ListaSimple;
import crazyriverride.Disparo;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pruebasproyecdiagnostico.MovimientoObjeto;
import static pruebasproyecdiagnostico.MovimientoObjeto.TitVida;

public class Jugador {
    
    private int vida;
    private int combustible;
    private int puntaje;
    private int nivel;
    private int x,y; //Coordenadas
    //Tipos de municion 
    private int mBas; //Municion basica
    private int mPro; //Municion Pro
    private int mDif; //Municion difusión
    private int mMay; //Municion Mayhem
    private static ListaSimple <Disparo> disparos = new <Disparo> ListaSimple();
    
    /**
     * Metodo constructor de jugador
     */
    public Jugador(){
        vida = 100;
        combustible = 100;
        puntaje = 0;
        nivel = 1;
        mBas = 35;
        mPro = 0;
        mDif = 0;
        mMay = 0;
        x = 400;
        y = 520;
    }//Fin del constructor
        
    
    /**
     * Metodo devuelve la lista que contiene los disparos.
     * @return disparos La ListaSimple de los disparos
     */
    public static ListaSimple getListaDisparos(){ 
        return disparos;
    }
    
    /**
     * Metodo suma o resta la vida actual e imprime los valores de juego en pantalla
     * @param num El parametro es la cantidad de vida que se suma o resta
     * (es negativo para restar y positivo para sumar)
     * Si la suma es mayor que 100, la vida toma su valor
     * maximo que es 100. En caso de ser menor o igual a cero el juegador pierde.
    */
    public void setVida(int num){
        if(num >= 0){
            vida += num;
            if(vida > 100)
                vida = 100;
        }else{
            vida += num;
            if(vida <= 0){
                vida = 0;
                //AGREGAR FUNCION TERMINA EL JUEGO
            }//Fin del if
        }//Fin del else
        System.out.println("La vida del jugador cambio a " + vida);
        MovimientoObjeto.TitVida.setText("<html>Nivel: " + "<br>" + this.getNivel() + 
                "<br>" +"Vida: " + "<br>" + this.vida + "<br>Combustible:" + "<br>" + 
                this.getCombustible() + "<br>" + "Puntaje: " + "<br>"+ 
                this.getPuntaje() + "</html>");
    }// Fin de setVida
    
    
    /**
     * Metodo devuelve la vida del jugador.
     * @return vida
     */
    public int getVida(){
        return vida;
    }//Fin de getVid
    
     
    /**
     * Método suma o resta el combustible actual e imprime los valores de juego en pantalla
     * @param num El parametro es la cantidad de combustible que se va a sumar 
     * o restar (es negativo para restar y positivo para sumar)
     * Si la suma es mayor que 100, el combustible toma su valor
     * maximo que es 100. En caso de ser menor o igual a cero el juegador pierde.
    */
    public void setCombustible(int num){
        if(num >= 0){
            combustible += num;
            if(combustible > 100)
                combustible = 100;
        }else{
            combustible += num;
            if(combustible <= 0){
                combustible = 0;
                //AGREGAR FUNCION TERMINA EL JUEGO
            }//Fin del if
        }//Fin del else
        System.out.println("Combustible del jugador cambio a " + combustible);
        MovimientoObjeto.TitVida.setText("<html>Nivel: " + "<br>" + this.getNivel() + 
                "<br>" +"Vida: " + "<br>" + this.getVida() + "<br>Combustible:" +
                "<br>" + this.combustible + "<br>" + "Puntaje: " + "<br>"+ 
                this.getPuntaje() + "</html>");
    }// Fin de setCombustible
    
    
    /**
     * Metodo devuelve el combustible que tiene el jugador.
     * @return combustible
     */
    public int getCombustible(){
        return combustible;
    }//Fin de getCombustible
    
    /**
     * Metodo define el puntaje que tiene el jugador e imprime valores de juego en pantalla.
     * @param sumar El parametro es la cantidad de puntaje que el jugador obtiene
     */
    public void setPuntaje(int sumar){
        this.puntaje += sumar;
        System.out.println("Puntaje del jugador cambio a " + puntaje);
        MovimientoObjeto.TitVida.setText("<html>Nivel: " + "<br>" + this.getNivel() + 
                "<br>" +"Vida: " + "<br>" + this.getVida() + "<br>Combustible:" +
                "<br>" + this.getCombustible() + "<br>" + "Puntaje: " + "<br>"+ 
                this.puntaje + "</html>");
    }
    
    /**
     * Metodo devuelve el puntaje que tiene el jugador.
     * @return puntaje
     */
    public int getPuntaje(){
        return puntaje;
    }
    
    /**
     * Metodo sube el nivel del juego
     */
    public void subirNivel(){
        this.nivel += 1;
        System.out.println("Nivel del jugador cambio a " + nivel);
        MovimientoObjeto.TitVida.setText("<html>Nivel: " + "<br>" + this.nivel + 
                "<br>" +"Vida: " + "<br>" + this.getVida() + "<br>Combustible:" +
                "<br>" + this.getCombustible() + "<br>" + "Puntaje: " + "<br>"+ 
                this.getPuntaje() + "</html>");
    }
    
    /**
     * Metodo devuelve el nivel de juego
     * @return nivel
     */
    public int getNivel(){
        return nivel;
    }
    
    /**
     * Método suma o resta la municion actual
     * @param tipo El parametro es el tipo de muncion que se debe sumar o restar
     * @param municion El parametro es la cantidad de municiones a cambiar 
     * (es negativo para restar y positivo para sumar)
     * Si la suma es mayor que 40, el combustible toma su valor
     * maximo que es 40. En caso de ser menor o igual a cero el juegador pierde.
    */
    public void setMunicion(int tipo, int municion){
        switch(tipo){
            case 1:
                mBas += municion;
                if(mBas > 40)
                    mBas = 40;
                System.out.println("municion tipo " + tipo + " cambio a " + mBas);
                break;
                
            case 2:
                mPro += municion;
                if(mPro > 40)
                    mPro = 40;
                System.out.println("municion tipo " + tipo + " cambio a " + mPro);
                break;
            case 3:
                mDif += municion;
                if(mDif > 40)
                    mDif = 40;
                System.out.println("municion tipo " + tipo + " cambio a " + mDif);
                break;
                
            case 4:
                mMay += municion;
                if(mMay > 40)
                    mMay = 40;
                System.out.println("municion tipo " + tipo + " cambio a " + mMay);
                break; 
                
            default:
                JOptionPane.showMessageDialog(null, "Metodo setMunicion en Jugador:\n"
                        + "Solo existen 4 tipos de "
                        + "municiones (1 al 4)");
                break;
        }//Fin del switch
    }// Fin de setmunicion
    
    
    /**
     * Metodo devuelve el numero de municiones que tiene el jugador
     * @param tipo El paramatro indica el tipo de municion
     * @return municion Si el tipo no es ninguno de los cuatro, devuelve -1.
     */
    public int getMonicion(int tipo){
        int municion = -1;
        switch(tipo){
            case 1:
                municion = mBas;
                break;            
            case 2:
                municion = mPro;
                break;
            case 3:
                municion = mDif;
                break;
            case 4:
                municion = mMay;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Metodo getMunicion en Jugador:\n "
                        + "Solo existen 4 tipos de"
                        + "municiones (1 al 4)");
                System.out.println("dddfrr");
                break;
        }//Fin del switch
        return municion;
    }//Fin de getMunicion
    
    /**
     * Metodo define un valor a la coordenada x de la nave
     * @param x Coordenada x
    */
    public void setX(int x){
        this.x = x;
    }//Fin de setX
    
    
    /**
     * Metodo devuelve la posicion en x de la nave
     * @return x Coordenada x
     */
    public int getX(){ 
        return x;
    }//Fin de getX
    
    
    /**
     * Metodo define la coordenada y de la nave
     * @param y Coordenada y
    */
    public void setY(int y){
        this.y = y;
    }//Fin de setY
    
    
    /**
     * Metodo devuelve la posicion en y de la nave
     * @return y
     */
    public int getY(){ 
        return y;
    }//Fin de getY
    
    
    /**
     * Metodo imprime la información del jugador.
     */
    public void imprimirJugador(){
        System.out.println();
        System.out.println("La vida del jugador: " + this.getVida());
        System.out.println("El combustible del jugador: " + this.getCombustible());
        System.out.println("La municion basica " + this.getMonicion(1));
        System.out.println("La municion Pro: " + this.getMonicion(2));
        System.out.println("La municion Difusion: " + this.getMonicion(3));
        System.out.println("La municion Mayhem: " + this.getMonicion(4));
        System.out.println();
    }//Fin de immprimirJugador
    
}//Fin de Jugador
