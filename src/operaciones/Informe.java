package operaciones;

import java.util.List;
import hotel.Habitacion;

public class Informe {

    public String generarReporteOcupacion(List<Habitacion> habitaciones) {
        StringBuilder sb = new StringBuilder();
        sb.append("REPORTE DE OCUPACIÓN\n");

        for (Habitacion h : habitaciones) {
            if (h != null) {
                sb.append("Hab ").append(h.getNumeroHabitacion())
                  .append(" - Tipo: ").append(h.getTipoHabitacion().getNombre())
                  .append(" - Estado: ").append(h.getEstado())
                  .append(" - Entretenimiento: ");

                String[] ent = h.getEntretenimiento();
                if (ent != null && ent.length > 0) {
                    sb.append(String.join(", ", ent));
                } else {
                    sb.append("Sin extras");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String generarReporteIngresos(List<Estadia> estadias,
                                         String fechaInicio, String fechaFin) {

        double totalHabitaciones = 0;
        double totalServicios = 0;

        for (Estadia e : estadias) {
            if (e != null) {
                totalHabitaciones += e.getTotalHabitacion();
                totalServicios += e.getTotalServicios();
            }
        }

        return "REPORTE DE INGRESOS\n" +
               "Desde: " + fechaInicio + " Hasta: " + fechaFin + "\n" +
               "Total Habitaciones: " + totalHabitaciones + "\n" +
               "Total Servicios: " + totalServicios + "\n" +
               "Total General: " + (totalHabitaciones + totalServicios);
    }

    public String generarReporteLugarProcedencia(List<Huesped> huespedes) {

        StringBuilder sb = new StringBuilder("REPORTE DE PROCEDENCIA\n");

        for (Huesped h : huespedes) {
            if (h != null) {
                sb.append(h.getLugarResidencia()).append(" - ")
                  .append(h.getNombres()).append(" ").append(h.getApellidos())
                  .append(" | Tel: ").append(h.getTelefono())
                  .append(" | Correo: ").append(h.getCorreo())
                  .append("\n");
            }
        }

        return sb.toString();
    }
}
