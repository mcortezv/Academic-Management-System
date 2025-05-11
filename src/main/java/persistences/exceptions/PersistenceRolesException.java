/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences.exceptions;

/**
 * Excepción personalizada para manejar errores en la Persistencia de Roles.
 *
 * @author Cortez, Manuel;
 */
public class PersistenceRolesException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public PersistenceRolesException(){}

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public PersistenceRolesException(String s){
        super(s);
    }
}