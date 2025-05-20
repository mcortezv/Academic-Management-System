/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 * Clase que representa una solicitud realizada para realizar cambios dentro del
 * sistema
 *
 * @author Sebas
 */
public class Request {

    private final Type type;
    private final Object data;

    /**
     * Enumeracion que define los distintos tipos de acciones del sistema
     */
    public enum Type {
        addGrade,
        updateGrade,
        removeGrade,
        listGrades
    }

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param type
     * @param data
     */
    public Request(Type type, Object data) {
        this.type = type;
        this.data = data;

    }

    /**
     * Metodo que regresa el tipo de solicitud realizada
     *
     * @return type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Metodo que regresa los datos de la solicitud realizada
     *
     * @return data
     */
    public Object getData() {
        return this.data;
    }

}
