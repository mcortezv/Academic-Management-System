/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.nodes;

/**
 * Clase que representa un nodo de la lista doblemente enlazada.
 *
 * @param <T> Tipo de dato almacenado en el nodo.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class DoubleNode<T> {

    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    /**
     * Constructor por defecto, crea un nodo sin dato.
     */
    public DoubleNode() {
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    /**
     * Constructor que inicializa un nodo con un dato.
     *
     * @param value El valor almacenado en el nodo.
     */
    public DoubleNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /**
     * Establece el valor del nodo al valor del parametro
     *
     * @param value valor a establecer
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Obtiene el valor de la instancia
     *
     * @return value valor del nodo
     */
    public T getValue() {
        return value;
    }

    /**
     * Establece como siguiente el nodo recibido al parametro
     *
     * @param next
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo siguiente
     *
     * @return next nodo siguiente
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Establece como previo el nodo recibido al parametro
     *
     * @param prev
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Obtiene el nodo previo
     *
     * @return prev nodo previo
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }
}
