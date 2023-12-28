public class Prueba {
    public static void main(String[] args) {
        ListaLigadaSimple<Integer> lista = new ListaLigadaSimple<Integer>();

        System.out.println("Se desea modelar la lista [7,4,3,3,2,1], a continuación se insertan los elementos empezando por el último usando el método insertar: ");

        System.out.println("________________________________________________________________________________________________________________________________________");

        // Insertar elementos en la listaNodo cabeza, Nodo rabo, int longitud
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(3);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(7);

        // Imprimir los elementos de la lista
        System.out.println("Lista:");
        System.out.print("[");
        int cont = 0;
        for (Integer elemento : lista) {
            if(cont == lista.darLongitud()-1){
              System.out.print(elemento);
            }else{
              System.out.print(elemento);
              System.out.print(",");
            }
            cont++;
        }
        System.out.println("]");

        System.out.println("________________________________________________________________________________________________________________________________________");
        //Probamos metodo acceder
        System.out.println("El elemento en la posición 4 es: " + lista.acceder(4));

        System.out.println("________________________________________________________________________________________________________________________________________");

        System.out.println("El 10 está en la lista? " + lista.buscar(10));
        System.out.println("El 3 está en la lista? " + lista.buscar(3));

        System.out.println("________________________________________________________________________________________________________________________________________");

        System.out.println("La lista después de eliminar el primer elemento es:");
        lista.eliminar(0);
        System.out.print("[");
        int cont2 = 0;
        for (Integer elemento2 : lista) {
            if(cont2 == lista.darLongitud()-1){
              System.out.print(elemento2);
            }else{
              System.out.print(elemento2);
              System.out.print(",");
            }
            cont2++;
        }
        System.out.println("]");

        System.out.println("________________________________________________________________________________________________________________________________________");

        System.out.println("Si a la lista anterior le quitamos el último elemento es:");
        lista.eliminar(lista.darLongitud()-1);
        System.out.print("[");
        int cont3 = 0;
        for (Integer elemento3 : lista) {
            if(cont3 == lista.darLongitud()-1){
              System.out.print(elemento3);
            }else{
              System.out.print(elemento3);
              System.out.print(",");
            }
            cont3++;
        }
        System.out.println("]");

        System.out.println("________________________________________________________________________________________________________________________________________");

        System.out.println("Si a la lista anterior le quitamos el elemento de la posición 1 queda:");
        lista.eliminar(1);
        System.out.print("[");
        int cont4 = 0;
        for (Integer elemento4 : lista) {
            if(cont4 == lista.darLongitud()-1){
              System.out.print(elemento4);
            }else{
              System.out.print(elemento4);
              System.out.print(",");
            }
            cont4++;
        }
        System.out.println("]");
    }
}
