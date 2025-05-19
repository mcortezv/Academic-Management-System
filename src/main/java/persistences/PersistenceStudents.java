/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Contact;
import components.Student;
import structures.*;

/**
 * Clase encargada de manejar la persistencia de los estudiantes agregados al
 * sistema, utilizando un arbol binario de busqueda y un arbol AVL que almacenan
 * tipo de dato Student
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public final class PersistenceStudents {

    private final BinarySearchTree<Student> students;
    private AVLTree<Student> studentsByAverage;
    private ArrayList<Student> studentArrayList;

    /**
     * Constructor que inicializa los dos arboles vacios
     */
    public PersistenceStudents() {
        this.students = new BinarySearchTree<>();
        this.studentsByAverage = new AVLTree<>();
        populateStudents();
    }

    /**
     * Metodo que agrega un nuevo estudiante al arbol binario de busqueda
     *
     * @param student estudiante a agregar
     */
    public void addStudent(Student student) {
        students.insert(students.root, student);
    }

    /**
     * Metodo que elimina un estudiante del arbol binario de busqueda
     *
     * @param student estudiante a eliminar
     */
    public void removeStudent(Student student) {
        if (student != null) {
            students.remove(student);
        }
    }

    /**
     * Metodo que realiza la busqueda de un estudiante en el arbol binario de
     * busqueda
     *
     * @param studentId id del estudiante a buscar
     * @return estudiante encontrado
     */
    public Student searchStudent(String studentId) {
        return students.get(studentId);
    }

    /**
     * Devuelve una lista ArrayList de tipo Student de estudiantes en recorrido
     * "In-Orden" del arbol binario de busqueda
     *
     * @return lista de estudiantes
     */
    public ArrayList<Student> listStudents() {
        return students.listInOrderToArrayList();
    }

    /**
     * Devuelve una lista ArrayList de tipo Student de los estudiantes ordenados
     * por promedio usando el arbol AVL
     *
     * @return lista de estudiantes ordenados por promedio
     */
    public ArrayList<Student> listStudentsInOrderFromAVLTree() {
        studentsByAverage.clear();
        studentArrayList = listStudents();
        for (Student student : studentArrayList) {
            if (student.getAverage() != 0.0) {
                studentsByAverage.insert(student);
            }
        }
        return studentsByAverage.listInOrderToArrayList();
    }

    /**
     * Metodo auxiliar que permite agregar estudiantes al sistema al ser
     * iniciado
     */
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
