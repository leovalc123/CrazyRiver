/*
 * Clase para el menú principal.
 */

package menu;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import pruebasproyecdiagnostico.MovimientoObjeto;


public class Menu extends javax.swing.JFrame {
    private String[] arg;
    

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setSize(800,600);
        setResizable(false);
        setTitle("Crazy River Ride");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        BotonInstrucciones = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        TituloMenu = new javax.swing.JLabel();
        BotonJugar = new javax.swing.JButton();
        FondoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BotonInstrucciones.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        BotonInstrucciones.setText("Instrucciones");
        BotonInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInstruccionesActionPerformed(evt);
            }
        });
        getContentPane().add(BotonInstrucciones);
        BotonInstrucciones.setBounds(280, 270, 180, 40);

        BotonSalir.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        BotonSalir.setText("Salir");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(BotonSalir);
        BotonSalir.setBounds(280, 410, 180, 40);

        TituloMenu.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 36)); // NOI18N
        TituloMenu.setText("CRAZY RIVER RIDE");
        getContentPane().add(TituloMenu);
        TituloMenu.setBounds(210, 30, 390, 70);

        BotonJugar.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        BotonJugar.setText("Jugar");
        BotonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonJugarActionPerformed(evt);
            }
        });
        getContentPane().add(BotonJugar);
        BotonJugar.setBounds(280, 140, 180, 40);

        FondoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo menu.jpg"))); // NOI18N
        getContentPane().add(FondoMenu);
        FondoMenu.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>                        

    /**
     * Metodo genara la accion al precionar el boton
     * @param evt 
     */
    private void BotonInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Instrucciones1.main();
        dispose();
    }                                                  

    /**
     * Metodo genara la accion al precionar el boton
     * @param evt 
     */
    private void BotonJugarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        MovimientoObjeto.main(arg);
        dispose();
    }                                          

    /**
     * Metodo genara la accion al precionar el boton
     * @param evt 
     */
    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
        
        //Inicia el hilo para la musica
        //solamente si hay un solo objeto Musica 
        if(Musica.getNum() == 0){
            Musica m = new Musica("/Sonidos/MusicShort.wav");
            m.start();
        }//Fin del if   
        
 
    }//Fin del main
    
    
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotonInstrucciones;
    private javax.swing.JButton BotonJugar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JLabel FondoMenu;
    private javax.swing.JLabel TituloMenu;
    // End of variables declaration                   
}
