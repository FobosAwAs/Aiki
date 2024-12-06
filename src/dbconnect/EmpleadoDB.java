/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Empleo;
import models.Usuario;

/**
 *
 * @author camil
 */
public class EmpleadoDB {
    public static List<Usuario> getEmpleados(DBConnect cx) {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try (
            java.sql.Connection connection = cx.conectar();
            java.sql.Statement st = connection.createStatement();
            java.sql.ResultSet rs = st.executeQuery(query)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id"); 
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String usuario = rs.getString("usuario"); 
                String contrasena = rs.getString("contrasena");
                String  rol = rs.getString("rol");
                
                Usuario userModel = new Usuario(id, nombre, apellido, usuario, contrasena, rol);
                usuarios.add(userModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public static List<Empleo> getEmpleadoByUsuario(DBConnect cx, String usuario) {
        List<Empleo> empleos = new ArrayList<>();
        String query = "SELECT * FROM empleos "
                + "INNER JOIN usuarios ON empleos.idEmpleado = usuarios.id "
                + "WHERE usuarios.nombre = '" + usuario + "'";
        try (
            java.sql.Connection connection = cx.conectar();
            java.sql.Statement st = connection.createStatement();
            java.sql.ResultSet rs = st.executeQuery(query)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id"); 
                int idEmpleado = rs.getInt("idEmpleado");
                Date fecha = rs.getDate("fechaEmpleo");
                String descripcion = rs.getString("descripcion"); 
                
                Empleo empleoModel = new Empleo(id, idEmpleado, fecha, descripcion);
                empleos.add(empleoModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleos;
    }
}
