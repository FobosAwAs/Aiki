/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                int rol = rs.getInt("rol");
                
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
    
//    public static Usuario crearUsuario(DBConnect cx, Usuario usuario) {}
    
//    public static Usuario[] getUsuarios(DBConnect cx) {}  //para el admn

}
