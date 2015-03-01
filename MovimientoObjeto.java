package pruebasproyecdiagnostico;


import Basico.ListaSimple;
import crazyriverride.Disparo;
import crazyriverride.Jugador;
import crazyriverride.Kamikaze;
import crazyriverride.NaveSimple;
import crazyriverride.NavesMoviles;
import crazyriverride.PaqueteMedico;
import crazyriverride.Puente;
import crazyriverride.TanqueCombustible;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import menu.Musica;

public class MovimientoObjeto extends JPanel implements ActionListener, KeyListener, Runnable {

    Timer tiempo = new Timer(60, this);
    Thread crono = new Thread(this);
    int tiemcomb = 0;
    int x = 200, y = 550, veloX = 0, veloY = 0;
    private static int navB, navGB;
    public  static ListaSimple <NaveSimple> naves;
    public  static ListaSimple <Image> navesG;
    public  static ListaSimple <NavesMoviles> navesMov;
    public  static ListaSimple <Image> navesMovG;
    public  static ListaSimple <Kamikaze> kamikaze;
    public  static ListaSimple <Image> kamikazeG;
    public  static ListaSimple <Puente> puentes;
    public  static ListaSimple <Image> puentesG;
    public  static ListaSimple <TanqueCombustible> combustibles;
    public  static ListaSimple <Image> combustiblesG;
    public  static ListaSimple <PaqueteMedico> paquetesMed;
    public  static ListaSimple <Image> paquetesMedG;
    public  static JLabel TitVida = new JLabel();
    private static Jugador jug = new Jugador(); //Si no se instancia aqui hay error
    

    public MovimientoObjeto() {
        tiempo.start();
        crono.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }//Fin de movimientoObjeto

    /**
     * Metodo inicializador
     */
    public void init() {
    }
    
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Image avion = new ImageIcon(this.getClass().getResource("/Imagenes/Nave aliada.jpg")).getImage();
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 200, 600);
        g.fillRect(600, 0, 200, 600);
        //g.drawImage(avion, x, y, null);
        g.drawImage(avion, jug.getX(), jug.getY(), null);
        
        int jugx, jugy, navx, navy;
        //Coordenadas del jugador
        jugx = jug.getX();
        jugy = jug.getY();
       
        
        //ACTIVAR LAS FABRICAS DE OBJETOS
        if(navB == 0){
            FabricaNaves fabNav = new FabricaNaves();
            fabNav.start();
            System.out.println("Hilo naves activado");
            
            FabricaNavesMoviles fabNavMov = new FabricaNavesMoviles();
            fabNavMov.start();
            System.out.println("Hilo naves activado");

            FabricaKamikaze fabk = new FabricaKamikaze();
            fabk.start();
            System.out.println("Hilo kamikaze activado");
            
            FabricaCombustible fabComb = new FabricaCombustible();
            fabComb.start();
            System.out.print("Hilo combustible activado");
            
            FabricaVida fabvida = new FabricaVida();
            fabvida.start();
            System.out.print("Hilo vida activado");
            
            navB = 1;
        }//Fin del if 
        
        
        if(Puente.getLista().len() > 0){
            
            
            
        }//Fin del if
        
        
        if(Jugador.getListaDisparos().len() > 0){
            for(int i = 0; i < Jugador.getListaDisparos().len(); i++){
                //Coordenadas de la nave en la posicion i
                int dx = ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).getX();
                int dy = ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).getY();
                Image imagen = ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).getImagen();
                
                for(int j = 0; j < navesG.len(); j++){
                    //Coordenadas de la nave en la posicion i
                    navx = naves.buscarPosicion2(j).getX();
                    navy = naves.buscarPosicion2(j).getY();
                    
                    if(  (dx > navx - 15) && (dx < navx + 40) && (dy > navy - 45) && (dy < navy + 45) ){
                        if(naves.buscarPosicion2(j).getVida() == 0){
                            Musica musica = new Musica("/Sonidos/explosion.wav");
                            musica.start();
                            naves.buscarPosicion2(j).setY(1000);
                        }//Fin del if
                        naves.buscarPosicion2(j).setVida(1);
                        g.drawImage(imagen, dx, dy+2000, null);
                        //naves.buscarPosicion2(j).setY(1000);
                        naves.buscarPosicion2(j).setVida(1);
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setX(2000);
                                                    
                    }else{
                        //Dibuja cada diaparo en su posicion
                        g.drawImage(imagen, dx, dy, null);
                        //Cambia las coordenadas para que se mueva en el y
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setY(dy - 5);
                    }//Fin del else
                }//Fin del for
                
                for(int j = 0; j < navesMov.len(); j++){
                    //Coordenadas de la nave en la posicion i
                    navx = navesMov.buscarPosicion2(j).getX();
                    navy = navesMov.buscarPosicion2(j).getY();
                    
                    if(  (dx > navx - 15) && (dx < navx + 40) && (dy > navy - 45) && (dy < navy + 45) ){
                        if(navesMov.buscarPosicion2(j).getVida() == 0){
                            Musica musica = new Musica("/Sonidos/explosion.wav");
                            musica.start(); 
                            navesMov.buscarPosicion2(j).setY(1000);
                        }//Fin del if
                        navesMov.buscarPosicion2(j).setVida(1);
                        g.drawImage(imagen, dx, dy+2000, null);
                        //navesMov.buscarPosicion2(j).setY(1000);
                        navesMov.buscarPosicion2(j).setVida(1);
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setX(2000);
                                     
                    }else{
                        //Dibuja cada diaparo en su posicion
                        g.drawImage(imagen, dx, dy, null);
                        //Cambia las coordenadas para que se mueva en el y
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setY(dy - 5);
                    }//Fin del else
                }//Fin del for
                
                for(int j = 0; j < kamikaze.len(); j++){
                    //Coordenadas de la nave en la posicion i
                    navx = kamikaze.buscarPosicion2(j).getX();
                    navy = kamikaze.buscarPosicion2(j).getY();
                    
                    if( (dx > navx - 15) && (dx < navx + 40) && (dy > navy - 45) && (dy < navy + 45) ){
                        
                        Musica musica = new Musica("/Sonidos/explosion.wav");
                        musica.start();
                        g.drawImage(imagen, dx, dy, null);
                        kamikaze.buscarPosicion2(j).setY(1000);
                        kamikaze.buscarPosicion2(j).setVida(1);
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setX(2000);
                    }else{
                        //Dibuja cada disparo en su posicion
                        g.drawImage(imagen, dx, dy, null);
                        //Cambia las coordenadas para que se mueva en el y
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setY(dy - 5);
                    }//Fin del else
                }//Fin del for
                
                for(int j = 0; j < paquetesMed.len(); j++){
                    //Coordenadas de la nave en la posicion i
                    int vidx = paquetesMed.buscarPosicion2(j).getPosX();
                    int vidy = paquetesMed.buscarPosicion2(j).getPosY();
                    
                    if( (dx > vidx - 15) && (dx < vidx + 30) && (dy > vidy - 45) && (dy < vidy + 45) ){
                        
                        Musica musica = new Musica("/Sonidos/explosion.wav");
                        musica.start();
                        g.drawImage(imagen, dx, dy+3000, null);
                        paquetesMed.buscarPosicion2(j).setPosX(4000);
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setX(2000);
                    }else{
                        //Dibuja cada disparo en su posicion
                        g.drawImage(imagen, dx, dy, null);
                        //Cambia las coordenadas para que se mueva en el y
                        ((Disparo)Jugador.getListaDisparos().buscarPosicion2(i)).setY(dy - 5);
                    }//Fin del else
                }//Fin del for
                
            }//Fin de for
        }//Fin del if

        
        //Movimiento y choque de naves simples
        if(navesG.len() > 0){
            
            for(int i = 0; i < navesG.len(); i++){
                //Coordenadas de la nave en la posicion i
                navx = naves.buscarPosicion2(i).getX();
                navy = naves.buscarPosicion2(i).getY();
                
                if(  (jugx > navx - 40) && (jugx < navx + 40) && (jugy > navy - 50) && (jugy < navy + 50) ){
                    /*
                    System.out.println();
                    System.out.println("Numero " + i);
                    System.out.println("Jugador x " + jug.getX());
                    System.out.println("Jugador y " + jug.getY());
                    System.out.println("Nave x: " + naves.buscarPosicion2(i).getX());
                    System.out.println("Nave y: " + naves.buscarPosicion2(i).getY());
                    System.out.println();*/
                    Musica musica = new Musica("/Sonidos/explosion.wav");
                    musica.start();
                    g.drawImage(navesG.buscarPosicion2(i), naves.buscarPosicion2(i).getX() + 1000, naves.buscarPosicion2(i).getY(), null);
                    naves.buscarPosicion2(i).setX(1000);
                    jug.setVida(-naves.buscarPosicion2(i).getVida());   
                    
                }else{
                    //Dibuja cada nave en su posicion
                    g.drawImage(navesG.buscarPosicion2(i), naves.buscarPosicion2(i).getX(), naves.buscarPosicion2(i).getY(), null);
                    //Cambia las coordenadas para que se mueva en el y
                    naves.buscarPosicion2(i).setY(naves.buscarPosicion2(i).getY() + 2);
                }//Fin del else
            }//Fin de for
        }//Fin del if
        
        
        
        //Movimiento y choque de naves Moviles
        if(navesMovG.len() > 0){
            
            for(int i = 0; i < navesMovG.len(); i++){
                //Coordenadas de la nave en la posicion i
                navx = navesMov.buscarPosicion2(i).getX();
                navy = navesMov.buscarPosicion2(i).getY();
                
                if(  (jugx > navx - 40) && (jugx < navx + 40) && (jugy > navy - 50) && (jugy < navy + 50) ){
                    Musica musica = new Musica("/Sonidos/explosion.wav");
                    musica.start();
                    g.drawImage(navesMovG.buscarPosicion2(i), navesMov.buscarPosicion2(i).getX() + 1000, navesMov.buscarPosicion2(i).getY(), null);
                    navesMov.buscarPosicion2(i).setY(2000);
                    jug.setVida(-navesMov.buscarPosicion2(i).getVida());  
                    
                }else{
                    //Dibuja cada nave en su posicion
                    g.drawImage(navesMovG.buscarPosicion2(i), navesMov.buscarPosicion2(i).getX(), navesMov.buscarPosicion2(i).getY(), null);
                    //Cambia las coordenadas para que se mueva en el y
                    navesMov.buscarPosicion2(i).setY(navesMov.buscarPosicion2(i).getY() + 1);
                    //System.out.println("Origen: " + navesMov.buscarPosicion2(i).getOrigenX());
                    
                    if( navesMov.buscarPosicion2(i).getDerIzq() == 1 ){
                        if (navesMov.buscarPosicion2(i).getOrigenX() + 20 >= navx){
                           navesMov.buscarPosicion2(i).setX(navesMov.buscarPosicion2(i).getX() + 1);
                        }else{
                           navesMov.buscarPosicion2(i).cambiarDerIzq();
                        }     
                    }else{
                        if (navesMov.buscarPosicion2(i).getOrigenX() - 20 <= navx){
                           navesMov.buscarPosicion2(i).setX(navesMov.buscarPosicion2(i).getX() - 1);
                        }else{
                            navesMov.buscarPosicion2(i).cambiarDerIzq();
                        }//Fin de else
                    }//Fin del else
                }//Fin del else
            }//Fin de for
        }//Fin del if
        
        
        
        //Choques y movimiento de los kamikaze
        if(kamikazeG.len() > 0){
            
            for(int i = 0; i < kamikazeG.len(); i++){
                //Coordenadas de la nave en la posicion i
                navx = kamikaze.buscarPosicion2(i).getX();
                navy = kamikaze.buscarPosicion2(i).getY();
                if(  (jugx > navx - 40) && (jugx < navx + 40) && (jugy > navy - 50) && (jugy < navy + 50) ){ 
                    Musica musica = new Musica("/Sonidos/explosion.wav");
                    musica.start();
                    g.drawImage(kamikazeG.buscarPosicion2(i), kamikaze.buscarPosicion2(i).getX() + 1000, kamikaze.buscarPosicion2(i).getY() + 2000, null);
                    kamikaze.buscarPosicion2(i).setY(2000);
                    jug.setVida(-jug.getVida()/2); 
                    
                }else{
                    //Dibuja cada nave en su posicion
                    g.drawImage(kamikazeG.buscarPosicion2(i), kamikaze.buscarPosicion2(i).getX(), kamikaze.buscarPosicion2(i).getY(), null);
                    //Cambia las coordenadas para que se mueva 
                    kamikaze.buscarPosicion2(i).setY(kamikaze.buscarPosicion2(i).getY() + 1);
                    if(jug.getX() > navx || jug.getX() < navx){
                        if(jug.getX() > navx){
                            //System.out.println("DERECHA");
                            kamikaze.buscarPosicion2(i).setX(kamikaze.buscarPosicion2(i).getX() + 1);
                        }else{
                            //System.out.println("IZQUIERDA");
                            kamikaze.buscarPosicion2(i).setX(kamikaze.buscarPosicion2(i).getX() - 1);
                        }//Fin del else
                    }//Fin del if
                }//Fin del else
            }//Fin de for
        }//Fin del if 
        
        //Movimiento y choque del paquete medico
        if(paquetesMedG.len() > 0){
            int vidx, vidy;
            //Coordenadas del jugador
            jugx = jug.getX();
            jugy = jug.getY();
   
            for(int i = 0; i < paquetesMedG.len(); i++){
                //Coordenadas de la nave en la posicion i
                vidx = paquetesMed.buscarPosicion2(i).getPosX();
                vidy = paquetesMed.buscarPosicion2(i).getPosY();
                
                if(  (jugx > vidx - 40) && (jugx < vidx + 40) && (jugy > vidy - 50) && (jugy < vidy + 50) ){
                    
                    g.drawImage(paquetesMedG.buscarPosicion2(i), paquetesMed.buscarPosicion2(i).getPosX() + 1000, paquetesMed.buscarPosicion2(i).getPosY(), null);
                    paquetesMed.buscarPosicion2(i).setPosX(1000);
                    jug.setVida(paquetesMed.buscarPosicion2(i).getVida());
                }else{
                    //Dibuja cada nave en su posicion
                    g.drawImage(paquetesMedG.buscarPosicion2(i), paquetesMed.buscarPosicion2(i).getPosX(), paquetesMed.buscarPosicion2(i).getPosY(), null);
                    //Cambia las coordenadas para que se mueva en el y
                    paquetesMed.buscarPosicion2(i).setPosY(paquetesMed.buscarPosicion2(i).getPosY() + 2);
                }//Fin del else
            }//Fin de for
        }//Fin del if
        
        //Movimiento y choque del Combustible
        if (combustiblesG.len() > 0) {
            int vidx, vidy;
            //Coordenadas del jugador
            jugx = jug.getX();
            jugy = jug.getY();

            for (int i = 0; i < combustiblesG.len(); i++) {
                //Coordenadas de la nave en la posicion i
                vidx = combustibles.buscarPosicion2(i).getPosX();
                vidy = combustibles.buscarPosicion2(i).getPosY();

                if ((jugx > vidx - 40) && (jugx < vidx + 30) && (jugy > vidy - 50) && (jugy < vidy + 30)) {

                    g.drawImage(combustiblesG.buscarPosicion2(i), combustibles.buscarPosicion2(i).getPosX() + 1000, combustibles.buscarPosicion2(i).getPosY(), null);
                    combustibles.buscarPosicion2(i).setPosX(1000);
                    jug.setCombustible(combustibles.buscarPosicion2(i).getCombustible());
                } else {

                    //Dibuja cada nave en su posicion
                    
                    g.drawImage(combustiblesG.buscarPosicion2(i), combustibles.buscarPosicion2(i).getPosX(), combustibles.buscarPosicion2(i).getPosY(), null);

                    //Cambia las coordenadas para que se mueva en el y
                    combustibles.buscarPosicion2(i).setPosY(combustibles.buscarPosicion2(i).getPosY() + 2);
                }//Fin del else
            }//Fin de for
        }//Fin del if
        
        
        
    }//Fin del metodo paint


    @Override
    public void actionPerformed(ActionEvent ae) {
        //x = x + veloX;
        //y = y + veloY;
        jug.setX(jug.getX() + veloX);
        jug.setY(jug.getY() + veloY);
        
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int b = ke.getKeyCode();
        
    }//Fin del metodo

    public static void main (String[] arg){
        MovimientoObjeto obj = new MovimientoObjeto();
        JFrame Ventana = new JFrame();
        Ventana.setTitle("Crazy River Ride");
        Ventana.setSize(850, 600);
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setLocationRelativeTo(null);
        Ventana.setResizable(false);
        Ventana.add(obj);
        TitVida.setText("<html>Nivel: " + "<br>" + jug.getNivel() + "<br>" +"Vida: " 
                + "<br>" + jug.getVida() + "<br>Combustible:" + "<br>" + 
                jug.getCombustible() + "<br>" + "Puntaje: " + "<br>"+ 
                jug.getPuntaje() + "</html>");
        TitVida.setFont(new Font("Arial",Font.PLAIN,20));
        Ventana.add(TitVida, BorderLayout.LINE_START);
        navB = 0;
        naves = new ListaSimple();
        navesG = new ListaSimple();
        kamikaze = new ListaSimple();
        kamikazeG = new ListaSimple();
        navesMov = new ListaSimple();
        navesMovG = new ListaSimple();
        puentes = new ListaSimple();
        puentesG = new ListaSimple();
        combustibles = new ListaSimple();
        combustiblesG = new ListaSimple();
        paquetesMed = new ListaSimple();
        paquetesMedG = new ListaSimple();
        
        //jug = new Jugador();
    }//Fin del mmin 
    

    
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("teclado");
        int b = e.getKeyCode();
        if (b == KeyEvent.VK_RIGHT) {
            if (jug.getX() < 558) {
                veloX = 5;
                veloY = 0;
            } else {
                veloX = 0;
                veloY = 0;
            }//Fin del else
        }//Fin del if
        
        if (b == KeyEvent.VK_LEFT) {
            if (jug.getX() > 202) {
                veloX = -5;
                veloY = 0;
            } else {
                veloX = 0;
                veloY = 0;
            }//Fin del else
        }//Fin del if
        
        if (b == KeyEvent.VK_UP) {
            if (jug.getY() > 1) {
                veloX = 0;
                veloY = -5;
            } else {
                veloX = 0;
                veloY = 0;
            }//Fin del else
        }//Fin del if
        
        if (b == KeyEvent.VK_DOWN) {
            if (jug.getY() < 510) {
                veloX = 0;
                veloY = 5;
            } else {
                veloX = 0;
                veloY = 0;
            }//Fin del else
        }//Fin del if
        
        if (b == KeyEvent.VK_SPACE) {
            //System.out.println("ESPACIO");
            if(jug.getMonicion(1) != 0){
                Disparo disparo = new Disparo("/Imagenes/misil2.jpeg");
                disparo.setX(jug.getX() + 20);
                disparo.setY(jug.getY() - 40);
                jug.setMunicion(1, -1);
                Jugador.getListaDisparos().insertarAlFrente(disparo);
            }//Fin del if
        }//Fin del if
        
    }//Fin del metodo
    

    @Override
    public void keyReleased(KeyEvent e) {
        int b = e.getKeyCode();

        if (b == KeyEvent.VK_LEFT) {
            veloX = 0;
            veloY = 0;
        }//Fin del if
        if (b == KeyEvent.VK_UP) {
            veloX = 0;
            veloY = 0;
        }//Fin del if
        if (b == KeyEvent.VK_RIGHT) {
            veloX = 0;
            veloY = 0;
        }//Fin del if
        if (b == KeyEvent.VK_DOWN) {
            veloX = 0;
            veloY = 0;
        }//Fin del if
    }//Fin del metodo
    
    @Override
    public void run() {
        try {
            for (;;) {
                crono.sleep(500);
                jug.setCombustible(-2);
                //crono.sleep(1000);
                //paquetesMedG.buscarPosicion2(i) =  
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
}//Fin de la clase
