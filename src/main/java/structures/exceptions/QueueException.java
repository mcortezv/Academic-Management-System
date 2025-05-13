/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.exceptions;

/**
 * Excepción personalizada para manejar errores en Colas.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class QueueException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public QueueException(){}

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public QueueException(String s){
        super(s);
    }
}