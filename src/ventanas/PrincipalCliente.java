package ventanas;

import dbconnect.DBConnect;
import dbconnect.EmpleadoDB;
import dbconnect.EmpleoDB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Empleo;
import models.Usuario;
import models.EvaluadorFecha;



public class PrincipalCliente extends javax.swing.JFrame {

    static DBConnect cx;
    Ventana1 v1 = new Ventana1();
    Ventana2 v2 = new Ventana2();
    List<Usuario> empleados = null;
    EvaluadorFecha evaluator = new EvaluadorFecha();

    public PrincipalCliente() {
        initComponents();
        jCalendarCliente.setEnabled(false);
        setSize(700, 500);
        cx = DBConnect.iniciar();
        cx.conectar();
        llenarComboEmpleados();
        this.setLocationRelativeTo(null);
        jCalendarCliente.getJCalendar().getDayChooser().addDateEvaluator(evaluator);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jComboEmpleados = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDescripcion = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jCalendarCliente = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
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

        jComboEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleadosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboEmpleados);
        jComboEmpleados.setBounds(220, 80, 170, 22);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(410, 80, 80, 23);

        jScrollPane2.setViewportView(textDescripcion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(220, 200, 290, 70);

        jLabel2.setText("Filtrar Empleado");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 60, 80, 16);

        jLabel3.setText("Fecha");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 110, 90, 16);

        btnAgregar.setText("Agregar solicitud");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(220, 320, 120, 30);
        getContentPane().add(jCalendarCliente);
        jCalendarCliente.setBounds(220, 130, 220, 30);

        jLabel4.setText("Descripción");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(220, 180, 90, 16);

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

    private void jComboEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadosActionPerformed
        
    }//GEN-LAST:event_jComboEmpleadosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String empleadoSeleccionado = this.jComboEmpleados.getSelectedItem().toString();
        jCalendarCliente.setEnabled(true);
        jCalendarCliente.setDate(null);
        List<Date> fechas = new ArrayList<>();
        if(!"Seleccione...".equals(empleadoSeleccionado)){
            int idEmpleado = obtenerIdEmpleado(empleadoSeleccionado);
            List <Empleo> empleos = EmpleadoDB.getEmpleadoByIdUsuario(cx, idEmpleado);
            for (Empleo empleo : empleos) {            
                System.out.println(empleo.getFecha());
                fechas.add(empleo.getFecha());
            }  
            evaluator.setFechas(fechas);
            JOptionPane.showMessageDialog(this, "Se cargaron los dias disponibles");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un empleado");
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombreEmpleado = jComboEmpleados.getSelectedItem().toString();
        Date fechaSeleccionada = jCalendarCliente.getDate();
        String descripcion = textDescripcion.getText();
        int idEmpleado = obtenerIdEmpleado(nombreEmpleado);
        
        Empleo nuevoEmpleo = 
                new Empleo(0, idEmpleado, fechaSeleccionada, descripcion);
        
        if(validarCampos(idEmpleado, fechaSeleccionada)){
            EmpleoDB.insertEmpleoByEmpleado(cx, nuevoEmpleo);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor complete los campos");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCliente().setVisible(true);
            }
        });
    }
    
    private void llenarComboEmpleados() {
        this.empleados = EmpleadoDB.getEmpleados(cx);
        jComboEmpleados.removeAllItems();
        jComboEmpleados.addItem("Seleccione...");
        for (Usuario user : empleados) {            
            jComboEmpleados.addItem(user.getId() + "-" + user.getNombre().concat(" " + user.getApellido()));
        }
    }
 
    private int obtenerIdEmpleado(String nombre) {
    if (nombre != null && nombre.contains("-")) {
        String[] partes = nombre.split("-");
        try {
            return Integer.parseInt(partes[0].trim()); // Convertir la primera parte a entero
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el ID: " + e.getMessage());
        }
    }
    return -1; // Retorna un valor por defecto si el formato es inválido
}
  
    public boolean validarCampos(int id, Date fecha) {
        return !(id == 0 || fecha == null);
    }
    
    public void limpiarCampos() {
        jCalendarCliente.setCalendar(null);
        jCalendarCliente.setEnabled(false);
        textDescripcion.setText("");
        jComboEmpleados.setSelectedIndex(0);
    }


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem borrarNotificacion;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private com.toedter.calendar.JDateChooser jCalendarCliente;
    private javax.swing.JComboBox<String> jComboEmpleados;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem listadoEmpleados;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JMenuItem marcarComoVisto;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem menuTipoEmpleado;
    private javax.swing.JTextPane textDescripcion;
    private javax.swing.JMenuItem verNotificaciones;
    // End of variables declaration//GEN-END:variables
}
