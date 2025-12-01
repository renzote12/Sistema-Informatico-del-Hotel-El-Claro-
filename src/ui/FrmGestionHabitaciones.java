package ui; // Paquete donde está este formulario

import hotel.TipoHabitacion; // Para trabajar con el tipo de habitación
import hotel.Hotel;          // Lista global de habitaciones y tipos
import javax.swing.table.DefaultTableModel; // Modelo de tabla
import hotel.Habitacion;    // Clase principal de habitación
import javax.swing.JOptionPane; // Para mostrar mensajes

public class FrmGestionHabitaciones extends javax.swing.JPanel {

    // Constructor del panel
    public FrmGestionHabitaciones() {
        initComponents(); // Carga la interfaz creada por NetBeans

        // Etiquetas de resumen de habitaciones por tipo (se inicializan aquí)
        lblTotalEstandar = new javax.swing.JLabel("Estandar: 0");
        lblTotalDeluxe = new javax.swing.JLabel("Deluxe: 0");
        lblTotalSuite = new javax.swing.JLabel("Suite: 0");

        // Fuente para los contadores
        lblTotalEstandar.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lblTotalDeluxe.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lblTotalSuite.setFont(new java.awt.Font("Segoe UI", 0, 16));

        cargarTipos();      // Llena combo de tipos según listaTipos
        cargarEstados();    // Carga los estados posibles
        cargarCamas();      // Carga el combo de camas según el tipo
        cargarTabla();      // Tabla de habitaciones registradas
        actualizarResumenTipos(); // Muestra total por tipo

        // Listener: cuando cambia el tipo, se actualiza combo de camas
        cmbTipoHab.addActionListener(e -> cargarCamas());
    }

    // ------------------------------
    // CARGA DE COMBOS Y TABLA
    // ------------------------------

    private void cargarTipos() {
        cmbTipoHab.removeAllItems(); // Limpia combo

        for (TipoHabitacion th : Hotel.listaTipos) {
            cmbTipoHab.addItem(th.getNombre()); // Añade cada tipo existente
        }
    }

    private void cargarCamas() {
        cmbTipoCama.removeAllItems(); // Limpia combo

        // Obtiene el tipo seleccionado para saber qué camas permite
        String tipoSeleccionado = cmbTipoHab.getSelectedItem().toString();

        for (TipoHabitacion th : Hotel.listaTipos) {
            if (th.getNombre().equals(tipoSeleccionado)) {

                // Añade solo las camas permitidas por ese tipo
                for (String cama : th.getTiposCamaPermitidos()) {
                    cmbTipoCama.addItem(cama);
                }
                break;
            }
        }
    }

    private void cargarEstados() {
        cmbEstado.removeAllItems(); // Limpia combo

        cmbEstado.addItem("Disponible");
        cmbEstado.addItem("Ocupada");
        cmbEstado.addItem("En mantenimiento");
    }

    // Carga habitaciones registradas a la tabla
    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblHabitaciones.getModel();
        modelo.setRowCount(0); // Vacía tabla previa

        for (Habitacion h : Hotel.listaHabitaciones) {

            // Maneja el entretenimiento como texto separado por comas
            String entretenimiento = (h.getEntretenimiento() == null)
                ? ""
                : String.join(", ", h.getEntretenimiento());

            modelo.addRow(new Object[]{
                h.getNumeroHabitacion(),
                h.getTipoHabitacion().getNombre(),
                h.getTipoCama(),
                h.getEstado(),
                entretenimiento
            });
        }
    }

    // Limpia campos de entrada
    private void limpiarCampos() {
        txtNumero.setText("");
        cmbTipoHab.setSelectedIndex(0);
        cmbTipoCama.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
        txtEntretenimiento.setText("");
    }

    // Actualiza contador total por tipo
    private void actualizarResumenTipos() {

        int estandar = 0;
        int deluxe = 0;
        int suite = 0;

        for (Habitacion h : Hotel.listaHabitaciones) {
            String tipo = h.getTipoHabitacion().getNombre();

            switch (tipo) {
                case "Estandar": estandar++; break;
                case "Deluxe":   deluxe++;   break;
                case "Suite":    suite++;    break;
            }
        }

        // Muestra resultados en los campos
        txtTotalEstandar.setText(String.valueOf(estandar));
        txtTotalDeluxe.setText(String.valueOf(deluxe));
        txtTotalSuite.setText(String.valueOf(suite));
    }



   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHabitaciones = new javax.swing.JTable();
        lblNumero = new javax.swing.JLabel();
        lblTipoHab = new javax.swing.JLabel();
        lblTipoCama = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblEntretenimientoBasico = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        cmbTipoHab = new javax.swing.JComboBox<>();
        cmbTipoCama = new javax.swing.JComboBox<>();
        txtEntretenimiento = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblTotalEstandar = new javax.swing.JLabel();
        lblTotalDeluxe = new javax.swing.JLabel();
        lblTotalSuite = new javax.swing.JLabel();
        txtTotalEstandar = new javax.swing.JTextField();
        txtTotalDeluxe = new javax.swing.JTextField();
        txtTotalSuite = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nº Habitación", "Tipo Habitación", "Tipo Cama", "Estado", "Entretenimiento basico"
            }
        ));
        jScrollPane1.setViewportView(tblHabitaciones);

        lblNumero.setText("N° Habitación:");

        lblTipoHab.setText("Tipo de Habitación:");

        lblTipoCama.setText("Tipo de cama:");

        lblEstado.setText("Estado:");

        lblEntretenimientoBasico.setText("Entretenimiento básico:");

        cmbTipoHab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estandar", "Deluxe", "Suite", " " }));

        cmbTipoCama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Queen", "King", " " }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupada", "En mantenimiento", " " }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblTotalEstandar.setText("Estandar");

        lblTotalDeluxe.setText("Deluxe");

        lblTotalSuite.setText("Suite");

        txtTotalEstandar.setEditable(false);
        txtTotalEstandar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalEstandarActionPerformed(evt);
            }
        });

        txtTotalDeluxe.setEditable(false);
        txtTotalDeluxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalDeluxeActionPerformed(evt);
            }
        });

        txtTotalSuite.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipoHab)
                                    .addComponent(lblNumero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipoHab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipoCama)
                                    .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTipoCama, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblEntretenimientoBasico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEntretenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTotalEstandar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalDeluxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalSuite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalDeluxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSuite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalEstandar)
                            .addComponent(txtTotalEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalDeluxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalDeluxe))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalSuite)
                            .addComponent(txtTotalSuite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoCama)
                    .addComponent(cmbTipoCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEntretenimientoBasico)
                    .addComponent(txtEntretenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoHab)
                    .addComponent(cmbTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         try {
            // Validación: debe indicar número
            if (txtNumero.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el número de habitación.");
                return;
            }

            int numero = Integer.parseInt(txtNumero.getText().trim());

            // Buscar habitación por número
            Habitacion h = null;
            for (Habitacion hab : Hotel.listaHabitaciones) {
                if (hab.getNumeroHabitacion() == numero) {
                    h = hab;
                    break;
                }
            }

            if (h == null) {
                JOptionPane.showMessageDialog(this, "No existe una habitación con ese número.");
                return;
            }

            // Obtiene nuevos valores
            String nuevoTipoNombre = cmbTipoHab.getSelectedItem().toString();
            String nuevoTipoCama = cmbTipoCama.getSelectedItem().toString();
            String nuevoEstado = cmbEstado.getSelectedItem().toString();
            String[] nuevoEntretenimiento = txtEntretenimiento.getText().split(",");

            // Buscar el tipo de habitación
            TipoHabitacion tipoNuevo = null;
            for (TipoHabitacion th : Hotel.listaTipos) {
                if (th.getNombre().equals(nuevoTipoNombre)) {
                    tipoNuevo = th;
                    break;
                }
            }

            if (tipoNuevo == null) {
                JOptionPane.showMessageDialog(this, "Error: tipo no encontrado.");
                return;
            }

            // Si cambió de tipo, ajusta los contadores
            TipoHabitacion tipoViejo = h.getTipoHabitacion();

            if (!tipoViejo.getNombre().equals(tipoNuevo.getNombre())) {
                tipoViejo.disminuirCantidad(1);
                tipoNuevo.aumentarCantidad(1);
            }

            // Actualiza datos de la habitación
            h.setTipoHabitacion(tipoNuevo);
            h.setTipoCama(nuevoTipoCama);
            h.setEstado(nuevoEstado);
            h.setEntretenimiento(nuevoEntretenimiento);

            actualizarResumenTipos(); // Actualiza contadores

            JOptionPane.showMessageDialog(this, "Habitación modificada correctamente.");

            cargarTabla();
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número inválido.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
          try {
            int numero = Integer.parseInt(txtNumero.getText()); // Número de habitación

            String tipoHabNombre = cmbTipoHab.getSelectedItem().toString();
            String tipoCama = cmbTipoCama.getSelectedItem().toString();
            String estado = cmbEstado.getSelectedItem().toString();

            // Divide entretenimiento por comas
            String[] entretenimiento = txtEntretenimiento.getText().split(",");

            // Buscar el tipo elegido
            TipoHabitacion tipoHab = null;
            for (TipoHabitacion th : Hotel.listaTipos) {
                if (th.getNombre().equals(tipoHabNombre)) {
                    tipoHab = th;
                    break;
                }
            }

            if (tipoHab == null) {
                JOptionPane.showMessageDialog(this, "Error: tipo no encontrado.");
                return;
            }

            // Validar número duplicado
            for (Habitacion h : Hotel.listaHabitaciones) {
                if (h.getNumeroHabitacion() == numero) {
                    JOptionPane.showMessageDialog(this,
                        "El número de habitación ya existe.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Validar capacidad del tipo
            if (tipoHab.getCantidadOcupada() >= tipoHab.getCantidadDisponible()) {
                JOptionPane.showMessageDialog(this,
                    "Ya no hay más disponibilidad para el tipo: " + tipoHabNombre,
                    "Capacidad llena", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Crear habitación
            Habitacion nueva = new Habitacion(numero, tipoHab, tipoCama, estado, entretenimiento);
            Hotel.listaHabitaciones.add(nueva);

            // Incrementa contador del tipo
            tipoHab.aumentarCantidad(1);
            actualizarResumenTipos();

            JOptionPane.showMessageDialog(this, "Habitación registrada correctamente.");
            cargarTabla();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de habitación inválido.");
        }

        limpiarCampos();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       try {
            // Validar número
            if (txtNumero.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el número de habitación a eliminar.");
                return;
            }

            int numero = Integer.parseInt(txtNumero.getText().trim());

            Habitacion h = null;
            int index = -1;

            // Buscar habitación por número
            for (int i = 0; i < Hotel.listaHabitaciones.size(); i++) {
                if (Hotel.listaHabitaciones.get(i).getNumeroHabitacion() == numero) {
                    h = Hotel.listaHabitaciones.get(i);
                    index = i;
                    break;
                }
            }

            if (h == null) {
                JOptionPane.showMessageDialog(this, "No existe una habitación con ese número.");
                return;
            }

            // Confirmación
            int resp = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que desea eliminar la habitación Nº " + numero + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );

            if (resp != JOptionPane.YES_OPTION) return;

            // Actualiza contador del tipo
            h.getTipoHabitacion().disminuirCantidad(1);

            // Eliminar
            Hotel.listaHabitaciones.remove(index);

            actualizarResumenTipos();

            JOptionPane.showMessageDialog(this, "Habitación eliminada correctamente.");

            cargarTabla();
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Número de habitación inválido.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void txtTotalEstandarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalEstandarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalEstandarActionPerformed

    private void txtTotalDeluxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalDeluxeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDeluxeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbTipoCama;
    private javax.swing.JComboBox<String> cmbTipoHab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntretenimientoBasico;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTipoCama;
    private javax.swing.JLabel lblTipoHab;
    private javax.swing.JLabel lblTotalDeluxe;
    private javax.swing.JLabel lblTotalEstandar;
    private javax.swing.JLabel lblTotalSuite;
    private javax.swing.JTable tblHabitaciones;
    private javax.swing.JTextField txtEntretenimiento;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTotalDeluxe;
    private javax.swing.JTextField txtTotalEstandar;
    private javax.swing.JTextField txtTotalSuite;
    // End of variables declaration//GEN-END:variables
}
