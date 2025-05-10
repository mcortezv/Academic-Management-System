/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import exceptions.TreeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase AVLTree con enteros.
 *
 * @author Cortez, Manuel;
 */
public class AVLTreeTest {

    @Test
    public void testInsertarYEliminar() {
        AVLTree<Integer> arbol = new AVLTree<>();
        arbol.insert(30);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(10);
        assertFalse(arbol.isEmpty());
        arbol.remove(20);
        assertThrows(TreeException.class, () -> arbol.remove(20));
    }

    @Test
    public void testEliminarRaiz() {
        AVLTree<Integer> arbol = new AVLTree<>();
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.remove(50);
        assertNotNull(arbol.getRaiz());
        assertNotEquals(50, arbol.getRaiz().getValue());
    }

    @Test
    public void testExcepcionInsertarDuplicado() {
        AVLTree<Integer> arbol = new AVLTree<>();
        arbol.insert(10);
        assertThrows(TreeException.class, () -> arbol.insert(10));
    }

    @Test
    public void testExcepcionEliminarInexistente() {
        AVLTree<Integer> arbol = new AVLTree<>();
        arbol.insert(5);
        assertThrows(TreeException.class, () -> arbol.remove(100));
    }
}