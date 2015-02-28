package Basico;

/**
 *
 * @author 
 */
public class Nodo<T> {
    private T datos;
    public Nodo siguiente;
 
    /**
     * Metodo constructor de nodo
     * @param datos El parametro son los datos del nodo
     */
    Nodo(T datos) {
        this.datos = datos;
        this.siguiente = null;        
    }//Fin del Constructor
     
    /**
     * Metodo constructor de nodo
     * @param datos El parametro son los datos del nodo
     * @param nodo El parametro es el nodo siguiente
     */
    Nodo(T datos, Nodo nodo) {
        this.datos = datos;
        this.siguiente = nodo;
    }//Fin del Constructor
 
    /**
     * Metodo define los datos del nodo
     * @param datos El parametro son los datos del nodo
     */
    public void setDatos(T datos) {
        this.datos = datos;
    }//Fin de setDatos
 
    /**
     * Metodo define el siguiente nodo
     * @param siguiente El parametro son los datos del nodo
     */
    public void setSiguienteNodo(Nodo siguiente) {
        this.siguiente = siguiente;
    }//Fin de setSiguienteNodo
     
    /**
     * Metodo devuelve los datos del nodo\
     * @return datos Los datos del nodo
     */
    public T getDatos() {
        return datos;
    }//Fin de getDatos
    
    /**
     * Metodo devuelve el nodo siguiente nodo en la ListaSimple
     * @return siguiente El nodo siguiente
     */
    public Nodo getSiguienteNodo() {
        return siguiente;
    }//Fin de getSiguienteNodo
}//Fin de Nodo

