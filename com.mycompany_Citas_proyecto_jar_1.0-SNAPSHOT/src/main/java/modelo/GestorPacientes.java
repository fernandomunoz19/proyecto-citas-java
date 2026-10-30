package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GestorPacientes {

    private Connection conn;

    public GestorPacientes() {
        // Conexión limpia a tu clase Conexion de MySQL
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
    }

    public void RegistrarPacientes(Paciente paciente) {
        // Ajusta las columnas según la estructura real de tu tabla en MySQL
        String sql = "INSERT INTO pacientes (pacIdentificacion, pacNombre, pacApellidos, pacFechaNacimiento, pacSexo) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, paciente.getIdentificacion());
            pst.setString(2, paciente.getNombres());
            pst.setString(3, paciente.getApellidos());
            pst.setString(4, paciente.getFechadenacimiento());
            pst.setString(5, paciente.getGenero());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente registrado con éxito.");
        } catch (SQLException ex) {
            Logger.getLogger(GestorPacientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al registrar en MySQL: " + ex.getMessage());
        }
    }

    public LinkedList<Paciente> getPacientebyParametro(int parametro, String valor) {
        LinkedList<Paciente> resultado = new LinkedList<>();
        String sql = "";

        switch (parametro) {
            case 1:
                sql = "SELECT * FROM pacientes WHERE pacIdentificacion = '" + valor + "'";
                break;
            case 2:
                sql = "SELECT * FROM pacientes WHERE pacNombre LIKE '%" + valor + "%'";
                break;
            case 3:
                sql = "SELECT * FROM pacientes WHERE pacApellidos LIKE '%" + valor + "%'";
                break;
            case 4:
                sql = "SELECT * FROM pacientes WHERE pacSexo = '" + valor + "'";
                break;
        }

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) { // Corregido: rs.next()
                resultado.add(new Paciente(
                    rs.getString("pacIdentificacion"),
                    rs.getString("pacNombre"),
                    rs.getString("pacApellidos"),
                    rs.getString("pacFechaNacimiento"),
                    rs.getString("pacSexo")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar: " + e.getMessage());
        }
        return resultado;
    }
}