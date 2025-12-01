package Sistema;

import java.util.List;
import rrhh.Empleado;

/**
 * Clase encargada del proceso de autenticación de usuarios.
 * Incluye:
 *  - Un método para encriptar contraseñas.
 *  - La validación de usuario y contraseña contra la lista de empleados.
 */
public class Autenticacion {

    /**
     * Constructor vacío.
     * No realiza ninguna operación, pero permite crear objetos de Autenticacion.
     */
    public Autenticacion() { }

    /**
     * Encripta la contraseña original aplicando sustituciones de caracteres.
     *
     * @param contraseñaOriginal Contraseña ingresada por el usuario.
     * @return Cadena encriptada mediante sustitución de caracteres.
     */
    public String encriptar(String contraseñaOriginal) {

        // Si la contraseña es null, retornamos una cadena vacía para evitar errores.
        if (contraseñaOriginal == null) return "";

        // Usamos StringBuilder porque es más eficiente para concatenar dentro de un ciclo.
        StringBuilder sb = new StringBuilder();

        // Convertir la contraseña en un arreglo de caracteres para iterar.
        for (char c : contraseñaOriginal.toCharArray()) {

            // Reglas simples de sustitución de caracteres.
            switch (c) {
                case 'a': sb.append('$'); break;
                case 'e': sb.append('%'); break;
                case 'i': sb.append('&'); break;
                case 'o': sb.append('#'); break;
                case 'u': sb.append('*'); break;
                case '1': sb.append('!'); break;
                case '2': sb.append(')'); break;
                case '3': sb.append("#$"); break;
                case 'c': sb.append("@##"); break;
                case 'd': sb.append("*-*"); break;
                case 'f': sb.append(";;"); break;
                case 'g': sb.append("/-/"); break;
                case 'h': sb.append("&*&"); break;

                // Si no hay una regla para el caracter, se deja igual.
                default: sb.append(c); break;
            }
        }

        // Retorna la contraseña encriptada.
        return sb.toString();
    }

    /**
     * Valida usuario y contraseña contra la lista de empleados.
     *
     * @param empleados Lista de empleados registrados en el sistema.
     * @param usuario Usuario ingresado en el login.
     * @param contraseñaIngresada Contraseña digitada por el usuario.
     * @return true si el usuario existe, la contraseña coincide y está activo.
     */
    public boolean validarUsuarioYContrasena(List<Empleado> empleados,
                                             String usuario,
                                             String contraseñaIngresada) {

        // Validación inicial para evitar errores NullPointer.
        if (empleados == null || usuario == null || contraseñaIngresada == null) {
            return false;
        }

        // Encriptamos la contraseña ingresada para compararla con la guardada.
        String encriptada = encriptar(contraseñaIngresada);

        // Recorremos la lista de empleados.
        for (Empleado e : empleados) {

            // Validamos nulls y luego coincidencia exacta con:
            //   - Usuario
            //   - Contraseña encriptada
            //   - Estado activo
            if (e != null &&
                e.getUsuario().equals(usuario) &&
                e.getContraseñaEncriptada().equals(encriptada) &&
                "Activo".equalsIgnoreCase(e.getEstado())) {

                return true; // Autenticación exitosa.
            }
        }

        // Si no se encontró coincidencia, devolvemos false.
        return false;
    }
}
