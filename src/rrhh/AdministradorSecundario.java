package rrhh;

import java.util.List;
import hotel.Habitacion;
import operaciones.ServicioAdicional;

/**
 * Representa al Administrador Secundario.
 * Tiene permisos para gestionar habitaciones y servicios del hotel.
 */
public class AdministradorSecundario extends Empleado {

    /**
     * Constructor del Administrador Secundario.
     */
    public AdministradorSecundario(String dni, String nombres, String apellidos,
                                   String usuario, String contraseñaEncriptada,
                                   String estado) {

        super(dni, nombres, apellidos, usuario, contraseñaEncriptada,
              "Administrador Secundario", estado);
    }

    // ===================== GESTIÓN DE HABITACIONES =====================

    /**
     * Registra una nueva habitación en el hotel.
     */
    public void registrarHabitacion(List<Habitacion> habitaciones, Habitacion hab) {
        if (habitaciones != null && hab != null)
            habitaciones.add(hab);
    }

    /**
     * Elimina una habitación por número.
     */
    public void eliminarHabitacion(List<Habitacion> habitaciones, int numero) {
        if (habitaciones != null)
            habitaciones.removeIf(h -> h.getNumeroHabitacion() == numero);
    }

    // ===================== GESTIÓN DE SERVICIOS =====================

    /**
     * Registra un nuevo servicio adicional.
     */
    public void registrarServicio(List<ServicioAdicional> servicios, ServicioAdicional s) {
        if (servicios != null && s != null)
            servicios.add(s);
    }
}
