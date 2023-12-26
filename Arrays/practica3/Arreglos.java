/**
 * En esta clase se definen los arreglos que se usaran asi 
 * @author: Erick Israel Agapito Bautista
 * @author: Sebastian Solano Juarez 
 */

/*Inicio de la clase*/
public class Arreglos {
  static public int[] arr5 = { -1, 3, 3, 3, 3 };
  static public int[] arr10 = { 2, 7, 7, 8, 8, 11, 11, 16, 16, 18 };
  static public int[] arr15 = { 2, 2, 3, 5, 5, 7, 9, 9, 10, 10, 12, 12, 14, 17, 17 };
  static public int[] arr20 = { 0, 0, 0, 0, 0, 1, 2, 3, 3, 3, 5, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10 };
  static public int[] arr25 = { 1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 9, 9, 10, 10, 11, 11, 12,
      13, 14, 15, 16, 17, 18, 19, 20, 20, 21, 21, 21, 21, 21, 23, 23, 23, 23, 23, 24, 25 };

  /**
   * Imprime un arreglo
   * 
   * @param arr el arreglo a imprimir
   */
  /*Inicio metodo printArray*/
  public static void printArray(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length - 1; i++)
      System.out.printf("%d,", arr[i]);
    System.out.printf("%d]\n", arr[arr.length - 1]);
  }/*Cierre metodo printArray*/
    /**

     * Metodo que elimina los numeros repetidos de un arreglo
     * @param arr un arreglo de enteros ordenado de forma creciente 
     * @return nuevo que es un arreglo con los numeros repetidos eliminados
     */
  /* Inicio metodo repetidos*/
  public static void repetidos(int [] arr){
    int contador = 0;
    for(int i = 0; i < arr.length; i ++){    
      if(i == 0){        
        contador++;        
      }else if(arr[i-1] != arr[i]){
        contador++;
      }
    }    
    int [] nuevo = new int[contador];
    int indice = 0;
    for(int i = 0; i < arr.length; i ++){
      if(i == 0){        
        nuevo[indice] = arr[i];  
        indice ++;      
      }else if(arr[i-1] != arr[i]){        
        nuevo[indice] = arr[i];
        indice++;
      }
    }
    
    printArray(nuevo);
  }/*Cierre metodo repetidos*/
}/*Cierre clase*/