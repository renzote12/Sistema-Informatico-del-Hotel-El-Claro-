package operaciones;

/**
 * Representa un servicio adicional del hotel:
 * Ejemplos: Spa, Desayuno, Traslado, etc.
 */
public class ServicioAdicional {

    private String nombre;   // Nombre del servicio
    private double precio;   // Precio unitario

    /**
     * Constructor del servicio adicional.
     */
    public ServicioAdicional(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // GETTERS
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    // SETTERS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
}
