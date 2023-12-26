package Class;
import java.util.*;
public class Conjunto{

  int[] elementos;

  public Conjunto(int[] elementos2){
    if(elementos2.length == 0){
      this.elementos = elementos2;
    }else{
      List<Integer> listaSinRepetidos = new ArrayList<>();
      for(int x : elementos2){
        if(!listaSinRepetidos.contains(x)){
          listaSinRepetidos.add(x);
        }
      }
      List<Integer> listaSinNeg = new ArrayList<>();
      for(int z : listaSinRepetidos){
        if(z > 0){
          listaSinNeg.add(z);
        }
      }
      int[] elementosAux = new int[listaSinNeg.size()];
      int cont = 0;
      for(int y : listaSinNeg){
        elementosAux[cont] = y;
        cont++;
      }
      this.elementos = elementosAux;
    }
  }

  public boolean esVacio(){    
    return elementos.length == 0;
    
  }

 public boolean pertenencia(int x){ 
    boolean pert = false;   
    for(int i=0;i<elementos.length;i++){
      if(elementos[i] == x){
        pert = true;       
      }
    }
    return pert;
    
 }

  public boolean subConjunto(Conjunto c) { 
    boolean esub = true;  
    for(int i = 0; i<c.elementos.length;i++){   
      if(this.pertenencia(c.elementos[i]) != true){
       esub = false;
       return esub;       
      }    
    }
    return esub;
  }


  public Conjunto diferencia(Conjunto c) {
    int tamaño = 0;
    for (int i = 0; i < c.elementos.length; i++) {
        boolean encontrado = false;
        for (int j = 0; j < elementos.length; j++) {
            if (c.elementos[i] == elementos[j]) {
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            tamaño++;
        }
    }

    int[] diferenciaArreglo = new int[tamaño];
    int indicedif = 0;

    for (int i = 0; i < c.elementos.length; i++) {
        boolean encontrado = false;
        for (int j = 0; j < elementos.length; j++) {
            if (c.elementos[i] == elementos[j]) {
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            diferenciaArreglo[indicedif] = c.elementos[i];
            indicedif++;
        }
    }

    return new Conjunto(diferenciaArreglo);
  }
  
  

 public Conjunto union(Conjunto c){

    int [] unioncapacidad = new int[elementos.length + c.elementos.length];

    for(int i = 0; i < elementos.length; i++){
      unioncapacidad[i] = elementos[i];      
    }
    
    for(int j = 0; j < c.elementos.length; j++){
      unioncapacidad[elementos.length+j] = c.elementos[j];    
      
    }


    Conjunto unido = new Conjunto(unioncapacidad);
    return unido;
  }
public Conjunto interseccion(Conjunto c){
    int capacidad = 0;
    
    for(int i = 0; i < elementos.length; i ++){
      for(int j = 0; j < c.elementos.length; j ++){
        if(elementos[i]== c.elementos[j]){
          capacidad = capacidad +1;
        }
      }
    }


    int [] intercapacidad = new int[capacidad];

    for(int k = 0; k< elementos.length; k ++){
      for(int l = 0; l<c.elementos.length; l++){
        if(elementos[k]==c.elementos[l]){
          intercapacidad[k] = c.elementos[l];
        }
      }
    }
    Conjunto intersectado = new Conjunto(intercapacidad);

    return intersectado;
  }

  public String toString(){
    String s = "{";
    for(int i = 0; i < this.elementos.length; i++){
      if(i == 0){
        s = s + this.elementos[i];
      }else{
        s = s + "," + this.elementos[i];
      }
    }
    s = s + "}";
    return s;
  }


}
