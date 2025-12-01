package hotel;

/**
 * Representa un tipo de habitación en el hotel:
 * Ejemplos: Estandar, Deluxe, Suite.
 *
 * Un tipo de habitación define:
 *  - Capacidad máxima de personas
 *  - Precio por noche
 *  - Descuento por noche
 *  - Cantidad total disponible en el hotel
 *  - Cantidad ocupada actualmente (se actualiza en check-in/check-out)
 *  - Tipos de cama permitidos para las habitaciones de este tipo
 */
public class TipoHabitacion {

    // Nombre identificador del tipo (Estandar, Deluxe, Suite)
    private String nombre;

    // Máximo de personas permitidas
    private int capacidadMaxima;

    // Precio base por noche
    private double precioPorNoche;

    // Descuento por noche (se resta al total por cada noche)
    private double descuentoPorNoche;

    // Número total de habitaciones disponibles de este tipo
    private int cantidadDisponible;

    // Número de habitaciones ocupadas actualmente
    private int cantidadOcupada;

    // Tipos de cama permitidos (lista)
    private String[] tiposCamaPermitidos;


    /**
     * Constructor principal.
     *
     * @param nombre                Nombre del tipo de habitación
     * @param capacidadMaxima       Máximo de huéspedes permitidos
     * @param precioPorNoche        Precio base por noche
     * @param descuentoPorNoche     Descuento aplicado por noche
     * @param cantidadDisponible    Cantidad total de habitaciones de este tipo
     * @param tiposCamaPermitidos   Lista de camas permitidas para este tipo
     */
    public TipoHabitacion(String nombre, int capacidadMaxima,
                          double precioPorNoche, double descuentoPorNoche,
                          int cantidadDisponible, String[] tiposCamaPermitidos) {

        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        this.descuentoPorNoche = descuentoPorNoche;
        this.cantidadDisponible = cantidadDisponible;
        this.tiposCamaPermitidos = tiposCamaPermitidos;

        // Inicialmente ninguna habitación está ocupada
        this.cantidadOcupada = 0;
    }


    // =====================================================
    //  GETTERS
    // =====================================================

    public String getNombre() { return nombre; }

    public int getCapacidadMaxima() { return capacidadMaxima; }

    public double getPrecioPorNoche() { return precioPorNoche; }

    public double getDescuentoPorNoche() { return descuentoPorNoche; }

    public int getCantidadDisponible() { return cantidadDisponible; }

    public int getCantidadOcupada() { return cantidadOcupada; }

    public String[] getTiposCamaPermitidos() { return tiposCamaPermitidos; }


    // =====================================================
    //  MÉTODOS LÓGICOS
    // =====================================================

    /**
     * Verifica si un tipo de cama es permitido para este tipo de habitación.
     *
     * @param cama tipo de cama a validar
     * @return true si es permitida, false si no
     */
    public boolean camaEsPermitida(String cama) {
        if (cama == null || tiposCamaPermitidos == null) return false;

        for (String permitida : tiposCamaPermitidos) {
            if (permitida.equalsIgnoreCase(cama)) return true;
        }
        return false;
    }

    /**
     * Indica si aún quedan habitaciones libres de este tipo.
     *
     * @return true si hay disponibilidad, false si todas están ocupadas
     */
    public boolean hayDisponibilidad() {
        return cantidadOcupada < cantidadDisponible;
    }

    /**
     * Marca una habitación adicional como ocupada.
     * Se usa durante el check-in.
     */
    public void ocupar() {
        if (hayDisponibilidad()) {
            cantidadOcupada++;
        }
    }

    /**
     * Libera una habitación ocupada.
     * Se usa durante el check-out.
     */
    public void liberar() {
        if (cantidadOcupada > 0) {
            cantidadOcupada--;
        }
    }

    /**
     * Aumenta la cantidad total de habitaciones disponibles.
     */
    public void aumentarCantidad(int n) {
        if (n > 0) {
            this.cantidadDisponible += n;
        }
    }

    /**
     * Disminuye la cantidad disponible de habitaciones de este tipo.
     * Solo si no rompe la lógica (por ejemplo: no puede bajar por debajo
     * de las ocupadas).
     */
    public void disminuirCantidad(int n) {
        if (n > 0 && this.cantidadDisponible >= n) {
            this.cantidadDisponible -= n;
        }
    }
}
