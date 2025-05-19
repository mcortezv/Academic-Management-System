/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import structures.nodes.DictionaryNode;

/**
 * Implementación de un diccionario hash utilizando un arreglo de listas
 * enlazadas para manejar colisiones mediante encadenamiento.
 *
 * @param <K> Tipo de dato para la clave.
 * @param <V> Tipo de dato para el valor.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class HashDictionary<K, V> {

    private DictionaryNode<K, V>[] table;
    private int size;
    private int capacity;

    /**
     * Constructor que inicializa el diccionario con una capacidad específica.
     *
     * @param initialCapacity Capacidad inicial del diccionario.
     */
    public HashDictionary(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new DictionaryNode[initialCapacity];
        this.size = 0;
    }

    /**
     * Metodo que regresa una lista enlazada que contiene solo los valores
     * almacenados en el diccionario
     *
     * @return values los valores devueltos del diccionario
     */
    public ArrayList<V> getValues() {
        ArrayList<V> values = new ArrayList<>(size);
        for (int i = 0; i < capacity; i++) {
            DictionaryNode<K, V> actual = table[i];
            while (actual != null) {
                values.add(actual.getValue());
                actual = actual.getNext();
            }
        }
        return values;
    }

    /**
     * Metodo que regresa una lista enlazada que contiene solo las llaves
     * almacenadas en el diccionario
     *
     * @return keys las llaves devueltas del diccionario
     */
    public ArrayList<K> getKeys() {
        ArrayList<K> keys = new ArrayList<>(size);
        for (int i = 0; i < capacity; i++) {
            DictionaryNode<K, V> actual = table[i];
            while (actual != null) {
                keys.add(actual.getKey());
                actual = actual.getNext();
            }
        }
        return keys;
    }

    /**
     * Devuelve una representación de todos los pares clave-valor almacenados en
     * la tabla hash como un String.
     *
     * @return Cadena con los valores y claves del diccionario.
     */
    public String getKeysAndValues() {
        return getKeysAndValues(table);
    }

    /**
     * Método auxiliar que recorre la tabla hash e imprime todos los pares
     * clave-valor.
     *
     * @param table Arreglo de nodos que representa la tabla hash.
     * @return Cadena con los pares clave-valor.
     */
    private String getKeysAndValues(DictionaryNode<K, V>[] table) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            DictionaryNode<K, V> actual = table[i];
            while (actual != null) {
                sb.append(actual.getValue()).append("\n");
                sb.append(actual.getKey()).append(" -> ").append(actual.getValue()).append("\n");
                actual = actual.getNext();
            }
        }
        return sb.toString();
    }

    /**
     * Obtiene el número actual de elementos en el diccionario.
     *
     * @return Número de elementos.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el número de elementos del diccionario manualmente.
     *
     * @param size Nuevo valor del tamaño.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Calcula el índice hash para una clave.
     *
     * @param key Clave cuya posición hash se desea obtener.
     * @return Índice calculado dentro del arreglo.
     */
    private int getHash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Inserta o actualiza un par clave-valor en el diccionario. Si la clave ya
     * existe, actualiza su valor. Si no, la inserta al final de la lista del
     * bucket correspondiente.
     *
     * @param key Clave a insertar o actualizar.
     * @param value Valor asociado a la clave.
     */
    public void put(K key, V value) {
        int index = getHash(key);
        DictionaryNode<K, V> newToPut = new DictionaryNode<>(key, value);
        if (table[index] == null) {
            table[index] = newToPut;
        } else {
            DictionaryNode<K, V> actual = table[index];
            while (actual != null) {
                if (actual.getKey().equals(key)) {
                    actual.setValue(value);
                    return;
                }
                if (actual.getNext() == null) {
                    break;
                }
                actual = actual.getNext();
            }
            actual.setNext(newToPut);
        }
        size++;
    }

    /**
     * Elimina un par clave-valor del diccionario si existe.
     *
     * @param clave Clave del elemento a eliminar.
     * @return true si fue eliminado, false si no se encontró.
     */
    public boolean remove(K clave) {
        int index = getHash(clave);
        DictionaryNode<K, V> actual = table[index];
        DictionaryNode<K, V> previus = null;
        while (actual != null) {
            if (actual.getKey().equals(clave)) {
                if (previus == null) {
                    table[index] = actual.getNext();
                } else {
                    previus.setNext(actual.getNext());
                }
                size--;
                return true;
            }
            previus = actual;
            actual = actual.getNext();
        }
        return false;
    }

    /**
     * Busca y retorna el valor asociado a una clave específica.
     *
     * @param key Clave a buscar.
     * @return Valor asociado, o null si no se encuentra.
     */
    public V get(K key) {
        int index = getHash(key);
        DictionaryNode<K, V> actual = table[index];
        while (actual != null) {
            if (actual.getKey().equals(key)) {
                return actual.getValue();
            }
            actual = actual.getNext();
        }
        return null;
    }

    /**
     * Verifica si una clave existe en el diccionario.
     *
     * @param key Clave a verificar.
     * @return true si existe, false en caso contrario.
     */
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * Limpia completamente el diccionario, eliminando todos los elementos y
     * reiniciando el tamaño.
     */
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    /**
     * Imprime en consola todos los pares clave-valor del diccionario.
     */
    public void entrySet() {
        for (int i = 0; i < capacity; i++) {
            DictionaryNode<K, V> actual = table[i];
            while (actual != null) {
                System.out.println(actual.getKey() + " -> " + actual.getValue());
                actual = actual.getNext();
            }
        }
    }
}
