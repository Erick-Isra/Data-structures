/**
 * Implementación de la EDD Cola.
 * @author Agapito Bautista Erick Israel
 * @author Solano Juarez Sebastian
 * @param <T> - El tipo de elementos de la Cola.
 */
public class Cola<T> {
    
    /*
    * Unidades básicas de una Cola.
    */
    private class NodoCola {
        /* Parámetros */
        public T elemento;
        public NodoCola siguiente;
    
        /* Métodos */
        /**
         * Construye un NodoCola a partir de un elemento dado.
         * @param elemento - El elemento que contendrá este NodoCola.
         */
        public NodoCola( T elemento ) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }
    
    /* Parámetros */
    private NodoCola inicio;
    private NodoCola fin;
    private int longitud;
    
    /* Métodos */
    /**
     * Crea la Cola vacía.
     */
    public Cola() {
        this.inicio = null;
        this.fin = null;
        this.longitud = 0;
    }
    
    /**
     * Encola un nuevo elemento en esta Cola.
     * @param elemento - El elemento a encolar.
     */
    public void encolar( T elemento ) {

        NodoCola nuevo = new NodoCola(elemento);

        if(longitud == 0){
            inicio = nuevo;
            fin = nuevo;
            longitud++;
        }else{
            fin.siguiente = nuevo;
            fin = nuevo;
            longitud++;
        }
    }
    
    /**
     * Desencola el elemento del inicio de esta Cola.
     * @throws Exception - Si esta Cola es vacía.
     */
    public void desencolar() throws Exception {

        if(longitud == 0){
            System.out.println("La cola es vacia");
        }else{
            if(longitud == 1){
                fin = null;
                inicio = null;
                longitud = 0; 
            }else{
                NodoCola actual = inicio;
                inicio = inicio.siguiente;
                actual.siguiente = null;
                actual = null;
                longitud --;
            }
                    
        }
    }
    
    /**
     * Devuelve el elemento contenido en el inicio de esta Cola.
     * @return El inicio de esta Cola.
     * @throws Exception - Si esta Cola es vacía.
     */
    public T darElementoInicio() throws Exception {
        
        if(longitud == 0){
            throw new Exception("La lista es vacia");
        }else{
            return inicio.elemento;
        }  
    }
    
    /**
     * Determina si esta Cola es vacía.
     * @return true si esta Cola es vacía. En caso contrario, false.
     */
    public boolean esVacia() {
        if (longitud == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Devuelve el número de elementos de esta Cola.
     * @return El número de elementos de esta Cola.
     */
    public int darLongitud(){
        return longitud;
    } 
}
