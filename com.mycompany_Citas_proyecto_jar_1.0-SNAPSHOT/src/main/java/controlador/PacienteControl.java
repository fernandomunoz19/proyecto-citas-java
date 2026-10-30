package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class PacienteControl implements ActionListener {

    vista.RegistrarPacientesForm pacientevista;
    modelo.Paciente pacientemodelo;
    modelo.GestorPacientes GestorPacientesmodelo;

    public PacienteControl(vista.RegistrarPacientesForm pacientevista) {
        this.pacientevista = pacientevista;
        this.GestorPacientesmodelo = new modelo.GestorPacientes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pacientevista.btn_cerrar) {
            pacientevista.dispose();
        }
        if (e.getSource().equals(pacientevista.btnRegistrar)) {
            String identificacion = pacientevista.txt_identificacion.getText();
            String nombre = utilidades.utilidades.capitalizarTexto(pacientevista.txt_nombres.getText());
            String apellidos = utilidades.utilidades.capitalizarTexto(pacientevista.txt_apellidos.getText());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            String fecha_nacimiento = formato.format(pacientevista.Dtd_fecha_nacimiento.getDate());
            String genero = "";
            if (pacientevista.rdb_masculino.isSelected()) {
                genero = "M";
            }
            if (pacientevista.rdb_femenino.isSelected()) {
                genero = "F";
            }
            pacientemodelo = new modelo.Paciente(identificacion, nombre, apellidos, fecha_nacimiento, genero);
            GestorPacientesmodelo.RegistrarPacientes(pacientemodelo);
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
