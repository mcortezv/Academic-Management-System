/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reset;
import components.StudentCourse;
import structures.LinkedList;

/**
 *
 * @author Sebas
 */
public class PersistenceStudentsCourses {
    public LinkedList<StudentCourse> studentsCourses;

    public PersistenceStudentsCourses(){
        this.studentsCourses = new LinkedList<StudentCourse>();
    }

    public int getCapacity(){
        return 0;
    }

    public void enrollStudentCourse(StudentCourse studentCourse){
        studentsCourses.add(studentCourse);
    }
}