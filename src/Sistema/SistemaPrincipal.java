package Sistema;

// Importamos utilidades, listas y GUI
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

// Importamos paquetes del proyecto
import rrhh.*;
import hotel.*;
import operaciones.*;
import ui.LoginFrame;

/**
 * Clase principal del sistema.
 * Se encarga de:
 *  - Crear el conjunto inicial de empleados.
 *  - Registrar los tipos de habitación.
 *  - Crear las habitaciones disponibles.
 *  - Registrar los servicios adicionales del hotel.
 *  - Iniciar la interfaz de Login.
 *
 * Nota: Esta clase funciona como "cargador" del sistema.
 */
public class SistemaPrincipal {

    // =====================================================
    //  LISTA GLOBAL DE EMPLEADOS (ACCESIBLE EN TODO EL SISTEMA)
    //  Ya no se pasa por parámetro a los menús.
    // =====================================================
    public static List<Empleado> empleados = new ArrayList<>();


    public static void main(String[] args) {

        // =====================================================
        // 1. CREACIÓN DEL EMPLEADO ADMINISTRADOR GENERAL
        // =====================================================

        Autenticacion auth = new Autenticacion(); // para encriptar la contraseña

        // Agregamos un administrador general por defecto
        empleados.add(new AdministradorGeneral(
                "60986393",         // DNI
                "Renzo",            // Nombre
                "Garces",           // Apellido
                "admin",            // Usuario
                auth.encriptar("admin123"), // Contraseña encriptada
                "Activo"            // Estado
        ));


        // =====================================================
        // 2. REGISTRO DE TIPOS DE HABITACIÓN CON PRECIOS POR NOCHE
        // =====================================================

        TipoHabitacion simple = new TipoHabitacion(
                "Estandar",
                2,          // capacidad máxima
                60.0,       // precio por noche
                5.0,        // descuento por noche
                20,         // cantidad disponible del tipo
                new String[]{"Individual", "Queen"}
        );

        TipoHabitacion deluxe = new TipoHabitacion(
                "Deluxe",
                4,
                120.0,
                10.0,
                7,
                new String[]{"Queen", "King"}
        );

        TipoHabitacion suite = new TipoHabitacion(
                "Suite",
                6,
                200.0,
                15.0,
                5,
                new String[]{"King"}
        );

        // Registramos los tipos en el sistema
        Hotel.listaTipos.add(simple);
        Hotel.listaTipos.add(deluxe);
        Hotel.listaTipos.add(suite);


        // =====================================================
        // 3. CREACIÓN DE HABITACIONES (10 estándar, 7 deluxe, 5 suite)
        // =====================================================

        // ---- ESTÁNDAR (100–120)
        for (int i = 1; i <= 10; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(
                        100 + i,
                        simple,
                        "Queen",
                        "Disponible",
                        new String[]{"tv4k", "wifiBasico"}
                )
            );
        }

        for (int i = 11; i <= 20; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(
                        100 + i,
                        simple,
                        "Individual",
                        "Disponible",
                        new String[]{"tv4k", "wifiBasico"}
                )
            );
        }

        // ---- DELUXE (200–207)
        for (int i = 1; i <= 7; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(
                        200 + i,
                        deluxe,
                        "King",
                        "Disponible",
                        new String[]{"tv4k", "jacuzzi", "wifiBasico"}
                )
            );
        }

        // ---- SUITE (300–305)
        for (int i = 1; i <= 5; i++) {
            Hotel.listaHabitaciones.add(
                new Habitacion(
                        300 + i,
                        suite,
                        "King",
                        "Disponible",
                        new String[]{"tv4k", "jacuzzi", "sillonTematico", "wifiPremiun"}
                )
            );
        }


        // =====================================================
        // 4. REGISTRO DE SERVICIOS ADICIONALES
        // =====================================================

        Hotel.listaServicios.add(new ServicioAdicional("Desayuno buffet", 15.0));
        Hotel.listaServicios.add(new ServicioAdicional("Spa", 40.0));
        Hotel.listaServicios.add(new ServicioAdicional("Traslado aeropuerto", 25.0));


        // =====================================================
        // 5. INICIAR LA VENTANA DE LOGIN
        // =====================================================

        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true); // LoginFrame ya no necesita lista de empleados
        });
    }
}
