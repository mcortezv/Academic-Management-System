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
 * Clase encargada de manejar la persistencia de los estudiantes inscritos en
 * cursos , utilizando una lista enlazada simple para almacenar los estudiantes
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceStudentsCourses {

    public LinkedList<Student> studentsCourses;

    /**
     * Constructor que inicializa la lista de alumnos inscritos como vacia
     */
    public PersistenceStudentsCourses() {
        this.studentsCourses = new LinkedList<>();
        populateStudentsCourses();
    }

    /**
     * Obtiene el tamaño de la lista de estudiantes inscritos
     *
     * @return numero de estudiantes de la lista
     */
    public int getSize() {
        return studentsCourses.getSize();
    }

    /**
     * Obtiene la lista de los estudiantes inscritos en forma de ArrayList de
     * Student
     *
     * @return lista con los estudiantes inscritos
     */
    public ArrayList<Student> getList() {
        return studentsCourses.getList();
    }

    /**
     * Agrega un estudiante a la lista de alumnos inscritos
     *
     * @param student estudiante a agregar
     */
    public void enrollStudentCourse(Student student) {
        studentsCourses.add(student);
    }

    /**
     * Verifica si un estudiante ya esta inscrito en el curso y se encuentra en
     * la lista
     *
     * @param student estudiante a buscar
     * @return true si el estudiante esta inscrito, false en caso contrario
     */
    public boolean contains(Student student) {
        return studentsCourses.indexOf(student) != -1;
    }

    /**
     * Metodo auxiliar que permite agregar estudiantes a los cursos al iniciar
     * el sistema
     */
    public void populateStudentsCourses() {
        Contact datosContacto1 = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Contact datosContacto2 = new Contact("6681117834", "juanito@gmail.com", "817232");
        Contact datosContacto3 = new Contact("6681892523", "manuel@gmail.com", "817272");
        Contact datosContacto4 = new Contact("6681151615", "alonso@gmail.com", "817937");
        Contact datosContacto5 = new Contact("6681029372", "juandavid@gmail.com", "819283");
        Contact datosContacto6 = new Contact("6681272634", "antonio@gmail.com", "72834");
        Contact datosContacto7 = new Contact("6681928323", "luisangel@gmail.com", "81293");
        Contact datosContacto8 = new Contact("6681191827", "daniel@gmail.com", "818234");



        Student student1 = new Student("1111AAAA", "Sebastian Escalante", datosContacto1);
        Student student2 = new Student("2222BBBB", "Juan Manuel Perez", datosContacto2);
        Student student3 = new Student("3333CCCC", "Manuel Cortez", datosContacto3);
        Student student4 = new Student("4444DDDD", "Luis Alonso", datosContacto4);
        Student student5 = new Student("5555EEEE", "Juan Baldenegro", datosContacto5);
        Student student6 = new Student("6666FFFF", "Antonio Quintana", datosContacto6);
        Student student7 = new Student("7777GGGG", "Luis Angel Rivera", datosContacto7);
        Student student8 = new Student("8888HHHH", "Daniel Miramontes", datosContacto8);



        studentsCourses.add(student1);
        studentsCourses.add(student2);
        studentsCourses.add(student3);
        studentsCourses.add(student4);
        studentsCourses.add(student5);
        studentsCourses.add(student6);
        studentsCourses.add(student7);
        studentsCourses.add(student8);

    }
}
