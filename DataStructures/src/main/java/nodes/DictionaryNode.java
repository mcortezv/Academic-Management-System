/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodes;

/**
 * Clase que representa un nodo de un Mapa.
 * @param <K, V> Tipo de dato de la llave y del valor almacenado en el nodo.
 *
 * @author Cortez, Manuel;
 */
public class DictionaryNode<K, V> {
    private K key;
    private V value;
    private DictionaryNode<K, V> next;

    /**
     * Constructor por defecto, crea un nodo sin dato.
     */
    public DictionaryNode() {
        this.key = null;
        this.value = null;
        this.next = null;
    }

    /**
     * Constructor que inicializa un nodo con un dato.
     * @param key Llave del nodo.
     * @param value El valor almacenado en el nodo.
     */
    public DictionaryNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public void setKey(K key){
        this.key = key;
    }

    public K getKey(){
        return key;
    }

    public void setValue(V value){
        this.value = value;
    }

    public V getValue(){
        return value;
    }

    public void setNext(DictionaryNode<K, V> next){
        this.next = next;
    }

    public DictionaryNode<K, V> getNext(){
        return next;
    }
}