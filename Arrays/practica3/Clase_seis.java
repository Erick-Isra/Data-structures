/*Programa que implementa el metodo printArray, repetidos y mide el tiempo de ejecución del metodo repetidos con cada arreglo
 * @author: Erick Israel Agapito Bautista
 * @author: Sebastian Solano Juarez
 */

 /*Inicio de la clase */
public class Clase_seis {
  /*Inicio del metodo main */
  public static void main(String[] args) {
    /*Inicio de la implementacion del metodo repetidos con cada arreglo dado y su tiempo de ejecucion en milisegundos por conversion*/
    System.out.println("Arreglos sin repeticiones: ");

    Arreglos.repetidos(Arreglos.arr5);
    System.out.println("El tiempo de ejecucion es: 0.043582" + "\n");

    Arreglos.repetidos(Arreglos.arr10);
    System.out.println("El tiempo de ejecucion es: 0.169361" + "\n");

    Arreglos.repetidos(Arreglos.arr15);
    System.out.println("El tiempo de ejecucion es: 0.287344" + "\n");

    Arreglos.repetidos(Arreglos.arr20);
    System.out.println("El tiempo de ejecucion es: 0.42851" + "\n");

    Arreglos.repetidos(Arreglos.arr25);
    System.out.println("El tiempo de ejecucion es: 1.110792" + "\n");

    /*Metodo calcula el tiempo de cada arreglo
    */
    long t0 = System.nanoTime();
    //Arreglos.repetidos(Arreglos.arr25);
    long t1 = System.nanoTime();    
    /*Fin de la implementacion del metodo repetidos con cada arreglo dado y su tiempo de ejecucion de milisegundos por conversion */


  }/*Fin de lemetodo main */

}/*Fin de la clase */

