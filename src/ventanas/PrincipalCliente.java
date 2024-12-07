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
        jButton1 = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JMenuBar();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleadosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboEmpleados);
        jComboEmpleados.setBounds(60, 70, 220, 22);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(350, 70, 80, 23);

        jScrollPane2.setViewportView(textDescripcion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 200, 550, 70);

        jLabel2.setText("Filtrar Empleado");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 50, 140, 16);

        jLabel3.setText("Fecha");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 110, 90, 16);

        btnAgregar.setText("Agregar solicitud");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(300, 320, 120, 30);
        getContentPane().add(jCalendarCliente);
        jCalendarCliente.setBounds(60, 130, 220, 30);

        jLabel4.setText("Descripción");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 180, 90, 16);

        jButton1.setText("Desconectar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(540, 10, 100, 30);
        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadosActionPerformed
        jCalendarCliente.setEnabled(false);
        textDescripcion.setEnabled(false);
    }//GEN-LAST:event_jComboEmpleadosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String empleadoSeleccionado = this.jComboEmpleados.getSelectedItem().toString();
        jCalendarCliente.setEnabled(true);
        textDescripcion.setEnabled(true);
        jCalendarCliente.setDate(null);
        List<Date> fechas = new ArrayList<>();
        if(!"Seleccione...".equals(empleadoSeleccionado)){
            int idEmpleado = obtenerIdEmpleado(empleadoSeleccionado);
            List<Empleo> empleos = EmpleadoDB.getEmpleadoByIdUsuario(cx, idEmpleado);
            for (Empleo empleo : empleos) {
                if (empleo.getEstado() == 1) {
                    fechas.add(empleo.getFecha());
                }
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
                new Empleo(0, idEmpleado, fechaSeleccionada, descripcion, 0);
        
        if(validarCampos(idEmpleado, fechaSeleccionada)){
            EmpleoDB.insertEmpleoByEmpleado(cx, nuevoEmpleo);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor complete los campos");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
    this.dispose();
    Login loginFrame = new Login(); 
    loginFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jCalendarCliente;
    private javax.swing.JComboBox<String> jComboEmpleados;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JTextPane textDescripcion;
    // End of variables declaration//GEN-END:variables
}
