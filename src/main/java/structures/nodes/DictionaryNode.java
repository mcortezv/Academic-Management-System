/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.nodes;

/**
 * Clase que representa un nodo de un Mapa.
 *
 * @param <K> llave con la que se almacenara el valor en el diccionario
 * @param <V> valor registrado a la llave en el diccionario
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
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
     *
     * @param key Llave del nodo.
     * @param value El valor almacenado en el nodo.
     */
    public DictionaryNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    /**
     * Establece la clave del nodo al valor recibido del parametro
     *
     * @param key la clave del nodo
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Obtiene la clave del nodo
     *
     * @return key la clave del nodo
     */
    public K getKey() {
        return key;
    }

    /**
     * Establece el valor del nodo al valor recibido del parametro
     *
     * @param value el valor del nodo
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Obtiene el valor del nodo
     *
     * @return value el valoor del nodo
     */
    public V getValue() {
        return value;
    }

    /**
     * Establece como siguiente el nodo recibido del parametro
     *
     * @param next el nodo siguiente
     */
    public void setNext(DictionaryNode<K, V> next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo siguiente
     *
     * @return next el nodo siguiente
     */
    public DictionaryNode<K, V> getNext() {
        return next;
    }
}
