/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reset.exceptions;

/**
 * Excepción personalizada para manejar errores en la Persistencia de Lissta de Espera de Cursos.
 *
 * @author Cortez, Manuel;
 */
public class PersistenceWaitingListCoursesException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public PersistenceWaitingListCoursesException(){}

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public PersistenceWaitingListCoursesException(String s){
        super(s);
    }
}