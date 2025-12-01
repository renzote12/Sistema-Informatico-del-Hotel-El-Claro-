package hotel;

/**
 * Representa una habitación física dentro del hotel.
 * Almacena información sobre su número, tipo de habitación,
 * tipo de cama, estado actual y elementos de entretenimiento.
 */
public class Habitacion {

    // Número único que identifica la habitación (por ejemplo: 101, 203, 305)
    private int numeroHabitacion;

    // Tipo de habitación (Estandar, Deluxe, Suite...). Contiene precios y configuración.
    private TipoHabitacion tipoHabitacion;

    // Tipo de cama (Individual, Queen, King)
    private String tipoCama;

    // Estado actual de la habitación (Disponible, Ocupada, En limpieza, etc.)
    private String estado;

    // Lista de servicios o elementos dentro de la habitación (TV, jacuzzi, etc.)
    private String[] entretenimiento;

    /**
     * Constructor de la clase Habitacion.
     *
     * @param numeroHabitacion número identificador de la habitación
     * @param tipoHabitacion objeto que describe el tipo de habitación
     * @param tipoCama descripción del tipo de cama
     * @param estado estado inicial de la habitación
     * @param entretenimiento lista de elementos o servicios en la habitación
     */
    public Habitacion(int numeroHabitacion,
                      TipoHabitacion tipoHabitacion,
                      String tipoCama,
                      String estado,
                      String[] entretenimiento) {

        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.tipoCama = tipoCama;
        this.estado = estado;
        this.entretenimiento = entretenimiento;
    }

    // =====================================================
    //  GETTERS (LECTURA)
    // =====================================================

    /** @return número de habitación */
    public int getNumeroHabitacion() { return numeroHabitacion; }

    /** @return tipo de habitación */
    public TipoHabitacion getTipoHabitacion() { return tipoHabitacion; }

    /** @return tipo de cama */
    public String getTipoCama() { return tipoCama; }

    /** @return estado actual de la habitación */
    public String getEstado() { return estado; }

    /** @return lista de servicios/elementos en la habitación */
    public String[] getEntretenimiento() { return entretenimiento; }


    // =====================================================
    //  SETTERS (MODIFICACIÓN)
    // =====================================================

    /** Permite cambiar el tipo de habitación asignado. */
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /** Permite cambiar el tipo de cama. */
    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    /** Permite actualizar el estado de la habitación. */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** Permite actualizar la lista de elementos de entretenimiento. */
    public void setEntretenimiento(String[] entretenimiento) {
        this.entretenimiento = entretenimiento;
    }
}
