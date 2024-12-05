package dbconnect;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    String bd = "";
    String url = "jdbc:mariadb://localhost:3306/";
    String user = "root";
    String password = "toor";
    String driver = "org.mariadb.jdbc.Driver";
    Connection cx;

    public DBConnect(String bd) {
        this.bd = bd;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("SE CONECTO A LA BD " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("NO SE CONECTO A LA BD " + bd);
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }

    public static DBConnect iniciar() {
        
        return new DBConnect("proyectodeaula");

    }

    public void desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
