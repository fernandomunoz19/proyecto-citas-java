package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Pacientes;

public class PacienteControl implements ActionListener {

    vista.RegistrarPacientesForm pacientevista;
    Pacientes pacientemodelo;
    PacientesJpaController GestorPacientesmodelo;

    public PacienteControl(vista.RegistrarPacientesForm pacientevista) {
        this.pacientevista = pacientevista;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Citas_proyecto_jar_1.0-SNAPSHOTPU");
        GestorPacientesmodelo = new PacientesJpaController(emf);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pacientevista.btn_cerrar) {
            pacientevista.dispose();
        }
        if (e.getSource().equals(pacientevista.btnRegistrar)) {
            int identificacion = Integer.parseInt(pacientevista.txt_identificacion.getText());
            String nombre = utilidades.utilidades.capitalizarTexto(pacientevista.txt_nombres.getText());
            String apellidos = utilidades.utilidades.capitalizarTexto(pacientevista.txt_apellidos.getText());
            Date fecha_nacimiento = pacientevista.Dtd_fecha_nacimiento.getDate();
            String genero = pacientevista.rdb_masculino.isSelected() ? "M" : "F";

            pacientemodelo = new Pacientes();
            pacientemodelo.setPacIdentificacion(identificacion);
            pacientemodelo.setPacNombre(nombre);
            pacientemodelo.setPacApellidos(apellidos);
            pacientemodelo.setPacFechaNacimiento(fecha_nacimiento);
            pacientemodelo.setPacSexo(genero);

            try {
                GestorPacientesmodelo.create(pacientemodelo);
                javax.swing.JOptionPane.showMessageDialog(pacientevista, "¡Paciente registrado con éxito!");
            } catch (Exception ex) {
                System.out.println("Error al guardar: " + ex.getMessage());
                javax.swing.JOptionPane.showMessageDialog(pacientevista, "Error: El paciente ya esta guardado o los datos son invalidos");
            }
        }
        if (e.getSource().equals(pacientevista.btnNuevo)) {
            pacientevista.txt_identificacion.setText("");
            pacientevista.txt_nombres.setText("");
            pacientevista.txt_apellidos.setText("");
            pacientevista.Dtd_fecha_nacimiento.setDate(null);
            pacientevista.rdb_masculino.setSelected(true);
            pacientevista.rdb_femenino.setSelected(false);
            pacientevista.txt_identificacion.requestFocus();
        }
    }
}
