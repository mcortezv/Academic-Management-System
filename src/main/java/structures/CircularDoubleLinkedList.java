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
    private DoubleNode<T> ultimo;
    private int tam;

    /**
     * Agrega un nuevo elemento al final de la lista.
     *
     * @param o Elemento a agregar.
     */
    public void add(T o) {
        DoubleNode<T> nuevoNodo = new DoubleNode<>(o);
        if (ultimo == null) {
            P = nuevoNodo;
            nuevoNodo.setNext(nuevoNodo);
            nuevoNodo.setPrev(nuevoNodo);
        } else {
            nuevoNodo.setNext(P);
            nuevoNodo.setPrev(ultimo);
            P.setPrev(nuevoNodo);
            ultimo.setNext(nuevoNodo);
        }
        ultimo = nuevoNodo;
        tam++;
    }

    /**
     * Inserta un nuevo elemento en la posición especificada.
     *
     * @param o      Elemento a insertar.
     * @param indice Índice en el cual se insertará el elemento.
     * @throws ListException Si el índice está fuera de rango.
     */
    public void set(T o, int indice) {
        if (indice < 0 || indice > tam) {
            throw new ListException("Indice fuera del rango");
        }

        DoubleNode<T> nuevoNodo = new DoubleNode<>(o);

        if (indice == 0) {
            if (P == null) {
                P = nuevoNodo;
                P.setNext(P);
                P.setPrev(P);
                ultimo = P;
            } else {
                nuevoNodo.setNext(P);
                nuevoNodo.setPrev(ultimo);
                P.setPrev(nuevoNodo);
                ultimo.setNext(nuevoNodo);
                P = nuevoNodo;
            }
        } else {
            DoubleNode<T> actual = P;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getNext();
            }
            nuevoNodo.setNext(actual.getNext());
            nuevoNodo.setPrev(actual);
            actual.getNext().setPrev(nuevoNodo);
            actual.setNext(nuevoNodo);
            if (actual == ultimo) {
                ultimo = nuevoNodo;
            }
        }

        tam++;
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
            if (P == ultimo) {
                P = null;
                ultimo = null;
            } else {
                P.getNext().setPrev(ultimo);
                ultimo.setNext(P.getNext());
                P = P.getNext();
            }
            tam--;
            return true;
        }

        DoubleNode<T> actual = P;
        while (actual.getNext() != P) {
            if (Objects.equals(actual.getNext().getValue(), o)) {
                if (actual.getNext() == ultimo) {
                    ultimo = actual;
                }
                DoubleNode<T> aEliminar = actual.getNext();
                actual.setNext(aEliminar.getNext());
                aEliminar.getNext().setPrev(actual);
                tam--;
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
        for (int i = 0; i < tam; i++) {
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
        this.ultimo = null;
        this.tam = 0;
    }

    /**
     * Genera y retorna una lista de estudiantes a partir de los elementos actuales.
     *
     * @return Lista de objetos Student contenidos en la lista circular.
     */
    public ArrayList<Student> getList() {
        ArrayList<Student> students = new ArrayList<>(10);
        DoubleNode<T> actual = P;
        for (int i = 0; i < tam - 1; i++) {
            students.add((Student) actual.getValue());
            actual = actual.getNext();
        }
        return students;
    }
}