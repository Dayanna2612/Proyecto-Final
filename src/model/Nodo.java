package model;

public class Nodo {
    
    private Vuelo vuelo;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.siguiente = null;
        this.anterior = null;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
