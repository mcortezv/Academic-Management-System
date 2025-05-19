/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import components.Contact;
import components.Student;
import org.junit.jupiter.api.BeforeEach;
import persistences.PersistenceGrades;
import structures.AVLTree;
import structures.BinarySearchTree;
import structures.exceptions.TreeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase AVLTree con enteros.
 *
 * @author Cortez, Manuel;
 */
public class AVLTreeTest {
    private Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
    private Student student1 = new Student("Escalante Sebastian", datosContacto);
    private Student student2 = new Student("Escalante Sebastian", datosContacto);
    private Student student3 = new Student("Escalante Sebastian", datosContacto);
    private Student student4 = new Student("Escalante Sebastian", datosContacto);
    private Student student5 = new Student("Escalante Sebastian", datosContacto);


    @BeforeEach
    public void setUp() {
        student1.setId("ABC100");
        student2.setId("ABC200");
        student3.setId("ABC300");
        student4.setId("ABC400");
        student5.setId("ABC500");
        student1.addGrade(10.0);
        student2.addGrade(9.0);
        student3.addGrade(8.0);
        student4.addGrade(7.0);
        student5.addGrade(6.0);
    }

    @Test
    public void testInsertarYEliminar() {
        AVLTree<Student> arbol = new AVLTree<>();
        arbol.insert(student1);
        arbol.insert(student2);
        arbol.insert(student3);
        arbol.insert(student4);
        assertFalse(arbol.isEmpty());
        arbol.remove(student1);
        assertThrows(TreeException.class, () -> arbol.remove(student1));
    }

    @Test
    public void testEliminarRaiz() {
        AVLTree<Student> arbol = new AVLTree<>();
        arbol.insert(student1);
        arbol.insert(student2);
        arbol.insert(student3);
        arbol.remove(student4);
        assertNotNull(arbol.getRoot());
        assertNotEquals(student1, arbol.getRoot().getValue());
    }

    @Test
    public void testExcepcionInsertarDuplicado() {
        AVLTree<Student> arbol = new AVLTree<>();
        arbol.insert(student1);
        assertThrows(TreeException.class, () -> arbol.insert(student1));
    }

    @Test
    public void testExcepcionEliminarInexistente() {
        AVLTree<Student> arbol = new AVLTree<>();
        arbol.insert(student5);
        assertThrows(TreeException.class, () -> arbol.remove(student1));
    }
}