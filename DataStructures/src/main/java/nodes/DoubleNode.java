/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodes;

/**
 * Clase que representa un nodo de la lista doblemente enlazada.
 * @param <T> Tipo de dato almacenado en el nodo.
 *
 * @author Cortez, Manuel;
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
     * @param value El valor almacenado en el nodo.
     */
    public DoubleNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setNext(DoubleNode<T> next){
        this.next = next;
    }

    public DoubleNode<T> getNext(){
        return next;
    }

    public void setPrev(DoubleNode<T> prev){
        this.prev = prev;
    }

    public DoubleNode<T> getPrev(){
        return prev;
    }
}