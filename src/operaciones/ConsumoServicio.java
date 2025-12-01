package operaciones;

/**
 * Representa el consumo de un servicio adicional durante una estadía.
 * Cada consumo tiene:
 *  - Un servicio adicional (spa, desayuno, traslado)
 *  - Una cantidad
 *  - Un subtotal calculado automáticamente
 */
public class ConsumoServicio {

    private ServicioAdicional servicio;  // Servicio consumido
    private int cantidad;                // Cantidad consumida
    private double subtotal;             // Precio total servicio*cantidad

    /**
     * Constructor del consumo de servicio.
     * Calcula automáticamente el subtotal.
     */
    public ConsumoServicio(ServicioAdicional servicio, int cantidad) {
        this.servicio = servicio;
        setCantidad(cantidad); // asigna cantidad y calcula subtotal
    }

    // GETTERS
    public ServicioAdicional getServicio() { return servicio; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }

    /**
     * Setter de cantidad.
     * Si la cantidad es <=0, se corrige a 1.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = (cantidad <= 0 ? 1 : cantidad);
        calcularSubtotal();
    }

    /**
     * Calcula el subtotal basado en la cantidad y el precio del servicio.
     */
    private void calcularSubtotal() {
        subtotal = (servicio != null) ? servicio.getPrecio() * cantidad : 0;
    }
}
