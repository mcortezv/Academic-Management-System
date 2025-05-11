/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import components.Contact;
import components.Role;
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
    private Role rol;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;    
    
    @BeforeEach
    public void setUp() {
        arbol = new BinarySearchTree<>();
        datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        grades = new PersistenceGrades();
        student1 = new Student("ABC100", "Escalante Sebastian", datosContacto, grades, rol);
        student2 = new Student("ABC200", "Escalante Sebastian", datosContacto, grades, rol);
        student3 = new Student("ABC300", "Escalante Sebastian", datosContacto, grades, rol);
        student4 = new Student("ABC400", "Escalante Sebastian", datosContacto, grades, rol);
        student5 = new Student("ABC500", "Escalante Sebastian", datosContacto, grades, rol);
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