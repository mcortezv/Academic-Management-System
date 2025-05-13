/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.exceptions;

/**
 * Excepción personalizada para manejar errores en Listas.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class ListException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public ListException(){}

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public ListException(String s){
        super(s);
    }
}