/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;
import hotel.Hotel;
import hotel.Habitacion;
import operaciones.Estadia;
import operaciones.Huesped;
import operaciones.Comprobante;
import javax.swing.*;
import java.time.LocalDateTime;

public class FrmCheckOut extends javax.swing.JPanel {

     private Estadia estadiaActual;

    public FrmCheckOut() {
        initComponents();
    }
  private void limpiar() {
    txtDNI.setText("");

    lblNombre.setText("Nombre:");
    lblTipoHabitacion.setText("Tipo habitación:");
    lblNumeroHabitacion.setText("N° Habitación:");
    lblFechaInicio.setText("Fecha inicio:");
    lblFechaFin.setText("Fecha fin:");
    lblTotalHabitacion.setText("Total habitación:");
    lblTotalServicios.setText("Total servicios:");
    lblTotalPagar.setText("TOTAL A PAGAR:");

    estadiaActual = null;
}

   private void mostrarDatos() {
   Huesped h = estadiaActual.getReservacion().getHuesped();

    lblNombre.setText("Nombre: " + h.getNombres() + " " + h.getApellidos());
    lblTipoHabitacion.setText("Tipo habitación: " 
        + estadiaActual.getHabitacionAsignada().getTipoHabitacion().getNombre());
    lblNumeroHabitacion.setText("N° Habitación: " 
        + estadiaActual.getHabitacionAsignada().getNumeroHabitacion());

    lblFechaInicio.setText("Fecha inicio: " 
        + estadiaActual.getReservacion().getFechaInicio().toString());
    lblFechaFin.setText("Fecha fin: " 
        + estadiaActual.getReservacion().getFechaFin().toString());

    // HORA ACTUAL PARA CALCULOS PRELIMINARES
    LocalDateTime ahora = LocalDateTime.now();

    double tHab = estadiaActual.calcularTotalHabitacion(ahora);
    double tServ = estadiaActual.calcularTotalServicios();
    double tTotal = estadiaActual.calcularTotalPagar(ahora);

    lblTotalHabitacion.setText("Total habitación: S/ " + tHab);
    lblTotalServicios.setText("Total servicios: S/ " + tServ);
    lblTotalPagar.setText("TOTAL A PAGAR: S/ " + tTotal);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDNI = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblTipoHabitacion = new javax.swing.JLabel();
        lblNumeroHabitacion = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        lblTotalHabitacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        lblTotalServicios = new javax.swing.JLabel();
        btnCheckOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDNI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDNI.setText("DNI:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Check - out");

        btnBuscar.setText("Buscar estadía ");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblTipoHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTipoHabitacion.setText("Tipo de habitación:");

        lblNumeroHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumeroHabitacion.setText("N° Habitación");

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechaInicio.setText("Fecha inicio:           ");

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechaFin.setText("Fecha fin:       ");

        lblTotalHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalHabitacion.setText("Total Habitación: ");

        jLabel3.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        lblTotalPagar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalPagar.setText("Total a pagar:");

        lblTotalServicios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalServicios.setText("Total servicios: ");

        btnCheckOut.setText("Realizar Check- out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("DATOS DE LA ESTADIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipoHabitacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumeroHabitacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTotalHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                        .addComponent(lblTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTotalServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblTotalHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoHabitacion)
                    .addComponent(lblTotalServicios))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPagar)
                    .addComponent(lblNumeroHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lblFechaInicio)
                .addGap(39, 39, 39)
                .addComponent(lblFechaFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String dni = txtDNI.getText().trim();

    if (dni.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese DNI.");
        return;
    }

    estadiaActual = null;

    for (Estadia e : Hotel.listaEstadias) {
        if (e.getReservacion().getHuesped().getDni().equals(dni)
            && e.getHoraCheckOut() == null) {

            estadiaActual = e;
            break;
        }
    }

    if (estadiaActual == null) {
        JOptionPane.showMessageDialog(this, "No hay estadía activa para ese DNI.");
        return;
    }

    mostrarDatos();     // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
         if (estadiaActual == null) {
        JOptionPane.showMessageDialog(this, "Busque una estadía primero.");
        return;
    }

    // Realizar Check-Out
    estadiaActual.realizarCheckOut();

    LocalDateTime ahora = LocalDateTime.now();

    double tHab = estadiaActual.calcularTotalHabitacion(ahora);
    double tServ = estadiaActual.calcularTotalServicios();
    double tTotal = estadiaActual.calcularTotalPagar(ahora);

    // Crear comprobante con el nuevo constructor
    Comprobante c = new Comprobante(
        ahora,
        estadiaActual.getReservacion().getHuesped(),
        estadiaActual.getHabitacionAsignada(),
        tHab,
        tServ,
        tTotal
    );

    Hotel.listaComprobantes.add(c);

    JOptionPane.showMessageDialog(this,
        "Check-Out realizado.\nMonto total: S/ " + tTotal);

    limpiar();    // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroHabitacion;
    private javax.swing.JLabel lblTipoHabitacion;
    private javax.swing.JLabel lblTotalHabitacion;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lblTotalServicios;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables
}
