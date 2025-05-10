/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import structures.BinarySearchTree;
import exceptions.TreeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase BinarySearchTree.
 *
 * @author Cortez, Manuel;
 */
public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> arbol;

    @BeforeEach
    public void setUp() {
        arbol = new BinarySearchTree<>();
    }

    @Test
    public void testArbolVacio() {
        assertTrue(arbol.isEmpty());
        assertThrows(TreeException.class, () -> arbol.firstEntry());
        assertThrows(TreeException.class, () -> arbol.lastEntry());
    }

    @Test
    public void testInsertYContains() {
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        assertFalse(arbol.isEmpty());
        assertTrue(arbol.contains(50));
        assertTrue(arbol.contains(30));
        assertTrue(arbol.contains(70));
        assertTrue(arbol.contains(20));
        assertTrue(arbol.contains(40));
        assertTrue(arbol.contains(60));
        assertTrue(arbol.contains(80));
        assertFalse(arbol.contains(100));
    }

    @Test
    public void testFirstAndLastEntry() {
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        assertEquals(20, arbol.firstEntry());
        assertEquals(80, arbol.lastEntry());
    }

    @Test
    public void testGet() {
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        assertEquals(50, arbol.get(50));
        assertEquals(30, arbol.get(30));
        assertEquals(70, arbol.get(70));
        assertEquals(20, arbol.get(20));
        assertEquals(40, arbol.get(40));
        assertEquals(60, arbol.get(60));
        assertEquals(80, arbol.get(80));
        assertThrows(TreeException.class, () -> arbol.get(100));
    }

    @Test
    public void testRemove() {
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        arbol.remove(20);
        assertFalse(arbol.contains(20));
        arbol.remove(30);
        assertFalse(arbol.contains(30));
        assertTrue(arbol.contains(40));
        arbol.remove(50);
        assertFalse(arbol.contains(50));
        assertTrue(arbol.contains(40));
        assertTrue(arbol.contains(60));
        assertTrue(arbol.contains(70));
        assertTrue(arbol.contains(80));
    }
}