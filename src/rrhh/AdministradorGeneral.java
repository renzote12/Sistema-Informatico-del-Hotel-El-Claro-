package rrhh;

import java.util.List;
import hotel.Habitacion;
import operaciones.Estadia;
import operaciones.Huesped;
import operaciones.Informe;

public class AdministradorGeneral extends Empleado {

    public AdministradorGeneral(String dni, String nombres, String apellidos,
                                String usuario, String contraseñaEncriptada,
                                String estado) {

        super(dni, nombres, apellidos, usuario, contraseñaEncriptada,
              "Administrador General", estado);
    }

    public void crearEmpleado(List<Empleado> empleados, Empleado nuevo) {
        if (empleados != null && nuevo != null) empleados.add(nuevo);
    }

    public void modificarEmpleado(List<Empleado> empleados, Empleado modificado) {
        if (empleados == null || modificado == null) return;

        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(modificado.getDni())) {
                empleados.set(i, modificado);
                return;
            }
        }
    }

    public void eliminarEmpleado(List<Empleado> empleados, String dni) {
        if (empleados != null && dni != null)
            empleados.removeIf(e -> e.getDni().equals(dni));
    }

    public String generarReporteOcupacion(List<Habitacion> habitaciones) {
        return new Informe().generarReporteOcupacion(habitaciones);
    }

    public String generarReporteIngresos(List<Estadia> estadias,
                                         String inicio, String fin) {
        return new Informe().generarReporteIngresos(estadias, inicio, fin);
    }

    public String generarReporteLugarProcedencia(List<Huesped> huespedes) {
        return new Informe().generarReporteLugarProcedencia(huespedes);
    }
}
