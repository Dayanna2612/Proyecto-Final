package model;

public class Vuelo {

    private String codigo;
    private String destino;
    private int prioridad;
    private int hora; // Nueva variable para la hora del vuelo

    // Constructor completo con hora
    public Vuelo(String codigo, String destino, int prioridad, int hora) {
        this.codigo = codigo;
        this.destino = destino;
        this.prioridad = prioridad;
        this.hora = hora;
    }

    // Constructor con hora por defecto (0) para compatibilidad con código viejo
    public Vuelo(String codigo, String destino, int prioridad) {
        this(codigo, destino, prioridad, 0);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestino() {
        return destino;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getHora() {
        return hora;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return codigo + " | Destino: " + destino + " | Prioridad: " + prioridad + " | Hora: " + hora;
    }
}
