
package vista;

import javax.swing.table.DefaultTableModel;


public class consultpac extends javax.swing.JInternalFrame {
    public controlador.GestorPacienteControl gestorpacienteControl;
    private DefaultTableModel tabla;
    
    public consultpac() {
        initComponents();
        gestorpacienteControl=new controlador.GestorPacienteControl(this);
        String titulosTabla[]={"Identificacion","Nombres","Apellidos","Fecha Nacimiento","Genero"};
        tabla=new DefaultTableModel(null,titulosTabla);
        tbl_datos.setModel(tabla);
        btn_aceptar.addActionListener(gestorpacienteControl);
        txt_valor.addActionListener(gestorpacienteControl);
        btn_cerrar.addActionListener(gestorpacienteControl);
    }

public DefaultTableModel getTableModel(){
    return tabla;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbtn_identificacion = new javax.swing.JRadioButton();
        rbtn_nombres = new javax.swing.JRadioButton();
        rbtn_apellidos = new javax.swing.JRadioButton();
        rbtn_sexo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        btn_aceptar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_datos = new javax.swing.JTable();
        btn_cerrar = new javax.swing.JButton();

        buttonGroup1.add(rbtn_identificacion);
        rbtn_identificacion.setText("Identificacion");

        buttonGroup1.add(rbtn_nombres);
        rbtn_nombres.setText("Nombres");

        buttonGroup1.add(rbtn_apellidos);
        rbtn_apellidos.setText("Apellidos");

        buttonGroup1.add(rbtn_sexo);
        rbtn_sexo.setText("Sexo");

        jLabel1.setText("Valro a buscar:");

        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(this::btn_aceptarActionPerformed);

        tbl_datos.setAutoCreateRowSorter(true);
        tbl_datos.setBackground(new java.awt.Color(242, 242, 242));
        tbl_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Identificacion", "Nombres", "Apellidos", "Fecha Nacimiento", "Genero"
            }
        ));
        tbl_datos.setGridColor(new java.awt.Color(102, 102, 102));
        tbl_datos.setShowGrid(true);
        jScrollPane1.setViewportView(tbl_datos);

        btn_cerrar.setText("Cerrar");
        btn_cerrar.addActionListener(this::btn_cerrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtn_identificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn_nombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn_apellidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn_sexo))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_aceptar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_cerrar)
                        .addGap(26, 26, 26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn_identificacion)
                    .addComponent(rbtn_nombres)
                    .addComponent(rbtn_apellidos)
                    .addComponent(rbtn_sexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton btn_aceptar;
    public javax.swing.JButton btn_cerrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rbtn_apellidos;
    public javax.swing.JRadioButton rbtn_identificacion;
    public javax.swing.JRadioButton rbtn_nombres;
    public javax.swing.JRadioButton rbtn_sexo;
    public javax.swing.JTable tbl_datos;
    public javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
