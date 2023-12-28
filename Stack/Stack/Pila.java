/**
 * Implementación de la EDD Pila.
 * @param <T> - El tipo de elementos de la Pila.
 */
public class Pila<T> {

    /*
    * Unidades básicas de una pila.
    */
    private class NodoPila {
        /* Parámetros */
        public T elemento;
        public NodoPila siguiente;

        /* Métodos */
        /**
         * Construye un NodoPila a partir de un elemento dado.
         * @param elemento - El elemento que contendrá este NodoPila.
         */
        public NodoPila( T elemento ) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }

    /* Parámetros */
    private NodoPila cima;
    private int longitud;

    /* Métodos */
    /**
     * Crea la Pila vacía.
     */
    public Pila() {
      this.cima = null;
      this.longitud = 0;
    }

    /**
     * Apila un nuevo elemento en esta Pila.
     * @param elemento - El elemento a apilar.
     */
    public void apilar( T elemento ) {
      NodoPila nuevo = new NodoPila(elemento);

      if(longitud == 0){
        cima = nuevo;
        longitud++;
      }else{
        nuevo.siguiente = cima;
        cima = nuevo;
        longitud++;
      }
    }

    /**
     * Desapila el elemento de la cima de esta Pila.
     * @throws Exception - Si esta Pila es vacía.
     */
    public void desapilar() throws Exception {
      if(longitud == 0){
        System.out.println("La pila es vacia");
      }else{
        NodoPila actual = cima;
        cima = cima.siguiente;
        actual.siguiente = null;
        actual = null;
        longitud --;
      }
    }

    /**
     * Devuelve el elemento contenido en la cima de esta Pila.
     * @return La cima de esta Pila.
     * @throws Exception - Si esta Pila es vacía.
     */
    
    public T darElementoCima() throws Exception {
       if(longitud == 0){
        return null;
      }else{
        return cima.elemento;
      }
    }

    /**
     * Determina si esta Pila es vacía.
     * @return true si esta Pila es vacía. En caso contrario, false.
     */
    public boolean esVacia() {
      if(longitud == 0){
        return true;
      }else{
        return false;
      }
    }

    /**
     * Devuelve el número de elementos de esta Pila.
     * @return El número de elementos de esta Pila.
     */
    public int darLongitud(){
      return this.longitud;
    }
}
