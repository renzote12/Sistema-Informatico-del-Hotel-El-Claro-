package operaciones;

import hotel.Habitacion;
import java.time.LocalDateTime;

public class Comprobante {

    private LocalDateTime fecha;      // fecha del check-out / emisión
    private Huesped huesped;          // huésped que paga
    private Habitacion habitacion;    // habitación usada

    private double montoHabitacion;
    private double montoServicios;
    private double montoTotal;

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

    public LocalDateTime getFecha() { return fecha; }
    public Huesped getHuesped() { return huesped; }
    public Habitacion getHabitacion() { return habitacion; }

    public double getMontoHabitacion() { return montoHabitacion; }
    public double getMontoServicios() { return montoServicios; }
    public double getMontoTotal() { return montoTotal; }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setMontoHabitacion(double montoHabitacion) {
        this.montoHabitacion = montoHabitacion;
    }

    public void setMontoServicios(double montoServicios) {
        this.montoServicios = montoServicios;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
}
