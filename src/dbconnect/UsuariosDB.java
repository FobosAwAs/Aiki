/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Usuario;

/**
 *
 * @author Aiki
 */
public class UsuariosDB {

    public static Usuario getUsuarioByUsuarioAndContrasena(DBConnect cx, String user, String password) {
        try {
            String query = "SELECT * FROM usuarios WHERE usuario='" + user + "' and contrasena='" + password + "'";
            System.out.println(query);
            java.sql.Statement st = cx.conectar().createStatement();
            java.sql.ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("id"); 
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String usuario = rs.getString("usuario"); 
                String contrasena = rs.getString("contrasena");
                String  rol = rs.getString("rol");
                
                Usuario userModel = new Usuario(id, nombre, apellido, usuario, contrasena, rol);
                return userModel;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void insertUser(DBConnect cx, Usuario usuario){
        try{
            
        String checkQuery = "SELECT * FROM usuarios WHERE usuario = ?";
        java.sql.PreparedStatement checkStmt = cx.conectar().prepareStatement(checkQuery);
        checkStmt.setString(1, usuario.getUsuario());
        java.sql.ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "El usuario ya existe, intenta con otro nombre de usuario.");
        } else {
            String insertQuery = "INSERT INTO usuarios (nombre, apellido, usuario, contrasena, rol) VALUES (?, ?, ?, ?, ?)";
            java.sql.PreparedStatement insertStmt = cx.conectar().prepareStatement(insertQuery);
            insertStmt.setString(1, usuario.getNombre());
            insertStmt.setString(2, usuario.getApellido());
            insertStmt.setString(3, usuario.getUsuario());
            insertStmt.setString(4, usuario.getContrasena());
            insertStmt.setString(5, usuario.getRol());

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
                // Opcional: Limpiar campos o redirigir
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el usuario.");
            }
        }

        rs.close();
        checkStmt.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
