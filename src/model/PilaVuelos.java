package model;

import java.util.List;
import java.util.ArrayList;

public class PilaVuelos {
    private Nodo cima;

    public PilaVuelos() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(Vuelo vuelo) {
        Nodo nuevo = new Nodo(vuelo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public Vuelo desapilar() {
        if (estaVacia())
            return null;

        Vuelo aux = cima.getVuelo();
        cima = cima.getSiguiente();
        return aux;
    }

    public void mostrarPila() {
        Nodo actual = cima;
        while (actual != null) {
            System.out.println(actual.getVuelo());
            actual = actual.getSiguiente();
        }
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("[PILA VACÍA]");
            return;
        }

        Nodo actual = cima;
        System.out.println("Contenido de la pila:");
        while (actual != null) {
            System.out.println(" -> " + actual.getVuelo());
            actual = actual.getSiguiente();
        }
    }

    public List<Vuelo> getTodos() {
        List<Vuelo> lista = new ArrayList<>();
        Nodo aux = cima;
        while (aux != null) {
            lista.add(aux.getVuelo());
            aux = aux.getSiguiente();
        }
        return lista;
    }
}
