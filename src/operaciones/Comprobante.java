package operaciones;

import hotel.Habitacion;
import java.time.LocalDateTime;

/**
 * Representa el comprobante emitido al finalizar una estadía (check-out).
 * Contiene información del huésped, habitación y montos cobrados.
 */
public class Comprobante {

    // Fecha y hora en que se genera el comprobante (momento del check-out)
    private LocalDateTime fecha;

    // Huésped que realizó la estancia
    private Huesped huesped;

    // Habitación que ocupó el huésped
    private Habitacion habitacion;

    // Monto cobrado por el uso de la habitación
    private double montoHabitacion;

    // Monto total de servicios adicionales consumidos
    private double montoServicios;

    // Suma del monto de habitación + servicios
    private double montoTotal;

    /**
     * Constructor principal del comprobante.
     */
    public Comprobante(LocalDateTime fecha,
                       Huesped huesped,
                       Habitacion habitacion,
                       double montoHabitacion,
                       double montoServicios,
                       double montoTotal) {

        this.fecha = fecha;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.montoHabitacion = montoHabitacion;
        this.montoServicios = montoServicios;
        this.montoTotal = montoTotal;
    }

    // ======================
    // GETTERS
    // ======================

    public LocalDateTime getFecha() { return fecha; }
    public Huesped getHuesped() { return huesped; }
    public Habitacion getHabitacion() { return habitacion; }
    public double getMontoHabitacion() { return montoHabitacion; }
    public double getMontoServicios() { return montoServicios; }
    public double getMontoTotal() { return montoTotal; }

    // ======================
    // SETTERS
    // ======================

    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setHuesped(Huesped huesped) { this.huesped = huesped; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }
    public void setMontoHabitacion(double montoHabitacion) { this.montoHabitacion = montoHabitacion; }
    public void setMontoServicios(double montoServicios) { this.montoServicios = montoServicios; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
}
