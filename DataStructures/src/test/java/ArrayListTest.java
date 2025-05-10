/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import exceptions.ListException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class ArrayListTest {

    @Test
    public void InstanciarArrayConTamañoNegativoLanzaExcepcion(){
        Exception ex = assertThrows(ListException.class, () -> new ArrayList<>(-1));
        assertEquals("El Tamaño no Puede Ser Negativo", ex.getMessage());
    }

    @Test
    public void InstanciarArrayConTamañoValidoFuncionaCorrectamente(){
        assertDoesNotThrow(() -> new ArrayList<>(1));
    }

    @Test
    public void StringMetodoAddFuncionaCorrectamente() {
        ArrayList<String> listaString = new ArrayList<>(1);
        listaString.add("Hola");
        assertEquals(0, listaString.indexOf("Hola"));
        assertEquals(1, listaString.numObjects);
    }

    @Test
    public void StringMetodoAddConRedimensionamientoFuncionaCorrectamente() {
        ArrayList<String> listaString = new ArrayList<>(1);
        listaString.add("Uno");
        listaString.add("Dos");
        assertEquals(0, listaString.indexOf("Uno"));
        assertEquals(2, listaString.numObjects);
    }

    @Test
    public void IntegerMetodoAddFuncionaCorrectamente() {
        ArrayList<Integer> listaInt = new ArrayList<>(1);
        listaInt.add(10);
        assertEquals(0, listaInt.indexOf(10));
        assertEquals(1, listaInt.numObjects);
    }

    @Test
    public void IntegerMetodoAddConRedimensionamientoFuncionaCorrectamente() {
        ArrayList<Integer> listaInt = new ArrayList<>(2);
        listaInt.add(1);
        listaInt.add(2);
        listaInt.add(3);
        assertEquals(0, listaInt.indexOf(1));
        assertEquals(1, listaInt.indexOf(2));
        assertEquals(2, listaInt.indexOf(3));
        assertEquals(3, listaInt.numObjects);
    }

    @Test
    public void StringMetodoSetLanzaExcepcionIndiceFueraDeRango(){
        ArrayList<String> listaString = new ArrayList<>(5);
        Exception ex = assertThrows(ListException.class, () -> listaString.set("s", 10));
        assertEquals("Indice Fuera de Rango", ex.getMessage());
    }

    @Test
    public void StringMetodoSetFuncionaCorrectamente(){
        ArrayList<String> listaString = new ArrayList<>(10);
        listaString.set("s", 5);
        assertEquals(5, listaString.indexOf("s"));
    }

    @Test
    public void StringMetodoRemueveLanzaExcepcionListaVacia(){
        ArrayList<String> listaString = new ArrayList<>(10);
        Exception ex = assertThrows(ListException.class, () -> listaString.remove("s"));
        assertEquals("La Lista Esta Vacia", ex.getMessage());
    }

    @Test
    public void StringMetodoRemueveRetornaFalseCuandoNoHayOcurrencia(){
        ArrayList<String> listaString = new ArrayList<>(10);
        listaString.set("s", 5);
        assertFalse(listaString.remove("h"));
    }

    @Test
    public void StringMetodoRemueveFuncionaCorrectamente(){
        ArrayList<String> listaString = new ArrayList<>(10);
        listaString.set("s", 5);
        assertTrue(listaString.remove("s"));
    }

    @Test
    public void StringMetodoIndexOfRetorna1NegativoCuandoNoEncuentraOcurrencia(){
        ArrayList<String> listaString = new ArrayList<>(10);
        listaString.set("s", 5);
        assertEquals(-1, listaString.indexOf("h"));
    }

    @Test
    public void StringMetodoIndexOfFuncionaCorrectamente(){
        ArrayList<String> listaString = new ArrayList<>(10);
        int indice = 5;
        listaString.set("s", indice);
        assertEquals(indice, listaString.indexOf("s"));
    }

    @Test
    public void StringMetodoClearFuncionaCorrectamente(){
        int tam = 10;
        ArrayList<String> listaString = new ArrayList<>(tam);
        listaString.set("s", 5);
        listaString.clear();
        assertEquals(0, listaString.numObjects);
    }

    @Test
    public void IntegerMetodoSetLanzaExcepcionIndiceFueraDeRango(){
        ArrayList<Integer> listaString = new ArrayList<>(5);
        Exception ex = assertThrows(ListException.class, () -> listaString.set(7, 10));
        assertEquals("Indice Fuera de Rango", ex.getMessage());
    }

    @Test
    public void IntegerMetodoSetFuncionaCorrectamente(){
        ArrayList<Integer> listaString = new ArrayList<>(10);
        listaString.set(7, 5);
        assertEquals(5, listaString.indexOf(7));
    }

    @Test
    public void IntegerMetodoRemueveLanzaExcepcionListaVacia(){
        ArrayList<Integer> listaString = new ArrayList<>(10);
        Exception ex = assertThrows(ListException.class, () -> listaString.remove(7));
        assertEquals("La Lista Esta Vacia", ex.getMessage());
    }

    @Test
    public void IntegerMetodoRemueveRetornaFalseCuandoNoHayOcurrencia(){
        ArrayList<Integer> listaString = new ArrayList<>(10);
        listaString.set(7, 5);
        assertFalse(listaString.remove(9));
    }

    @Test
    public void IntegerMetodoRemueveFuncionaCorrectamente(){
        ArrayList<Integer> listaString = new ArrayList<>(10);
        listaString.set(7, 5);
        assertTrue(listaString.remove(7));
    }

    @Test
    public void IntegerMetodoIndexOfRetorna1NegativoCuandoNoEncuentraOcurrencia(){
        ArrayList<Integer> listaString = new ArrayList<>(10);
        listaString.set(7, 5);
        assertEquals(-1, listaString.indexOf(9));
    }

    @Test
    public void IntegerMetodoIndexOfFuncionaCorrectamente(){
        ArrayList<Integer> listaString = new ArrayList<>(10);
        int indice = 5;
        listaString.set(7, indice);
        assertEquals(indice, listaString.indexOf(7));
    }

    @Test
    public void IntegerMetodoClearFuncionaCorrectamente(){
        int tam = 10;
        ArrayList<Integer> listaString = new ArrayList<>(tam);
        listaString.set(7, 5);
        listaString.clear();
        assertEquals(0, listaString.numObjects);
    }
}