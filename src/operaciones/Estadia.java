package operaciones;

import hotel.Habitacion;
import hotel.TipoHabitacion;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa una estadía real dentro del hotel:
 *  - Deriva de una reservación
 *  - Se activa en el Check-in
 *  - Se cierra en el Check-out
 *
 * Contiene también los consumos de servicios adicionales.
 */
public class Estadia {

    private Reservacion reservacion;          // Reservación origen
    private Habitacion habitacionAsignada;    // Habitación asignada en check-in
    private LocalDateTime horaCheckIn;        // Hora de ingreso
    private LocalDateTime horaCheckOut;       // Hora de salida

    private ConsumoServicio[] consumos;       // Lista de consumos durante la estadía

    private double totalHabitacion;           // Total por noches
    private double totalServicios;            // Total por consumos
    private double totalPagar;                // Total general

    /**
     * Constructor: recibe la reservación y un tamaño máximo de consumos.
     */
    public Estadia(Reservacion reservacion, int maxConsumos) {
        this.reservacion = reservacion;
        this.consumos = new ConsumoServicio[maxConsumos];
    }

    // GETTERS
    public Reservacion getReservacion() { return reservacion; }
    public Habitacion getHabitacionAsignada() { return habitacionAsignada; }
    public LocalDateTime getHoraCheckIn() { return horaCheckIn; }
    public LocalDateTime getHoraCheckOut() { return horaCheckOut; }
    public double getTotalHabitacion() { return totalHabitacion; }
    public double getTotalServicios() { return totalServicios; }
    public double getTotalPagar() { return totalPagar; }

    // Setter para habitación asignada
    public void setHabitacionAsignada(Habitacion habitacionAsignada) {
        this.habitacionAsignada = habitacionAsignada;
    }


    // =====================================================
    // CÁLCULO DE NOCHES USANDO FECHAS DE LA RESERVACIÓN
    // =====================================================

    /**
     * Calcula cuántas noches corresponde cobrar.
     * Se basa en las fechas de la reservación.
     */
    private long calcularNoches(LocalDateTime salidaReal) {

        // Fechas tomadas de la reserva original
        LocalDate ingreso = reservacion.getFechaInicio();
        LocalDate salida = reservacion.getFechaFin();

        long noches = salida.toEpochDay() - ingreso.toEpochDay();

        // Nunca puede ser menos de 1 noche
        if (noches < 1) noches = 1;

        return noches;
    }


    // =====================================================
    // CÁLCULO DEL PRECIO POR HABITACIÓN
    // =====================================================

    /**
     * Calcula el total por noches de alojamiento,
     * aplicando precio por noche y descuento por noche.
     */
    public double calcularTotalHabitacion(LocalDateTime salidaReal) {

        TipoHabitacion tipo = habitacionAsignada.getTipoHabitacion();

        long noches = calcularNoches(salidaReal);
        double precioNoche = tipo.getPrecioPorNoche();
        double descuentoNoche = tipo.getDescuentoPorNoche();

        // Subtotal sin descuento
        double subtotal = noches * precioNoche;

        // Descuento aplicado por cada noche
        if (noches >= 1) {
            subtotal -= (noches * descuentoNoche);
        }

        totalHabitacion = subtotal;
        return subtotal;
    }


    // =====================================================
    // CÁLCULO DE SERVICIOS
    // =====================================================

    public double calcularTotalServicios() {
        double suma = 0;

        for (ConsumoServicio c : consumos) {
            if (c != null) suma += c.getSubtotal();
        }

        totalServicios = suma;
        return suma;
    }

    // =====================================================
    // TOTAL GENERAL
    // =====================================================

    public double calcularTotalPagar(LocalDateTime salidaReal) {
        totalPagar = calcularTotalHabitacion(salidaReal) + calcularTotalServicios();
        return totalPagar;
    }

    // =====================================================
    // CHECK-IN
    // =====================================================

    /**
     * Marca la hora de ingreso y actualiza estado de la habitación.
     */
    public void realizarCheckIn() {
        horaCheckIn = LocalDateTime.now();

        if (habitacionAsignada != null) {
            habitacionAsignada.setEstado("Ocupada");
            habitacionAsignada.getTipoHabitacion().ocupar();
        }
    }

    // =====================================================
    // CHECK-OUT
    // =====================================================

    /**
     * Marca salida, calcula total y libera la habitación.
     */
    public void realizarCheckOut() {
        horaCheckOut = LocalDateTime.now();
        calcularTotalPagar(horaCheckOut);

        if (habitacionAsignada != null) {
            habitacionAsignada.setEstado("En limpieza");
            habitacionAsignada.getTipoHabitacion().liberar();
        }
    }

    // =====================================================
    // REGISTRO DE CONSUMOS
    // =====================================================

    /**
     * Agrega un consumo de servicio a la estadía.
     */
    public void agregarServicio(ServicioAdicional servicio, int cantidad) {
        if (servicio == null || cantidad <= 0) return;

        // Buscar el primer espacio disponible
        for (int i = 0; i < consumos.length; i++) {
            if (consumos[i] == null) {
                consumos[i] = new ConsumoServicio(servicio, cantidad);
                return;
            }
        }
    }
}
