package structures;
import components.Student;
import interfaces.Identificable;
import structures.exceptions.TreeException;
import structures.nodes.AVLTreeNode;

/**
 * Clase genérica que representa un Árbol AVL. Proporciona inserción,
 * eliminación y balanceo automático de nodos.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 *
 * @param <T> el tipo de dato que se almacenará, debe ser comparable
 */
public class AVLTree<T extends Identificable> {
    private AVLTreeNode<T> raiz;
    private int altura;

    /**
     * Inserta un dato en el árbol AVL.
     *
     * @param dato el dato a insertar
     */
    public void insert(T dato) {
        raiz = insert(raiz, dato);
    }

    private AVLTreeNode<T> insert(AVLTreeNode<T> nodo, T dato) {
        if (nodo == null) {
            return new AVLTreeNode<>(dato);
        }
        int cmp = dato.getAverage().compareTo(nodo.getValue().getAverage());
        if (cmp < 0) {
            nodo.setLeft(insert(nodo.getLeft(), dato));
        } else if (cmp > 0) {
            nodo.setRight(insert(nodo.getRight(), dato));
        } else {
            throw new TreeException("Elemento duplicado");
        }
        return balancear(nodo);
    }

    /**
     * Elimina un dato del árbol AVL.
     *
     * @param dato el dato a eliminar
     */
    public void remove(T dato) {
        raiz = remove(raiz, dato);
    }

    /**
     * @param nodo
     * @param dato
     * @return
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> nodo, T dato) {
        if (nodo == null) {
            throw new TreeException("Elemento no encontrado");
        }
        int cmp = dato.compareTo(nodo.getValue());
        if (cmp < 0) {
            nodo.setLeft(remove(nodo.getLeft(), dato));
        } else if (cmp > 0) {
            nodo.setRight(remove(nodo.getRight(), dato));
        } else {
            if (nodo.getLeft() == null) {
                return nodo.getRight();
            }
            if (nodo.getRight() == null) {
                return nodo.getLeft();
            }
            AVLTreeNode<T> sucesor = obtenerMinimo(nodo.getRight());
            nodo.setValue(sucesor.getValue());
            nodo.setRight(remove(nodo.getRight(), sucesor.getValue()));
        }
        return balancear(nodo);
    }

    /**
     * @param nodo
     * @return
     */
    private AVLTreeNode<T> obtenerMinimo(AVLTreeNode<T> nodo) {
        while (nodo.getLeft() != null) {
            nodo = nodo.getLeft();
        }
        return nodo;
    }

    /**
     * @param nodo
     * @return
     */
    private AVLTreeNode<T> balancear(AVLTreeNode<T> nodo) {
        actualizarAltura(nodo);
        int balance = obtenerBalance(nodo);
        if (balance > 1) {
            if (obtenerBalance(nodo.getLeft()) < 0) {
                nodo.setLeft(rotarIzquierda(nodo.getLeft()));
            }
            return rotarDerecha(nodo);
        }
        if (balance < -1) {
            if (obtenerBalance(nodo.getRight()) > 0) {
                nodo.setRight(rotarDerecha(nodo.getRight()));
            }
            return rotarIzquierda(nodo);
        }
        return nodo;
    }

    /**
     * @param nodo
     */
    private void actualizarAltura(AVLTreeNode<T> nodo) {
        int izquierdaAltura = altura(nodo.getLeft());
        int derechaAltura = altura(nodo.getRight());
        nodo.setHeight(1 + Math.max(izquierdaAltura, derechaAltura));
    }

    /**
     * @param nodo
     * @return
     */
    private int altura(AVLTreeNode<T> nodo) {
        return nodo == null ? 0 : nodo.getHeight();
    }

    /**
     * @param nodo
     * @return
     */
    private int obtenerBalance(AVLTreeNode<T> nodo) {
        return nodo == null ? 0 : altura(nodo.getLeft()) - altura(nodo.getRight());
    }

    /**
     * @param y
     * @return
     */
    private AVLTreeNode<T> rotarDerecha(AVLTreeNode<T> y) {
        AVLTreeNode<T> x = y.getLeft();
        AVLTreeNode<T> T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        actualizarAltura(y);
        actualizarAltura(x);
        return x;
    }

    /**
     * @param x
     * @return
     */
    private AVLTreeNode<T> rotarIzquierda(AVLTreeNode<T> x) {
        AVLTreeNode<T> y = x.getRight();
        AVLTreeNode<T> T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        actualizarAltura(x);
        actualizarAltura(y);
        return y;
    }

    /**
     * Verifica si el árbol está vacío.
     *
     * @return true si el árbol está vacío, false en caso contrario
     */
    public boolean isEmpty() {
        return raiz == null;
    }

    /**
     * Devuelve la raíz del árbol (solo para pruebas).
     *
     * @return la raíz
     */
    public AVLTreeNode<T> getRaiz() {
        return raiz;
    }

    /**
     *
     */
    public void listInOrder() {
        inOrder(raiz);
    }

    /**
     * @param node
     */
    public void inOrder(AVLTreeNode<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getValue());
            inOrder(node.getRight());
        }
    }

    /**
     * @return
     */
    public ArrayList<Student> listInOrderToArrayList() {
        ArrayList<Student> students = new ArrayList<>(10);
        return inOrderToArrayList(raiz, students);
    }

    /**
     * @param node
     * @return
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
