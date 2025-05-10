/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nodes;

/**
 * Clase que representa un nodo de un Arbol.
 * @param <T> Tipo de dato almacenado en el nodo.
 *
 * @author Cortez, Manuel;
 */
public class AVLTreeNode<T> {
    private T value;
    private AVLTreeNode<T> left;
    private AVLTreeNode<T> right;
    private int altura;

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
     * @return el nodo derecho
     */
    public AVLTreeNode<T> getRight() {
        return right;
    }

    /**
     * Devuelve la altura del nodo en especifico.
     *
     * @return altura int
     */
    public int getAltura() { return altura; }

    /**
     * Establece la altura del nodo en especifico.
     *
     * @param altura int
     */
    public void setAltura(int altura) { this.altura = altura; }
}