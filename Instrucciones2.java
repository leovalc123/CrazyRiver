package menu;

/**
 *
 * @author Jose Eduardo
 */
public class Instrucciones2 extends javax.swing.JFrame {

    /**
     * Creates new form Instrucciones2
     */
    public Instrucciones2() {
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

        BotonAnterion = new javax.swing.JButton();
        BotonSiguiente = new javax.swing.JButton();
        FondoInstrucciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BotonAnterion.setBackground(java.awt.SystemColor.window);
        BotonAnterion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Anterior.gif"))); // NOI18N
        BotonAnterion.setOpaque(false);
        BotonAnterion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnterionActionPerformed(evt);
            }
        });
        getContentPane().add(BotonAnterion);
        BotonAnterion.setBounds(670, 530, 44, 41);

        BotonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Siguiente.gif"))); // NOI18N
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(BotonSiguiente);
        BotonSiguiente.setBounds(720, 530, 44, 41);

        FondoInstrucciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Instrucciones.jpg"))); // NOI18N
        getContentPane().add(FondoInstrucciones);
        FondoInstrucciones.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>                        
    /**
     * Metodo genera la accion al precionar el boton
     * @param evt 
     */
    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    /**
     * Metodo genera la accion al precionar el boton
     * @param evt 
     */
    private void BotonAnterionActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Instrucciones1.main();
        dispose();
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
            java.util.logging.Logger.getLogger(Instrucciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instrucciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instrucciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instrucciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instrucciones2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotonAnterion;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JLabel FondoInstrucciones;
    // End of variables declaration                   
}
