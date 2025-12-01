package ui; // Paquete donde está el formulario

import javax.swing.JOptionPane;
import hotel.Hotel;
import hotel.Habitacion;
import hotel.TipoHabitacion;

import operaciones.Estadia;
import operaciones.Huesped;
import operaciones.Reservacion;

import javax.swing.*;
import java.time.LocalDate;

// Este formulario gestiona el Check-In:
// 1. Busca una reservación activa por DNI
// 2. Muestra los datos
// 3. Lista habitaciones disponibles según el tipo reservado
// 4. Permite asignar una habitación y crear una estadía
public class FrmCheckIn extends javax.swing.JPanel {

    public FrmCheckIn() {
        initComponents(); // Carga el diseño desde NetBeans

        // Evento al cambiar la habitación seleccionada
        cmbHabitacionDisponible.addActionListener(e -> {

            String hab = (String) cmbHabitacionDisponible.getSelectedItem();

            if (hab != null) {
                lblNumeroHabitacion.setText("Habitación seleccionada: " + hab);
            }
        });
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDNI = new javax.swing.JLabel();
        btnBuscarReservacion = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblFin = new javax.swing.JLabel();
        btnCheckIn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblHabitacionDisponible = new javax.swing.JLabel();
        cmbHabitacionDisponible = new javax.swing.JComboBox<>();
        lblNumeroHabitacion = new javax.swing.JLabel();
        lblPrecioNoche = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblDNI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDNI.setText("DNI:");

        btnBuscarReservacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscarReservacion.setText("Buscar reservación");
        btnBuscarReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarReservacionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Check- in");

        jLabel2.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTipo.setText("Tipo:");

        lblInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblInicio.setText("Inicio:");

        lblFin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFin.setText("Fin:");

        btnCheckIn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCheckIn.setText("Realizar check-in");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("DATOS DE LA RESERVA");

        lblHabitacionDisponible.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblHabitacionDisponible.setText("Habitaciones dsponible");

        lblNumeroHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumeroHabitacion.setText("N° Habitación seleccionada:                                    ");

        lblPrecioNoche.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPrecioNoche.setText("Precio por noche s/:                  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 403, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarReservacion)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(332, 332, 332)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblHabitacionDisponible)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFin, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(cmbHabitacionDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(lblPrecioNoche)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnBuscarReservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioNoche))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblTipo)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblInicio)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHabitacionDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHabitacionDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(lblNumeroHabitacion)
                .addGap(31, 31, 31)
                .addComponent(btnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarReservacionActionPerformed
         String dni = txtDNI.getText().trim(); // Obtener DNI ingresado

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el DNI para buscar.");
            return;
        }

        Reservacion res = null;

        // Buscar reservación activa según DNI
        for (Reservacion r : Hotel.listaReservaciones) {
            if (r.getHuesped().getDni().equals(dni)) {
                res = r;
                break;
            }
        }

        // Si no existe reservación, mensaje y detener
        if (res == null) {
            JOptionPane.showMessageDialog(this, "No existe una reservación con ese DNI.");
            return;
        }

        // Mostrar datos del huésped y fechas
        lblNombre.setText(res.getHuesped().getNombres() + " " + res.getHuesped().getApellidos());
        lblTipo.setText(res.getTipo().getNombre());
        lblInicio.setText(res.getFechaInicio().toString());
        lblFin.setText(res.getFechaFin().toString());
        lblPrecioNoche.setText("Precio por noche: S/ " + res.getPrecioPorNoche());

        // Cargar habitaciones disponibles del tipo reservado
        cmbHabitacionDisponible.removeAllItems();

        for (Habitacion h : Hotel.listaHabitaciones) {

            boolean mismoTipo = h.getTipoHabitacion().equals(res.getTipo());
            boolean disponible = h.getEstado().equalsIgnoreCase("Disponible");

            if (mismoTipo && disponible) {
                cmbHabitacionDisponible.addItem(String.valueOf(h.getNumeroHabitacion()));
            }
        }

        // Si no hay habitaciones
        if (cmbHabitacionDisponible.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "No hay habitaciones disponibles para el tipo reservado.");
        }
    }//GEN-LAST:event_btnBuscarReservacionActionPerformed

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        String dni = txtDNI.getText().trim();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Busque una reservación primero.");
            return;
        }

        // Buscar la reservación
        Reservacion res = null;
        for (Reservacion r : Hotel.listaReservaciones) {
            if (r.getHuesped().getDni().equals(dni)) {
                res = r;
                break;
            }
        }

        if (res == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la reservación.");
            return;
        }

        // ==========================================================
        // Validación: El huésped NO puede tener otra estadía activa
        // ==========================================================
        for (Estadia e : Hotel.listaEstadias) {

            boolean mismoHuesped = e.getReservacion().getHuesped().getDni().equals(dni);
            boolean sigueDentro = e.getHoraCheckOut() == null;

            if (mismoHuesped && sigueDentro) {
                JOptionPane.showMessageDialog(this,
                        "El huésped ya tiene una estadía activa en la habitación "
                                + e.getHabitacionAsignada().getNumeroHabitacion()
                                + ". Debe realizar Check-Out antes de un nuevo Check-In.");
                return;
            }
        }

        // Validar que el combo tenga habitaciones
        if (cmbHabitacionDisponible.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay habitación seleccionada.");
            return;
        }

        // Obtener número de habitación seleccionada
        int numeroHab = Integer.parseInt(
                cmbHabitacionDisponible.getSelectedItem().toString()
        );

        // Buscar objeto Habitación
        Habitacion hab = null;
        for (Habitacion h : Hotel.listaHabitaciones) {
            if (h.getNumeroHabitacion() == numeroHab) {
                hab = h;
                break;
            }
        }

        if (hab == null) {
            JOptionPane.showMessageDialog(this, "Error al asignar habitación.");
            return;
        }

        // ==========================================================
        // Crear estadía y efectuar Check-In
        // ==========================================================
        Estadia est = new Estadia(res, 20); // 20 = costo por hora extra (ejemplo)
        est.setHabitacionAsignada(hab);
        est.realizarCheckIn();

        // Registrar la estadía en el hotel
        Hotel.listaEstadias.add(est);

        JOptionPane.showMessageDialog(this,
                "Check-In realizado correctamente.\nHabitación: " + numeroHab);            
    }//GEN-LAST:event_btnCheckInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarReservacion;
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JComboBox<String> cmbHabitacionDisponible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblHabitacionDisponible;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroHabitacion;
    private javax.swing.JLabel lblPrecioNoche;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables
}
