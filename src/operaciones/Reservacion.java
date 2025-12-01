package operaciones;

import java.time.LocalDate;
import hotel.TipoHabitacion;

/**
 * Representa una reservación previa al check-in.
 * La reserva guarda el precio por noche en el momento de realizarse.
 */
public class Reservacion {

    private Huesped huesped;            // Huésped que reserva
    private TipoHabitacion tipo;        // Tipo de habitación reservado
    private LocalDate fechaInicio;      // Fecha de entrada planeada
    private LocalDate fechaFin;         // Fecha de salida planeada

    // Precio por noche congelado al momento de reservar
    private double precioPorNoche;

    /**
     * Constructor de la reservación.
     */
    public Reservacion(Huesped huesped, TipoHabitacion tipo,
                       LocalDate fechaInicio, LocalDate fechaFin) {

        this.huesped = huesped;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        // Guarda el precio en ese momento
        this.precioPorNoche = tipo.getPrecioPorNoche();
    }

    // GETTERS
    public Huesped getHuesped() { return huesped; }
    public TipoHabitacion getTipo() { return tipo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public double getPrecioPorNoche() { return precioPorNoche; }

    // SETTERS
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public void setTipo(TipoHabitacion tipo) { this.tipo = tipo; }
}
