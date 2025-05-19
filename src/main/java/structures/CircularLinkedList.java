/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import structures.exceptions.ListException;
import structures.nodes.SingleNode;

import javax.swing.*;
import java.util.Objects;

/**
 * Clase Generica de una Lista Enalzada que permite Agregar, Remover y Encontrar
 * el indice de objetos, asi como vaciar por completo la lista.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 * @param <T> tipo de datos almacenados en la lista doblemente enlazada circular
 */
public class CircularLinkedList<T> {

    private SingleNode<T> P;
    private SingleNode<T> last;
    private int size;

    /**
     * Metodo que Asigna un objeto a la ultima posicion de la lista.
     *
     * @param o Objeto a insertar.
     */
    public void add(T o) {
        SingleNode<T> newNode = new SingleNode<>(o);
        if (last == null) {
            P = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(P);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    /**
     * Metodo que Asigna un objeto en la posicion que recibe como parametro.
     *
     * @param o Objeto a insertar.
     * @param index int Indice donde se desea insetar.
     */
    public void set(T o, int index) {
        if (index < 0 || index > size) {
            throw new ListException("Indice fuera del rango");
        }
        SingleNode<T> newNode = new SingleNode<>(o);
        if (index == 0) {
            if (P == null) {
                P = newNode;
                P.setNext(P);
                last = P;
            } else {
                newNode.setNext(P);
                P = newNode;
                last.setNext(P);
            }
        } else {
            SingleNode<T> actual = P;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getNext();
            }
            newNode.setNext(actual.getNext());
            actual.setNext(newNode);
            if (actual == last) {
                last = newNode;
            }
        }
        size++;
    }

    /**
     * Metodo que Elimina un objeto de la lista.
     *
     * @param o Objeto a eliminar.
     * @return true si el objeto fue eliminado, false si no se encontró.
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
                P = P.getNext();
                last.setNext(P);
            }
            size--;
            return true;
        }
        SingleNode<T> actual = P;
        while (actual.getNext() != P) {
            if (Objects.equals(actual.getNext().getValue(), o)) {
                if (actual.getNext() == last) {
                    last = actual;
                }
                actual.setNext(actual.getNext().getNext());
                size--;
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    /**
     * Metodo que busca un objeto en la lista y devuelve su índice.
     *
     * @param o Objeto a buscar.
     * @return Índice del objeto o -1 si no se encuentra.
     */
    public int indexOf(T o) {
        SingleNode<T> actual = P;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(actual.getValue(), o)) {
                return i;
            }
            actual = actual.getNext();
        }
        return -1;
    }

    /**
     * Metodo que limpia la lista, eliminando todos los elementos.
     */
    public void clear() {
        this.P = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Metodo que establece el nodo principal al siguiente.
     *
     * @return nodo que fue establecido como siguiente
     */
    public SingleNode<T> rotateNode() {
        if (P == null) {
            JOptionPane.showMessageDialog(null, "El rol no se puede rotar porque no hay estudiantes.", "Error", JOptionPane.ERROR_MESSAGE);
            return new SingleNode<>();
        }
        if (size < 2) {
            JOptionPane.showMessageDialog(null, "El rol no se puede rotar porque no hay suficientes estudiantes.", "Error", JOptionPane.ERROR_MESSAGE);
            return new SingleNode<>();
        }
        last.setNext(P);
        last = P;
        P = P.getNext();
        return P;
    }

    /**
     *
     * @return
     */
    public SingleNode<T> undoRotateNode(){
        SingleNode<T> var = new SingleNode<>();
        for(int i = 0; i < size ; i++ ){
            var = rotateNode();
        }
        return var;
    }
}
