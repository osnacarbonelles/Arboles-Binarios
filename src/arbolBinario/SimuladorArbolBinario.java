package arbolBinario;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

/**
 *
 * @author Toloza XD
 */
public class SimuladorArbolBinario {

    ArbolBinario miArbol = new ArbolBinario();
    ArbolBinario miArbolEspejo = new ArbolBinario();

    public SimuladorArbolBinario() {
    }

    public boolean insertar(Integer dato) {
        return (this.miArbol.agregar(dato));
    }

    //metodo para mostrar los recorridos del arbol
    public String preOrden() {
        LinkedList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        LinkedList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

    public String postOrden() {
        LinkedList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }

    //metodo para poder mostrar los tipos d recorrido
    private String recorrido(LinkedList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "";
            i++;
        }
        return (r);
    }

    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.miArbol.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    int count;

    public String numeroDeHojas() {

        count = 0;

        miArbol.getNodosMap().forEach((i, x) -> {
            if (x.getDer() == null && x.getIzq() == null) {
                count++;
            }
        });

        return "Numero de hojas: " + count;
    }

    public String unHijo() {
        count = 0;

        miArbol.getNodosMap().forEach((i, x) -> {
            if ((x.getDer() == null && x.getIzq() != null) || (x.getIzq() == null && x.getDer() != null)) {
                count++;
            }
        });

        return "Numero de nodos con 1 hijo: " + count;
    }

    public String dosHijos() {
        count = 0;

        miArbol.getNodosMap().forEach((i, x) -> {
            if (x.getDer() != null && x.getIzq() != null) {
                count++;
            }
        });

        return "Numero de nodos con 2 hijos: " + count;
    }

    public void mostrarEspejo() {
        if (miArbol != null) {
            miArbolEspejo.agregar(miArbol.getRaiz().getDato());
        }
    }

    public JScrollPane getDibujo() {
        return new JScrollPane(miArbol.getdibujo(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public JScrollPane getDibujoEspejo() {
        return new JScrollPane(miArbol.getdibujoEspejo(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    public void printMap() {

        System.out.println("--- Nuevo Arbol -------");

        miArbol.getNodosMap().forEach((i, nodo) -> {

            System.out.println("----------------------------------------");
            System.out.println("Nodo: " + nodo.getDato());

            if (nodo.getIzq() != null) {
                System.out.println("Izq -> : " + nodo.getIzq().getDato());
            }

            if (nodo.getDer() != null) {
                System.out.println("Der -> : " + nodo.getDer().getDato());
            }

            System.out.println("----------------------------------------");
        });
    }
}
