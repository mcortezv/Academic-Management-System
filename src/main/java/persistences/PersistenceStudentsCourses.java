/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Student;
import structures.LinkedList;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceStudentsCourses {
    public LinkedList<Student> studentsCourses;

    public PersistenceStudentsCourses(){
        this.studentsCourses = new LinkedList<>();
    }

    public int getCapacity(){
        return 0;
    }

    public void enrollStudentCourse(Student student){
        studentsCourses.add(student);
    }
}