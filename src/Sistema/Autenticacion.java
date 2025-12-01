package Sistema;

import java.util.List;
import rrhh.Empleado;

public class Autenticacion {

    public Autenticacion() { }

    public String encriptar(String contraseñaOriginal) {
        if (contraseñaOriginal == null) return "";
        StringBuilder sb = new StringBuilder();
        for (char c : contraseñaOriginal.toCharArray()) {
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
                default: sb.append(c); break;
            }
        }
        return sb.toString();
    }
            
    public boolean validarUsuarioYContrasena(List<Empleado> empleados,
                                             String usuario,
                                             String contraseñaIngresada) {

        if (empleados == null || usuario == null || contraseñaIngresada == null) {
            return false;
        }

        String encriptada = encriptar(contraseñaIngresada);

        for (Empleado e : empleados) {
            if (e != null &&
                e.getUsuario().equals(usuario) &&
                e.getContraseñaEncriptada().equals(encriptada) &&
                "Activo".equalsIgnoreCase(e.getEstado())) {
                return true;
            }
        }
        return false;
    }
}
       