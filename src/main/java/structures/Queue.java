/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import structures.exceptions.QueueException;
import structures.nodes.SingleNode;

/**
 * Implementación de una cola utilizando una lista enlazada simple.
 * Esta clase implementa las operaciones basicas de una cola: encolar,
 * desencolar, obtener el primer elemento,
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 * @param <T> Tipo de datos de los elementos almacenados en la cola.
 */
public class Queue<T> {
    private SingleNode<T> P;

    /**
     * Constructor de la clase LinkedListQueue. Inicializa la cola vacia.
     */
    public Queue() {
        this.P = null;
    }

    /**
     * Añade un elemento al final de la cola.
     *
     * @param value El dato a agregar a la cola.
     */
    public void enqueue(T value) {
        SingleNode<T> nuevo = new SingleNode<>(value);
        if (P == null) {
            P = nuevo;
            return;
        }
        nuevo.setNext(P);
        P = nuevo;
    }

    /**
     * Elimina y devuelve el primer elemento de la cola.
     *
     * @return El primer elemento de la cola.
     * @throws QueueException Si la cola esta vacia.
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (getSize() == 1){
            T dato = P.getValue();
            P = null;
            return dato;
        }
        SingleNode<T> aux = P;
        while (aux.getNext().getNext() != null) {
            aux = aux.getNext();
        }
        T dato = aux.getNext().getValue();
        aux.setNext(null);
        return dato;
    }

    /**
     * Devuelve el primer elemento de la cola sin eliminarlo.
     *
     * @return El primer elemento de la cola.
     * @throws QueueException Si la cola esta vacia.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        SingleNode<T> aux = P;
        while (aux.getNext() != null){
            aux = aux.getNext();
        }
        return aux.getValue();
    }

    /**
     * Verifica si la cola esta vacia.
     *
     * @return true si la cola esta vacia, false en caso contrario.
     */
    public boolean isEmpty() {
        return P == null;
    }

    /**
     * Devuelve el tamaño de la cola, es decir, la cantidad de elementos presentes.
     *
     * @return El numero de elementos en la cola.
     */
    public int getSize() {
        int size = 0;
        SingleNode<T> aux = P;
        while (aux != null) {
            size++;
            aux = aux.getNext();
        }
        return size;
    }
}