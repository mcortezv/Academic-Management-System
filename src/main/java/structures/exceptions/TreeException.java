/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.exceptions;

/**
 * Excepción personalizada para manejar errores en Arboles.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class TreeException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public TreeException() {
    }

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public TreeException(String s) {
        super(s);
    }
}
