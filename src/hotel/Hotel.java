package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import operaciones.Comprobante;
import operaciones.Estadia;
import operaciones.Huesped;
import operaciones.Reservacion;
import operaciones.ServicioAdicional;

/**
 * Clase central del sistema.
 * Contiene LISTAS ESTÁTICAS que actúan como una base de datos en memoria.
 *
 * Aquí almacenamos:
 *  - Tipos de habitación
 *  - Habitaciones creadas
 *  - Servicios adicionales
 *  - Huespedes registrados
 *  - Reservaciones
 *  - Estadías (Check-in → Check-out)
 *  - Comprobantes generados
 *
 * Todas son listas estáticas para que puedan accederse desde cualquier parte del sistema.
 */
public class Hotel {

    // =====================================================
    //  LISTAS PRINCIPALES (ACTÚAN COMO "BASE DE DATOS")
    // =====================================================

    /** Lista de tipos de habitación: Estandar, Deluxe, Suite */
    public static List<TipoHabitacion> listaTipos = new ArrayList<>();

    /** Lista de habitaciones físicas del hotel */
    public static List<Habitacion> listaHabitaciones = new ArrayList<>();

    /** Servicios adicionales disponibles (Spa, desayuno, traslado, etc.) */
    public static List<ServicioAdicional> listaServicios = new ArrayList<>();


    // =====================================================
    //  REGISTROS OPERATIVOS
    // =====================================================

    /** Lista de comprobantes generados al realizar un check-out */
    public static List<Comprobante> listaComprobantes = new ArrayList<>();

    /** Lista de huéspedes registrados en el sistema */
    public static List<Huesped> listaHuespedes = new ArrayList<>();

    /** Lista de reservaciones activas y pasadas */
    public static List<Reservacion> listaReservaciones = new ArrayList<>();

    /** Lista de estadías: ocupación real después de un check-in */
    public static List<Estadia> listaEstadias = new ArrayList<>();


    // =====================================================
    //  MÉTODOS PRINCIPALES
    // =====================================================

    /**
     * Registra un check-out si la estadía no es nula.
     * Es una función simple, llamada desde la capa lógica.
     *
     * @param e Estadia sobre la cual se realizará el check-out.
     */
    public static void registrarCheckOut(Estadia e) {
        if (e != null) 
            e.realizarCheckOut();
    }


    // =====================================================
    //  DISPONIBILIDAD DE HABITACIONES SEGÚN RANGO DE FECHAS
    // =====================================================

    /**
     * Verifica si existe al menos UNA habitación disponible
     * para un tipo de habitación y un rango de fechas.
     *
     * La validación revisa SOLO las reservaciones (no los check-in reales)
     * usando detección de solapamiento de fechas.
     *
     * @param tipo   Tipo de habitación solicitado.
     * @param inicio Fecha de inicio de la reserva.
     * @param fin    Fecha de fin de la reserva.
     * @return true si hay disponibilidad, false si están ocupadas.
     */
    public static boolean hayDisponibilidad(TipoHabitacion tipo, LocalDate inicio, LocalDate fin) {

        int ocupadas = 0; // contador de habitaciones reservadas en ese rango

        // Recorre todas las reservaciones que usan el mismo tipo de habitación
        for (Reservacion r : listaReservaciones) {

            // Solo nos interesan las reservaciones del mismo tipo
            if (r.getTipo().equals(tipo)) {

                // Detectar solapamiento de fechas:
                // No se solapan si: fin < inicioReserva  O  inicio > finReserva
                boolean seSolapan = !(fin.isBefore(r.getFechaInicio()) ||
                                      inicio.isAfter(r.getFechaFin()));

                // Si se solapan, significa que esa habitación del tipo está ocupada
                if (seSolapan) {
                    ocupadas++;
                }
            }
        }

        // Si el total de ocupadas es menor que la cantidad disponible,
        // entonces el tipo de habitación todavía tiene espacios libres.
        return ocupadas < tipo.getCantidadDisponible();
    }
}
