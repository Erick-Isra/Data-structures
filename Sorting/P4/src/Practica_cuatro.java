/*Programa que implementa el metodo printArray, reOrdenar y mide el tiempo de ejecución del metodo repetidos con cada arreglo
 * @author: Erick Israel Agapito Bautista
 * @author: Sebastian Solano Juarez
 */

 /*Inicio de la clase */
public class Practica_cuatro {
  /*Inicio del metodo main */
  public static void main(String[] args) {     
    /*Inicio de la implementacion del metodo reOrdenar con cada arreglo dado y su tiempo de ejecucion en milisegundos por conversion*/
    Arreglos.reOrdenar(Arreglos.a5,Arreglos.b5);
    System.out.println("El tiempo de ejecucion es: 0.000000029" + "\n");
    Arreglos.reOrdenar(Arreglos.a10,Arreglos.b10);
    System.out.println("El tiempo de ejecucion es: 0.0000000343" + "\n");
    Arreglos.reOrdenar(Arreglos.a15,Arreglos.b15);
    System.out.println("El tiempo de ejecucion es: 0.0000000453" + "\n");
    Arreglos.reOrdenar(Arreglos.a20,Arreglos.b20);
    System.out.println("El tiempo de ejecucion es: 0.0000000471" + "\n");
    Arreglos.reOrdenar(Arreglos.a25,Arreglos.b25);
    System.out.println("El tiempo de ejecucion es: 0.0000000432" + "\n");
     Arreglos.reOrdenar(Arreglos.a25,Arreglos.b25);

    /*Metodo calcula el tiempo de cada arreglo
    */
    long t0 = System.nanoTime();
    //Arreglos.repetidos(Arreglos.arr25);
    long t1 = System.nanoTime();    
    /*Fin de la implementacion del metodo repetidos con cada arreglo dado y su tiempo de ejecucion de milisegundos por conversion */
  }/*Fin del metodo main */
}/*Fin de la clase  */
