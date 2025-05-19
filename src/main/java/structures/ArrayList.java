/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import structures.exceptions.ListException;

import javax.swing.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implementación de una lista basada en un array.
 *
 * @param <T> Tipo de elementos almacenados en la lista.
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class ArrayList<T> implements Iterable<T> {
    public int numObjects;
    public T[] array;

    /**
     * Constructor que establece los atributos de la instancia al valor de sus parametros
     *
     * @param numObjetos int Tamaño inicial de la lista.
     * @throws ListException si el tamaño es negativo.
     */
    public ArrayList(int numObjetos){
        if (numObjetos < 0){
            throw new ListException("El Tamaño no Puede Ser Negativo");
        }
        this.numObjects = 0;
        this.array = (T[]) new Object[numObjetos];
    }

    public boolean isEmpty(){
        return numObjects == 0;
    }

    /**
     * Agrega un objeto al final de la lista.
     *
     * @param o T Objeto a agregar.
     */
    public void add(T o) {
        if (numObjects >= array.length) {
            resize();
        }
        array[numObjects] = o;
        numObjects++;
    }

    /**
     * Asigna un objeto a una posición específica de la lista.
     *
     * @param o T Objeto a insertar.
     * @param i int Índice donde se insertará el objeto.
     * @throws ListException si el índice está fuera de rango.
     */
    public void set(T o, int i) {
        if (i < 0 || i >= array.length){
            JOptionPane.showMessageDialog(null, "Indice Fuera del Rango del Arreglo de Calificaciones", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        array[i] = o;
        numObjects++;
    }

    /**
     * Retorna un objeto a una posición específica de la lista.
     *
     * @return o T
     * @param i int Índice del objeto
     * @throws ListException si el índice está fuera de rango.
     */
    public T get(int i) {
        if (i < 0 || i >= array.length){
            throw new ListException("Indice Fuera de Rango");
        }
        return array[i];
    }

    /**
     * Elimina un objeto de la lista.
     *
     * @param o T Objeto a eliminar.
     * @return true si el objeto fue eliminado, false si no se encontró.
     * @throws ListException si la lista está vacía.
     */
    public boolean remove(T o) {
        if (this.numObjects == 0){
            throw new ListException("La Lista Esta Vacia");
        }
        for (int i = 0; i < array.length; i++){
            if (Objects.equals(o, array[i])){
                array[i] = null;
                numObjects--;
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un objeto en la lista y devuelve su índice.
     *
     * @param o T Objeto a buscar.
     * @return Índice del objeto o -1 si no se encuentra.
     */
    public int indexOf(T o) {
        for (int i = 0; i < array.length; i++){
            if (Objects.equals(o, array[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * Redimensiona el arreglo interno al doble de su tamaño actual.
     */
    private void resize() {
        int newSize = array.length * 2;
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /**
     * Limpia la lista, eliminando todos los elementos.
     */
    public void clear() {
        this.numObjects = 0;
        this.array = (T[]) new Object[array.length];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < numObjects;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[currentIndex++];
            }
        };
    }
}