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
        Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Student student1 = new Student("2222BBBB", "Sebas", datosContacto);
        Student student2 = new Student("3333CCCC", "manuel", datosContacto);
        studentsCourses.add(student1);
        studentsCourses.add(student2);
    }
}
