package hotel;

public class TipoHabitacion {

    private String nombre;
    private int capacidadMaxima;

    private double precioPorNoche;       
    private double descuentoPorNoche;    

    private int cantidadDisponible;
    private int cantidadOcupada;

    private String[] tiposCamaPermitidos;

    public TipoHabitacion(String nombre, int capacidadMaxima,
                          double precioPorNoche, double descuentoPorNoche,
                          int cantidadDisponible, String[] tiposCamaPermitidos) {

        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        this.descuentoPorNoche = descuentoPorNoche;
        this.cantidadDisponible = cantidadDisponible;
        this.tiposCamaPermitidos = tiposCamaPermitidos;
        this.cantidadOcupada = 0;
    }

    public String getNombre() { return nombre; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public double getDescuentoPorNoche() { return descuentoPorNoche; }
    public int getCantidadDisponible() { return cantidadDisponible; }
    public int getCantidadOcupada() { return cantidadOcupada; }
    public String[] getTiposCamaPermitidos() { return tiposCamaPermitidos; }

    public boolean camaEsPermitida(String cama) {
        if (cama == null || tiposCamaPermitidos == null) return false;
        for (String permitida : tiposCamaPermitidos) {
            if (permitida.equalsIgnoreCase(cama)) return true;
        }
        return false;
    }

    public boolean hayDisponibilidad() {
        return cantidadOcupada < cantidadDisponible;
    }

    public void ocupar() {
        if (hayDisponibilidad()) cantidadOcupada++;
    }

    public void liberar() {
        if (cantidadOcupada > 0) cantidadOcupada--;
    }

    public void aumentarCantidad(int n) {
        if (n > 0) this.cantidadDisponible += n;
    }

    public void disminuirCantidad(int n) {
        if (n > 0 && this.cantidadDisponible >= n)
            this.cantidadDisponible -= n;
    }
}
