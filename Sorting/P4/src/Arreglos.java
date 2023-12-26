
public class Arreglos {
  static public int[] a5 = { 17, 86, 88, 91, 95 };
  static public int[] a10 = { 3, 8, 23, 30, 49, 51, 57, 66, 67, 90 };
  static public int[] a15 = { 8, 21, 26, 32, 42, 43, 60, 63, 66, 74, 78, 88, 91, 94, 94 };
  static public int[] a20 = { 1, 2, 6, 7, 9, 11, 13, 14, 19, 26, 29, 33, 47, 57, 70, 75, 83, 89, 94, 99 };
  static public int[] a25 = { 1, 3, 7, 14, 15, 17, 29, 29, 38, 40, 48, 49, 53, 55, 57, 63, 64, 71, 74, 77, 80, 82, 85,
      88, 90 };

  static public int[] b5 = { 16, 33, 48, 64, 71 };
  static public int[] b10 = { 7, 27, 31, 49, 51, 56, 57, 60, 67, 81 };
  static public int[] b15 = { 8, 8, 9, 21, 28, 28, 29, 38, 41, 61, 63, 69, 90, 94, 98 };
  static public int[] b20 = { 1, 9, 15, 18, 26, 33, 34, 37, 42, 45, 47, 48, 54, 57, 64, 72, 73, 79, 80, 98 };
  static public int[] b25 = { 11, 13, 14, 16, 18, 24, 44, 44, 45, 47, 52, 56, 64, 66, 69, 74, 76, 77, 81, 83, 90, 91,
      96, 97, 100 };

  /**
   * Imprime un ar re glo
   *
   * @param arr el arreglo a imprimir
   */
  public static void printArray(int[] arr) {
    if (arr.length == 0){
      System.out.println("[]");
    }
    System.out.print("[");
    for (int i = 0; i < arr.length - 1; i++){
      System.out.printf("%d,", arr[i]);
    }
    System.out.printf("%d]\n", arr[arr.length - 1]);
  }
  public static void reOrdenar(int[] arrA, int[] arrB){    
    int[] ArregloFinal = new int[arrA.length+arrB.length];
    int indiceA = 0;
    int indiceB = 0; 
    int indiceFinal = 0;
    while(indiceA <arrA.length && indiceB < arrB.length){
      if(arrA[indiceA]<arrB[indiceB]){
        ArregloFinal[indiceFinal] = arrA[indiceA];
        indiceFinal ++;
        indiceA ++;
      }else{
        ArregloFinal[indiceFinal] = arrB[indiceB];
        indiceFinal ++;
        indiceB ++;
      }   

  }
  for(int i=indiceFinal;i<ArregloFinal.length;i++){
    if(indiceA == arrA.length){
      ArregloFinal[i] = arrB[indiceB];
      indiceB++;

    }else{
      ArregloFinal[i] = arrA[indiceA];
      indiceA++;

    }
  } 
 
  printArray(ArregloFinal);  
   

  
  
}
 
  
   

  
  
}

