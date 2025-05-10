/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import structures.Stack;
import exceptions.StackException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Cortez, Manuel;
 */
public class StackTest {
    private Stack<Integer> pilaInteger;
    private Stack<String> pilaString;

    @BeforeEach
    void setUp() {
        pilaInteger = new Stack<>();
        pilaString = new Stack<>();
    }

    @Test
    void TestMetodoPushYPopFuncionanCorrectamenteInteger() {
        pilaInteger.push(10);
        pilaInteger.push(20);
        pilaInteger.push(30);
        assertEquals(30, pilaInteger.pop());
        assertEquals(20, pilaInteger.pop());
        assertEquals(10, pilaInteger.pop());
    }

    @Test
    void TestMetodoPushYPopFuncionanCorrectamenteString() {
        pilaString.push("A");
        pilaString.push("B");
        pilaString.push("C");
        assertEquals("C", pilaString.pop());
        assertEquals("B", pilaString.pop());
        assertEquals("A", pilaString.pop());
    }

    @Test
    void TestMetodoPeekFuncionaCorrectamenteInteger() {
        pilaInteger.push(100);
        pilaInteger.push(200);
        assertEquals(200, pilaInteger.peek());
        pilaInteger.pop();
        assertEquals(100, pilaInteger.peek());
    }

    @Test
    void TestMetodoPeekFuncionaCorrectamenteString() {
        pilaString.push("X");
        pilaString.push("Y");
        assertEquals("Y", pilaString.peek());
        pilaString.pop();
        assertEquals("X", pilaString.peek());
    }

    @Test
    void TestMetodoVaciaFuncionaCorrectamente() {
        assertTrue(pilaInteger.isEmpty());
        pilaInteger.push(5);
        assertFalse(pilaInteger.isEmpty());
        pilaInteger.pop();
        assertTrue(pilaInteger.isEmpty());
    }

    @Test
    void TestMetodoGetSizeFuncionaCorrectamente() {
        assertEquals(0, pilaInteger.getSize());
        pilaInteger.push(1);
        pilaInteger.push(2);
        assertEquals(2, pilaInteger.getSize());
        pilaInteger.pop();
        assertEquals(1, pilaInteger.getSize());
        pilaInteger.pop();
        assertEquals(0, pilaInteger.getSize());
    }

    @Test
    void TestMetodoPopLanzaException() {
        assertThrows(StackException.class, () -> {
            pilaInteger.pop();
        });
    }

    @Test
    void TestMetodoPeekLanzaException() {
        assertThrows(StackException.class, () -> {
            pilaInteger.peek();
        });
    }
}