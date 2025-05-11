/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import structures.Queue;
import structures.exceptions.QueueException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Cortez, Manuel;
 */
public class QueueTest {
    private Queue<Integer> intQueue;
    private Queue<String> stringQueue;

    @BeforeEach
    void setUp() {
        intQueue = new Queue<>();
        stringQueue = new Queue<>();
    }

    @Test
    void testEncolarYDesencolar() {
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        assertEquals(1, intQueue.dequeue());
        assertEquals(2, intQueue.dequeue());
        assertEquals(3, intQueue.dequeue());
    }

    @Test
    void testEncolarYDesencolarStrings() {
        stringQueue.enqueue("A");
        stringQueue.enqueue("B");
        stringQueue.enqueue("C");
        assertEquals("A", stringQueue.dequeue());
        assertEquals("B", stringQueue.dequeue());
        assertEquals("C", stringQueue.dequeue());
    }

    @Test
    void testPeek() {
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        assertEquals(10, intQueue.peek());
        intQueue.dequeue();
        assertEquals(20, intQueue.peek());
    }

    @Test
    void testPeekString() {
        stringQueue.enqueue("X");
        stringQueue.enqueue("Y");
        assertEquals("X", stringQueue.peek());
        stringQueue.dequeue();
        assertEquals("Y", stringQueue.peek());
    }

    @Test
    void testVacia() {
        assertTrue(intQueue.isEmpty());
        intQueue.enqueue(99);
        assertFalse(intQueue.isEmpty());
        intQueue.dequeue();
        assertTrue(intQueue.isEmpty());
    }

    @Test
    void testVaciaString() {
        assertTrue(stringQueue.isEmpty());
        stringQueue.enqueue("Z");
        assertFalse(stringQueue.isEmpty());
        stringQueue.dequeue();
        assertTrue(stringQueue.isEmpty());
    }

    @Test
    void testGetSize() {
        assertEquals(0, intQueue.getSize());
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        assertEquals(2, intQueue.getSize());
        intQueue.dequeue();
        assertEquals(1, intQueue.getSize());
    }

    @Test
    void testGetSizeString() {
        assertEquals(0, stringQueue.getSize());
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        assertEquals(2, stringQueue.getSize());
        stringQueue.dequeue();
        assertEquals(1, stringQueue.getSize());
    }

    @Test
    void testDesencolarException() {
        assertThrows(QueueException.class, () -> intQueue.dequeue());
    }

    @Test
    void testPeekException() {
        assertThrows(QueueException.class, () -> intQueue.peek());
    }
}