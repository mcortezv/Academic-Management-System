/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.dtos;
import components.Student;

/**
 * Clase que funciona como intermediaria para relacionar un estudiante con
 * una de sus calificaciones
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class StudentGradeDTO {
    private Student student;
    private Double grade;
    private int index;

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param student Student
     * @param grade Double
     * @param index int
     */
    public StudentGradeDTO(Student student, Double grade, int index) {
        this.student = student;
        this.grade = grade;
        this.index = index;
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
     * Retorna la calificacion asociado
     *
     * @return course
     */
    public Double getGrade() {
        return grade;
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
     * Establece la calificacion asociado a la relacion
     *
     * @param grade
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    /**
     * Retorna el indice de la calificacion asociada, -1 si es agregar
     *
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Establece el indice de la calificacion asociado a la relacion
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }
}