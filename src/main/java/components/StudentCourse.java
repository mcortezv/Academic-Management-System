/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 *Clase que funciona como intermediaria para relacionar un estudiante con un curso especifico
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class StudentCourse {
    private Student student;
    private Course course;
    
    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     * @param student
     * @param course 
     */
    public StudentCourse(Student student, Course course){
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}