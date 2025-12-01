package operaciones;

import hotel.Habitacion;
import hotel.TipoHabitacion;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Estadia {

    private Reservacion reservacion;
    private Habitacion habitacionAsignada;
    private LocalDateTime horaCheckIn;
    private LocalDateTime horaCheckOut;

    private ConsumoServicio[] consumos;

    private double totalHabitacion;
    private double totalServicios;
    private double totalPagar;

    public Estadia(Reservacion reservacion, int maxConsumos) {
        this.reservacion = reservacion;
        this.consumos = new ConsumoServicio[maxConsumos];
    }

    public Reservacion getReservacion() { return reservacion; }
    public Habitacion getHabitacionAsignada() { return habitacionAsignada; }
    public LocalDateTime getHoraCheckIn() { return horaCheckIn; }
    public LocalDateTime getHoraCheckOut() { return horaCheckOut; }
    public double getTotalHabitacion() { return totalHabitacion; }
    public double getTotalServicios() { return totalServicios; }
    public double getTotalPagar() { return totalPagar; }

    public void setHabitacionAsignada(Habitacion habitacionAsignada) {
        this.habitacionAsignada = habitacionAsignada;
    }

    // =============== CÁLCULO POR NOCHE ==================
    private long calcularNoches(LocalDateTime salidaReal) {

    LocalDate ingreso = reservacion.getFechaInicio();
    LocalDate salida = reservacion.getFechaFin();

    long noches = salida.toEpochDay() - ingreso.toEpochDay();

    if (noches < 1) noches = 1;

    return noches;
}


public double calcularTotalHabitacion(LocalDateTime salidaReal) {

    TipoHabitacion tipo = habitacionAsignada.getTipoHabitacion();

    long noches = calcularNoches(salidaReal);

    double precioNoche = tipo.getPrecioPorNoche();
    double descuentoNoche = tipo.getDescuentoPorNoche();

    // calcular subtotal
    double subtotal = noches * precioNoche;

    // aplicar descuento por cada noche
    if (noches >= 1) {
        subtotal -= (noches * descuentoNoche);
    }

    totalHabitacion = subtotal;
    return subtotal;
}

    public double calcularTotalServicios() {
        double suma = 0;
        for (ConsumoServicio c : consumos) {
            if (c != null) suma += c.getSubtotal();
        }
        totalServicios = suma;
        return suma;
    }

    public double calcularTotalPagar(LocalDateTime salidaReal) {
        totalPagar = calcularTotalHabitacion(salidaReal) + calcularTotalServicios();
        return totalPagar;
    }

    public void realizarCheckIn() {
        horaCheckIn = LocalDateTime.now();
        if (habitacionAsignada != null) {
            habitacionAsignada.setEstado("Ocupada");
            habitacionAsignada.getTipoHabitacion().ocupar();
        }
    }

    public void realizarCheckOut() {
        horaCheckOut = LocalDateTime.now();
        calcularTotalPagar(horaCheckOut);

        if (habitacionAsignada != null) {
            habitacionAsignada.setEstado("En limpieza");
            habitacionAsignada.getTipoHabitacion().liberar();
        }
    }

    public void agregarServicio(ServicioAdicional servicio, int cantidad) {
        if (servicio == null || cantidad <= 0) return;

        for (int i = 0; i < consumos.length; i++) {
            if (consumos[i] == null) {
                consumos[i] = new ConsumoServicio(servicio, cantidad);
                return;
            }
        }
    }
}
