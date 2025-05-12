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
public class AVLTreeNode<T> {

    private T value;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;
    private int height;

    /**
     * Constructor que inicializa el nodo con un dato.
     *
     * @param value el dato a almacenar en el nodo
     */
    public AVLTreeNode(T value) {
        this.value = value;
    }

    /**
     * Establece el dato del nodo.
     *
     * @param value el nuevo dato a almacenar
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Devuelve el dato almacenado en el nodo.
     *
     * @return el dato del nodo
     */
    public T getValue() {
        return value;
    }

    /**
     * Establece el nodo hijo izquierdo.
     *
     * @param left la referencia al nodo izquierdo
     */
    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Devuelve la referencia al nodo hijo izquierdo.
     *
     * @return el nodo izquierdo
     */
    public AVLTreeNode<T> getLeft() {
        return left;
    }

    /**
     * Establece el nodo hijo derecho.
     *
     * @param right la referencia al nodo derecho
     */
    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Devuelve la referencia al nodo hijo derecho.
     *
     * @return right el nodo derecho
     */
    public AVLTreeNode<T> getRight() {
        return right;
    }

    /**
     * Devuelve la altura del nodo en especifico.
     *
     * @return height int
     */
    public int getHeight() {
        return height;
    }

    /**
     * Establece la altura del nodo en especifico.
     *
     * @param height int
     */
    public void setHeight(int height) {
        this.height = height;
    }
}
