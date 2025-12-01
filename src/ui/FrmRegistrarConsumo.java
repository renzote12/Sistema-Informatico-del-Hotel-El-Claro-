
package ui;
import hotel.Hotel;
import operaciones.Estadia;
import operaciones.Huesped;
import operaciones.ServicioAdicional;
import javax.swing.*;
import java.time.LocalDateTime;

public class FrmRegistrarConsumo extends javax.swing.JPanel {
    private Estadia estadiaActual;
    
    public FrmRegistrarConsumo() {
        initComponents();
        cargarServicios();
    }
    private void cargarServicios() {
    cmbServicios.removeAllItems();
    for (ServicioAdicional s : Hotel.listaServicios) {
        cmbServicios.addItem(s.getNombre());
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblTipoHabitacion = new javax.swing.JLabel();
        lblHabitacion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbServicios = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Consumo Adicional");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("DNI del huésped");

        btnBuscar.setText("Buscar Estadía");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:                                                                                             ");

        lblTipoHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTipoHabitacion.setText("Tipo habitación:                                                                               ");

        lblHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHabitacion.setText("Habitación:                                                                                        ");

        jLabel7.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad:  ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Servicio: ");

        cmbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServiciosActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar Consumo");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbServicios, 0, 145, Short.MAX_VALUE)
                    .addComponent(txtCantidad))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblTipoHabitacion)
                            .addComponent(lblHabitacion))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(lblTipoHabitacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(lblHabitacion)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap(146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void cmbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbServiciosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dni = txtDNI.getText().trim();

    if (dni.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el DNI del huésped.");
        return;
    }

    estadiaActual = null;

    // Buscar estadía activa
    for (Estadia e : Hotel.listaEstadias) {
        if (e.getReservacion().getHuesped().getDni().equals(dni)
            && e.getHoraCheckOut() == null) {

            estadiaActual = e;
            break;
        }
    }

    if (estadiaActual == null) {
        JOptionPane.showMessageDialog(this, "No hay estadía activa para ese DNI.");
        lblNombre.setText("Nombre:");
        lblTipoHabitacion.setText("Tipo habitación:");
        lblHabitacion.setText("Habitación:");
        return;
    }

    // Mostrar datos
    lblNombre.setText("Nombre: " +
        estadiaActual.getReservacion().getHuesped().getNombres() + " " +
        estadiaActual.getReservacion().getHuesped().getApellidos());

    lblTipoHabitacion.setText("Tipo habitación: " +
        estadiaActual.getHabitacionAsignada().getTipoHabitacion().getNombre());

    lblHabitacion.setText("Habitación: " +
        estadiaActual.getHabitacionAsignada().getNumeroHabitacion());        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (estadiaActual == null) {
        JOptionPane.showMessageDialog(this, "Busque una estadía primero.");
        return;
    }

    String servicioNombre = cmbServicios.getSelectedItem().toString();
    String cantidadStr = txtCantidad.getText().trim();

    if (cantidadStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese la cantidad.");
        return;
    }

    int cantidad;
    try {
        cantidad = Integer.parseInt(cantidadStr);
        if (cantidad <= 0) throw new NumberFormatException();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        return;
    }

    // Buscar el servicio seleccionado
    ServicioAdicional servicio = null;
    for (ServicioAdicional s : Hotel.listaServicios) {
        if (s.getNombre().equals(servicioNombre)) {
            servicio = s;
            break;
        }
    }

    if (servicio == null) {
        JOptionPane.showMessageDialog(this, "Servicio no encontrado.");
        return;
    }

    // REGISTRAR EL CONSUMO DENTRO DE LA ESTADÍA
    estadiaActual.agregarServicio(servicio, cantidad);

    JOptionPane.showMessageDialog(this, 
        "Consumo registrado correctamente:\n" +
        servicio.getNombre() + " x" + cantidad);

    txtCantidad.setText(""); // Limpiar campo        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoHabitacion;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables
}
