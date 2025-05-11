/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.nodes;

/**
 * Clase que representa un nodo de un Arbol.
 * @param <T> Tipo de dato almacenado en el nodo.
 *
 * @author Cortez, Manuel;
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
     * @param value El valor almacenado en el nodo.
     */
    public BinaryTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setLeft(BinaryTreeNode<T> left){
        this.left = left;
    }

    public BinaryTreeNode<T> getLeft(){
        return left;
    }

    public void setRight(BinaryTreeNode<T> right){
        this.right = right;
    }

    public BinaryTreeNode<T> getRight(){
        return right;
    }
}