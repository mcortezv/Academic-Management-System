/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;
import java.util.Random;
import persistences.PersistenceStudentsCourses;
import persistences.PersistenceWaitingListCourses;
import persistences.PersistenceRoles;
import structures.ArrayList;
import validators.Validator;
import javax.swing.*;

/**
 * Clase que representa un curso en el sistema
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public final class Course {
    private String id;
    private String name;
    private Student tutor;
    private PersistenceStudentsCourses enrolledStudents;
    private PersistenceWaitingListCourses waitingList;
    private PersistenceRoles studentsWithAssignedRole;
    private final int maxCapacity = 25;

    /**
     * Constructor vacio del curso
     * @param name
     */
    public Course(String name){
        this.id = generateRandomId();
        this.name = name;
        this.tutor = null;
        this.enrolledStudents = new PersistenceStudentsCourses();
        this.waitingList = new PersistenceWaitingListCourses();
        this.studentsWithAssignedRole = new PersistenceRoles();
    }
    
    public Course(String id, String name){
        this.id = generateRandomId();
        this.name = name;
        this.tutor = null;
        this.enrolledStudents = new PersistenceStudentsCourses();
        this.waitingList = new PersistenceWaitingListCourses();
        this.studentsWithAssignedRole = new PersistenceRoles();
        
    }
    
    public Course(String id, String name, Student tutor){
        this.id = id;
        this.name = name;
        this.tutor = tutor;
        this.enrolledStudents = new PersistenceStudentsCourses();
        this.waitingList = new PersistenceWaitingListCourses();
        this.studentsWithAssignedRole = new PersistenceRoles();
        
    }
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
        this.tutor = tutor;
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
    public ArrayList<Student> getEnrolledStudentsArrayList() {
        return enrolledStudents.getList();
    }

    public PersistenceStudentsCourses getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
     * Metodo que regresa una persistencia de estudiantes en lista de espera del curso.
     *
     * @return waitingList
     */
    public ArrayList<Student> getWaitingListArrayList() {
        return waitingList.getList();
    }

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

    public void enrollStudentInCourse(Student student){
        if (enrolledStudents.getTam() >= maxCapacity){
            waitingList.enrollStudentWaitingList(student);
            JOptionPane.showMessageDialog(null, "Cantidad Maxima de Estudiantes Alcanzada", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            enrolledStudents.enrollStudentCourse(student);
            JOptionPane.showMessageDialog(null, "Estudiante Agregado con Exito", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
     * @return 
     */
    public Student rotateRol() {
        return studentsWithAssignedRole.rotateRole();
    }
    /**
     * 
     * @return 
     */
    public String generateRandomId() {
        Random random = new Random();
        String numbers = String.format("%04d", random.nextInt(10000));
        String letters = "";
        for (int i = 0; i < 4; i++) {
            char letter = (char) (random.nextInt(26) + 'A');
            letters += letter;
        }
        String id = numbers + letters;
        if (Validator.validateId(id)) {
            return id;
        } else {
            return generateRandomId();
        }
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