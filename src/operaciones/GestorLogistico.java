package operaciones;

import java.util.List;
import hotel.Habitacion;
import hotel.TipoHabitacion;
import rrhh.Empleado;

/**
 * Representa a un empleado especializado en logística del hotel.
 * Tiene la capacidad de calcular ocupación por tipo de habitación.
 * Extiende a Empleado.
 */
public class GestorLogistico extends Empleado {

    /**
     * Constructor del Gestor Logístico.
     */
    public GestorLogistico(String dni, String nombres, String apellidos,
                           String usuario, String contraseñaEncriptada,
                           String estado) {

        super(dni, nombres, apellidos, usuario, contraseñaEncriptada,
              "Gestor Logístico", estado);
    }

    /**
     * Calcula el porcentaje de ocupación de un tipo de habitación.
     *
     * @param habitaciones lista total de habitaciones del hotel
     * @param tipo tipo de habitación a evaluar
     * @return porcentaje entre 0% y 100%
     */
    public double calcularOcupacionTipo(List<Habitacion> habitaciones, TipoHabitacion tipo) {
        if (habitaciones == null || tipo == null) return 0;

        int total = 0;
        int ocupadas = 0;

        for (Habitacion h : habitaciones) {

            // Filtrar habitaciones de este tipo
            if (h != null && h.getTipoHabitacion() == tipo) {

                total++;

                // Verifica si está ocupada
                if ("Ocupada".equalsIgnoreCase(h.getEstado())) {
                    ocupadas++;
                }
            }
        }

        // Evita dividir entre cero
        if (total == 0) return 0;

        return (ocupadas * 100.0) / total;
    }
}
