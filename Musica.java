package menu;

import java.applet.AudioClip;

public class Musica extends Thread{
    private String nombre;
    //Cantidad de objetos creados
    private static int num;
    private boolean fondo;
    
    /**
     * Metodo constructor de Musica
     */
    public Musica(){
        num += 1;
        setFondo();
        //fondo = false;
    }//Fin del constructor
    
    /**
     * Metodo constructor de musica
     * @param nom El parametro es la dirreccion de la musica
     */
    public Musica(String nom){
        nombre = nom;
        num += 1;
        setFondo();
        //fondo = false;
    }//Fin del constructor
    
    /**
     * Metodo define si la musica es de fondo o de accion
     */
    private void setFondo(){
        if(num == 1){
            fondo = true;
        }else{
            fondo = false;
        }//Fin del if4
    }//Fin de setFondo
    
    /**
     * Metodo devuelve la cantidad de objetos de este tipo que se han creado
     * @return num
     */
    public static int getNum(){ return num;}
    
    /**
     * Metodo define la direccion de la musica
     * @param nom 
     */
    public void setNombre(String nom){
        nombre = nom;
    }//Fin de setNombre
    
    
    @Override
    public void run() {
        
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource(nombre));
            sonido.play();
            if(fondo){
               sonido.loop();  
            }//Fi del if
        
    }//Fin del de run
}//Fin de Musica
