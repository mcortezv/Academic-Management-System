/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import structures.HashDictionary;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Cortez, Manuel;
 */
public class HashDictionaryTest {
    private HashDictionary<String, String> dict;

    @BeforeEach
    public void setUp() {
        dict = new HashDictionary<>(10);
    }

    @Test
    public void testPutAndGetSimple() {
        dict.put("CS101", "Math");
        assertTrue(dict.contains("CS101"));
        assertEquals("Math", dict.get("CS101"));
    }

    @Test
    public void testPutOverridesValue() {
        dict.put("CS101", "Math");
        dict.put("CS101", "Physics");
        assertEquals("Physics", dict.get("CS101"));
        assertEquals(1, dict.getSize());
    }

    @Test
    public void testRemoveSuccess() {
        dict.put("CS101", "Math");
        assertTrue(dict.remove("CS101"));
        assertNull(dict.get("CS101"));
        assertEquals(0, dict.getSize());
    }

    @Test
    public void testSizeIncrementsCorrectly() {
        dict.put("A", "uno");
        dict.put("B", "dos");
        dict.put("C", "tres");
        assertEquals(3, dict.getSize());
    }

    @Test
    public void testEntrySetDoesNotCrash() {
        dict.put("A", "uno");
        dict.put("B", "dos");
        dict.entrySet();
    }

    @Test
    public void testGetKeyNotFound() {
        dict.put("CS101", "Math");
        assertNull(dict.get("NonExistentKey"));
    }

    @Test
    public void testRemoveKeyNotFound() {
        dict.put("CS101", "Math");
        assertFalse(dict.remove("Physics"));
        assertEquals(1, dict.getSize());
    }

    @Test
    public void testPutNullKey() {
        assertThrows(NullPointerException.class, () -> {
            dict.put(null, "Value");
        });
    }

    @Test
    public void testPutNullValue() {
        dict.put("Clave", null);
        assertNull(dict.get("Clave"));
        assertEquals(1, dict.getSize());
    }

    @Test
    public void testGetFromEmptyDictionary() {
        assertNull(dict.get("Anything"));
    }
}