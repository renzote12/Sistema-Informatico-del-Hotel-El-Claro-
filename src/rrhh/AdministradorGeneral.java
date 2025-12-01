package rrhh;

import java.util.List;
import hotel.Habitacion;
import operaciones.Estadia;
import operaciones.Huesped;
import operaciones.Informe;

/**
 * Representa al Administrador General del hotel.
 * Tiene permisos completos: gestionar empleados y generar reportes.
 */
public class AdministradorGeneral extends Empleado {

    /**
     * Constructor del Administrador General.
     */
    public AdministradorGeneral(String dni, String nombres, String apellidos,
                                String usuario, String contraseñaEncriptada,
                                String estado) {

        super(dni, nombres, apellidos, usuario, contraseñaEncriptada,
              "Administrador General", estado);
    }

    // ===================== GESTIÓN DE EMPLEADOS =====================

    /**
     * Agrega un nuevo empleado a la lista.
     */
    public void crearEmpleado(List<Empleado> empleados, Empleado nuevo) {
        if (empleados != null && nuevo != null)
            empleados.add(nuevo);
    }

    /**
     * Modifica un empleado existente buscando por DNI.
     */
    public void modificarEmpleado(List<Empleado> empleados, Empleado modificado) {
        if (empleados == null || modificado == null) return;

        for (int i = 0; i < empleados.size(); i++) {

            if (empleados.get(i).getDni().equals(modificado.getDni())) {
                empleados.set(i, modificado);
                return;
            }
        }
    }

    /**
     * Elimina un empleado usando su DNI.
     */
    public void eliminarEmpleado(List<Empleado> empleados, String dni) {
        if (empleados != null && dni != null) {
            empleados.removeIf(e -> e.getDni().equals(dni));
        }
    }

    // ===================== REPORTES =====================

    /**
     * Genera un reporte de ocupación del hotel.
     */
    public String generarReporteOcupacion(List<Habitacion> habitaciones) {
        return new Informe().generarReporteOcupacion(habitaciones);
    }

    /**
     * Genera reporte de ingresos por habitaciones y servicios.
     */
    public String generarReporteIngresos(List<Estadia> estadias,
                                         String inicio, String fin) {
        return new Informe().generarReporteIngresos(estadias, inicio, fin);
    }

    /**
     * Reporte de lugar de procedencia de los huéspedes.
     */
    public String generarReporteLugarProcedencia(List<Huesped> huespedes) {
        return new Informe().generarReporteLugarProcedencia(huespedes);
    }
}
