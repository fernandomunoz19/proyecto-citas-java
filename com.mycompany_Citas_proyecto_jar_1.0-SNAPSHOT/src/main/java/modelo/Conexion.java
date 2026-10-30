
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    // Escribe el nombre exacto de la base de datos a utilizar
    private final String Base = "citas_odontologia"; 
    private final String url = "jdbc:mysql://localhost:3306/" + Base;
    
    private final String usuario = "root";
    private final String clave = "Adrsan891904";

    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        Conexion c = new Conexion();
        if (c.conectar() != null) {
            JOptionPane.showMessageDialog(null, "¡Conexión exitosa a la base de datos!");
        }
    }
}