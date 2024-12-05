package ventanas;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class PrincipalCliente extends javax.swing.JFrame {

    Ventana1 v1 = new Ventana1();
    Ventana2 v2 = new Ventana2();

    public PrincipalCliente() {
        initComponents();
//        fondo.add(v1);
//        fondo.add(v2);

        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
//        barraHerramientas.setFloatable(false);
//        barraHerramientas.setSize(ancho, 40);
//        fondo.setSize(ancho, alto);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuTipoEmpleado = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        listadoEmpleados = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        borrarNotificacion = new javax.swing.JMenuItem();
        verNotificaciones = new javax.swing.JMenuItem();
        marcarComoVisto = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        logOut = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin filtro", "Días disponibles", "Días agendados" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(400, 90, 170, 26);

        jButton3.setText("Filtrar");
        getContentPane().add(jButton3);
        jButton3.setBounds(600, 90, 57, 24);

        jScrollPane2.setViewportView(jTextPane2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(370, 170, 180, 170);

        jLabel2.setText("Filtrar agenda");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 70, 80, 16);

        jLabel3.setText("Descripción");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 150, 90, 16);
        getContentPane().add(jCalendar2);
        jCalendar2.setBounds(30, 100, 300, 220);

        jButton1.setText("Editar solicitud");
        getContentPane().add(jButton1);
        jButton1.setBounds(610, 240, 100, 24);

        jButton2.setText("Agregar solicitud");
        getContentPane().add(jButton2);
        jButton2.setBounds(610, 190, 104, 24);

        jMenu1.setText("Tipo de empleado");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuTipoEmpleado.setText("jMenuItem2");
        jMenu1.add(menuTipoEmpleado);

        menuPrincipal.add(jMenu1);

        jMenu2.setText("Listado de empleados");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        listadoEmpleados.setText("jMenuItem2");
        jMenu2.add(listadoEmpleados);

        menuPrincipal.add(jMenu2);

        jMenu3.setLabel("Notificaciones");

        borrarNotificacion.setText("jMenuItem2");
        jMenu3.add(borrarNotificacion);

        verNotificaciones.setText("jMenuItem2");
        jMenu3.add(verNotificaciones);

        marcarComoVisto.setText("jMenuItem2");
        jMenu3.add(marcarComoVisto);

        menuPrincipal.add(jMenu3);

        jMenu4.setAlignmentX(1.0F);
        jMenu4.setLabel("Perfil");
        jMenu4.setVerifyInputWhenFocusTarget(false);

        logOut.setText("jMenuItem2");
        jMenu4.add(logOut);

        menuPrincipal.add(jMenu4);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        v1.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        v2.setVisible(true);
    }//GEN-LAST:event_jMenu2ActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem borrarNotificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JMenuItem listadoEmpleados;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JMenuItem marcarComoVisto;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem menuTipoEmpleado;
    private javax.swing.JMenuItem verNotificaciones;
    // End of variables declaration//GEN-END:variables
}
