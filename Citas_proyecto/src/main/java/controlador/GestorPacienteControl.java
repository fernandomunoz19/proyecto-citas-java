package controlador;

import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import java.util.*;

public class GestorPacienteControl implements ActionListener {

    controlador.PacientesJpaController Pacientemodelo;
    vista.consultpac consultarPacientevista;

    public GestorPacienteControl(vista.consultpac consultarPacientevista) {
        this.consultarPacientevista = consultarPacientevista;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Citas_proyecto_jar_1.0-SNAPSHOTPU");
        Pacientemodelo = new controlador.PacientesJpaController(emf);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tmodelo;
        String valor = consultarPacientevista.txt_valor.getText();
        int parametro = 0;
        if (consultarPacientevista.rbtn_identificacion.isSelected()) {
            parametro = 1;
        } else if (consultarPacientevista.rbtn_nombres.isSelected()) {
            parametro = 2;
        } else if (consultarPacientevista.rbtn_apellidos.isSelected()) {
            parametro = 3;
        } else if (consultarPacientevista.rbtn_sexo.isSelected()) {
            parametro = 4;
        }

        List<modelo.Pacientes> paciente = Pacientemodelo.findPacientesPorFiltro(parametro, valor);
        String registro[] = new String[5];
        String[] titulos = {"Identificación", "Nombres", "Apellidos", "Fecha Nacimiento", "Género"};
        tmodelo = new DefaultTableModel();
        tmodelo.setColumnIdentifiers(titulos);
        for (modelo.Pacientes p : paciente) {
            registro[0] = String.valueOf(p.getPacIdentificacion());
            registro[1] = p.getPacNombre();
            registro[2] = p.getPacApellidos();
            registro[3] = String.valueOf(p.getPacFechaNacimiento());
            registro[4] = p.getPacSexo();
            tmodelo.addRow(registro);
        }
        consultarPacientevista.tbl_datos.setModel(tmodelo);
    }
}
