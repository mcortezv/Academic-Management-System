/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Contact;
import components.Student;
import structures.*;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public final class PersistenceStudents {
    private final BinarySearchTree<Student> students;
    private AVLTree<Student> studentsByAverage;

    public PersistenceStudents() {
        this.students = new BinarySearchTree<>();
        this.studentsByAverage = new AVLTree<>();
        populateStudents();
    }

    public void addStudent(Student student) {
        students.insert(students.raiz, student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student searchStudent(String studentId) {
        return students.get(studentId);
    }

    public ArrayList<Student> listStudents() {
        return students.listInOrderToArrayList();
    }

    public ArrayList<Student> listStudentsInOrderFromAVLTree() {
        return studentsByAverage.listInOrderToArrayList();
    }

    public void populateStudents() {
        if (studentsByAverage == null) {
            studentsByAverage = new AVLTree<>();
        }
        Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Student student1 = new Student("2222BBBB", "Sebas", datosContacto);
        Student student2 = new Student("1111AAAA", "Manuel", datosContacto);
        student1.addGrade(9.0);
        student2.addGrade(10.0);
        studentsByAverage.insert(student1);
        studentsByAverage.insert(student2);
        students.insert(student1);
        students.insert(student2);
    }

}
