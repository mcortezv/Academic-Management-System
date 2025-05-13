package structures;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import structures.nodes.DictionaryNode;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class HashDictionary<K, V> {
    private DictionaryNode<K, V>[] table;
    private int size;
    private int capacity;

    public HashDictionary(int capacidadInicial) {
        this.capacity = capacidadInicial;
        this.table = new DictionaryNode[capacidadInicial];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int getHash(K clave) {
        return Math.abs(clave.hashCode()) % capacity;
    }

    public void put(K clave, V valor) {
        int indice = getHash(clave);
        DictionaryNode<K, V> nuevo = new DictionaryNode<>(clave, valor);
        if (table[indice] == null) {
            table[indice] = nuevo;
        } else {
            DictionaryNode<K, V> actual = table[indice];
            while (actual != null) {
                if (actual.getKey().equals(clave)) {
                    actual.setValue(valor);
                    return;
                }
                if (actual.getNext() == null) break;
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
        }
        size++;
    }

    public boolean remove(K clave) {
        int indice = getHash(clave);
        DictionaryNode<K, V> actual = table[indice];
        DictionaryNode<K, V> anterior = null;
        while (actual != null) {
            if (actual.getKey().equals(clave)) {
                if (anterior == null) {
                    table[indice] = actual.getNext();
                } else {
                    anterior.setNext(actual.getNext());
                }
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.getNext();
        }
        return false;
    }


    public V get(K clave) {
        int indice = getHash(clave);
        DictionaryNode<K, V> actual = table[indice];
        while (actual != null) {
            if (actual.getKey().equals(clave)) {
                return actual.getValue();
            }
            actual = actual.getNext();
        }
        return null;
    }

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