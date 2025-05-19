/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Contact;
import components.Student;
import structures.ArrayList;
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

    public int getSize(){
        return studentsCourses.getSize();
    }

    public ArrayList<Student> getList(){
        return studentsCourses.getList();
    }

    public void enrollStudentCourse(Student student){
        studentsCourses.add(student);
    }

    public void populateStudentsCourses() {
        Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Student student1 = new Student("2222BBBB", "Sebas", datosContacto);
        Student student2 = new Student("3333CCCC", "manuel", datosContacto);
        studentsCourses.add(student1);
        studentsCourses.add(student2);
    }
}