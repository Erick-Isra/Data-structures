/*Programa que implementa los metodos de BusquedaBinaria y BusquedaSecuencial, tambien mide el tiempo de busqueda para cada arreglo 
 * @author: Erick Israel Agapito Bautista
 * @author: Sebastian Solano Juarez
 */
/*Inicio clase*/
public class Practica5{

  //Arreglos para probar los metodos
  int[] a1 = {3,7,12,16,29};
  int[] a2 = {1,6,7,9,12,14,18,19,20,22};
  int[] a3 = {0,2,4,5,7,9,11,12,13,15,16,17,18,22,27};
  int[] a4 = {2,3,4,6,7,8,11,12,13,14,15,17,18,20,21,22,24,25,27,28};
  int[] a5 = {0,1,2,4,5,6,8,9,11,13,14,16,17,18,19,21,22,24,25,27,28,29,29,30,35};
  int[] a6 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
  int[] a7 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,31,33};
  int[] a8 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,30,30,30,30,30,31,32};
  int[] a9 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,42,42,43,44,45};
  int[] a10 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,45,47,50,51,60,72};
  /**

    * Método que implementa BusquedaSecuencial 
    * @param array donde array es un arreglo finito de enteros
    * @param x x es el entero que se buscara en array
    * @return el primer indice i donde esta el elemento x

  */
  /*Inicio metodo BusquedaSecuencial*/ 
  public static int BusquedaSecuencial(int[] array, int x){    
    for(int i = 0; i<array.length;i++){
      if(array[i] == x){
        return i;
      }
    }
    return -1;
  }/*Cierre metodo BusquedaSecuencial*/ 
  /**

    * Método que implementa BusquedaBinaria
    * @param a donde a es una arreglo finito de enteros, ordenado de forma creciente
    * @param x x es un entero que se buscara en a
    * @param s s es el primer indice del arreglo a
    * @param t t es el ultimo indice del arreglo a
    * @param n n es el largo del arreglo  
    * @return el indice i donde esta el elemento x

  */
 /*Inicio metodo BusquedaBinaria*/
  public static int BusquedaBinaria(int [] a, int x, int s, int t, int n){
    if(n < 2){
      if (x == a[s]){
        return s;
      }else{
        return -1;
      }
    } else {

      int mid = ((s + t)/2);
      
      if (x <= a[mid]){
        return BusquedaBinaria(a, x, s, mid, mid-s+1);
      }else{
        return BusquedaBinaria(a, x, mid + 1, t, t-mid);
      }
    }
  }/*Cierre metodo BusquedaBinaria*/
  /*Inicio metodo main */
  public static void main(String[] args){
    int[] a1 = {3,7,12,16,29};
    int[] a2 = {1,6,7,9,12,14,18,19,20,22};
    int[] a3 = {0,2,4,5,7,9,11,12,13,15,16,17,18,22,27};
    int[] a4 = {2,3,4,6,7,8,11,12,13,14,15,17,18,20,21,22,24,25,27,28};
    int[] a5 = {0,1,2,4,5,6,8,9,11,13,14,16,17,18,19,21,22,24,25,27,28,29,29,30,35};
    int[] a6 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
    int[] a7 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,31,33};
    int[] a8 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,30,30,30,30,30,31,32};
    int[] a9 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,42,42,43,44,45};
    int[] a10 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,45,47,50,51,60,72};
    //Busquedas:
    //Prueba con el primer arreglo 
    System.out.println("Primer arreglo es: {3,7,12,16,29}" );
    long t0 = System.nanoTime(); 
    System.out.println("Con Busqueda Secuencial se busca el entero 7, que nos retoran el indice: "+BusquedaSecuencial(a1, 7));
    long t_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 29, que nos retorna  el indice: " +BusquedaBinaria(a1, 29, 0, 4, 5));
    long t_2 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 12.61 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 29.46  milisegundos" + "en Busqueda Binaria" + "\n");

    //Prueba con el segundo arreglo
    System.out.println("Segundo arreglo es: {1,6,7,9,12,14,18,19,20,22}" );
    long t_0_2 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 20, que nos retoran el indice: "+BusquedaSecuencial(a2, 20));
    long t_0_3 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 12, que nos retorna  el indice: " +BusquedaBinaria(a2, 12, 0, 9, 10) + "\n");
    long t_0_4 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 0.145 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.7928  milisegundos" + "en Busqueda Binaria" + "\n");
    
    
    //Prueba con el tercer arreglo
    System.out.println("Tercer arreglo es: {0,2,4,5,7,9,11,12,13,15,16,17,18,22,27}" );
    long t_3 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 15, que nos retoran el indice: "+BusquedaSecuencial(a3, 15));
    long t_3_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 19, que nos retorna  el indice: " +BusquedaBinaria(a3, 19, 0, 14, 15) + "\n");
    long t_3_2 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 0.1588 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.2721  milisegundos" + "en Busqueda Binaria" + "\n");


    //Prueba con el cuarto arreglo
    System.out.println("Cuarto arreglo es: {2,3,4,6,7,8,11,12,13,14,15,17,18,20,21,22,24,25,27,28}" );
    long t_4 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 9, que nos retoran el indice: "+BusquedaSecuencial(a4, 9));
    long t_4_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 13, que nos retorna  el indice: " +BusquedaBinaria(a4, 13, 0, 19, 20) + "\n");
    long t_4_2 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 0.1686 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.334602  milisegundos" + "en Busqueda Binaria" + "\n");

    //Prueba con el quinto arreglo
    System.out.println("Quinto arreglo es: {0,1,2,4,5,6,8,9,11,13,14,16,17,18,19,21,22,24,25,27,28,29,29,30,35}" );
    long t_5 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 16, que nos retoran el indice: "+BusquedaSecuencial(a5, 16));
    long t_5_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 2, que nos retorna  el indice: " +BusquedaBinaria(a5, 2, 0, 24, 25) + "\n");
    long t_5_2 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 0.10519 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.235568  milisegundos" + "en Busqueda Binaria" + "\n");


    //Prueba con el sexto arreglo 
    System.out.println("Sexto arreglo es: {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29}" );
    long t_6 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 28, que nos retoran el indice: "+BusquedaSecuencial(a6, 28));
    long t_6_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 10, que nos retorna  el indice: " +BusquedaBinaria(a6, 10, 0, 29, 30) + "\n");
    long t_6_2 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 0.105339 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.245676  milisegundos" + "en Busqueda Binaria" + "\n");


    //Prueba con el septimo arreglo 
    System.out.println("Septimo arreglo es: {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,31,33}" );
    long t_7 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 18, que nos retoran el indice: "+BusquedaSecuencial(a7, 18));
    long t_7_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 22, que nos retorna  el indice: " +BusquedaBinaria(a7, 22, 0, 34, 35) + "\n");
    long t_7_2 = System.nanoTime();


    System.out.println("El tiempo con conversion es: 0.178509 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.386513  milisegundos" + "en Busqueda Binaria" + "\n");


    //Prueba con el octavo arreglo
    System.out.println("Octavo arreglo es: {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,30,30,30,30,30,30,31,32}" );
    long t_8 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 30, que nos retoran el indice: "+BusquedaSecuencial(a8, 30));
    long t_8_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 3, que nos retorna  el indice: " +BusquedaBinaria(a8, 3, 0, 39, 40) + "\n");
    long t_8_2 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 0.110079 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.230948  milisegundos" + "en Busqueda Binaria" + "\n");

    //Prueba con el noveno arreglo
    System.out.println("Noveno arreglo es: {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,42,42,43,44,45}" );
    long t_9 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 40, que nos retoran el indice: "+BusquedaSecuencial(a9, 40));
    long t_9_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 3, que nos retorna  el indice: " +BusquedaBinaria(a9, 3, 0, 44, 45) + "\n");
    long t_9_2 = System.nanoTime();

    System.out.println("El tiempo con conversion es: 0.348821 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.734071 milisegundos" + "en Busqueda Binaria" + "\n");


    //Prueba con el decimo arreglo 
    System.out.println("Decimo arreglo es: {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,45,47,50,51,60,72}" );
    long t_10 = System.nanoTime();
    System.out.println("Con Busqueda Secuencial se busca el entero 9, que nos retoran el indice: "+BusquedaSecuencial(a10, 9));
    long t_10_1 = System.nanoTime();
    System.out.println("Con Busqueda Binaria se busca el entero 36, que nos retorna  el indice: " +BusquedaBinaria(a9, 36, 0, 49, 50) + "\n");
    long t_10_2 = System.nanoTime();


    System.out.println("El tiempo con conversion es: 0.155414 milisegundos" + "en Busqueda Secuencial");
    System.out.println("El tiempo con conversion es: 0.272616 milisegundos" + "en Busqueda Binaria" + "\n");

    
    
      
  }/*Fin metodo main*/
}/*Fin de la clase*/
