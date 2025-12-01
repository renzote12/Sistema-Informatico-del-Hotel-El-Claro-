package operaciones;

public class ConsumoServicio {

    private ServicioAdicional servicio;
    private int cantidad;
    private double subtotal;

    public ConsumoServicio(ServicioAdicional servicio, int cantidad) {
        this.servicio = servicio;
        setCantidad(cantidad);
    }

    public ServicioAdicional getServicio() { return servicio; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }

    public void setCantidad(int cantidad) {
        this.cantidad = (cantidad <= 0 ? 1 : cantidad);
        calcularSubtotal();
    }

    private void calcularSubtotal() {
        subtotal = (servicio != null) ? servicio.getPrecio() * cantidad : 0;
    }
}
