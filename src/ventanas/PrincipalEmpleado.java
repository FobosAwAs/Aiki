package ventanas;

import dbconnect.DBConnect;
import dbconnect.EmpleadoDB;
import dbconnect.EmpleoDB;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JFrame;
import models.Empleo;
import models.EmpleoTableModel;
import models.EmpleoTableRenderer;
import models.Usuario;

public class PrincipalEmpleado extends javax.swing.JFrame {

   static DBConnect cx;
   Usuario usuario;
   
    public PrincipalEmpleado(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        cx = DBConnect.iniciar();
        cx.conectar();
        
        
        cargarTabla();     
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
     public PrincipalEmpleado() {
      
    }
    
    private void cargarTabla() {
        // Simulación: Lista de objetos Empleo
        List<Empleo> empleos = EmpleadoDB.getEmpleadoByIdUsuario(cx, usuario.getId()); // Método para obtener los empleos
        // Crear el modelo de la tabla
        EmpleoTableModel empleoModel = new EmpleoTableModel(empleos);
        // Asignar el modelo a la tabla
        tablaEmpleo.setDefaultRenderer(Object.class, new EmpleoTableRenderer());
        tablaEmpleo.setModel(empleoModel);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEmpleo = new javax.swing.JTable();
        menuPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEmpleo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEmpleo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaEmpleo);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 29, 540, 320));

        jMenu1.setLabel("Solicitudes");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("ABRIR VENTANA 1");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        menuPrincipal.add(jMenu1);

        jMenu2.setLabel("Editar agenda");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("ABRIR VENTANA 2");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        menuPrincipal.add(jMenu2);

        jMenu3.setLabel("Notificaciones");
        menuPrincipal.add(jMenu3);

        jMenu4.setAlignmentX(1.0F);
        jMenu4.setLabel("Perfil");
        jMenu4.setVerifyInputWhenFocusTarget(false);
        menuPrincipal.add(jMenu4);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
       
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
      
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
       
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void tablaEmpleoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleoMouseClicked
        int columna = tablaEmpleo.getColumnModel().getColumnIndexAtX(evt.getX());
        int fila = evt.getY() / tablaEmpleo.getRowHeight();
        int colCount = tablaEmpleo.getColumnCount();
        int filCount = tablaEmpleo.getRowCount();
        
        if (columna <= colCount && columna >= 0 && fila <= filCount && fila >= 0) {
            EmpleoTableModel tm = (EmpleoTableModel)tablaEmpleo.getModel();
            Empleo e = tm.getEmpleo(fila);
            
            if (columna == EmpleoTableModel.DELETE_COLUMN) {
                rechazarEmpleo(e);
                tm.eliminarEmpleo(fila);
            } else if (columna == EmpleoTableModel.ACCEPT_COLUMN && validarAceptarEmpleo(e, fila)) {
                aceptarEmpleo(e);
            }
            tm.fireTableDataChanged();
        }
    }//GEN-LAST:event_tablaEmpleoMouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalEmpleado().setVisible(true);
            }
        });
    }
    
    public boolean validarAceptarEmpleo(Empleo e, int fila) {
        EmpleoTableModel tm = (EmpleoTableModel)tablaEmpleo.getModel();
        for (int i = 0; i < tm.getRowCount(); i++) {
            if (i == fila) {
                continue;
            }
            
            Empleo t = tm.getEmpleo(i);
            if (t.getFecha().equals(e.getFecha()) && (t.getEstado() == 1) || e.getEstado() == 1) {
                return false;
            }
        }
        return true;
    }
    
    public void aceptarEmpleo(Empleo e) {
        if (e.getEstado() == 0) {
            EmpleoDB.actualizarEstadoEmpleo(cx, e.getId());
            e.setEstado(1);
            System.out.println("Actualizado -> " + e.getId() + " | " + e);
        } else {
            System.out.println("Skippeado   -> " + e.getId() + " | " + e);
        }
    }
    
    public void rechazarEmpleo(Empleo e) {
        if (e.getEstado() == 0) {
            EmpleoDB.eliminarEmpleo(cx, e.getId());
            System.out.println("Eliminado -> " + e.getId() + " | " + e);
        } else {
            System.out.println("Skippeado   -> " + e.getId() + " | " + e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JTable tablaEmpleo;
    // End of variables declaration//GEN-END:variables
}
