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
     * Agrega un curso
     * @param course curso a agregar
     * @return course
     */
    @Override
    public Course addCourse(Course course) {
        persistenceActions.addAction( new Action(Action.Type.addCourse, course));
        return persistenceCourses.addCourse(course);
    }

    /**
     * Elimina un curso
     * @param course
     * @return course curso eliminado
     */
    @Override
    public Course deleteCourse(Course course) {
        persistenceActions.addAction( new Action(Action.Type.removeCourse, course));
        return persistenceCourses.removeCourse(course);
    }

    /**
     * Lista tods los cursos
     * @return cursos del sistema
     */
    @Override
    public HashDictionary<String, Course> lisCourses() {
        persistenceActions.addAction( new Action(Action.Type.listCourses, null));
        return persistenceCourses.listCourses();
    }






    
    /**
     * Agrega una calificacion 
     * @param studentId
     * @param grade calificacion a añadir
     */
    @Override
    public void addGrade(String studentId, Double grade) {
        Student student = persistenceStudents.searchStudent(studentId);
        if(student != null){
            student.addGrade(grade);
            persistenceActions.addAction(new Action(Action.Type.addGrade,student));
        }
    }
    /**
     * Actualiza una calificacion
     * @param studentId
     * @param grade calificacion a actualizar
     * @param index indice del arreglo en el que se hará la actualizacion
     */
    @Override
    public void updateGrade(String studentId, Double grade, int index) {
        
    }
    /**
     * Obtiene el promedio de calificacion de un estudiante
     * @param studentId
     * @return double
     */
    @Override
    public Double getAverage(String studentId) {
        Student student = persistenceStudents.searchStudent(studentId);
        if(student != null){
            persistenceActions.addAction(new Action(Action.Type.getAverage,student));
            return student.getAverage();
        }
        return null;
    }
    /**
     * Lista el arreglo de calificaciones
     * @param studentId
     * @return 
     */
    @Override
    public ArrayList<Double> listGrades(String studentId) {
        Student student = persistenceStudents.searchStudent(studentId);
        if(student != null){
            persistenceActions.addAction(new Action(Action.Type.listGrades, student));
            return student.listGrades();
        }
        return null;
    }

    /**
     * Deshace la ultima accion registrada
     */
    @Override
    public void undoAction(){
        persistenceActions.undoLastAction();
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

    //@Override
    //public Student rotateRol() {
        //persistenceActions.addAction( new Action(Action.Type.listStudents, null));
        //return persistenceStudents.listStudents();
    //}
}