package model;

public class Vuelo {

    private String codigo;
    private String origen;
    private String destino;
    private String hora;

    public Vuelo(String codigo, String origen, String destino, String hora) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return codigo + " | " + origen + " -> " + destino + " | " + hora;
    }
}
