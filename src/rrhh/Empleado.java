package rrhh;

public abstract class Empleado {

    private String dni;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contraseñaEncriptada;
    private String rol;
    private String estado;

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

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseñaEncriptada(String contraseñaEncriptada) {
        this.contraseñaEncriptada = contraseñaEncriptada;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getUsuario() { return usuario; }
    public String getContraseñaEncriptada() { return contraseñaEncriptada; }
    public String getRol() { return rol; }
    public String getEstado() { return estado; }
    

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "[" + rol + "] " + nombres + " " + apellidos;
    }
}
