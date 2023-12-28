import java.util.LinkedList;

/** Programa que crea una grafica con las clases Grafica, Arista y Vertice junto con sus metodos correspondientes
 * @author Agapito Bautista Erick Israel
 * @author Solano Juarez Sebastian
 */

/*Inicio de la clase Grafica */
public class Grafica<T> {

    /*Inicio de la clase Vertice */ 
    public class Vertice {
        public String identificador;
        public T elemento;
        public boolean visitado;

        /*Metodo constructor de la clase Vertice */
        public Vertice( String identificador, T elemento ) {
            this.identificador = identificador;
            this.elemento = elemento;
        }

        /*Inicio de los metodos set, get y toString de la clase Vertice*/
        public String darIdentificador() {
            return this.identificador;
        }

        public T darElemento() {
            return this.elemento;
        }

        public boolean darVisitado() {
            return this.visitado;
        }

        public void modificarIdentificador( String nuevoIdentificador ) {
            this.identificador = nuevoIdentificador;
        }

        public void modificarElemento( T nuevoElemento ) {
            this.elemento = nuevoElemento;
        }

        public void modificarVisitado( boolean nuevoVisitado ) {
            this.visitado = nuevoVisitado;
        }

        public String toString() {
            return "<" +
                    this.identificador +
                    ", " +
                    this.elemento.toString() +
                    ", " +
                    Boolean.toString( this.visitado ) +
                    ">";
        } /*Fin de los metodos de la clase vertice */
    } /*Fin de la clase vertice */

    /*Inicio de la clase Arista */
    public class Arista {
        public String u;
        public String v;

        /*Metodo Constructor de la clase Arista */
        public Arista( String u, String v ) {
            this.u = u;
            this.v = v;
        }

        /*Inicio de los metodos set, get y toString de la clase Arista */
        public String darU() {
            return this.u;
        }

        public String darV() {
            return this.v;
        }

        public void modificarU ( String nuevoU ) {
            this.u = u;
        }

        public void modificarV ( String nuevoV ) {
            this.v = v;
        }

        public String toString() {
            return this.u + this.v;
        } /*Fin de los metodos de la clase Arista */
    } /*Fin de la clase arista */

    /*Parametros de la clase Grafica */
    private LinkedList<Vertice> vertices;
    private LinkedList<Arista> aristas;
    private int orden;
    private int tamano;

    /*Metodo constructor de la clase Grafica */
    public Grafica() {
        this.vertices = new LinkedList<Vertice>();
        this.aristas = new LinkedList<Arista>();
        this.orden = 0;
        this.tamano = 0;
    }

    /*Inicio de los metodos de la clase Grafica */

    /*Metodo que busca si un vertice se encuentra en la grafica
     * @param identificador - define el identificador del vertice a encontrar
     * @return true si el vertice se encuentra en la grafica
     */
    public boolean buscarVertice( String identificador ) {
        boolean encontrado = false;
        for( Vertice v : this.vertices ) {
            if( v.darIdentificador().equals( identificador ) ) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /*Metodo que busca si una arista pertenece a la grafica
     * @param u,v - definen los identificadores a los que la arista a buscar se encuentra asociada en sus extremos
     * @return true si la arista pertenece a la grafica
     */
    public boolean buscarArista( String u, String v ) {
        boolean encontrada = false;
        for( Arista e : this.aristas ) {
            if( ( e.darU().equals( u ) && e.darV().equals( v ) ) || ( e.darU().equals( v ) && e.darV().equals( u ) ) ) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }

    /*Metodo que inserta un nuevo vertice en la grafica
     * @param identificador,elemento son los elementos que conforman al nuevo vertice que se está por ingresar 
     */
    public void insertarVertice( String identificador, T elemento ) throws Exception {
        if( this.buscarVertice( identificador ) ) {
            throw new Exception( "El vertice ya existe." );
        }
        else {
            Vertice nuevoVertice = new Vertice( identificador, elemento );
            this.vertices.add( nuevoVertice );
            this.orden++;
        }
    }

    /*Metodo que inserta una nueva arista en la grafica
     * @param u,v son los extremos que conforman a la nueva arista que se está por ingresar 
     */
    public void insertarArista( String u, String v ) throws Exception {
        if( this.buscarArista( u, v ) ) {
            throw new Exception( "La arista ya existe." );
        }
        else {
            if( !this.buscarVertice( u ) || !this.buscarVertice( v ) ) {
                throw new Exception( "Uno de los vertices indicados no existe." );
            }
            else {
                Arista nuevaArista = new Arista( u, v );
                this.aristas.add( nuevaArista );
                this.tamano++;
            }
        }
    }
    /*Metodos get de la clase Grafica */
    public LinkedList<Vertice> darVertices() {
        return this.vertices;
    }

    public LinkedList<Arista> darAristas() {
        return this.aristas;
    }

    public int darOrden() {
        return this.orden;
    }

    public int darTamano() {
        return this.tamano;
    }

    /**
    * Metodo que se encarga eliminar un vertice junto con todas las aristas que la tengan como un extremo, si es que el vertice existe 
    * @param identificador Este parametro es el identificador del vertice a remover junto con sus aristas
    */
    public void eliminarVertice(String identificador) throws Exception {
    if (!buscarVertice(identificador)) {
        throw new Exception("El vértice no existe.");
    } else {
        Vertice verticeEliminar = null;
        for (Vertice v : this.vertices) {
            if (v.darIdentificador().equals(identificador)) {
                verticeEliminar = v;
                break;
            }
        }
        LinkedList<Arista> aristasAEliminar = new LinkedList<Arista>();
        for (Arista e : this.aristas) {
            if (e.darU().equals(identificador) || e.darV().equals(identificador)) {
                aristasAEliminar.add(e);
            }
        }
        this.vertices.remove(verticeEliminar);
        this.orden--;
        for (Arista e : aristasAEliminar) {
            this.aristas.remove(e);
            this.tamano--;
        }
    }
}

    /**
    * Metodo que se encarga de eliminar una arista si es que esta existe
    * @param u Este parametro es el identificador del vertice de uno de los extremos de la arista
    * @param v Este parametro es el identificador de vertice de uno de los extremos de la arista
    */
    public void eliminarArista(String u, String v) throws Exception {
    Arista aristaAEliminar = null;
    for (Arista e : this.aristas) {
        if ((e.darU().equals(u) && e.darV().equals(v)) || (e.darU().equals(v) && e.darV().equals(u))) {
            aristaAEliminar = e;
            break;
        }
    }
    if (aristaAEliminar != null) {
        this.aristas.remove(aristaAEliminar);
        this.tamano--;
    } else {
        throw new Exception("La arista no existe.");
    }
    }


    /**
    * Metodo que devuelve una lista con los verciones de un vertice si es que este existe
    * @param identificador Este parametro es el identificador del vertice a buscar sus vecinos
    * @return LinkedLst Devuleve la lista de vecinos a un vertice 
    */
    public LinkedList<String> darVecindad(String identificador) throws Exception {
    if (!buscarVertice(identificador)) {
        throw new Exception("El vértice no existe.");
    } else {
        LinkedList<String> vecindad = new LinkedList<String>();
        for (Arista e : this.aristas) {
            if (e.darU().equals(identificador)) {
                vecindad.add(e.darV());
            } else if (e.darV().equals(identificador)) {
                vecindad.add(e.darU());
            }
        }
        return vecindad;
    }
    }

    /**
    * Metodo que se encarga de obtener el grado de un vertice si es que este existe
    * @param identificador Este parametro es el identificador del vertice 
    * @return grado Devuleve el grado del vertice en un numero entero 
    */
    public int darGrado(String identificador) throws Exception {
    if (!buscarVertice(identificador)) {
        throw new Exception("El vértice no existe.");
    } else {
        LinkedList<String> vecindad = darVecindad(identificador);
        return vecindad.size();
    }
}
    /**
    * Metodo que se encarga de buscar un vertice por su idenditifador y si este existe lo devuelve
    * @param identificador Este parametro es el identificador del vertice a buscar y devolver
    * @return Vertice Devuleve el vertice si es que existe el identifciador 
    */
    public Vertice darVertice(String identificador) throws Exception {
    if (!buscarVertice(identificador)) {
        throw new Exception("El vértice no existe.");
    } else {
        Vertice verticeEncontrado = null;
        for (Vertice v : this.vertices) {
            if (v.darIdentificador().equals(identificador)) {
                verticeEncontrado = v;
                break;
            }
        }
        return verticeEncontrado;
    }
} /*Fin de los metodos de la clase Grafica */
    
} /*FIn de la clase Grafica */