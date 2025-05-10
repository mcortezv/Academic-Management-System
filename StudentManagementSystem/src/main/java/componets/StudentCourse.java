/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componets;

/**
 *
 * @author Sebas
 */
public class StudentCourse {
    private Student student;
    private Course course;
    
    /**
     * 
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
