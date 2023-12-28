import java.util.Iterator;

/**
 * Implementación de una lista enlazada simple genérica.
 * @author: Agapito Bautista Erick Israel
 * @author: Solano Juarez Sebastian
 * @param <T> El tipo de elementos almacenados en la lista.
 */
public class ListaLigadaSimple<T> implements Coleccion<T> {

    private class Nodo {
        /**
         * Elemento almacenado en el nodo.
         */
        public T elemento;

        /**
         * Apuntador al siguiente nodo en la lista.
         */
        public Nodo siguiente;

        /**
         * Crea un nuevo nodo con el elemento proporcionado.
         *
         * @param elemento El elemento a almacenar en el nodo.
         */
        public Nodo(T elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }

        /**
         * Devuelve el elemento del nodo.
         *
         */
        public T darElemento(){
          return this.elemento;
        }

        /**
         * Devuelve el siguiente del nodo.
         *
         */
        public Nodo darSiguiente(){
          return this.siguiente;
        }

        /**
         * Modifica el elemento del nodo.
         *
         * @param elemento El elemento a almacenar en el nodo.
         */
        public void modificaElemeto(T elem){
          this.elemento = elem;
        }

        /**
         * Modifica el elemento del nodo.
         *
         * @param sig nodo a cambiar.
         */
        public void modificaSiguiente(Nodo sig){
          this.siguiente = sig;
        }
    }

    /**
    * Un iterador para recorrer la lista enlazada simple.
    */
    private class IteradorListaSimple implements Iterator<T> {

        /**
         * El nodo siguiente al que se moverá el iterador.
         */
        private Nodo iteradorLista;

        /**
         * Crea un nuevo iterador y lo inicializa en el primer nodo de la lista.
         */
        public IteradorListaSimple() {
            iteradorLista = new Nodo(null);
            iteradorLista.siguiente = cabeza;
        }

        /**
         * Verifica si hay un siguiente elemento en la lista.
         *
         * @return true si hay un siguiente elemento, false de lo contrario.
         */
        public boolean hasNext() {
            return iteradorLista.siguiente != null;
        }

        /**
         * Obtiene el siguiente elemento en la lista y mueve el iterador al siguiente nodo.
         *
         * @return El siguiente elemento en la lista.
         */
        public T next() {
            iteradorLista = iteradorLista.siguiente;
            return iteradorLista.elemento;
        }
    }

   /** Atributos del objeto Nodo**/
    private Nodo cabeza;

    private Nodo rabo;

    private int longitud;
    
    /**Constructor de la Lista Ligada Simple**/
    public ListaLigadaSimple(){
      this.cabeza = null;
      this.rabo = null;
      this.longitud = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple();
    }

    /**
     * Método que inserta un elemento en la colección.
     * @param elemento
     */
    @Override
    public void insertar(T elemento) throws IllegalArgumentException {
      if(longitud == 0){
        Nodo nuevo = new Nodo(elemento);
        cabeza = nuevo;
        rabo = nuevo;
        longitud++;

      }else{
        Nodo nuevito = new Nodo(elemento);
        nuevito.siguiente = cabeza;
        cabeza = nuevito;
        longitud++;
      }
    }

    /**
     * Método que accede a un elemento de la colección.
     * @param indice
     * @return T elemento de la colección.
     */
    
    public T acceder(int i) throws IllegalArgumentException {
      int indice = 0;

      if(longitud == 0){
        return null; 
      }else if(i<0 || i > longitud){
        return null;
      }else{
        Nodo refe_1 = cabeza;
        Nodo refe_2 = cabeza.siguiente;

        while(indice< i-1){
          refe_1 = refe_2;
          refe_2 = refe_1.siguiente;
          indice++;
        }
        return refe_2.darElemento();
      }
    }

    /**
     * Método que busca un elemento en la colección.
     * @param elemento
     * @return Boolean que indica si se ha encontrado el elemento.
     */
    @Override
    public boolean buscar(T elemento) {
      if(longitud == 0){
        return false;

      }else{
        Nodo refe_1 = cabeza;
        Nodo refe_2 = cabeza.siguiente;

        while(refe_2!= null){
          if(refe_1.darElemento() == elemento){
            return true;
          }else{
            refe_1 = refe_2;
            refe_2 = refe_1.siguiente;
          }
        } return false;
      } 
    }

    /**
     * Método que elimina un elemento de la colección.
     * @param indice
     * @return Boolean que indica si se ha eliminado el elemento.
     */
    @Override
    public void eliminar(int i) {
      if(longitud == 0){
        System.out.println("Lista vacia");
      }else{
        if(!(0<=i) || !(i<= longitud-1)){
          System.out.println("Indice Invalido");
        }else{
          if(longitud == 1){
            cabeza = null;
            rabo = null;
            longitud--;
          }else{
            if(i == 0){
              Nodo actual = darCabeza();
              cabeza = actual.siguiente;
              actual.modificaSiguiente(null);
              actual = null;
              longitud--;
            } 
            if(i == longitud-1){
              Nodo anterior = null;
              Nodo actual = cabeza;
              while (actual != rabo) {
                anterior = actual;
                actual = actual.darSiguiente();
              }
              anterior.modificaSiguiente(null);
              rabo = anterior;
              actual = null;
              longitud--;
            } else if (0 < i && i < longitud - 1) {
              int j = 0;
              Nodo anterior = null;
              Nodo actual = cabeza;
              while (j != i) {
                anterior = actual;
                actual = actual.darSiguiente();
                j++;
              }
              anterior.modificaSiguiente(actual.darSiguiente());
              actual.modificaSiguiente(null);
              actual = null;
              longitud--;
            }
          }
        }
      }
    }
    /**
     * Método que da la longitud de la colección.
     * @return Int que indica la cantidad de nodos en la lista
     */
    public int darLongitud() {
      
      if(longitud == 0){
        return 0;
      }else{
        Nodo n_1 = cabeza;
        Nodo n_2 = cabeza.siguiente;
        
        while(n_2 != null){
          n_1 = n_2;
          n_2 = n_1.siguiente;
          longitud++;
        }
      }
      return longitud;
    }

    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return El primer nodo de la lista.
     */
    public Nodo darCabeza() {
        return this.cabeza;
    }

    /**
     * Obtiene el elemento almacenado en el primer nodo de la lista.
     *
     * @return El elemento almacenado en el primer nodo de la lista.
     */
    public T darCabezaElemento() {
        return this.cabeza.elemento;
    }

    /**
     * Obtiene el último nodo de la lista.
     *
     * @return El último nodo de la lista.
     */
    public Nodo getRabo() {
        return this.rabo;
    }

    /**
     * Obtiene el elemento almacenado en el último nodo de la lista.
     *
     * @return El elemento almacenado en el último nodo de la lista.
     */
    public T getRaboElemento() {
        return this.rabo.elemento;
    }
}
