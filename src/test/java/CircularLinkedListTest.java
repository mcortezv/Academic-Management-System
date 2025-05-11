/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import structures.CircularLinkedList;
import structures.exceptions.ListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class CircularLinkedListTest {
    private CircularLinkedList<Integer> listaInteger;
    private CircularLinkedList<String> listaString;

    @BeforeEach
    void setUp() {
        listaInteger = new CircularLinkedList<>();
        listaString = new CircularLinkedList<>();
    }

    @Test
    void PruebaMetodoSetFuncionaCorrectamenteInteger() {
        listaInteger.add(10);
        listaInteger.add(20);
        listaInteger.add(30);
        assertEquals(0, listaInteger.indexOf(10));
        assertEquals(1, listaInteger.indexOf(20));
        assertEquals(2, listaInteger.indexOf(30));
    }

    @Test
    void PruebaMetodoSetFuncionaCorrectamenteString() {
        listaString.add("Manuel");
        listaString.add("Cortez");
        assertEquals(0, listaString.indexOf("Manuel"));
        assertEquals(1, listaString.indexOf("Cortez"));
    }

    @Test
    void PruebaMetodoSetConIndiceFuncionaCorrectamenteInteger() {
        listaInteger.add(10);
        listaInteger.add(20);
        listaInteger.set(30, 1);
        assertEquals(1, listaInteger.indexOf(30));
        assertEquals(2, listaInteger.indexOf(20));
    }

    @Test
    void PruebaMetodoSetConIndiceFuncionaCorrectamenteString() {
        listaString.add("Manuel");
        listaString.add("Cortez");
        listaString.set("Villa", 1);
        assertEquals(1, listaString.indexOf("Villa"));
        assertEquals(2, listaString.indexOf("Cortez"));
    }

    @Test
    void PruebaMetodoRemoveFuncionaCorrectamenteInteger() {
        listaInteger.add(10);
        listaInteger.add(20);
        listaInteger.add(30);
        assertTrue(listaInteger.remove(10));
        assertEquals(-1, listaInteger.indexOf(10));
        assertTrue(listaInteger.remove(30));
        assertEquals(-1, listaInteger.indexOf(30));
        assertTrue(listaInteger.remove(20));
        assertEquals(-1, listaInteger.indexOf(20));
        assertFalse(listaInteger.remove(40));
    }

    @Test
    void PruebaMetodoRemoveFuncionaCorrectamenteString() {
        listaString.add("Manuel");
        listaString.add("Cortez");
        listaString.add("Villa");
        assertTrue(listaString.remove("Manuel"));
        assertEquals(-1, listaString.indexOf("Manuel"));
        assertTrue(listaString.remove("Villa"));
        assertEquals(-1, listaString.indexOf("Villa"));
        assertTrue(listaString.remove("Cortez"));
        assertEquals(-1, listaString.indexOf("Cortez"));
        assertFalse(listaString.remove("No existe"));
    }

    @Test
    void PruebaMetodoIndexOfFuncionaCorrectamenteInteger() {
        listaInteger.add(10);
        listaInteger.add(20);
        listaInteger.add(30);
        assertEquals(0, listaInteger.indexOf(10));
        assertEquals(1, listaInteger.indexOf(20));
        assertEquals(2, listaInteger.indexOf(30));
    }

    @Test
    void PruebaMetodoIndexOfFuncionaCorrectamenteString() {
        listaString.add("Manuel");
        listaString.add("Cortez");
        listaString.add("Villa");
        assertEquals(0, listaString.indexOf("Manuel"));
        assertEquals(1, listaString.indexOf("Cortez"));
        assertEquals(2, listaString.indexOf("Villa"));
    }

    @Test
    void PruebaMetodoSetAtConIndiceInvalidoLanzaExepcion() {
        Exception ex1 = assertThrows(ListException.class, () -> listaInteger.set(10, 5));
        assertEquals(ex1.getMessage(), "Indice fuera del rango");
        Exception ex2 = assertThrows(ListException.class, () -> listaString.set("Texto", -1));
        assertEquals(ex2.getMessage(), "Indice fuera del rango");
    }

    @Test
    void PruebaMetodoClearFuncionaCorrectamente() {
        listaInteger.add(10);
        listaInteger.add(20);
        listaInteger.add(30);
        listaInteger.clear();
        assertEquals(-1, listaInteger.indexOf(10));
        assertEquals(-1, listaInteger.indexOf(20));
        assertEquals(-1, listaInteger.indexOf(30));
    }

    @Test
    void PruebaMetodoSetListaVaciaFuncionaCorrectamente() {
        listaInteger.add(100);
        assertEquals(0, listaInteger.indexOf(100));
    }

    @Test
    void PruebaMetodoRemoveUltimoObjetoFuncionaCorrectamenteString() {
        listaString.add("Hola");
        assertTrue(listaString.remove("Hola"));
        assertEquals(-1, listaString.indexOf("Hola"));
    }

    @Test
    void PruebaCircularidadDetectablePorIndices() throws ListException {
        listaInteger.add(100);
        listaInteger.add(200);
        listaInteger.add(300);
        int index100 = listaInteger.indexOf(100);
        int index200 = listaInteger.indexOf(200);
        int index300 = listaInteger.indexOf(300);
        listaInteger.remove(100);
        listaInteger.remove(200);
        listaInteger.remove(300);
        listaInteger.add(100);
        listaInteger.add(200);
        listaInteger.add(300);
        assertEquals(0, listaInteger.indexOf(100));
        assertEquals(1, listaInteger.indexOf(200));
        assertEquals(2, listaInteger.indexOf(300));
    }

    @Test
    void PruebaRecorridoCircularLogico() throws ListException {
        listaString.add("uno");
        listaString.add("dos");
        listaString.add("tres");
        listaString.remove("uno");
        listaString.add("cuatro");
        assertEquals(2, listaString.indexOf("cuatro"));
    }
}