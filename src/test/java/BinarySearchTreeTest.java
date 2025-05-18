/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import components.Contact;
import components.Student;
import structures.BinarySearchTree;
import structures.exceptions.TreeException;
import persistences.PersistenceGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase BinarySearchTree.
 *
 * @author Cortez, Manuel;
 */
public class BinarySearchTreeTest {
    private BinarySearchTree<Student> arbol;
    private Contact datosContacto;
    private PersistenceGrades grades;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;

    @BeforeEach
    public void setUp() {
        arbol = new BinarySearchTree<>();
        datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        student1 = new Student("Escalante Sebastian", datosContacto);
        student1.setId("ABC100");

        student2 = new Student("Escalante Sebastian", datosContacto);
        student2.setId("ABC200");

        student3 = new Student("Escalante Sebastian", datosContacto);
        student3.setId("ABC300");

        student4 = new Student("Escalante Sebastian", datosContacto);
        student4.setId("ABC400");

        student5 = new Student("Escalante Sebastian", datosContacto);
        student5.setId("ABC500");
    }

    @Test
    public void testArbolVacio() {
        assertTrue(arbol.isEmpty());
        assertThrows(TreeException.class, () -> arbol.firstEntry());
        assertThrows(TreeException.class, () -> arbol.lastEntry());
    }

    @Test
    public void testInsertYContains() {
        arbol.insert(student1);
        arbol.insert(student2);
        arbol.insert(student3);
        arbol.insert(student4);
        arbol.insert(student5);
        assertFalse(arbol.isEmpty());
        assertTrue(arbol.contains(student1));
        assertTrue(arbol.contains(student2));
        assertTrue(arbol.contains(student3));
        assertTrue(arbol.contains(student4));
        assertTrue(arbol.contains(student5));
    }

    @Test
    public void testFirstAndLastEntry() {
        arbol.insert(student1);
        arbol.insert(student2);
        arbol.insert(student3);
        arbol.insert(student4);
        arbol.insert(student5);
        assertEquals(student1, arbol.firstEntry());
        assertEquals(student5, arbol.lastEntry());
    }

    @Test
    public void testGet() {
        arbol.insert(student1);
        arbol.insert(student2);
        arbol.insert(student3);
        arbol.insert(student4);
        assertEquals(student1, arbol.get(student1));
        assertEquals(student2, arbol.get(student2));
        assertEquals(student3, arbol.get(student3));
        assertEquals(student4, arbol.get(student4));

        assertThrows(TreeException.class, () -> arbol.get(student5));
    }

    @Test
    public void testRemove() {
        arbol.insert(student1);
        arbol.insert(student2);
        arbol.insert(student3);
        arbol.insert(student4);
        arbol.insert(student5);
        arbol.remove(student5);
        assertFalse(arbol.contains(student5));
        arbol.remove(student1);
        assertFalse(arbol.contains(student1));
        assertTrue(arbol.contains(student2));
        arbol.remove(student2);
        assertFalse(arbol.contains(student2));
        assertTrue(arbol.contains(student3));
        assertTrue(arbol.contains(student3));
    }
}