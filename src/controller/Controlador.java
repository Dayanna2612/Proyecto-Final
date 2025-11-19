package controller;

import model.Vuelo;
import java.util.ArrayList;

public class Controlador {

    private ArrayList<Vuelo> listaGlobal;
    private ArrayList<Vuelo> colaEspera;
    private ArrayList<Vuelo> pilaFinalizados;

    public Controlador() {
        listaGlobal = new ArrayList<>();
        colaEspera = new ArrayList<>();
        pilaFinalizados = new ArrayList<>();
    }

    public void agregarVueloListaGlobal(Vuelo v) {
        listaGlobal.add(v);
    }

    public void encolarVuelo(Vuelo v) {
        colaEspera.add(v);
    }

    public Vuelo moverAEnEjecucion() {
        if (colaEspera.isEmpty()) return null;
        return colaEspera.remove(0);
    }

    public void finalizarVuelo(Vuelo vuelo) {
        pilaFinalizados.add(vuelo);
    }

    public void mostrarTodo() {
        System.out.println("\n--- LISTA GLOBAL ---");
        for (Vuelo v : listaGlobal) System.out.println(v);

        System.out.println("\n--- COLA DE ESPERA ---");
        for (Vuelo v : colaEspera) System.out.println(v);

        System.out.println("\n--- FINALIZADOS ---");
        for (Vuelo v : pilaFinalizados) System.out.println(v);
    }
}
