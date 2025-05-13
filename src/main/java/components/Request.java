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
    private Student student;
    private final Object data;
    private int index;

    /**
     * Enumeracion que define los distintos tipos de acciones del sistema
     */
    public enum Type {
        addGrade,
        updateGrade,
        removeGrade,
        listGrades
    }

    public Request(Type type, Object data) {
        this.type = type;
        this.data = data;

    }

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param type
     * @param student
     * @param data
     */
    public Request(Type type, Student student, Object data) {
        this.type = type;
        this.student = student;
        this.data = data;

    }

    public Request(Type type, Student student, Object data, int index) {
        this.type = type;
        this.student = student;
        this.data = data;
        this.index = index;

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

    /**
     *
     * @return
     */
    public Student getStudent() {
        return student;
    }
    /**
     * 
     * @return 
     */
    public int getIndex() {
        return index;
    }
    /**
     * 
     * @param student 
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    /**
     * 
     * @param index 
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
