package Sistema;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

import rrhh.*;
import hotel.*;
import operaciones.*;
import ui.LoginFrame;
//gaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
public class SistemaPrincipal {

    // =====================================================
    //  LISTA GLOBAL DE EMPLEADOS (ACCESIBLE EN TODO EL SISTEMA)
    // =====================================================
    public static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {

        // =====================================================
        // 1. EMPLEADOS
        // =====================================================
        Autenticacion auth = new Autenticacion();

        empleados.add(new AdministradorGeneral(
                "60986393", "Renzo", "Garces",
                "admin",
                auth.encriptar("admin123"),
                "Activo"
        ));

        // =====================================================
        // 2. TIPOS DE HABITACIÓN
        // =====================================================

        TipoHabitacion simple = new TipoHabitacion(
                "Estandar",
                2,
                60.0,     // precio por noche
                5.0,      // descuento por noche
                20,
                new String[]{"Individual", "Queen"}
        );

        TipoHabitacion deluxe = new TipoHabitacion(
                "Deluxe",
                4,
                120.0,    // precio por noche
                10.0,     // descuento por noche
                7,
                new String[]{"Queen", "King"}
        );

        TipoHabitacion suite = new TipoHabitacion(
                "Suite",
                6,
                200.0,    // precio por noche
                15.0,     // descuento por noche
                5,
                new String[]{"King"}
        );

        Hotel.listaTipos.add(simple);
        Hotel.listaTipos.add(deluxe);
        Hotel.listaTipos.add(suite);


        // =====================================================
        // 3. HABITACIONES
        // =====================================================

        for (int i = 1; i <= 10; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(100 + i, simple, "Queen", "Disponible",
                        new String[]{"tv4k", "wifiBasico"})
            );
        }
        for (int i = 11; i <= 20; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(100 + i, simple, "Individual", "Disponible",
                        new String[]{"tv4k", "wifiBasico"})
            );
        }

        for (int i = 1; i <= 7; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(200 + i, deluxe, "King", "Disponible",
                        new String[]{"tv4k", "jacuzzi", "wifiBasico"})
            );
        }

        for (int i = 1; i <= 5; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(300 + i, suite, "King", "Disponible",
                        new String[]{"tv4k", "jacuzzi", "sillonTematico", "wifiPremiun"})
            );
        }


        // =====================================================
        // 4. SERVICIOS ADICIONALES
        // =====================================================
        Hotel.listaServicios.add(new ServicioAdicional("Desayuno buffet", 15.0));
        Hotel.listaServicios.add(new ServicioAdicional("Spa", 40.0));
        Hotel.listaServicios.add(new ServicioAdicional("Traslado aeropuerto", 25.0));


        // =====================================================
        // 5. ABRIR LOGIN (SIN PASAR LISTA, YA ES GLOBAL)
        // =====================================================
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
