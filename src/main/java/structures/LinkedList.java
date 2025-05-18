/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import structures.exceptions.ListException;
import structures.nodes.SingleNode;
import java.util.Objects;

/**
 * Clase Generica de una Lista Enalzada que permite Agregar, Remover y Encontrar
 * el indice de objetos, asi como vaciar por completo la lista.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class LinkedList<T> {
    private SingleNode<T> P;
    private SingleNode<T> ultimo;
    private int tam;

    /**
     * Metodo que Asigna un objeto a la ultima posicion de la lista.
     *
     * @param o Objeto a insertar.
     */
    public void add(T o) {
        SingleNode<T> nuevoNodo = new SingleNode<>(o);
        if (ultimo == null){
            P = nuevoNodo;
        } else {
            ultimo.setNext(nuevoNodo);
        }
        ultimo = nuevoNodo;
        tam++;
    }

    /**
     * Metodo que Asigna un objeto en la posicion que recibe como parametro.
     *
     * @param o Objeto a insertar.
     * @param indice int Indice donde se desea insetar.
     */
    public void set(T o, int indice) {
        if (indice < 0 || indice >= tam) {
            throw new ListException("Indice fuera del rango");
        }
        SingleNode<T> nuevoNodo = new SingleNode<>(o);
        if (indice == 0) {
            nuevoNodo.setNext(P);
            P = nuevoNodo;
        } else {
            SingleNode<T> actual = P;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.getNext();
            }
            nuevoNodo.setNext(actual.getNext());
            actual.setNext(nuevoNodo);
        }
        tam++;
    }

    /**
     * Metodo que Elimina un objeto de la lista.
     *
     * @param o Objeto a eliminar.
     * @return true si el objeto fue eliminado, false si no se encontró.
     */
    public boolean remove(T o) {
        if (P == null){
            return false;
        }
        if (Objects.equals(P.getValue(), o)) {
            P = P.getNext();
            if (P == null) {
                ultimo = null;
            }
            tam--;
            return true;
        }
        SingleNode<T> actual = P;
        while (actual.getNext() != null) {
            if (Objects.equals(actual.getNext().getValue(), o)) {
                if (actual.getNext() == ultimo) {
                    ultimo = actual;
                }
                actual.setNext(actual.getNext().getNext());
                tam--;
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
        for (int i = 0; i < tam; i++) {
            if (Objects.equals(actual.getValue(), o)){
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
        this.ultimo = null;
        this.tam = 0;
    }
    
    
}