/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures.exceptions;

/**
 * Excepción personalizada para manejar errores en HashMaps.
 *
 * @author Cortez, Manuel;
 */
public class HashMapException extends RuntimeException {

    /**
     * Constructor por defecto de la excepción.
     */
    public HashMapException(){}

    /**
     * Constructor que acepta un mensaje de error.
     *
     * @param s String Mensaje de error descriptivo.
     */
    public HashMapException(String s){
        super(s);
    }
}