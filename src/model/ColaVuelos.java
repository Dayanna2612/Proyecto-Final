package model;

import java.util.List;
import java.util.ArrayList;

public class ColaVuelos {
    private Nodo frente;
    private Nodo fin;

    public ColaVuelos() {
        frente = null;
        fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Vuelo vuelo) {
        Nodo nuevo = new Nodo(vuelo);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public Vuelo desencolar() {
        if (estaVacia()) 
            return null;

        Vuelo aux = frente.getVuelo();
        frente = frente.getSiguiente();

        if (frente == null)
            fin = null;

        return aux;
    }

    public void mostrarCola() {
        Nodo actual = frente;
        while (actual != null) {
            System.out.println(actual.getVuelo());
            actual = actual.getSiguiente();
        }
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("[COLA VACÍA]");
            return;
        }

        Nodo aux = frente;
        System.out.println("Contenido de la cola:");
        while (aux != null) {
            System.out.println(" -> " + aux.getVuelo());
            aux = aux.getSiguiente();
        }
    }

    public List<Vuelo> getTodos() {
        List<Vuelo> lista = new ArrayList<>();
        Nodo aux = frente;
        while (aux != null) {
            lista.add(aux.getVuelo());
            aux = aux.getSiguiente();
        }
        return lista;
    }
}
