/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences.exceptions;

/**
 * Excepción personalizada para manejar errores en la Persistencia de Solicitudes.
 *
 * @author Cortez, Manuel;
 */
public class PersistenceRequestException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public PersistenceRequestException(){}

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public PersistenceRequestException(String s){
        super(s);
    }
}