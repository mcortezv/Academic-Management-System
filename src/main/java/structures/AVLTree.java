/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import components.Student;
import interfaces.Identificable;
import structures.nodes.AVLTreeNode;

import javax.swing.*;

/**
 * Clase genérica que representa un Árbol AVL. Proporciona inserción,
 * eliminación y balanceo automático de nodos.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 *
 * @param <T> el tipo de dato que se almacenará, debe ser comparable
 */
public class AVLTree<T extends Identificable> {

    private AVLTreeNode<T> root;
    private int height;

    /**
     * Inserta un dato en el árbol AVL.
     *
     * @param data el dato a insertar
     */
    public void insert(T data) {
        root = insert(root, data);
    }

    /**
     * Metodo recursivo auxiliar que inserta un nuevo nodo en el arbol AVL,
     * manteniendo el balance
     *
     * @param node nodo a insertar
     * @param data el dato a insertar en el nodo
     * @return la nueva raiz del arbol balanceado
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> node, T data) {
        if (node == null) {
            return new AVLTreeNode<>(data);
        }
        int cmp = data.getAverage().compareTo(node.getValue().getAverage());
        if (cmp > 0 || cmp == 0) {
            node.setRight(insert(node.getRight(), data));
        } else {
            node.setLeft(insert(node.getLeft(), data));
        }
        return balance(node);
    }

    /**
     * Elimina un dato del árbol AVL.
     *
     * @param data el dato a eliminar
     */
    public void remove(T data) {
        root = remove(root, data);
    }

    /**
     * Metodo recursivo para eliminar un nodo en el arbol AVL Muestra un mensje
     * si el dato no es encontrado
     *
     * @param node el nodo actual
     * @param data el dato a eliminar
     * @return la nueva raiz del subarbol balanceado
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> node, T data) {
        if (node == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int comparation = data.compareTo(node.getValue());
        if (comparation < 0) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (comparation > 0) {
            node.setRight(remove(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            AVLTreeNode<T> succesor = getMinimum(node.getRight());
            node.setValue(succesor.getValue());
            node.setRight(remove(node.getRight(), succesor.getValue()));
        }
        return balance(node);
    }

    /**
     * Obtiene el nodo con el valor minimo en el arbol
     *
     * @param node la raiz del subarbol
     * @return node nodo con el valor minimo
     */
    private AVLTreeNode<T> getMinimum(AVLTreeNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Realiza el balanceo de arbol AVL si su factor de equilibro es incorrecto
     *
     * @param node la raiz del arbol a balancear
     * @return node la lueva raiz del subarbol balanceado
     */
    private AVLTreeNode<T> balance(AVLTreeNode<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (getBalance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (getBalance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    /**
     * Actualiza la altura del nodo basandose en sus nodos hijos
     *
     * @param node el nodo al que se le actualiza la latura
     */
    private void updateHeight(AVLTreeNode<T> node) {
        int izquierdaAltura = height(node.getLeft());
        int derechaAltura = height(node.getRight());
        node.setHeight(1 + Math.max(izquierdaAltura, derechaAltura));
    }

    /**
     * Obtiene la altura del nodo
     *
     * @param node el nodo cuya altura se desea conocer
     * @return la altura del nodo, si es 0 devuelve null
     */
    private int height(AVLTreeNode<T> node) {
        return node == null ? 0 : node.getHeight();
    }

    /**
     * Calcula el factor de balance de un nodo
     *
     * @param node el nodo al que se le calcula el balance
     * @return la diferencia de altura entre el subarbol izquierdo y derecho
     */
    private int getBalance(AVLTreeNode<T> node) {
        return node == null ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    /**
     * Realiza una rotacion simple a la derecha
     *
     * @param y el nodo desequilibrado
     * @return el nuevo nodo raiz del subarbol tras la rotacion
     */
    private AVLTreeNode<T> rotateRight(AVLTreeNode<T> y) {
        AVLTreeNode<T> x = y.getLeft();
        AVLTreeNode<T> T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     * Realiza una rotacion simple a la izquierda
     *
     * @param x el nodo desequilibrado
     * @return el nuevo nodo raiz del subarbol tras la rotacion
     */
    private AVLTreeNode<T> rotateLeft(AVLTreeNode<T> x) {
        AVLTreeNode<T> y = x.getRight();
        AVLTreeNode<T> T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    /**
     * Verifica si el árbol está vacío.
     *
     * @return true si el árbol está vacío, false en caso contrario
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Elimina todos los elementos del arbol dejandolo vacio
     */
    public void clear() {
        root = null;
    }

    /**
     * Devuelve la raíz del árbol (solo para pruebas).
     *
     * @return la raíz del arbol
     */
    public AVLTreeNode<T> getRoot() {
        return root;
    }

    /**
     * Imprime los elementos del arbol en recorrido "In-Order" (izquierda, raiz,
     * derecha)
     */
    public void listInOrder() {
        inOrder(root);
    }

    /**
     * Metodo recursivo que imprime los elementos del arbol en orden "In-Order"
     *
     * @param node el nodo actual desde el cual iniciar el recorrido
     */
    public void inOrder(AVLTreeNode<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getValue());
            inOrder(node.getRight());
        }
    }

    /**
     * Devuelve una lista Arraylist con los elementos del arbol del tipo Student
     * en orden "In-Order"
     *
     * @return la lista de estudiantes
     */
    public ArrayList<Student> listInOrderToArrayList() {
        ArrayList<Student> students = new ArrayList<>(10);
        return inOrderToArrayList(root, students);
    }

    /**
     * Metodo auxiliar recursivo que agrega los valores del arbol a una lista
     * ArrayList con los elementos del tipo Student en orden "In-Order"
     *
     * @param node el nodo actual
     * @return la lista con los estudiantes
     */
    private ArrayList<Student> inOrderToArrayList(AVLTreeNode<T> node, ArrayList<Student> students) {
        if (node != null) {
            inOrderToArrayList(node.getLeft(), students);
            students.add((Student) node.getValue());
            inOrderToArrayList(node.getRight(), students);
        }
        return students;
    }
}
