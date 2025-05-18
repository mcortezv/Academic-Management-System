/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Contact;
import components.Student;
import structures.AVLTree;
import structures.BinarySearchTree;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceStudents {
    private final BinarySearchTree<Student> students;
    private AVLTree<Student> studentsByAverage;

    public PersistenceStudents() {
        this.students = new BinarySearchTree<>();
        this.studentsByAverage = new AVLTree<>();
        populateStudents();
    }

    public void addStudent(Student student) {
        students.insert(students.raiz, student);
        Double average = student.getAverage();
        studentsByAverage.insert(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        Double average = student.getAverage();
        studentsByAverage.remove(student);
    }

    public Student searchStudent(String studentId) {
        return students.get(studentId);
    }

    public BinarySearchTree<Student> listStudents() {
        return students;
    }

    public void listStudentsInOrderFromAVLTree() {
        studentsByAverage.listInOrderToString();
    }

    public AVLTree<Student> getStudentsByAverage() {
        System.out.println("Contenido del arbol antes de retornar: " + studentsByAverage.listInOrderToString());
        return studentsByAverage;
    }

    public void populateStudents() {
        if (studentsByAverage == null) {
            studentsByAverage = new AVLTree<>();
        }
        Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Student student1 = new Student("1111AAAA", "Sebas", datosContacto);
        Student student2 = new Student("2222BBBB", "Manuel", datosContacto);
        student1.addGrade(10.0);
        student1.addGrade(9.0);
        studentsByAverage.insert(student1);
        studentsByAverage.insert(student2);
        students.insert(student1);
        students.insert(student2);
        System.out.println("Datos insertados en el árbol.");
    }

}
