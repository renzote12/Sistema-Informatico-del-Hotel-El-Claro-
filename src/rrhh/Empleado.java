package rrhh;

/**
 * Clase abstracta base para todos los tipos de empleados del hotel.
 * Contiene información común como DNI, nombres, usuario, rol y estado.
 */
public abstract class Empleado {

    // ===================== ATRIBUTOS =====================
    private String dni;                    // Identificación del empleado
    private String nombres;                // Nombre del empleado
    private String apellidos;              // Apellidos del empleado
    private String usuario;                // Usuario para iniciar sesión
    private String contraseñaEncriptada;   // Contraseña encriptada
    private String rol;                    // Rol del empleado en el sistema
    private String estado;                 // Estado (Activo / Inactivo)

    /**
     * Constructor base para cualquier tipo de empleado.
     */
    public Empleado(String dni, String nombres, String apellidos,
                    String usuario, String contraseñaEncriptada,
                    String rol, String estado) {

        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseñaEncriptada = contraseñaEncriptada;
        this.rol = rol;
        this.estado = estado;
    }

    // ===================== SETTERS =====================
    public void setDni(String dni) { this.dni = dni; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setContraseñaEncriptada(String contraseñaEncriptada) { this.contraseñaEncriptada = contraseñaEncriptada; }
    public void setRol(String rol) { this.rol = rol; }
    public void setEstado(String estado) { this.estado = estado; }

    // ===================== GETTERS =====================
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getUsuario() { return usuario; }
    public String getContraseñaEncriptada() { return contraseñaEncriptada; }
    public String getRol() { return rol; }
    public String getEstado() { return estado; }

    /**
     * Muestra el empleado en texto, útil para listas.
     */
    @Override
    public String toString() {
        return "[" + rol + "] " + nombres + " " + apellidos;
    }
}
