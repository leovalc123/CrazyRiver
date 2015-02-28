package menu;

/**
 *
 * @author Jose Eduardo
 */
public class Instrucciones1 extends javax.swing.JFrame {

    /**
     * Creates new form Instrucciones1
     */
    public Instrucciones1() {
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

        BotonAnterior = new javax.swing.JButton();
        BotonSiguiente = new javax.swing.JButton();
        FondoInstrucciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BotonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Anterior.gif"))); // NOI18N
        BotonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(BotonAnterior);
        BotonAnterior.setBounds(670, 530, 44, 41);

        BotonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Siguiente.gif"))); // NOI18N
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(BotonSiguiente);
        BotonSiguiente.setBounds(720, 530, 44, 41);

        FondoInstrucciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Instrucciones 1.jpg"))); // NOI18N
        getContentPane().add(FondoInstrucciones);
        FondoInstrucciones.setBounds(0, 0, 790, 600);

        pack();
    }// </editor-fold>                        

    private void BotonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String[] args = null;
        Menu.main(args);
        dispose();
    }                                             

    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {                                               
        String[] args = null;
        Instrucciones2.main(args);
        dispose();
    }                                              

    /**
     * @param args the command line arguments
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(Instrucciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instrucciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instrucciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instrucciones1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instrucciones1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BotonAnterior;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JLabel FondoInstrucciones;
    // End of variables declaration                   
}