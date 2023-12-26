import java.util.Scanner;   
import Class.Conjunto;

public class Main {
   public static void main(String[] args){ 
      int elements1[] = {1,2,3,4,5,6}; 
      int elements2[] = {1,2,3,4,5,6,7,8,9,10};
      int elements3[] = {10,11,12,24,7,8};
      int elements4[] = {22,30,45,60};
      
      Conjunto c1 = new Conjunto(elements1);
      Conjunto c2 = new Conjunto(elements2);
      Conjunto c3 = new Conjunto(elements3);
      Conjunto c4 = new Conjunto(elements4);
      // Es vacio
      System.out.println("Metodo esVacio que checa si el arreglo {1,2,3,4,5,6} es vacia\n" + c1.esVacio());
       System.out.println("Metodo esVacio que checa si el arreglo {1,2,3,4,5,6,7,8,9,10} es vacia\n" + c2.esVacio());
      //Pertenencia
      System.out.println("Metodo pertenencia que checa si 6 pertenece el arreglo {1,2,3,4,5,6}\n" + c1.pertenencia(6));
      System.out.println("Metodo pertenencia que checa si 2 pertenece el arreglo {1,2,3,4,5,6}\n" + c1.pertenencia(2));
      System.out.println("Metodo pertenencia que checa si 50 pertenece el arreglo {1,2,3,4,5,6}\n" + c1.pertenencia(50));
      //Union
      System.out.println("Metodo union que une dos arreglo {1,2,3,4,5,6} y {1,2,3,4,5,6,7,8,9,10} \n" + c1.union(c2));
      System.out.println("Metodo union que une dos arreglo {10,11,12,24,7,8} y {22,30,45,60} \n" + c3.union(c4));
      //Diferencia 
      System.out.println("Metodo dieferencia que saca la diferencia de {1,2,3,4,5,6} y {1,2,3,4,5,6,7,8,9,10} \n" + c2.diferencia(c1));
      System.out.println("Metodo dieferencia que saca la diferencia de {1,2,3,4,5,6} y {1,2,3,4,5,6,7,8,9,10} \n" + c1.diferencia(c2));
      //Interseccion
      System.out.println("Metodo interseccion  que regresa la interseccion del arreglo {1,2,3,4,5,6} y {1,2,3,4,5,6,7,8,9,10} \n" + c1.interseccion(c2));
      System.out.println("Metodo interseccion  que regresa la interseccion del arreglo {10,11,12,24,7,8} y {22,30,45,60} \n" + c3.interseccion(c4));
      //Subconjunto 
      System.out.println("Metodo subconjunto que checa si el arreglo {1,2,3,4,5,6,7,8,9,10} es subconjunto de {1,2,3,4,5,6}\n" + c1.subConjunto(c2));
      System.out.println("Metodo subconjunto que checa si el arreglo{ 10,11,12,24,7,8} es subconjunto de {22,30,45,60}\n" + c2.subConjunto(c4));
      System.out.println("Metodo subconjunto que checa si el arreglo {1,2,3,4,5,6} es subconjunto de {1,2,3,4,5,6,7,8,9,10}\n" + c2.subConjunto(c1));

   



    
    
   }
}