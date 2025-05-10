/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import exceptions.ListException;
import nodes.DoubleNode;
import java.util.Objects;

/**
 * Clase Generica de una Lista Doblemente Enlazada Circular que permite Agregar, Remover y Encontrar
 * el indice de objetos, asi como vaciar por completo la lista.
 *
 * @author Cortez, Manuel;
 */
public class CircularDoubleLinkedList<T> {
    private DoubleNode<T> P;
    private DoubleNode<T> ultimo;
    private int tam;

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

    public int indexOf(T o) {
        DoubleNode<T> actual = P;
        for (int i = 0; i < tam; i++) {
            if (Objects.equals(actual.getValue(), o)){
                return i;
            }
            actual = actual.getNext();
        }
        return -1;
    }

    public void clear() {
        this.P = null;
        this.ultimo = null;
        this.tam = 0;
    }
}