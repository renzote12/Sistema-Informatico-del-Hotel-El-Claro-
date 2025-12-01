package ui;

// Importamos las clases necesarias
import hotel.Hotel;
import hotel.TipoHabitacion;
import operaciones.Huesped;
import operaciones.Reservacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FrmReservaciones extends javax.swing.JPanel {

    // ============================
    //  CONSTRUCTOR DEL FORMULARIO
    // ============================
    public FrmReservaciones() {

        initComponents();      // Construye los elementos gráficos (NetBeans)
        cargarTipos();         // Carga los tipos de habitación al combo box
        cargarTabla();         // Muestra todas las reservaciones en la tabla
        actualizarPrecio();    // Muestra el precio del tipo seleccionado

        // Cada vez que se cambie el tipo en el combo, se actualiza el precio
        cmbTipoHab.addActionListener(e -> actualizarPrecio());
    }

    // ======================================================
    //  Cargar nombres de tipos de habitación en el combo
    // ======================================================
    private void cargarTipos() {
        cmbTipoHab.removeAllItems();  // Limpia el combo

        // Recorremos la lista de tipos del hotel
        for (TipoHabitacion th : Hotel.listaTipos) {
            cmbTipoHab.addItem(th.getNombre()); // Agrega el nombre al combo
        }
    }

    // ======================================================
    //  Cargar todas las reservas en la tabla
    // ======================================================
    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblReservas.getModel();
        modelo.setRowCount(0); // Limpia la tabla

        // Cada reservación se agrega como fila
        for (Reservacion r : Hotel.listaReservaciones) {
            modelo.addRow(new Object[]{
                    r.getHuesped().getDni(),
                    r.getHuesped().getNombres() + " " + r.getHuesped().getApellidos(),
                    r.getTipo().getNombre(),
                    r.getFechaInicio().toString(),
                    r.getFechaFin().toString()
            });
        }
    }

    // ======================================================
    //  Limpiar los campos del formulario
    // ======================================================
    private void limpiar() {
        txtDni.setText("");
        txtNombre.setText("");
        txtInicio.setText("");
        txtFin.setText("");
        cmbTipoHab.setSelectedIndex(0); // Regresa al primer tipo
    }

    // ======================================================
    //  Actualizar el precio por noche según tipo
    // ======================================================
    private void actualizarPrecio() {

        String nombreTipo = cmbTipoHab.getSelectedItem().toString();

        // Busca el tipo en la lista del hotel
        for (TipoHabitacion t : Hotel.listaTipos) {

            if (t.getNombre().equalsIgnoreCase(nombreTipo)) {

                // Muestra el precio por noche en un label
                lblPrecioNoche.setText("Precio por noche: S/ " + t.getPrecioPorNoche());
                return;
            }
        }
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        cmbTipoHab = new javax.swing.JComboBox<>();
        txtInicio = new javax.swing.JTextField();
        txtFin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblPrecioNoche = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI-Huésped");

        jLabel2.setText("Nombre");

        jLabel3.setText("Tipo habitación");

        jLabel4.setText("Fecha inicio(AAAA-MM-DD)");

        jLabel5.setText("Fecha final(AAAA-MM-DD)");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Tipo Habitación", "Fecha inicio", "Fecha final"
            }
        ));
        jScrollPane1.setViewportView(tblReservas);

        cmbTipoHab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estandar", "Deluxe", "Suite" }));

        txtInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInicioActionPerformed(evt);
            }
        });

        jLabel7.setText("--------------------------------------------------------------DATOS DEL HUESPED------------------------------------------------------------------");

        lblPrecioNoche.setText("Precio por noche s/:           ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblPrecioNoche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(38, 38, 38)
                                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblPrecioNoche)
                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      try {
            // Leer datos del formulario
            String dni = txtDni.getText().trim();
            String fechaI = txtInicio.getText().trim();
            String fechaF = txtFin.getText().trim();
            String tipoNombre = cmbTipoHab.getSelectedItem().toString();

            // ===========================
            // Buscar huésped en el sistema
            // ===========================
            Huesped h = null;
            for (Huesped x : Hotel.listaHuespedes) {
                if (x.getDni().equals(dni)) {
                    h = x;
                    break;
                }
            }

            if (h == null) {
                JOptionPane.showMessageDialog(this, "Huésped no registrado.");
                return;
            }

            // ===========================
            // Validar fechas
            // ===========================
            LocalDate fi = LocalDate.parse(fechaI);
            LocalDate ff = LocalDate.parse(fechaF);

            if (!ff.isAfter(fi)) {
                JOptionPane.showMessageDialog(this, "La fecha fin debe ser posterior a la fecha inicio.");
                return;
            }

            // ===========================
            // Buscar tipo habitación
            // ===========================
            TipoHabitacion tipo = null;
            for (TipoHabitacion t : Hotel.listaTipos) {
                if (t.getNombre().equals(tipoNombre)) {
                    tipo = t;
                    break;
                }
            }

            if (tipo == null) {
                JOptionPane.showMessageDialog(this, "Tipo no encontrado.");
                return;
            }

            // ===========================
            // Validar disponibilidad
            // ===========================
            if (!Hotel.hayDisponibilidad(tipo, fi, ff)) {
                JOptionPane.showMessageDialog(this, "No hay habitaciones disponibles para ese rango.");
                return;
            }

            // ===========================
            // Registrar reservación
            // ===========================
            Reservacion r = new Reservacion(h, tipo, fi, ff);
            Hotel.listaReservaciones.add(r);

            JOptionPane.showMessageDialog(this, "Reservación registrada.");

            cargarTabla(); // Refresca la tabla
            limpiar();     // Limpia formulario

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Usar AAAA-MM-DD.");
        }
    
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInicioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       try {
            // Obtener datos
            String dni = txtDni.getText().trim();
            String inicio = txtInicio.getText().trim();
            String fin = txtFin.getText().trim();

            if (dni.isEmpty() || inicio.isEmpty() || fin.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese DNI, fecha inicio y fecha fin para eliminar.");
                return;
            }

            LocalDate fi = LocalDate.parse(inicio);
            LocalDate ff = LocalDate.parse(fin);

            // Buscar reservación exacta
            int index = -1;
            for (int i = 0; i < Hotel.listaReservaciones.size(); i++) {
                Reservacion r = Hotel.listaReservaciones.get(i);

                if (r.getHuesped().getDni().equals(dni)
                        && r.getFechaInicio().equals(fi)
                        && r.getFechaFin().equals(ff)) {

                    index = i;
                    break;
                }
            }

            if (index == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró la reservación.");
                return;
            }

            // Eliminar
            Hotel.listaReservaciones.remove(index);

            JOptionPane.showMessageDialog(this, "Reservación eliminada.");

            cargarTabla();
            limpiar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: revise los datos.");
        }
    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
     try {
            String dni = txtDni.getText().trim();
            String inicio = txtInicio.getText().trim();
            String fin = txtFin.getText().trim();
            String tipoNuevoNombre = cmbTipoHab.getSelectedItem().toString();

            if (dni.isEmpty() || inicio.isEmpty() || fin.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete DNI, fecha inicio y fin.");
                return;
            }

            LocalDate fiNueva = LocalDate.parse(inicio);
            LocalDate ffNueva = LocalDate.parse(fin);

            if (!ffNueva.isAfter(fiNueva)) {
                JOptionPane.showMessageDialog(this,
                        "La fecha final debe ser posterior a la inicial.");
                return;
            }

            // Buscar la reservación por DNI
            Reservacion reservacion = null;

            for (Reservacion r : Hotel.listaReservaciones) {
                if (r.getHuesped().getDni().equals(dni)) {
                    reservacion = r;
                    break;
                }
            }

            if (reservacion == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la reservación.");
                return;
            }

            // Buscar nuevo tipo
            TipoHabitacion nuevoTipo = null;

            for (TipoHabitacion t : Hotel.listaTipos) {
                if (t.getNombre().equals(tipoNuevoNombre)) {
                    nuevoTipo = t;
                    break;
                }
            }

            if (nuevoTipo == null) {
                JOptionPane.showMessageDialog(this, "Tipo no válido.");
                return;
            }

            // Validar disponibilidad
            if (!Hotel.hayDisponibilidad(nuevoTipo, fiNueva, ffNueva)) {
                JOptionPane.showMessageDialog(this,
                        "No hay disponibilidad para ese tipo de habitación en estas fechas.");
                return;
            }

            // Modificar datos
            reservacion.setFechaInicio(fiNueva);
            reservacion.setFechaFin(ffNueva);
            reservacion.setTipo(nuevoTipo);

            JOptionPane.showMessageDialog(this, "Reservación modificada.");

            cargarTabla();
            limpiar();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en modificación.");
        }
    
       
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTipoHab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrecioNoche;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
