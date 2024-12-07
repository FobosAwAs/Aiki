/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Empleo;
import ventanas.Registro;

/**
 *
 * @author camil
 */
public class EmpleoDB {

    public static void insertEmpleoByEmpleado(DBConnect cx, Empleo empleo) {
        try {
            String insertQuery = "INSERT INTO empleos (idEmpleado, fechaEmpleo, descripcion, estado) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement insertStmt = cx.conectar().prepareStatement(insertQuery);
            insertStmt.setInt(1, empleo.getIdEmpleado());
            java.sql.Date fechaSql = new java.sql.Date(empleo.getFecha().getTime());
            insertStmt.setDate(2, fechaSql);
            insertStmt.setString(3, empleo.getDescripcion());
            insertStmt.setInt(4, empleo.getEstado());

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Empleo registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el empleo.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar registrar el empleo.");
        }
    }

    public static void actualizarEstadoEmpleo(DBConnect cx, int idEmpleado) {
        String query = "UPDATE empleos SET estado = 1 WHERE id = ?";

        try (
                java.sql.Connection connection = cx.conectar(); java.sql.PreparedStatement pst = connection.prepareStatement(query)) {       
            pst.setInt(1, idEmpleado);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void eliminarEmpleo(DBConnect cx, int idEmpleado) {
        String query = "DELETE FROM empleos WHERE id = ?";

        try (
                java.sql.Connection connection = cx.conectar(); java.sql.PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, idEmpleado);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
