/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import exceptions.TreeException;
import nodes.BinaryTreeNode;
import commun.Identificable;

/**
 * Implementación de un árbol binario de búsqueda genérico que almacena elementos ordenados.
 * Los elementos deben implementar la interfaz Comparable para permitir la comparación.
 *
 * @param <T> el tipo de elementos almacenados en el árbol, debe implementar Comparable<T>
 * @author Cortez, Manuel
 */
public class BinarySearchTree<T extends Identificable> {
    public BinaryTreeNode<T> raiz;

    /**
     * Constructor que inicializa un árbol binario de búsqueda vacío.
     */
    public BinarySearchTree() {
        raiz = null;
    }

    /**
     * Encuentra el nodo con el dato más grande en el subárbol del nodo dado.
     *
     * @param nodo el nodo raíz del subárbol a buscar
     * @return el nodo con el dato más grande, o null si el subárbol está vacío
     */
    private BinaryTreeNode<T> findBiggestNode(BinaryTreeNode<T> nodo) {
        if (nodo == null) {
            return null;
        }
        BinaryTreeNode<T> actual = nodo;
        while (actual.getLeft() != null) {
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
        if (raiz == null) {
            throw new TreeException("El arbol esta vacío");
        }
        BinaryTreeNode<T> actual = raiz;
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
        if (raiz == null) {
            throw new TreeException("El árbol está vacío");
        }
        BinaryTreeNode<T> mayor = findBiggestNode(raiz);
        return mayor.getValue();
    }

    /**
     * Busca un dato en el árbol y lo devuelve si se encuentra.
     *
     * @param dato el dato a buscar en el árbol
     * @return el dato encontrado en el árbol
     * @throws TreeException si el dato no se encuentra en el árbol o es null
     */
    public T get(T dato) {
        if (dato == null) {
            throw new TreeException("El dato no puede ser nulo");
        }
        return get(raiz, dato);
    }

    /**
     * Método recursivo auxiliar para buscar un dato en el árbol.
     *
     * @param nodo el nodo actual en la búsqueda recursiva
     * @param dato el dato a buscar
     * @return el dato encontrado
     * @throws TreeException si el dato no se encuentra en el subárbol
     */
    private T get(BinaryTreeNode<T> nodo, T dato) {
        if (nodo == null) {
            throw new TreeException("Dato no encontrado en el árbol");
        }
        int comparacion = dato.compareTo(nodo.getValue());
        if (comparacion == 0) {
            return nodo.getValue();
        } else if (comparacion < 0) {
            return get(nodo.getLeft(), dato);
        } else {
            return get(nodo.getRight(), dato);
        }
    }

    /**
     * Verifica si el árbol está vacío.
     *
     * @return true si el árbol no contiene nodos, false en caso contrario
     */
    public boolean isEmpty() {
        return raiz == null;
    }

    /**
     * Inserta un nuevo dato en el árbol manteniendo el orden.
     *
     * @param dato el dato a insertar en el árbol
     * @throws TreeException si el dato a insertar es null
     */
    public void insert(T dato) {
        if (dato == null) {
            throw new TreeException("El dato no puede ser nulo");
        }
        raiz = insert(raiz, dato);
    }

    /**
     * Método recursivo auxiliar para insertar un dato en el árbol.
     *
     * @param nodo el nodo actual en la inserción recursiva
     * @param dato el dato a insertar
     * @return el nodo modificado con el nuevo dato insertado
     */
    public BinaryTreeNode<T> insert(BinaryTreeNode<T> nodo, T dato) {
        if (nodo == null) {
            return new BinaryTreeNode<T>(dato);
        }
        int comparacion = dato.compareTo(nodo.getValue());
        if (comparacion < 0) {
            nodo.setLeft(insert(nodo.getLeft(), dato));
        } else if (comparacion > 0) {
            nodo.setRight(insert(nodo.getRight(), dato));
        }
        return nodo;
    }

    /**
     * Verifica si un dato existe en el árbol.
     *
     * @param dato el dato a buscar
     * @return true si el dato existe en el árbol, false en caso contrario
     */
    public boolean contains(T dato) {
        try {
            get(dato);
        } catch (TreeException e) {
            return false;
        }
        return true;
    }

    /**
     * Elimina un dato del árbol manteniendo la estructura de árbol binario de búsqueda.
     *
     * @param dato el dato a eliminar del árbol
     */
    public void remove(T dato) {
        raiz = remove(raiz, dato);
    }

    /**
     * Método recursivo auxiliar para eliminar un dato del árbol.
     *
     * @param nodo el nodo actual en la eliminación recursiva
     * @param dato el dato a eliminar
     * @return el nodo modificado con el dato eliminado
     */
    private BinaryTreeNode<T> remove(BinaryTreeNode<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }
        int comparacion = dato.compareTo(nodo.getValue());
        if (comparacion < 0) {
            nodo.setLeft(remove(nodo.getLeft(), dato));
        } else if (comparacion > 0) {
            nodo.setRight(remove(nodo.getRight(), dato));
        } else {
            if (nodo.getLeft() == null) {
                return nodo.getRight();
            } else if (nodo.getRight() == null) {
                return nodo.getLeft();
            }
            BinaryTreeNode<T> sucesor = findBiggestNode(nodo.getLeft());
            nodo.setValue(sucesor.getValue());
            nodo.setLeft(remove(nodo.getLeft(), sucesor.getValue()));
        }
        return nodo;
    }
}