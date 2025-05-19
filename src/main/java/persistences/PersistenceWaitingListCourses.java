/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Student;
import structures.ArrayList;
import structures.CircularDoubleLinkedList;

/**
 * Clase encargada de manejar la persistencia de la lista de espera de los
 * cursos, utilizando una lista doblemente enlazada circular para almacenar los
 * estudiantes que estan en lista de espera en el curso
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceWaitingListCourses {

    private CircularDoubleLinkedList<Student> waitingListCourses;

    /**
     * Constructor que inicializa la lista de espera como una lista doblemente
     * enlazada circular
     */
    public PersistenceWaitingListCourses() {
        this.waitingListCourses = new CircularDoubleLinkedList<>();
    }

    /**
     * Agrega un nuevo estudiante a la lista de espera
     *
     * @param student estudiante a agregar a la lista de espera
     */
    public void enrollStudentWaitingList(Student student) {
        waitingListCourses.add(student);
    }

    /**
     * Obtiene la lista completa de estudiantes en espera por medio de un
     * arrayList de tipo Student
     *
     * @return la lista de estudiantes
     */
    public ArrayList<Student> getList() {
        return waitingListCourses.getList();
    }
}
