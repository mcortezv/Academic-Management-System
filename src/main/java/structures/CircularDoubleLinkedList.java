/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import components.Student;
import structures.exceptions.ListException;
import structures.nodes.DoubleNode;
import java.util.Objects;

/**
 * Clase Genérica de una Lista Doblemente Enlazada Circular.
 * Permite operaciones como agregar, insertar por índice, eliminar por valor,
 * obtener el índice de un elemento, limpiar la lista y generar una lista de estudiantes.
 *
 * @param <T> Tipo de dato que se almacenará en la lista.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class CircularDoubleLinkedList<T> {
    private DoubleNode<T> P;
    private DoubleNode<T> last;
    private int size;

    /**
     * Agrega un nuevo elemento al final de la lista.
     *
     * @param o Elemento a agregar.
     */
    public void add(T o) {
        DoubleNode<T> newNode = new DoubleNode<>(o);
        if (last == null) {
            P = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
        } else {
            newNode.setNext(P);
            newNode.setPrev(last);
            last.setNext(newNode);
            P.setPrev(newNode);

        }
        last = newNode;
        size++;
    }

    /**
     * Inserta un nuevo elemento en la posición especificada.
     *
     * @param o      Elemento a insertar.
     * @param index Índice en el cual se insertará el elemento.
     * @throws ListException Si el índice está fuera de rango.
     */
    public void set(T o, int index) {
        if (index < 0 || index > size) {
            throw new ListException("Indice fuera del rango");
        }

        DoubleNode<T> newNode = new DoubleNode<>(o);

        if (index == 0) {
            if (P == null) {
                P = newNode;
                P.setNext(P);
                P.setPrev(P);
                last = P;
            } else {
                newNode.setNext(P);
                newNode.setPrev(last);
                P.setPrev(newNode);
                last.setNext(newNode);
                P = newNode;
            }
        } else {
            DoubleNode<T> actual = P;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getNext();
            }
            newNode.setNext(actual.getNext());
            newNode.setPrev(actual);
            actual.getNext().setPrev(newNode);
            actual.setNext(newNode);
            if (actual == last) {
                last = newNode;
            }
        }

        size++;
    }

    /**
     * Elimina la primera aparición del elemento especificado.
     *
     * @param o Elemento a eliminar.
     * @return true si el elemento fue encontrado y eliminado; false en caso contrario.
     */
    public boolean remove(T o) {
        if (P == null) {
            return false;
        }

        if (Objects.equals(P.getValue(), o)) {
            if (P == last) {
                P = null;
                last = null;
            } else {
                P.getNext().setPrev(last);
                last.setNext(P.getNext());
                P = P.getNext();
            }
            size--;
            return true;
        }

        DoubleNode<T> actual = P;
        while (actual.getNext() != P) {
            if (Objects.equals(actual.getNext().getValue(), o)) {
                if (actual.getNext() == last) {
                    last = actual;
                }
                DoubleNode<T> toEliminate = actual.getNext();
                actual.setNext(toEliminate.getNext());
                toEliminate.getNext().setPrev(actual);
                size--;
                return true;
            }
            actual = actual.getNext();
        }

        return false;
    }

    /**
     * Devuelve el índice de la primera aparición del elemento especificado.
     *
     * @param o Elemento a buscar.
     * @return Índice del elemento si se encuentra; -1 si no está en la lista.
     */
    public int indexOf(T o) {
        DoubleNode<T> actual = P;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(actual.getValue(), o)) {
                return i;
            }
            actual = actual.getNext();
        }
        return -1;
    }

    /**
     * Elimina todos los elementos de la lista.
     * La lista queda vacía.
     */
    public void clear() {
        this.P = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Genera y retorna una lista de estudiantes a partir de los elementos actuales.
     *
     * @return Lista de objetos Student contenidos en la lista circular.
     */
    public ArrayList<Student> getList() {
        ArrayList<Student> students = new ArrayList<>(10);
        DoubleNode<T> actual = P;
        for (int i = 0; i < size; i++) {
            students.add((Student) actual.getValue());
            actual = actual.getNext();
        }
        return students;
    }
}