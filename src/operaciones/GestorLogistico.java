package operaciones;

import java.util.List;
import hotel.Habitacion;
import hotel.TipoHabitacion;
import rrhh.Empleado;

public class GestorLogistico extends Empleado {

    public GestorLogistico(String dni, String nombres, String apellidos,
                           String usuario, String contraseñaEncriptada,
                           String estado) {

        super(dni, nombres, apellidos, usuario, contraseñaEncriptada,
              "Gestor Logístico", estado);
    }

    public double calcularOcupacionTipo(List<Habitacion> habitaciones, TipoHabitacion tipo) {
        if (habitaciones == null || tipo == null) return 0;

        int total = 0;
        int ocupadas = 0;

        for (Habitacion h : habitaciones) {
            if (h != null && h.getTipoHabitacion() == tipo) {
                total++;
                if ("Ocupada".equalsIgnoreCase(h.getEstado())) {
                    ocupadas++;
                }
            }
        }

        if (total == 0) return 0;

        return (ocupadas * 100.0) / total;
    }
}
