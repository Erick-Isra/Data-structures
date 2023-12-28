import java.util.LinkedList;
/**
 * Implementación de Grafica y el algoritmo BFS
 * @author Agapito Bautista Erick Israel
 * @author Solano Juárez Sebastian
 */
public class Grafica<T> {
    /**Inicio de la clase vertice */
    public class Vertice {
        public String identificador;
        public T elemento;
        public boolean visitado;
        public boolean pendiente;
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

        public boolean darPendiente(){
            return this.pendiente;
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
        
        public void modificarPendiente (boolean nuevoPendiente){
            this.pendiente = nuevoPendiente;
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
    
    /**Inicio de la clase Arista */
    public class Arista {
        public String u;
        public String v;
        /*Constructor de arista */
        public Arista( String u, String v ) {
            this.u = u;
            this.v = v;
        }
        /*Inicio de los metodos set, get y toString de la clase Vertice*/
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

    /**Metodo que busca si un vertice se encuentra en la grafica
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
    /**Metodo que inserta un nuevo vertice en la grafica
     * @param identificador,elemento son los elementos que conforman al nuevo vertice que se está por ingresar 
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
    /**Metodo que inserta un nuevo vertice en la grafica
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
    /**Metodo que inserta una nueva arista en la grafica
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
    /**
    * Metodo que se encarga eliminar un vertice junto con todas las aristas que la tengan como un extremo, si es que el vertice existe 
    * @param identificador Este parametro es el identificador del vertice a remover junto con sus aristas
    */
    public void eliminarVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            int i = 0;
            for( Vertice v : this.vertices ) {
                if( v.darIdentificador().equals( identificador ) ) {
                    break;
                }
                else {
                    i++;
                }
            }
            LinkedList<String> vecinos = this.darVecindad( identificador );
            this.vertices.remove( i );
            this.orden--;
            for( String v : vecinos ) {
                this.eliminarArista( identificador, v );
            }
        }
    }
    /**
    * Metodo que se encarga de eliminar una arista si es que esta existe
    * @param u Este parametro es el identificador del vertice de uno de los extremos de la arista
    * @param v Este parametro es el identificador de vertice de uno de los extremos de la arista
    */
    public void eliminarArista( String u, String v ) throws Exception {
        if( this.buscarArista( u, v ) == false ) {
            throw new Exception( "La arista no existe." );
        }
        else {
            int i = 0;
            for( Arista e : this.aristas ) {
                if( ( e.darU().equals( u ) && e.darV().equals( v ) ) || ( e.darU().equals( v ) && e.darV().equals( u ) ) ) {
                    break;
                }
                else {
                    i++;
                }
            }
            this.aristas.remove( i );
            this.tamano--;
        }
    }
    /**
     * Metodo que se encarga de regresar un vertice dado su identificador
     * @param indentificador es el identificador del vertice a regresar
     * @return vertice 
     */
    public Vertice darVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice u = null;
            for( Vertice v : this.vertices ) {
                if( v.darIdentificador().equals( identificador ) ) {
                    u = v;
                    break;
                }
            }
            return u;
        }
    }
     /**
     * Metodo que se encarga de regresar una listas con los vecinos de un vertice
     * @param indentificador es el identificador del vertice al que se buscaran sus vecinos
     * @return  vecindad es la lista con los vertices vecinos
     */
    public LinkedList<String> darVecindad( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice NO existe." );
        }
        else {
            LinkedList<String> vecindad = new LinkedList<String>();
            for( Arista e : this.aristas ) {
                if( e.darU().equals( identificador ) || e.darV().equals( identificador ) ) {
                    if( e.darU().equals( identificador ) ) {
                        vecindad.add( e.darV() );
                    }
                    else {
                        vecindad.add( e.darU() );
                    }
                }
            }
            return vecindad;
        }
    }
     /**
     * Metodo que se encarga de regresar el grado de un vertice 
     * @param indentificador es el identificador del vertice al que se dara su grado
     * @return  grado 
     */
    public int darGrado( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            LinkedList<String> vecindad = this.darVecindad( identificador );
            return vecindad.size();
        }
    }
    /*Inicio de los metodos set, get y toString de grafica*/
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
    
    public boolean sonVecinos( String u, String v ) {
        return this.buscarArista( u, v );
    }
    /**
     * Metodo que se encarga de dar los elementos de un vertice 
     * @param indentificador es el identificador del vertice que se devolvera sus elementos
     * @return  elemento elemento de un vertice
     */
    public T darElementoVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice v = this.darVertice( identificador );
            return v.darElemento();
        }
    }
     /**
     * Metodo que dar visitado vertice
     * @param indentificador es el identificador del vertice que se checara
     * @return  boolean 
     */
    public boolean darVisitadoVertice( String identificador ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice v = this.darVertice( identificador );
            return v.darVisitado();
        }
    }
    /**
     * Metodo que modifica visitado de un vertice
     * @param indentificador es el identificador del vertice que se modificara
     * @param nuevoVisitado es el  nuevo estado del vertice que es un booleano
     * 
     */
    public void modificarVisitadoVertice( String identificador, boolean nuevoVisitado ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice v = this.darVertice( identificador );
            v.modificarVisitado( nuevoVisitado );
        }
    }
    /**
     * Metodo que modifica pendiente vertice
     * @param indentificador es el identificador del vertice que se modificara
     * @param nuevoVisitado es el nuevo valor booleano     
     */    
    public void modificarPendienteVertice( String identificador, boolean nuevoVisitado ) throws Exception {
        if( this.buscarVertice( identificador ) == false ) {
            throw new Exception( "El vertice no existe." );
        }
        else {
            Vertice v = this.darVertice( identificador );
            v.modificarPendiente(nuevoVisitado);
        }
    }
    /**
     * Metodo que modifica implmenta busqueda DFS
     * @param s es el identificador del vertice con el comenzara     
     */   
    public void algoritmoDFS( String s ) throws Exception {
        for (Vertice v : this.vertices) {
            modificarVisitadoVertice(v.darIdentificador(), false);
            modificarPendienteVertice(v.darIdentificador(), false);
        }

        Pila <Vertice> nueva_pila = new Pila<>();
        nueva_pila.apilar(darVertice(s));
        modificarPendienteVertice(s, true);

        while (!(nueva_pila.esVacia())) {
            Vertice u = nueva_pila.darElementoCima();
            nueva_pila.desapilar();

            LinkedList<String> vecinos = this.darVecindad(u.darIdentificador());

            while (vecinos.size() != 0 ) {
                String v = vecinos.getFirst();
                vecinos.removeFirst();
                Vertice w = darVertice(v);

                if (darVisitadoVertice(v) == false && w.darPendiente() == false) {
                    nueva_pila.apilar(w);
                    modificarPendienteVertice(v, true);

                }
            }
            modificarVisitadoVertice(u.darIdentificador(), true);
        }

    }
}
