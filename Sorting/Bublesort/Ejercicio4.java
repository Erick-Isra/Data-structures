
public class Ejercicio4 {
    public static void ordenaBurbuja(int ArrayN[]) {
        
        for (int i = 0; i < ArrayN.length - 1; i++) {
            
            for (int j = 0; j < ArrayN.length - 1; j++) { 
                if (ArrayN[j] > ArrayN[j + 1]) {
                    
                    int temp = ArrayN[j + 1];
                    
                    ArrayN[j + 1] = ArrayN[j];
                    ArrayN[j] = temp;                   
                }
            }
        }
    }
    
    public static int mediana(int[] arrA, int[] arrB) {
        int indiceUnion = 0;
        int[] concatenacion =  new int[arrA.length * 2];
    
        for (indiceUnion = 0; indiceUnion < arrA.length; indiceUnion++) {
            concatenacion[indiceUnion ] = arrA[indiceUnion];
        }    
        for (int j = 0; j < arrB.length; j++) {
            concatenacion[indiceUnion ] = arrB[j];
            indiceUnion  = indiceUnion + 1;
        }
        
        ordenaBurbuja(concatenacion);          
        int mediana = concatenacion[concatenacion.length/2];        
        
        System.out.println(mediana);
        return 0;
        
    }
    


    public static void main(String[] args) {    

        int [] arreglo1 = {3,8,-4};
        int [] arreglo2 = {7,3,0};
        
        mediana(arreglo1,arreglo2);    
    }
}
