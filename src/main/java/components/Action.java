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
    private Student student;
    private final Object data;
    private int index;

    /**
     * Enumeracion que define los distintos tipos de acciones del sistema
     */
    public enum Type {
        addStudent,
        searchStudent,
        removeStudent,
        addCourse,
        removeCourse,
        listCourses,
        enrollStudentInCourse,
        showEnrolledStudentsInCourse,
        showWaitingListForCourse,
        submitGradesRequest,
        processNextRequest,
        listStudents,
        rotateRoles,
        addGrade,
        updateGrade,
        getAverage,
        listGrades,
    }

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param type
     * @param data
     */
    public Action(Type type, Object data) {
        this.type = type;
        this.data = data;
    }

    /**
     *
     * @param type
     * @param student
     * @param data
     */
    public Action(Type type, Student student, Object data) {
        this.type = type;
        this.student = student;
        this.data = data;

    }

    public Action(Type type, Student student, Object data, int index) {
        this.type = type;
        this.student = student;
        this.data = data;
        this.index = index;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
