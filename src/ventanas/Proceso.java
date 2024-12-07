package ventanas;

import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

public class Proceso extends javax.swing.JFrame {

    Usuario usuario;
    
    public Proceso() {
        initComponents();
        this.setLocationRelativeTo(null);
        arrancar();
    }

    public void arrancar() {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        barra.setValue(i);
                        lblPorcentaje.setText(i + " %");
                        Thread.sleep(10);
                        if (i == 100) {
                            System.out.println("Pase por aqui");
                            if ("C".equalsIgnoreCase(usuario.getRol())) {
                                System.out.println("Soy cliente");
                                PrincipalCliente principalCliente = new PrincipalCliente();
                                principalCliente.setVisible(true);
                                setVisible(false);
                            } else {
                                System.out.println("Soy empleado");
                                PrincipalEmpleado principalEmpleado = new PrincipalEmpleado(usuario);                                                            
                                principalEmpleado.setVisible(true);
                                setVisible(false);
                                
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        hilo.start();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JProgressBar();
        lblPorcentaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, 674, 40));

        lblPorcentaje.setFont(new java.awt.Font("Eras Bold ITC", 3, 18)); // NOI18N
        lblPorcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentaje.setText("0%");
        getContentPane().add(lblPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 668, 32));

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 3, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CARGANDO SISTEMA...");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 674, 32));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPorcentaje;
    // End of variables declaration//GEN-END:variables
}
