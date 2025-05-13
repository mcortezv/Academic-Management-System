 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 * Clase que funciona como intermediaria para relacionar un estudiante con un
 * curso especifico
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class StudentCourse {
    private Student student;
    private Course course;

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param student
     * @param course
     */
    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    /**
     * Retorna el estudiante asociado al curso
     *
     * @return student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Retorna el curso asociado
     *
     * @return course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Establece el estudiante asociado a la relacion
     *
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Establece el curso asociado a la relacion
     *
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }
}