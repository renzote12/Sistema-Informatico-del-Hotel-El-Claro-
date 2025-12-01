// Importaciones necesarias
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;        // Para manejar fechas
import java.time.ZoneId;          // Convertir DateTime a LocalDate
import javax.swing.JTextField;    // Permite recibir campos de texto

import hotel.Habitacion;
import hotel.Hotel;

import javax.swing.JOptionPane;

import operaciones.Comprobante;   // Para leer datos de facturación

public class FrmReportesAdminGeneral extends javax.swing.JPanel {

    // Logger opcional (no lo usas, pero no estorba)
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(FrmReportesAdminGeneral.class.getName());

    // ================================
    //       CONSTRUCTOR DEL PANEL
    // ================================
    public FrmReportesAdminGeneral() {
        initComponents();  // Construye interfaz gráfica (NetBeans)
    }

    // ===============================================================
    // ===============    REPORTE DE OCUPACIÓN     ===================
    // ===============================================================

    /**
     * Carga a la tabla las habitaciones registradas en el hotel.
     * No depende de fechas, solo muestra el estado actual.
     */
    private void cargarReporteOcupacion() {

        // Obtenemos el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblOcupacion.getModel();

        modelo.setRowCount(0); // Limpia la tabla antes de cargar nuevos datos

        // Recorremos TODAS las habitaciones del sistema
        for (Habitacion h : Hotel.listaHabitaciones) {

            // Agregamos cada habitación como una fila
            modelo.addRow(new Object[]{
                    h.getNumeroHabitacion(),     // Número físico de habitación
                    h.getTipoCama(),             // Tipo de cama
                    h.getEstado()                // Estado: Ocupada / Libre
            });
        }
    }

    // ===============================================================
    // ===============    REPORTE DE INGRESOS     ====================
    // ===============================================================

    /**
     * Genera el reporte de ingresos entre dos fechas.
     * Recorre los comprobantes generados durante los check-out.
     */
    private void generarReporteIngresos() {

        // Leemos las fechas de los textfields (validando formato)
        LocalDate inicio = obtenerFecha(txtFechaInicio);
        LocalDate fin = obtenerFecha(txtFechaFin);

        if (inicio == null || fin == null) return; // Si hay error, detener método

        // Si la tabla tenía datos viejos, los limpiamos
        DefaultTableModel modelo = (DefaultTableModel) tblIngresos.getModel();
        modelo.setRowCount(0);

        double totalHab = 0;   // Acumula ingresos por habitaciones
        double totalServ = 0;  // Acumula ingresos por servicios

        // Recorremos cada comprobante generado por el hotel
        for (Comprobante f : Hotel.listaComprobantes) {

            // Convertimos LocalDateTime (fecha completa) -> LocalDate (solo día)
            LocalDate fechaFactura = f.getFecha()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            // Validamos que la fecha esté dentro del rango solicitado
            if (!fechaFactura.isBefore(inicio) && !fechaFactura.isAfter(fin)) {

                // Cargar fila en la tabla
                modelo.addRow(new Object[]{
                        fechaFactura.toString(),
                        f.getHuesped().getNombres() + " " + f.getHuesped().getApellidos(),
                        f.getHabitacion().getNumeroHabitacion(),
                        f.getMontoHabitacion(),
                        f.getMontoServicios()
                });

                // Sumar totales
                totalHab += f.getMontoHabitacion();
                totalServ += f.getMontoServicios();
            }
        }

        // Mostrar montos en los textfields
        txtTotalHabitaciones.setText(String.valueOf(totalHab));
        txtTotalServicios.setText(String.valueOf(totalServ));
        txtTotalGeneral.setText(String.valueOf(totalHab + totalServ));
    }

    // ===============================================================
    // ==========   VALIDAR Y OBTENER UNA FECHA DESDE INPUT ==========
    // ===============================================================

    /**
     * Convierte el texto de un campo en LocalDate.
     * Si el formato es incorrecto, muestra un error.
     */
    private LocalDate obtenerFecha(JTextField campo) {
        try {

            return LocalDate.parse(campo.getText().trim());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Fecha inválida: " + campo.getText() + "\nFormato correcto: AAAA-MM-DD",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            campo.requestFocus();  // Regresa el cursor al campo incorrecto
            return null;           // Indica error
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelOcupacion = new javax.swing.JPanel();
        lblTituloOcupacion = new javax.swing.JLabel();
        scrollOcupacion = new javax.swing.JScrollPane();
        tblOcupacion = new javax.swing.JTable();
        btnActualizarOcupacion = new javax.swing.JButton();
        panelIngresos = new javax.swing.JPanel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        btnGenerarIngresos = new javax.swing.JButton();
        lblTituloIngresos = new javax.swing.JLabel();
        scrollIngresos = new javax.swing.JScrollPane();
        tblIngresos = new javax.swing.JTable();
        lblTotalHabitaciones = new javax.swing.JLabel();
        lblTotalServicios = new javax.swing.JLabel();
        lblTotalGeneral = new javax.swing.JLabel();
        txtTotalHabitaciones = new javax.swing.JTextField();
        txtTotalServicios = new javax.swing.JTextField();
        txtTotalGeneral = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelOcupacion.setBackground(new java.awt.Color(204, 204, 204));

        lblTituloOcupacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTituloOcupacion.setText("Reporte de Ocupación");

        tblOcupacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N° Habitación", "Tipo de Cama", "Estado"
            }
        ));
        scrollOcupacion.setViewportView(tblOcupacion);

        btnActualizarOcupacion.setText("Actualizar");
        btnActualizarOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarOcupacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOcupacionLayout = new javax.swing.GroupLayout(panelOcupacion);
        panelOcupacion.setLayout(panelOcupacionLayout);
        panelOcupacionLayout.setHorizontalGroup(
            panelOcupacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOcupacionLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(scrollOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(panelOcupacionLayout.createSequentialGroup()
                .addGap(598, 598, 598)
                .addComponent(lblTituloOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOcupacionLayout.setVerticalGroup(
            panelOcupacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOcupacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelOcupacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOcupacionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOcupacionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );

        panelIngresos.setBackground(new java.awt.Color(204, 204, 204));
        panelIngresos.setToolTipText("");

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechaInicio.setText("Fecha Inicio (AAAA-MM-DD):");

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFechaFin.setText("Fecha Fin (AAAA-MM-DD):");

        btnGenerarIngresos.setText("Generar Ingresos");
        btnGenerarIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarIngresosActionPerformed(evt);
            }
        });

        lblTituloIngresos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTituloIngresos.setText("Reporte de Ingresos");

        tblIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Empleado", "Habitación", "Monto Habitación", "Monto Servicios"
            }
        ));
        scrollIngresos.setViewportView(tblIngresos);

        lblTotalHabitaciones.setText("Total Habitaciones:");

        lblTotalServicios.setText("Total Servicios:");

        lblTotalGeneral.setText("Total General:");

        txtTotalHabitaciones.setEditable(false);
        txtTotalHabitaciones.setName(""); // NOI18N

        txtTotalServicios.setEditable(false);
        txtTotalServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalServiciosActionPerformed(evt);
            }
        });

        txtTotalGeneral.setEditable(false);
        txtTotalGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalGeneralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelIngresosLayout = new javax.swing.GroupLayout(panelIngresos);
        panelIngresos.setLayout(panelIngresosLayout);
        panelIngresosLayout.setHorizontalGroup(
            panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIngresosLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelIngresosLayout.createSequentialGroup()
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(lblFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(249, 249, 249)
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(194, 194, 194)))
                .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIngresosLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIngresosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))))
            .addGroup(panelIngresosLayout.createSequentialGroup()
                .addGap(604, 604, 604)
                .addComponent(lblTituloIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIngresosLayout.setVerticalGroup(
            panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIngresosLayout.createSequentialGroup()
                .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIngresosLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelIngresosLayout.createSequentialGroup()
                        .addComponent(lblTituloIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnGenerarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelIngresosLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIngresosLayout.createSequentialGroup()
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelIngresosLayout.createSequentialGroup()
                                .addComponent(lblTotalHabitaciones)
                                .addGap(73, 73, 73)
                                .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalServicios)
                                    .addComponent(txtTotalServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtTotalHabitaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(panelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalGeneral)
                            .addComponent(txtTotalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIngresosLayout.createSequentialGroup()
                        .addComponent(scrollIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelOcupacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarIngresosActionPerformed
         generarReporteIngresos();// TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarIngresosActionPerformed

    private void txtTotalServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalServiciosActionPerformed

    private void txtTotalGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalGeneralActionPerformed

    private void btnActualizarOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarOcupacionActionPerformed
         cargarReporteOcupacion();// TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarOcupacionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarOcupacion;
    private javax.swing.JButton btnGenerarIngresos;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblTituloIngresos;
    private javax.swing.JLabel lblTituloOcupacion;
    private javax.swing.JLabel lblTotalGeneral;
    private javax.swing.JLabel lblTotalHabitaciones;
    private javax.swing.JLabel lblTotalServicios;
    private javax.swing.JPanel panelIngresos;
    private javax.swing.JPanel panelOcupacion;
    private javax.swing.JScrollPane scrollIngresos;
    private javax.swing.JScrollPane scrollOcupacion;
    private javax.swing.JTable tblIngresos;
    private javax.swing.JTable tblOcupacion;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtTotalGeneral;
    private javax.swing.JTextField txtTotalHabitaciones;
    private javax.swing.JTextField txtTotalServicios;
    // End of variables declaration//GEN-END:variables
}
