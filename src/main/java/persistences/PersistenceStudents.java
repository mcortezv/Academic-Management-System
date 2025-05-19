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
        Contact datosContacto1 = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Contact datosContacto2 = new Contact("6681117834", "juanito@gmail.com", "817232");
        Contact datosContacto3 = new Contact("6681892523", "manuel@gmail.com", "817272");
        Contact datosContacto4 = new Contact("6681151615", "alonso@gmail.com", "817937");
        Contact datosContacto5 = new Contact("6681029372", "juandavid@gmail.com", "819283");
        Contact datosContacto6 = new Contact("6681272634", "antonio@gmail.com", "72834");
        Contact datosContacto7 = new Contact("6681928323", "luisangel@gmail.com", "81293");
        Contact datosContacto8 = new Contact("6681191827", "daniel@gmail.com", "818234");
        Contact datosContacto9 = new Contact("6681928323", "luisangel@gmail.com", "81293");
        Contact datosContacto10 = new Contact("6681191827", "daniel@gmail.com", "818234");
        Contact datosContacto11 = new Contact("6681191827", "daniel@gmail.com", "818234");



        Student student1 = new Student("1111AAAA", "Sebastian Escalante", datosContacto1);
        Student student2 = new Student("2222BBBB", "Juan Manuel Perez", datosContacto2);
        Student student3 = new Student("3333CCCC", "Manuel Cortez", datosContacto3);
        Student student4 = new Student("4444DDDD", "Luis Alonso", datosContacto4);
        Student student5 = new Student("5555EEEE", "Juan Baldenegro", datosContacto5);
        Student student6 = new Student("6666FFFF", "Antonio Quintana", datosContacto6);
        Student student7 = new Student("7777GGGG", "Luis Angel Rivera", datosContacto7);
        Student student8 = new Student("8888HHHHH", "Daniel Miramontes", datosContacto8);
        Student student9 = new Student("9999IIII", "Ana Miramontes", datosContacto9);
        Student student10 = new Student("1010JJJJ", "Pedro Miramontes", datosContacto10);
        Student student11 = new Student("2020KKKK", "David Miramontes", datosContacto11);


        student1.addGrade(9.0);
        student1.addGrade(7.0);
        student1.addGrade(8.0);
        student1.addGrade(9.0);
        student1.addGrade(6.0);
        student1.addGrade(8.0);
        student1.addGrade(9.0);
        student1.addGrade(7.0);

        student2.addGrade(10.0);
        student2.addGrade(9.0);

        student3.addGrade(8.0);

        student4.addGrade(5.0);
        student4.addGrade(9.0);
        student4.addGrade(8.0);

        student5.addGrade(10.0);
        student5.addGrade(5.0);

        student6.addGrade(8.0);
        student6.addGrade(5.0);

        student7.addGrade(9.0);
        student7.addGrade(10.0);

        student8.addGrade(9.0);
        student8.addGrade(7.0);
        student8.addGrade(9.0);
        student8.addGrade(10.0);


        students.insert(student1);
        students.insert(student2);
        students.insert(student3);
        students.insert(student4);
        students.insert(student5);
        students.insert(student6);
        students.insert(student7);
        students.insert(student8);
        students.insert(student9);
        students.insert(student10);
        students.insert(student11);

        studentsByAverage.insert(student1);
        studentsByAverage.insert(student2);
        studentsByAverage.insert(student3);
        studentsByAverage.insert(student4);
        studentsByAverage.insert(student5);
        studentsByAverage.insert(student6);
        studentsByAverage.insert(student7);
        studentsByAverage.insert(student8);
    }

}
