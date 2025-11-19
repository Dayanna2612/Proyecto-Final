package controller;

import model.Vuelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public void eliminarVuelo(String codigo) {
        listaGlobal.removeIf(v -> v.getCodigo().equalsIgnoreCase(codigo));
        colaEspera.removeIf(v -> v.getCodigo().equalsIgnoreCase(codigo));
        pilaFinalizados.removeIf(v -> v.getCodigo().equalsIgnoreCase(codigo));
    }

    public void encolarVuelo(Vuelo v) {
        if (!colaEspera.contains(v)) colaEspera.add(v);
    }

    public Vuelo moverAEnEjecucion() {
        if (colaEspera.isEmpty()) return null;
        return colaEspera.remove(0);
    }

    public void finDeEjecucion(Vuelo v) {
        if (v != null) pilaFinalizados.add(v);
    }

    public ArrayList<Vuelo> getListaGlobal() {
        return listaGlobal;
    }

    public ArrayList<Vuelo> getCola() {
        return colaEspera;
    }

    public ArrayList<Vuelo> getFinalizados() {
        return pilaFinalizados;
    }

    public Vuelo buscarPorCodigo(String codigo) {
        for (Vuelo v : listaGlobal) {
            if (v.getCodigo().equalsIgnoreCase(codigo)) return v;
        }
        return null;
    }

    public ArrayList<Vuelo> buscarPorDestino(String destino) {
        ArrayList<Vuelo> resultados = new ArrayList<>();
        for (Vuelo v : listaGlobal) {
            if (v.getDestino().equalsIgnoreCase(destino)) resultados.add(v);
        }
        return resultados;
    }

    public void ordenarPorPrioridad() {
        Collections.sort(listaGlobal, Comparator.comparingInt(Vuelo::getPrioridad).reversed());
    }

    public void ordenarPorHora() {
        Collections.sort(listaGlobal, new Comparator<Vuelo>() {
            @Override
            public int compare(Vuelo v1, Vuelo v2) {
                return Integer.compare(v1.getHora(), v2.getHora());
            }
        });
    }

    public void reiniciarSimulacion() {
        listaGlobal.clear();
        colaEspera.clear();
        pilaFinalizados.clear();
    }

    public String eficienciaAlgoritmos() {
        int total = listaGlobal.size();
        int enCola = colaEspera.size();
        int finalizados = pilaFinalizados.size();
        return "Total vuelos: " + total + ", En cola: " + enCola + ", Finalizados: " + finalizados;
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
