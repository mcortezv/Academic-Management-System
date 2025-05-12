/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.nodes;

/**
 * Clase que representa un nodo de un Arbol.
 *
 * @param <T> Tipo de dato almacenado en el nodo.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class BinaryTreeNode<T> {

    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    /**
     * Constructor por defecto, crea un nodo sin dato.
     */
    public BinaryTreeNode() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructor que inicializa un nodo con un dato.
     *
     * @param value El valor almacenado en el nodo.
     */
    public BinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Establece el valor del nodo al valor recibido del parametro
     *
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Obtiene el valor del nodo
     *
     * @return value
     */
    public T getValue() {
        return value;
    }

    /**
     * Establece el nodo recibido del parametro como nodo izquierdo
     *
     * @param left
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Obtiene el nodo que se encuentra a la izquierda
     *
     * @return left
     */
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    /**
     * Establece el nodo recibido del paremtro como nodo derecho
     *
     * @param right
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Obtiene el nodo que se encuentra a la derecha
     *
     * @return right
     */
    public BinaryTreeNode<T> getRight() {
        return right;
    }
}
