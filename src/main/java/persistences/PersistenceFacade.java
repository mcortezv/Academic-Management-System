/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Action;
import components.Course;
import components.Student;
import interfaces.IPersistenceFacade;
import structures.ArrayList;
import structures.BinarySearchTree;
import structures.HashDictionary;

/**
 * Clase que actua como fachada para las distintas capas de persistencia del sistema
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceFacade implements IPersistenceFacade {
    private PersistenceStudents persistenceStudents;
    private PersistenceCourses persistenceCourses;
    private PersistenceStudentsCourses persistenceStudentsCourses;
    private PersistenceRequests persistenceRequests;
    private PersistenceActions persistenceActions;
    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     * @param persistenceStudents
     * @param persistenceCourses
     * @param persistenceStudentsCourses
     * @param persistenceRequests
     * @param persistenceActions 
     */
    public PersistenceFacade(PersistenceStudents persistenceStudents, PersistenceCourses persistenceCourses,
                             PersistenceStudentsCourses persistenceStudentsCourses, PersistenceRequests persistenceRequests,
                             PersistenceActions persistenceActions){
        this.persistenceStudents = persistenceStudents;
        this.persistenceCourses = persistenceCourses;
        this.persistenceStudentsCourses = persistenceStudentsCourses;
        this.persistenceRequests = persistenceRequests;
        this.persistenceActions = persistenceActions;
    }
    /**
     * Agrega un estudiante al sistema y registra la accion 
     * @param student el estudiante a agregar     
     */
    
    @Override
    public void addStudent(Student student) {
        persistenceActions.addAction( new Action(Action.Type.addStudent, student));
        persistenceStudents.addStudent(student);
    }
    /**
     * Busca un estudiante por su id y registra la accion
     * @param id del estudiante
     * @return instancia del estudiante encontrado o null
     */
    @Override
    public Student searchStudentById(String id) {
        persistenceActions.addAction( new Action(Action.Type.searchStudent, id));
        return persistenceStudents.searchStudent(id);
    }
    /**
     * Lista todos los estudiantes agregados al sistema y registra la accion
     * @return arbol binario con los estudiantes 
     */
    @Override
    public BinarySearchTree<Student> listStudents() {
        persistenceActions.addAction( new Action(Action.Type.listStudents, null));
        return persistenceStudents.listStudents();
    }
    
    /**
     * Agrega una calificacion 
     * @param grade 
     */
    @Override
    public void addGrade(Double grade) {
        
    }
    /**
     * 
     * @param grade
     * @param index 
     */
    @Override
    public void updateGrade(Double grade, int index) {

    }
    /**
     * 
     * @return 
     */
    @Override
    public Double getAverage() {
        return null;
    }
    /**
     * 
     * @return 
     */
    @Override
    public ArrayList<Double> listGrades() {
        return null;
    }
    /**
     * 
     * @param course
     * @return 
     */
    @Override
    public Course addCourse(Course course) {
        persistenceActions.addAction( new Action(Action.Type.addCourse, course));
        return persistenceCourses.addCourse(course);
    }
    /**
     * 
     * @param course
     * @return 
     */
    @Override
    public Course deleteCourse(Course course) {
        persistenceActions.addAction( new Action(Action.Type.removeCourse, course));
        return persistenceCourses.removeCourse(course);
    }
    /**
     * 
     * @return 
     */
    @Override
    public HashDictionary<String, Course> lisCourses() {
        persistenceActions.addAction( new Action(Action.Type.listCourses, null));
        return persistenceCourses.listCourses();
    }
    /**
     * 
     */
    @Override
    public void undoAction(){
        persistenceActions.undoLastAction();
    }
}