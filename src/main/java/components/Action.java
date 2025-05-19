/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 * Clase que representa una accion realizada dentro del sistema
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class Action {
    private final Type type;
    private final Object data;
    private final String name;

    /**
     * Enumeracion que define los distintos tipos de acciones del sistema
     */
    public enum Type {
        addStudent,
        removeStudent,
        addCourse,
        removeCourse,
        enrollStudentInCourse,
        submitGradesRequest,
        processNextRequest,
        rotateRoles,
        addGrade,
        updateGrade,
        listGrades,
    }

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param type
     * @param data
     */
    public Action(Type type, Object data, String name) {
        this.type = type;
        this.data = data;
        this.name = name;
    }

    /**
     * Metodo que regresa el tipo de accion realizada
     *
     * @return type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Metodo que regresa los datos de la accion realizada
     *
     * @return data
     */
    public Object getData() {
        return this.data;
    }
    
    @Override
    public String toString() {
        return "[" + name + "]";
    }
}