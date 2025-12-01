
package ui; // Paquete donde se encuentra la ventana

import java.util.List;
import javax.swing.*;
import rrhh.*;                    // Importa clases de empleados
import Sistema.Autenticacion;    // Para encriptar contraseñas
import hotel.*;                  // (No se usa todo, pero puede ser necesario)
import javax.swing.table.DefaultTableModel;
import operaciones.*;

// Esta clase gestiona empleados: creación, modificación, eliminación
public class FrmGestionEmpleados extends javax.swing.JPanel {

    private List<Empleado> empleados; // Lista externa recibida desde la ventana principal

    // Constructor: recibe la lista de empleados
    public FrmGestionEmpleados(List<Empleado> empleados) {
        initComponents();   // Carga la interfaz visual generada por NetBeans
        this.empleados = empleados;

        cargarTabla();      // Muestra los empleados actuales en la tabla
    }


    // ======================================================
    // =============== MÉTODO: CARGA LA TABLA ===============
    // ======================================================
    private void cargarTabla() {

        // Define columnas y modelo para la tabla
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"DNI", "Nombre", "Apellido", "Rol", "Usuario", "Estado"}, 0
        );

        // Recorre todos los empleados y los agrega como filas
        for (Empleado e : empleados) {
            if (e != null) {
                modelo.addRow(new Object[]{
                    e.getDni(),
                    e.getNombres(),
                    e.getApellidos(),
                    e.getRol(),
                    e.getUsuario(),
                    e.getEstado()
                });
            }
        }

        jTable1.setModel(modelo); // Asigna el modelo a la tabla
    }


    // ======================================================
    // ========== CREA OBJETO EMPLEADO DESDE FORM ===========
    // ======================================================
    private Empleado obtenerEmpleadoDesdeFormulario() {

        // Obtiene los valores que ingresó el usuario
        String dni = txtDni.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String usuario = txtUsuario.getText();
        String contrasena = String.valueOf(txtContrasena.getPassword());
        String rol = comboRol.getSelectedItem().toString();

        // El estado depende del radio button seleccionado
        String estado = rbActivo.isSelected() ? "Activo" : "Inactivo";

        // Validación: todos los campos deben estar llenos
        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                || usuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return null;
        }

        // Encripta la contraseña para almacenarla de forma segura
        Autenticacion auth = new Autenticacion();
        String encriptada = auth.encriptar(contrasena);

        // Crea el objeto correcto según el rol escogido
        switch (rol) {

            case "Administrador General":
                return new AdministradorGeneral(dni, nombre, apellido, usuario, encriptada, estado);

            case "Administrador Secundario":
                return new AdministradorSecundario(dni, nombre, apellido, usuario, encriptada, estado);

            case "Recepcionista":
                return new Recepcionista(dni, nombre, apellido, usuario, encriptada, estado);

            default:
                JOptionPane.showMessageDialog(this, "Rol no reconocido.");
                return null;
        }
    }


    // ======================================================
    // =============== LIMPIAR CAMPOS DEL FORM ==============
    // ======================================================
    private void limpiarCampos() {

        txtDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");

        // Se deja el primer rol seleccionado
        comboRol.setSelectedIndex(0);

        // Estado vuelve a "Activo"
        rbActivo.setSelected(true);

        txtDni.requestFocus(); // Enfoca el primer campo
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        rbActivo = new javax.swing.JRadioButton();
        comboRol = new javax.swing.JComboBox<>();
        rbInactivo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Dni", "Nombre", "Apellido", "Usuario", "Contraseña", "Rol", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTable1);

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
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

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbActivo);
        rbActivo.setText("Activo");
        rbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActivoActionPerformed(evt);
            }
        });

        comboRol.setEditable(true);
        comboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador General", "Administrador Secundario", "Recepcionista" }));
        comboRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRolActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbInactivo);
        rbInactivo.setText("Inactivo");
        rbInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInactivoActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Usuario");

        jLabel5.setText("Contraseña ");

        jLabel6.setText("Rol");

        jLabel7.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbActivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbInactivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbActivo)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbInactivo)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRolActionPerformed

    private void rbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbActivoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    private void rbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInactivoActionPerformed
       
// TODO add your hdwaandling code here:
    }//GEN-LAST:event_rbInactivoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
             // Construye el objeto empleado con los datos ingresados
        Empleado nuevo = obtenerEmpleadoDesdeFormulario();
        if (nuevo == null) return;

        // Validación: evitar usuario duplicado
        for (Empleado e : empleados) {
            if (e != null && e.getUsuario().equals(nuevo.getUsuario())) {
                JOptionPane.showMessageDialog(this, "El usuario ya existe.");
                return;
            }
        }

        // Agregar nuevo empleado a la lista
        empleados.add(nuevo);

        cargarTabla();
        JOptionPane.showMessageDialog(this, "Empleado creado con éxito.");

        limpiarCampos();
    

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int fila = jTable1.getSelectedRow(); // Fila seleccionada

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado para eliminar.");
            return;
        }

        // Usuario del empleado seleccionado
        String usuarioSeleccionado = jTable1.getValueAt(fila, 4).toString();

        // Buscar el objeto empleado
        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);

            if (e != null && e.getUsuario().equals(usuarioSeleccionado)) {

                // Protección: NO permitir borrar al administrador 'admin'
                if (e instanceof AdministradorGeneral && e.getUsuario().equals("admin")) {
                    JOptionPane.showMessageDialog(this,
                        "No puedes eliminar al Administrador General por defecto.");
                    return;
                }

                empleados.remove(i); // Eliminar
                cargarTabla();
                JOptionPane.showMessageDialog(this, "Empleado eliminado.");
                limpiarCampos();
                return;
            }
        }
               
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       int fila = jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado para modificar.");
            return;
        }

        // Usuario del empleado que será modificado
        String usuarioSeleccionado = jTable1.getValueAt(fila, 4).toString();

        // Buscar objeto empleado
        for (Empleado e : empleados) {

            if (e != null && e.getUsuario().equals(usuarioSeleccionado)) {

                // Protección: NO modificar al admin por defecto
                if (e instanceof AdministradorGeneral && e.getUsuario().equals("admin")) {
                    JOptionPane.showMessageDialog(this,
                        "No puedes modificar al Administrador General por defecto.");
                    return;
                }

                // Actualización de datos básicos
                e.setNombres(txtNombre.getText());
                e.setApellidos(txtApellido.getText());
                e.setUsuario(txtUsuario.getText());
                e.setRol(comboRol.getSelectedItem().toString());
                e.setEstado(rbActivo.isSelected() ? "Activo" : "Inactivo");

                // Actualizar contraseña solo si el usuario escribió algo
                String nuevaContra = String.valueOf(txtContrasena.getPassword());
                if (!nuevaContra.isEmpty()) {
                    Autenticacion auth = new Autenticacion();
                    e.setContraseñaEncriptada(auth.encriptar(nuevaContra));
                }

                cargarTabla();
                JOptionPane.showMessageDialog(this, "Empleado modificado.");
                limpiarCampos();
                return;
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JRadioButton rbActivo;
    private javax.swing.JRadioButton rbInactivo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
