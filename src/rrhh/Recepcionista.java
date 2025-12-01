package rrhh;

import java.util.List;
import hotel.Habitacion;
import operaciones.Huesped;
import operaciones.Reservacion;
import operaciones.Estadia;
import operaciones.ServicioAdicional;

/**
 * Representa al Recepcionista del hotel.
 * Gestiona huéspedes, reservaciones, check-ins, check-outs y consumos.
 */
public class Recepcionista extends Empleado {

    /**
     * Constructor del Recepcionista.
     */
    public Recepcionista(String dni, String nombres, String apellidos,
                         String usuario, String contraseñaEncriptada,
                         String estado) {

        super(dni, nombres, apellidos, usuario, contraseñaEncriptada,
              "Recepcionista", estado);
    }

    // ===================== GESTIÓN DE HUÉSPEDES =====================

    public void registrarHuesped(List<Huesped> huespedes, Huesped nuevo) {
        if (huespedes != null && nuevo != null)
            huespedes.add(nuevo);
    }

    // ===================== RESERVACIONES =====================

    public void crearReservacion(List<Reservacion> reservaciones, Reservacion nueva) {
        if (reservaciones != null && nueva != null)
            reservaciones.add(nueva);
    }

    // ===================== CHECK-IN / CHECK-OUT =====================

    public void registrarCheckIn(Estadia e) {
        if (e != null) e.realizarCheckIn();
    }

    public void registrarCheckOut(Estadia e) {
        if (e != null) e.realizarCheckOut();
    }

    // ===================== CONSUMOS =====================

    public void registrarConsumo(Estadia e, ServicioAdicional s, int cantidad) {
        if (e != null && s != null)
            e.agregarServicio(s, cantidad);
    }

    // ===================== HABITACIONES =====================

    public void asignarHabitacion(Estadia e, Habitacion h) {
        if (e != null && h != null)
            e.setHabitacionAsignada(h);
    }
}
