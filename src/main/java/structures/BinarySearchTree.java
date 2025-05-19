/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import components.Student;
import structures.exceptions.TreeException;
import structures.nodes.BinaryTreeNode;
import interfaces.Identificable;

import javax.swing.*;

/**
 * Implementación de un árbol binario de búsqueda genérico que almacena
 * elementos ordenados. Los elementos deben implementar la interfaz Comparable
 * para permitir la comparación.
 *
 * @param <T> el tipo de elementos almacenados en el árbol, debe implementar
 * Comparable<T>
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class BinarySearchTree<T extends Identificable> {

    public BinaryTreeNode<T> root;

    /**
     * Constructor que inicializa un árbol binario de búsqueda vacío.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Encuentra el nodo con el dato más grande en el subárbol del nodo dado.
     *
     * @param node el nodo raíz del subárbol a buscar
     * @return el nodo con el dato más grande, o null si el subárbol está vacío
     */
    private BinaryTreeNode<T> findBiggestNode(BinaryTreeNode<T> node) {
        if (node == null) {
            throw new TreeException("El arbol esta vacío");
        }
        BinaryTreeNode<T> actual = node;
        while (actual.getRight() != null) {
            actual = actual.getRight();
        }
        return actual;
    }

    /**
     * Obtiene el dato más pequeño en el árbol.
     *
     * @return el dato más pequeño en el árbol
     * @throws TreeException si el árbol está vacío
     */
    public T firstEntry() {
        if (root == null) {
            throw new TreeException("El arbol esta vacío");
        }
        BinaryTreeNode<T> actual = root;
        while (actual.getLeft() != null) {
            actual = actual.getLeft();
        }
        return actual.getValue();
    }

    /**
     * Obtiene el dato más grande en el árbol.
     *
     * @return el dato más grande en el árbol
     * @throws TreeException si el árbol está vacío
     */
    public T lastEntry() {
        if (root == null) {
            throw new TreeException("El árbol está vacío");
        }
        BinaryTreeNode<T> bigger = findBiggestNode(root);
        return bigger.getValue();
    }

    /**
     * Busca un dato en el árbol y lo devuelve si se encuentra.
     *
     * @param id el dato a buscar en el árbol
     * @return el dato encontrado en el árbol
     * @throws TreeException si el dato no se encuentra en el árbol o es null
     */
    public T get(String id) {
        if (id == null) {
            throw new TreeException("El dato no puede ser nulo");
        }
        return get(root, id);
    }

    /**
     * Método recursivo auxiliar para buscar un dato en el árbol.
     *
     * @param node el nodo actual en la búsqueda recursiva
     * @param id el dato a buscar
     * @return el dato encontrado
     * @throws TreeException si el dato no se encuentra en el subárbol
     */
    private T get(BinaryTreeNode<T> node, String id) {
        if (node == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        int comparation = id.compareTo(node.getValue().getId());
        if (comparation == 0) {
            return node.getValue();
        } else if (comparation < 0) {
            return get(node.getLeft(), id);
        } else {
            return get(node.getRight(), id);
        }
    }

    /**
     * Verifica si el árbol está vacío.
     *
     * @return true si el árbol no contiene nodos, false en caso contrario
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Inserta un nuevo dato en el árbol manteniendo el orden.
     *
     * @param data el dato a insertar en el árbol
     * @throws TreeException si el dato a insertar es null
     */
    public void insert(T data) {
        if (data == null) {
            throw new TreeException("El dato no puede ser nulo");
        }
        root = insert(root, data);
    }

    /**
     * Método recursivo auxiliar para insertar un dato en el árbol.
     *
     * @param node el nodo actual en la inserción recursiva
     * @param data el dato a insertar
     * @return el nodo modificado con el nuevo dato insertado
     */
    public BinaryTreeNode<T> insert(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return new BinaryTreeNode<>(data);
        }
        int comparation = data.compareTo(node.getValue());
        if (comparation < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (comparation > 0) {
            node.setRight(insert(node.getRight(), data));
        }
        return node;
    }

    /**
     * Verifica si un dato existe en el árbol.
     *
     * @param id el dato a buscar
     * @return true si el dato existe en el árbol, false en caso contrario
     */
    public boolean contains(String id) {
        try {
            get(id);
        } catch (TreeException e) {
            return false;
        }
        return true;
    }

    /**
     * Elimina un dato del árbol manteniendo la estructura de árbol binario de
     * búsqueda.
     *
     * @param data el dato a eliminar del árbol
     */
    public void remove(T data) {
        root = remove(root, data);
    }

    /**
     * Método recursivo auxiliar para eliminar un dato del árbol.
     *
     * @param node el nodo actual en la eliminación recursiva
     * @param data el dato a eliminar
     * @return el nodo modificado con el dato eliminado
     */
    private BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T data) {
        if (node == null) {
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
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            BinaryTreeNode<T> succesor = findBiggestNode(node.getLeft());
            node.setValue(succesor.getValue());
            node.setLeft(remove(node.getLeft(), succesor.getValue()));
        }
        return node;
    }

    /**
     * Devuelve la raíz del árbol (solo para pruebas).
     *
     * @return root la raíz a devolver
     */
    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    /**
     * Imprime los elementos del arbol en orden "In-order" (izquierda, raiz,
     * derecha)
     */
    public void listInOrder() {
        inOrder(root);
    }

    /**
     * Recorre el arbol en orden "In-order" (izquierda, raiz, derecha) e imprime
     * el valor de cada uno de los nodos
     *
     * @param node
     */
    public void inOrder(BinaryTreeNode<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getValue());
            inOrder(node.getRight());
        }
    }

    /**
     * Recorre el árbol en orden "in-order" y retorna una lista ArrayList con
     * los elementos del árbol convertidos a objetos Student
     *
     * @return ArrayList<Student> lista con los estudiantes
     */
    public ArrayList<Student> listInOrderToArrayList() {
        ArrayList<Student> students = new ArrayList<>(10);
        return inOrderToArrayList(root, students);
    }

    /**
     * Metodo auxiliar recursivo que recorre el arbol "In-order" y agrega los
     * valores de tipo Student a una lista ArrayList
     *
     * @param node nodo actual en el que se realiza el recorrido
     * @return students estudiantes
     */
    private ArrayList<Student> inOrderToArrayList(BinaryTreeNode<T> node, ArrayList<Student> students) {
        if (node == null) {
            return students;
        }
        inOrderToArrayList(node.getLeft(), students);
        students.add((Student) node.getValue());
        inOrderToArrayList(node.getRight(), students);
        return students;
    }
}
