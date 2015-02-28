package menu;

import java.applet.AudioClip;

public class Musica extends Thread{
    private String nombre;
    //Cantidad de objetos creados
    private static int num;
    private boolean fondo;
    
    public Musica(){
        num += 1;
        setFondo();
        //fondo = false;
    }//Fin del constructor
    
    public Musica(String nom){
        nombre = nom;
        num += 1;
        setFondo();
        //fondo = false;
    }//Fin del constructor
    
    private void setFondo(){
        if(num == 1){
            fondo = true;
        }else{
            fondo = false;
        }//Fin del if4
    }//Fin de setFondo
    
    /**
     * Devuelve la cantidad de objetos de este tipo que se han creado
     * @return num
     */
    public static int getNum(){ return num;}
    
    
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
        
    }//Fin del metodo
    
    
}//Fin
