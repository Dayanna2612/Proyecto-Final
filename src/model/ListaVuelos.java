package model;

public class ListaVuelos {

    private Nodo inicio;
    private Nodo fin;

    public ListaVuelos() {
        inicio = null;
        fin = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void insertarFinal(Vuelo vuelo) {
        Nodo nuevo = new Nodo(vuelo);
        if (estaVacia()) {
            inicio = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
    }

    public void mostrar() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.getVuelo());
            actual = actual.getSiguiente();
        }
    }

    public Vuelo buscarPorCodigo(String codigo) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.getVuelo().getCodigo().equalsIgnoreCase(codigo)) {
                return actual.getVuelo();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public Vuelo buscarPorDestino(String destino) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.getVuelo().getDestino().equalsIgnoreCase(destino)) {
                return actual.getVuelo();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        if (estaVacia()) return false;

        Nodo actual = inicio;

        while (actual != null) {
            if (actual.getVuelo().getCodigo().equalsIgnoreCase(codigo)) {

                if (actual == inicio && actual == fin) {
                    inicio = fin = null;
                } else if (actual == inicio) {
                    inicio = inicio.getSiguiente();
                    inicio.setAnterior(null);
                } else if (actual == fin) {
                    fin = fin.getAnterior();
                    fin.setSiguiente(null);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}
