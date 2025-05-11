/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.exceptions;

/**
 * Excepción personalizada para manejar errores en la Persistencia de Estudiantes.
 *
 * @author Cortez, Manuel;
 */
public class PersistenceStudentsCoursesException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public PersistenceStudentsCoursesException(){}

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public PersistenceStudentsCoursesException(String s){
        super(s);
    }
}