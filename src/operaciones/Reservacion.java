package operaciones;

import java.time.LocalDate;
import hotel.TipoHabitacion;

public class Reservacion {

    private Huesped huesped;
    private TipoHabitacion tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private double precioPorNoche;     // NUEVO: precio congelado al momento de reservar

    public Reservacion(Huesped huesped, TipoHabitacion tipo,
                       LocalDate fechaInicio, LocalDate fechaFin) {

        this.huesped = huesped;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        // PRECIO GUARDADO (si cambia el tipo, la reserva NO cambia)
        this.precioPorNoche = tipo.getPrecioPorNoche();
    }

    public Huesped getHuesped() { return huesped; }
    public TipoHabitacion getTipo() { return tipo; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }

    public double getPrecioPorNoche() { return precioPorNoche; }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }
}
