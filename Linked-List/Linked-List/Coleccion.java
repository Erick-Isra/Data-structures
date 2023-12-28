/**
 * Interfaz Coleccion
 *
 * Interfaz que define los métodos que debe implementar una colección
 * genérica.
 * @author: Agapito Bautista Erick Israel
 * @author: Solano Juarez Sebastian
 */
public interface Coleccion<T> extends Iterable<T>{

    /**
     * Método que inserta un elemento en la colección.
     * @param elemento
     */
    public void insertar(T elemento);

    /**
     * Método que elimina un elemento de la colección.
     * @param indice
     * @return Boolean que indica si se ha eliminado el elemento.
     */
    public void eliminar(int indice);

    /**
     * Método que accede a un elemento de la colección.
     * @param indice
     * @return T elemento de la colección.
     */
    public T acceder(int indice);

    /**
     * Método que busca un elemento en la colección.
     * @param elemento
     * @return Boolean que indica si se ha encontrado el elemento.
     */
    public boolean buscar(T elemento);

}
