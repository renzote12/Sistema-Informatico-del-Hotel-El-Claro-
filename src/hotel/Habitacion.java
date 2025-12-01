package hotel;

public class Habitacion {

    private int numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private String tipoCama;
    private String estado;
    private String[] entretenimiento;

    public Habitacion(int numeroHabitacion,
                      TipoHabitacion tipoHabitacion,
                      String tipoCama,
                      String estado,
                      String[] entretenimiento) {

        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.tipoCama = tipoCama;
        this.estado = estado;
        this.entretenimiento = entretenimiento;
    }

    public int getNumeroHabitacion() { return numeroHabitacion; }
    public TipoHabitacion getTipoHabitacion() { return tipoHabitacion; }
    public String getTipoCama() { return tipoCama; }
    public String getEstado() { return estado; }
    public String[] getEntretenimiento() { return entretenimiento; }
public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
    this.tipoHabitacion = tipoHabitacion;
}

    public void setTipoCama(String tipoCama) { this.tipoCama = tipoCama; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setEntretenimiento(String[] entretenimiento) { this.entretenimiento = entretenimiento; }
}
