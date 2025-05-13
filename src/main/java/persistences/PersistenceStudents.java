/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Student;
import structures.BinarySearchTree;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceStudents {
    private BinarySearchTree<Student> students;

    public PersistenceStudents() {
        this.students = new BinarySearchTree<>();
    }

    public void addStudent(Student student) {
        students.insert(students.raiz, student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student searchStudent(String studentId) {
        Student studentToFind = new Student(studentId, "", null, null);
        return students.get(studentToFind);
    }

    public BinarySearchTree<Student> listStudents() {
        return students;
    }
}