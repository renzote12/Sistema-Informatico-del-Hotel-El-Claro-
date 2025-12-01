package operaciones;

/**
 * Representa a un huésped registrado en el hotel.
 * Contiene información personal y de contacto.
 */
public class Huesped {

    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String lugarResidencia;

    /**
     * Constructor del huésped.
     */
    public Huesped(String dni, String nombres, String apellidos,
                   String telefono, String correo,
                   String lugarResidencia) {

        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.lugarResidencia = lugarResidencia;
    }

    // GETTERS
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getLugarResidencia() { return lugarResidencia; }

    // SETTERS
    public void setNombres(String nombres) { this.nombres = nombres; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setLugarResidencia(String lugarResidencia) { this.lugarResidencia = lugarResidencia; }
}
