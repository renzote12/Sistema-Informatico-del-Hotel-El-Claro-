package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import operaciones.Comprobante;
import operaciones.Estadia;
import operaciones.Huesped;
import operaciones.Reservacion;
import operaciones.ServicioAdicional;

public class Hotel {

    public static List<TipoHabitacion> listaTipos = new ArrayList<>();
    public static List<Habitacion> listaHabitaciones = new ArrayList<>();
    public static List<ServicioAdicional> listaServicios = new ArrayList<>();

    public static List<Comprobante> listaComprobantes = new ArrayList<>();
    public static List<Huesped> listaHuespedes = new ArrayList<>();
    public static List<Reservacion> listaReservaciones = new ArrayList<>();
    public static List<Estadia> listaEstadias = new ArrayList<>();

    public static void registrarCheckOut(Estadia e) {
        if (e != null) e.realizarCheckOut();
    }

    // DISPONIBILIDAD
    public static boolean hayDisponibilidad(TipoHabitacion tipo, LocalDate inicio, LocalDate fin) {

        int ocupadas = 0;

        for (Reservacion r : listaReservaciones) {
            if (r.getTipo().equals(tipo)) {
                boolean seSolapan = !(fin.isBefore(r.getFechaInicio()) ||
                                      inicio.isAfter(r.getFechaFin()));
                if (seSolapan) ocupadas++;
            }
        }

        return ocupadas < tipo.getCantidadDisponible();
    }
}
