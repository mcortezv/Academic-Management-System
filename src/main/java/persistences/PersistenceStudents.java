/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Student;
import structures.AVLTree;
import structures.BinarySearchTree;
import structures.Pair;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceStudents {

    private final BinarySearchTree<Student> students;
    private AVLTree<Pair<Double, Student>> studentsByAverage;

    public PersistenceStudents() {
        this.students = new BinarySearchTree<>();
        this.studentsByAverage = new AVLTree<>();
    }

    public void addStudent(Student student) {
        students.insert(students.raiz, student);
        Double average = student.getAverage();
        Pair<Double, Student> studentToAVLTree = new Pair<>(average, student);
        studentsByAverage.insert(studentToAVLTree);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        Double average = student.getAverage();
        Pair<Double, Student> studentToTakeOutFromAVLTree = new Pair<>(average, student);
        studentsByAverage.remove(studentToTakeOutFromAVLTree);
    }

    public Student searchStudent(String studentId) {
        Student studentToFind = new Student(studentId);
        return students.get(studentToFind);
    }

    public BinarySearchTree<Student> listStudents() {
        return students;
    }

    public void listStudentsInOrderFromAVLTree() {
        studentsByAverage.ListinOrder();
    }

    public AVLTree<Pair<Double, Student>> getStudentsByAverage() {
        System.out.println("Contenido del arbol antes de retornar: " + studentsByAverage.inOrderToString());
        return studentsByAverage;
    }

    public void populateStudents() {
        if (studentsByAverage == null) {
            studentsByAverage = new AVLTree<>();
        }

        Student student1 = new Student("1923WSS");
        Student student2 = new Student("1234NNS");

        studentsByAverage.insert(new Pair<>(8.5, student1));
        studentsByAverage.insert(new Pair<>(9.0, student2));

        System.out.println("Datos insertados en el árbol.");
    }

}
