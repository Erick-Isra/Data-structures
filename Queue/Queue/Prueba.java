/**Clase que hace pruebas del programa Cola.java
 * @author Agapito Bautista Erick Israel
 * @author Solano Juarez Sebastian
 **/

/*Inicio de la clase Prueba */
public class Prueba{

/*Inicio del metodo Main */
public static void main(String[] args){
    Cola<Integer> cola = new Cola<>();

        try {
            System.out.println("La cola está vacía: " + cola.esVacia());            
            cola.encolar(1);
            cola.encolar(3);
            cola.encolar(7);
            System.out.println("El inicio de la cola es: " + cola.darElementoInicio());
            System.out.println("La cola está vacía: " + cola.esVacia());
            System.out.println("La longitud de la cola es: " + cola.darLongitud());

            cola.desencolar();
            System.out.println("Desencolando un elemento.");
            System.out.println("El inicio de la cola es: " + cola.darElementoInicio());
            System.out.println("La longitud de cola es: " + cola.darLongitud());
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
/*Fin del metodo Main */
}/*Fin de la clase Prueba */
