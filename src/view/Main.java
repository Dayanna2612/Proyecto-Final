package view;

import controller.Controlador;
import model.Vuelo;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        Scanner sc = new Scanner(System.in);

        Vuelo vueloEnEjecucion = null;
        int opcion;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Agregar vuelo a lista global");
            System.out.println("2. Encolar vuelo");
            System.out.println("3. Mover a ejecución");
            System.out.println("4. Finalizar vuelo");
            System.out.println("5. Mostrar todo");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                case 2:
                    System.out.print("Codigo: ");
                    String cod = sc.next();

                    System.out.print("Destino: ");
                    String des = sc.next();

                    System.out.print("Prioridad: ");
                    int p = sc.nextInt();

                    Vuelo v = new Vuelo(cod, des, p);

                    if (opcion == 1) controlador.agregarVueloListaGlobal(v);
                    else controlador.encolarVuelo(v);

                    break;   // <-- IMPORTANTE

                case 3:
                    vueloEnEjecucion = controlador.moverAEnEjecucion();
                    if (vueloEnEjecucion == null)
                        System.out.println("No hay vuelos en cola.");
                    else
                        System.out.println("Ahora en ejecución: " + vueloEnEjecucion);
                    break;

                case 4:
                    if (vueloEnEjecucion == null)
                        System.out.println("No hay vuelo en ejecución.");
                    else {
                        controlador.finDeEjecucion(vueloEnEjecucion);

                        System.out.println("Vuelo finalizado.");
                        vueloEnEjecucion = null;
                    }
                    break;

                case 5:
                    controlador.mostrarTodo();
                    break;
            }

        } while (opcion != 6);

        sc.close();
        System.out.println("Programa terminado.");
    }
}
