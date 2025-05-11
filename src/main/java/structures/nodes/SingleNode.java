/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.nodes;

/**
 * Clase Generica Nodo que permite crear un nuevo Nodo que guarda un Objeto
 * y la referencia del nodo siguiente, Null en caso de ser el ultimo.
 *
 * @author Cortez, Manuel;
 */
public class SingleNode<T> {
    T value;
    SingleNode<T> next;

    /**
     * Constructor por defecto de la clase Nodo que cre una nuevo Nodo con
     * sus atributos en null.
     */
    public SingleNode(){}

    /**
     * Constructor por defecto de la clase Nodo que cre una nuevo Nodo seteando
     * el dato que recibe como parametro a dicho Nodo.
     *
     * @param value T Valor del Nodo.
     */
    public SingleNode(T value){
        this.value = value;
    }

    /**
     * Metodo que establece el dato que recibe como parametro al atributo del Nodo
     * que lo manda llamar.
     *
     * @param value T Valor del Nodo.
     */
    public void setValue(T value){
        this.value = value;
    }

    /**
     * Metodo que retorna el Dato almacenado en el Nodo que lo manda llamar.
     *
     * @return T Valor del Nodo.
     */
    public T getValue(){
        return this.value;
    }

    /**
     * Metodo que establece la Referencia que recibe como parametro al atributo siguiente del Nodo
     * que lo manda llamar.
     *
     * @param next Nodo<T> Referencia del siguiente Nodo.
     */
    public void setNext(SingleNode<T> next){
        this.next = next;
    }

    /**
     * Metodo que retorna la Referencia del Nodo siguiente al que manda llamar al metodo.
     *
     * @return Nodo<T> Nodo siguiente al que llama al metodo.
     */
    public SingleNode<T> getNext(){
        return this.next;
    }
}