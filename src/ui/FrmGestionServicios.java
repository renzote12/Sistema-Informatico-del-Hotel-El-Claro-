/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;
import hotel.Hotel;
import operaciones.ServicioAdicional;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmGestionServicios extends javax.swing.JPanel {

    /**
     * Creates new form FrmGestionServicios
     */
    public FrmGestionServicios() {
        initComponents();
        cargarTabla();
    }
private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblServicios.getModel();
        modelo.setRowCount(0);

        for (ServicioAdicional s : Hotel.listaServicios) {
            modelo.addRow(new Object[]{
                s.getNombre(),
                s.getPrecio()
            });
        }
    }
    private void limpiarCampos() {
        txtNombreServicio.setText("");
        txtPrecioServicio.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        btnRegistrarServicio = new javax.swing.JButton();
        btnModificarServicio = new javax.swing.JButton();
        btnEliminarServicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreServicio = new javax.swing.JTextField();
        txtPrecioServicio = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre del servicio", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblServicios);

        btnRegistrarServicio.setText("Registar");
        btnRegistrarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarServicioActionPerformed(evt);
            }
        });

        btnModificarServicio.setText("Modificar");
        btnModificarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarServicioActionPerformed(evt);
            }
        });

        btnEliminarServicio.setText("Eliminar");
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del servicio");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Precio(S/):");

        txtPrecioServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(txtPrecioServicio))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(34, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombreServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrecioServicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioServicioActionPerformed

    private void btnRegistrarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarServicioActionPerformed
      String nombre = txtNombreServicio.getText().trim();
        String precioTxt = txtPrecioServicio.getText().trim();

        if (nombre.isEmpty() || precioTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        // Validar precio numérico
        double precio;
        try {
            precio = Double.parseDouble(precioTxt);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio inválido.");
            return;
        }

        // Verificar duplicado
        for (ServicioAdicional s : Hotel.listaServicios) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(this, "Ya existe un servicio con ese nombre.");
                return;
            }
        }

        // Registrar
        Hotel.listaServicios.add(new ServicioAdicional(nombre, precio));

        JOptionPane.showMessageDialog(this, "Servicio registrado correctamente.");

        cargarTabla();
        limpiarCampos();
                // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarServicioActionPerformed

    private void btnModificarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarServicioActionPerformed
        int fila = tblServicios.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un servicio de la tabla.");
            return;
        }

        String nombre = txtNombreServicio.getText().trim();
        String precioTxt = txtPrecioServicio.getText().trim();

        if (nombre.isEmpty() || precioTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioTxt);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio inválido.");
            return;
        }

        ServicioAdicional s = Hotel.listaServicios.get(fila);
        s.setNombre(nombre);
        s.setPrecio(precio);

        JOptionPane.showMessageDialog(this, "Servicio modificado correctamente.");

        cargarTabla();
        limpiarCampos();
       // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarServicioActionPerformed

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
      int fila = tblServicios.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un servicio para eliminar.");
            return;
        }

        int r = JOptionPane.showConfirmDialog(this,
                "¿Eliminar servicio?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (r != JOptionPane.YES_OPTION) return;

        Hotel.listaServicios.remove(fila);

        JOptionPane.showMessageDialog(this, "Servicio eliminado.");

        cargarTabla();
        limpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarServicio;
    private javax.swing.JButton btnModificarServicio;
    private javax.swing.JButton btnRegistrarServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txtNombreServicio;
    private javax.swing.JTextField txtPrecioServicio;
    // End of variables declaration//GEN-END:variables
}
