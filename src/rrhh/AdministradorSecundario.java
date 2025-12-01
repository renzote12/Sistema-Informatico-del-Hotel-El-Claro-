package rrhh;

import java.util.List;
import hotel.Habitacion;
import operaciones.ServicioAdicional;

public class AdministradorSecundario extends Empleado {

    public AdministradorSecundario(String dni, String nombres, String apellidos,
                                   String usuario, String contraseñaEncriptada,
                                   String estado) {

        super(dni, nombres, apellidos, usuario, contraseñaEncriptada,
              "Administrador Secundario", estado);
    }

    public void registrarHabitacion(List<Habitacion> habitaciones, Habitacion hab) {
        if (habitaciones != null && hab != null) habitaciones.add(hab);
    }

    public void eliminarHabitacion(List<Habitacion> habitaciones, int numero) {
        if (habitaciones != null)
            habitaciones.removeIf(h -> h.getNumeroHabitacion() == numero);
    }

    public void registrarServicio(List<ServicioAdicional> servicios, ServicioAdicional s) {
        if (servicios != null && s != null) servicios.add(s);
    }
}
