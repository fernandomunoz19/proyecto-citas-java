package controlador;

import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public class GestorPacienteControl implements ActionListener {

    modelo.GestorPacientes Pacientemodelo;
    vista.consultpac consultarPacientevista;

    public GestorPacienteControl(vista.consultpac consultarPacientevista) {
        this.consultarPacientevista = consultarPacientevista;
        Pacientemodelo = new modelo.GestorPacientes();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consultarPacientevista.btn_cerrar) {
            consultarPacientevista.dispose();
        }
        if (e.getSource() == consultarPacientevista.btn_aceptar || e.getSource() == consultarPacientevista.txt_valor) {
            try {
                // 1. Determinar el parámetro de búsqueda
                int parametro = 1; // 1 = Identificación por defecto
                if (consultarPacientevista.rbtn_nombres.isSelected()) {
                    parametro = 2;
                } else if (consultarPacientevista.rbtn_apellidos.isSelected()) {
                    parametro = 3;
                } else if (consultarPacientevista.rbtn_sexo.isSelected()) {
                    parametro = 4;
                }

                // 2. Capturar el valor digitado por el usuario
                String valor = consultarPacientevista.txt_valor.getText().trim();

                // 3. Validar que la instancia del modelo no sea nula
                if (Pacientemodelo == null) {
                    Pacientemodelo = new modelo.GestorPacientes();
                }
                LinkedList<modelo.Paciente> pacientes = Pacientemodelo.getPacientebyParametro(parametro, valor);

                String[] titulos = {"Identificación", "Nombres", "Apellidos", "Fecha Nacimiento", "Género"};
                DefaultTableModel tmodelo = new DefaultTableModel(null, titulos);
                for (modelo.Paciente p : pacientes) {
                    String registro[] = new String[5];
                    System.out.println("DATOS: " + p.getIdentificacion() + " | " + p.getNombres() + " | " + p.getApellidos());
                    registro[0] = p.getIdentificacion();
                    registro[1] = p.getNombres();
                    registro[2] = p.getApellidos();
                    registro[3] = p.getFechadenacimiento();
                    registro[4] = p.getGenero();
                    tmodelo.addRow(registro);
                }
                consultarPacientevista.tbl_datos.setAutoCreateColumnsFromModel(true);
                consultarPacientevista.tbl_datos.setModel(tmodelo);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error en la consulta: " + ex.getMessage());
            }
        }
    }
}
