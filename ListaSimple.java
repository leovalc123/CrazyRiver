package Basico;

/**
 *
 * @author 
 * @param <T> 
 */
public class ListaSimple<T> implements Cloneable{
    private Nodo<T> primerNodo;
    private Nodo<T> ultimoNodo;
     
    /**
     * Metodo constructor para la ListaSimple 
     */
    public ListaSimple() {
        primerNodo = ultimoNodo = null;
    }//Fin del constructor
     
    /**
     * Metodo clona la lista
     * @return lista clonada
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        Object obj = null;
        try{
            obj = super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("No se puede duplicar!");
        }//Fin del catch
        return obj;
    }//Fin de clone
    
    /**
     * Metodo Revisa si la lista esta vacia
     * @return el valor de falso y verdadero de si la lista esta vacia
     */
    public boolean estaVacia() {
        return primerNodo == null;
    }//Fin de estaVacia
     
    /**
     * Metodo inserta un elemento al frente de la ListaSimple
     * @param elemnto El parametro es el elemento de que se va a insertar
     */
    public void insertarAlFrente(T elemento) {
        if(estaVacia()) {
            primerNodo = ultimoNodo = new Nodo(elemento);
        }else {
            Nodo<T> nodo = new Nodo(elemento, primerNodo);
            primerNodo = nodo;          
        }//Fin del if else
    }//Fin de insertarAlFrente
     
    /**
     * Metodo inserta un elemento al final de la ListaSimple
     * @param elemnto El parametro es el elemento de que se va a insertar
     */
    public void insertarAlFinal(T elemento) {
        if (estaVacia()) {
            primerNodo = ultimoNodo = new Nodo(elemento);
        }else {
            Nodo<T> nodo = new Nodo(elemento);
            ultimoNodo.setSiguienteNodo(nodo);
            ultimoNodo = ultimoNodo.getSiguienteNodo();
        }//Fin del if else
    }//Fin del insertarAlFinal
    
    /**
     * Metodo elemina un elemento a la ListaSimple
     * @param posicion El parametro es la posicion en que se encuentra el 
     * elemento a eliminar
     */
    public void eliminarPosicion(int posicion){
        if(posicion < 0 || posicion > this.len()){
            System.out.println("Error en método eliminarPosicion:\n"
                    + "La posición es inválida, debe ser positivo"
                    + "y menor que el tamaño de la lista:" + this.len());
        }else{
            Nodo nodo = this.buscarPosicion(posicion);
            this.buscarPosicion(posicion - 1).setSiguienteNodo(nodo.getSiguienteNodo());
        }//Fin del if else
    }//Fin de eliminarPosicion
    
    /**
     * Metodo elimina el elemento de la ListaSimple que se encuentra al frente
     * @return elemento que fue eliminado
     * @throws Exception "No hay elementos en la lista"
     */
    public T eliminarDelFrente() throws Exception {
        if (estaVacia()) {
            throw new Exception("No hay elementos en la lista");
        }else {
            T elemento = primerNodo.getDatos();
            if (primerNodo == ultimoNodo) {
                primerNodo = ultimoNodo = null;
            }else {
                primerNodo = primerNodo.getSiguienteNodo();
            }//Fin del if else 
            return elemento;
        }//Fin del if else
    }//Fin de eliminarDelFrente
     
    /**
     * Metodo elimina el elemento del final de la ListaSimple
     * @return elemnto que fue eliminado
     * @throws Exception "No hay elementos en la lista"
     */
    public T eliminarDelFinal() throws Exception {
        if (estaVacia()) {
            throw new Exception("No hay elementos en la lista");
        }else {
            T elemento = ultimoNodo.getDatos();
            if (primerNodo == ultimoNodo) {
                primerNodo = ultimoNodo = null;
            }else {
                Nodo<T> actual = primerNodo;
                while (actual.getSiguienteNodo() != ultimoNodo) {
                    actual = actual.getSiguienteNodo();
                }//Fin del while
                ultimoNodo = actual;
                actual.setSiguienteNodo(null);
            }//Fin del if else
            return elemento;
        }//Fin del if else
    }//Fin de eliminarDelFinal
    
    /**
     * Metodo devuelve el nodo buscado en la ListaSimple
     * @param posicion El parametro es la posicion en donde esta el nodo
     * a buscar
     * @return indice El nodo buscado
     */
    public Nodo buscarPosicion(int posicion){
        Nodo indice;
        int i;
        if (posicion < 0) 
            return null;
        indice = primerNodo;
        for (i = 1 ;(i < posicion) && (indice != null); i++)
            indice = indice.siguiente;
        return indice;
     }//Fin del buscarPosicion
    
    /**
     * Metodo devuelve los datos del nodo buscado en la ListaSimple
     * @param posicion El parametro es la posicion en donde esta el nodo 
     * a buscar
     * @return m Datos del nodo
     */
    public T buscarPosicion2(int posicion){
        Nodo indice;
        T m = null;
        int i;
        if (posicion < 0) 
            return null;
        indice = primerNodo;
        m = primerNodo.getDatos();
        for (i = 1 ;(i <= posicion) && (indice != null); i++){
            indice = indice.siguiente;
            m = (T) indice.getDatos();
        }//fin del for
        //System.out.println("La lista esta vacia");
        return m;
     }//Fin de buscarPosicion2
    
    /**
     * Metodo devuelve la cantidad de nodos que tiene la ListaSimple
     * @return cant La cantidad de nodos
     */
    public int len(){
       int cant = 0;
       Nodo c;
       c = primerNodo;
       while(c != null){
           c = c.getSiguienteNodo();
           cant++;
       }//Fin del while
       return cant;
   }//Fin de len
     
    /**
     * Metodo imprime la ListaSimple
     */
    
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        }else {
            Nodo actual = primerNodo;
            int i = 0;
            while (actual != null) {
                System.out.print(i + " : ");
                System.out.println(actual.getDatos());
                actual = actual.getSiguienteNodo();
                i++;
            }//Fin del while
        }//Fin del if else
        System.out.println(""); //NO QUITAR!!
    }//Fin de imprimir
 }//Fin de ListaSimple

