/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;
import persistences.PersistenceStudentsCourses;
import persistences.PersistenceWaitingListCourses;
import persistences.PersistenceRoles;

/**
 * Clase que representa un curso en el sistema
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class Course {
    private String id;
    private String name;
    private Student tutor;
    private PersistenceStudentsCourses enrolledStudents;
    private PersistenceWaitingListCourses waitingList;
    private PersistenceRoles studentsWithAssignedRole;

    /**
     * Constructor vacio del curso
     */
    public Course(){}

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param id
     * @param name
     * @param tutor
     * @param enrolledStudents
     * @param waitingList
     * @param studentsWithAssignedRole
     */
    public Course(String id, String name, Student tutor,
            PersistenceStudentsCourses enrolledStudents,
            PersistenceWaitingListCourses waitingList, PersistenceRoles studentsWithAssignedRole) {
        this.id = id;
        this.name = name;
        this.enrolledStudents = enrolledStudents;
        this.waitingList = waitingList;
        this.studentsWithAssignedRole = studentsWithAssignedRole;
    }

    /**
     * Metodo que regresa una cadena de texto con el id del curso
     *
     * @return id del curso
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo que regresa una cadena de texto con el nombre del curso
     *
     * @return nombre del curso
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que regresa una instancia estudiante que representa el tutor del
     * curso
     *
     * @return tutor del curso
     */
    public Student getTutor() {
        return tutor;
    }

    /**
     * Metodo que regresa una persistencia de estudiantes inscritos en un curso.
     *
     * @return enrolledStudents
     */
    public PersistenceStudentsCourses getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Metodo que regresa una persistencia de estudiantes en lista de espera del curso.
     *
     * @return waitingList
     */
    public PersistenceWaitingListCourses getWaitingList() {
        return waitingList;
    }

    /**
     * Metodo que regresa una persistencia de estudiantes con rol asignado.
     *
     * @return studentsWithAssignedRole
     */
    public PersistenceRoles getStudentsWithAssignedRole() {
        return studentsWithAssignedRole;
    }

    /**
     * Establece el id del curso al valor recibido del parametro
     *
     * @param id id del curso
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Establece el nombre del curso al valor recibido del parametro
     *
     * @param name nombre del curso
     */
    public void setNombre(String name) {
        this.name = name;
    }

    /**
     * Establece el tutor del curso al valor recibido del parametro
     *
     * @param tutor
     */
    public void setTutor(Student tutor) {
        this.tutor = tutor;
    }

    /**
     * Metodo que rota el rol de lider del curso y devuelve al estudiante que es el nuevo lider.
     */
    public Student rotateRol() {
        return studentsWithAssignedRole.rotateRole();
    }

    /**
     * Metodo que regresa una cadena de texto con todos los atributos de la
     * instancia
     *
     * @return cadena de texto con la informacion del curso
     */
    @Override
    public String toString() {
        return "Curso{" + "Id: " + id + ", Nombre: " + name + ", Tutor: " + tutor;
    }
}