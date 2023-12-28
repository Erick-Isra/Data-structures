import java.util.LinkedList;
/** Programa que crea una grafica con las clases Grafica, Arista y Vertice junto con sus metodos correspondientes
 * @author Agapito Bautista Erick Israel
 * @author Solano Juarez Sebastian
 */
/*Inicio clase PruebaGrafica */
public class PruebaGrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafica<Integer> g = new Grafica<>();
        try {
            g.insertarVertice("v1", 5);
            g.insertarVertice("v2", 7);
            g.insertarVertice("v3", 9);
            g.insertarVertice("v4", 2);
            g.insertarVertice("v5", 0);
            g.insertarArista("v1", "v3");
            g.insertarArista("v1", "v5");
            g.insertarArista("v2", "v3");
            g.insertarArista("v2", "v4");
            g.insertarArista("v4", "v3");
            g.insertarArista("v5", "v2");
            System.out.println("G := (V, E), donde");
            LinkedList<Grafica<Integer>.Vertice> vertices = g.darVertices();
            LinkedList<Grafica<Integer>.Arista> aristas = g.darAristas();
            int orden = g.darOrden();
            int tamano = g.darTamano();
            System.out.print("  V := { ");
            int i = 1;
            for (Grafica<Integer>.Vertice v : vertices) {
                if (i != orden) {
                    System.out.print(v.toString() + ", ");
                    i++;
                } else {
                    System.out.println(v.toString() + " }");
                }
            }
            System.out.print("  E := { ");
            int j = 1;
            for (Grafica<Integer>.Arista e : aristas) {
                if (j != tamano) {
                    System.out.print(e.toString() + ", ");
                    j++;
                } else {
                    System.out.println(e.toString() + " }");
                }
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }    
}/*Fin clase PruebaGrafica */