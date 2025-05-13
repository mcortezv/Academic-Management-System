/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Action;
import components.Course;
import components.Request;
import components.Student;
import components.StudentCourse;
import interfaces.IPersistenceFacade;
import structures.ArrayList;
import structures.BinarySearchTree;
import structures.HashDictionary;

/**
 * Clase que actua como fachada para las distintas capas de persistencia del
 * sistema
 *
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
     *
     * @param persistenceStudents
     * @param persistenceCourses
     * @param persistenceStudentsCourses
     * @param persistenceRequests
     * @param persistenceActions
     */
    public PersistenceFacade(PersistenceStudents persistenceStudents, PersistenceCourses persistenceCourses,
            PersistenceStudentsCourses persistenceStudentsCourses, PersistenceRequests persistenceRequests,
            PersistenceActions persistenceActions) {
        this.persistenceStudents = persistenceStudents;
        this.persistenceCourses = persistenceCourses;
        this.persistenceStudentsCourses = persistenceStudentsCourses;
        this.persistenceRequests = persistenceRequests;
        this.persistenceActions = persistenceActions;
    }

    /**
     * Agrega un estudiante al sistema y registra la accion
     *
     * @param student el estudiante a agregar
     */
    @Override
    public void addStudent(Student student) {
        persistenceActions.addAction(new Action(Action.Type.addStudent, student));
        persistenceStudents.addStudent(student);
    }

    /**
     * Busca un estudiante por su id y registra la accion
     *
     * @param id del estudiante
     * @return instancia del estudiante encontrado o null
     */
    @Override
    public Student searchStudentById(String id) {
        persistenceActions.addAction(new Action(Action.Type.searchStudent, id));
        return persistenceStudents.searchStudent(id);
    }

    /**
     * Agrega un curso
     *
     * @param course curso a agregar
     * @return course
     */
    @Override
    public Course addCourse(Course course) {
        persistenceActions.addAction(new Action(Action.Type.addCourse, course));
        return persistenceCourses.addCourse(course);
    }

    /**
     * Elimina un curso
     *
     * @param course
     * @return course curso eliminado
     */
    @Override
    public Course deleteCourse(Course course) {
        persistenceActions.addAction(new Action(Action.Type.removeCourse, course));
        return persistenceCourses.removeCourse(course);
    }

    /**
     * Lista todos los cursos
     *
     * @return cursos del sistema
     */
    @Override
    public HashDictionary<String, Course> lisCourses() {
        persistenceActions.addAction(new Action(Action.Type.listCourses, null));
        return persistenceCourses.listCourses();
    }

    /**
     * Permite inscribir a un estudiante en un curso.
     *
     * @param studentId String
     * @param courseId String
     */
    @Override
    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = persistenceStudents.searchStudent(studentId);
        Course course = persistenceCourses.getCourse(courseId);
        if (course != null && student != null) {
            persistenceActions.addAction(new Action(Action.Type.enrollStudentInCourse, new StudentCourse(student, course)));
            course.getEnrolledStudents().enrollStudentCourse(student);
        }
    }

    /**
     * Lista todos los estudiantes inscritos en un curso.
     *
     * @return cursos del sistema
     */
    @Override
    public PersistenceStudentsCourses showEnrolledStudentsInCourse(String id) {
        Course course = persistenceCourses.getCourse(id);
        if (course != null) {
            persistenceActions.addAction(new Action(Action.Type.showEnrolledStudentsInCourse, id));
            return course.getEnrolledStudents();
        }
        return null;
    }

    /**
     * Lista tods los cursos
     *
     * @return cursos del sistema
     */
    @Override
    public PersistenceWaitingListCourses showWaitingListForCourse(String id) {
        Course course = persistenceCourses.getCourse(id);
        if (course != null) {
            persistenceActions.addAction(new Action(Action.Type.showWaitingListForCourse, id));
            return course.getWaitingList();
        }
        return null;
    }

    /**
     *
 
     */
    @Override
    public void processNextRequest() {
        persistenceRequests.processNextRequest();
    }

    /**
     * Agrega una calificacion
     *
     * @param studentId
     * @param grade calificacion a añadir
     */
    @Override
    public void requestAddGrade(String studentId, Double grade) {
        Student student = persistenceStudents.searchStudent(studentId);
        if (student != null) {
            student.addGrade(grade);
            persistenceRequests.addRequest(new Request(Request.Type.addGrade, student, grade));
        }
    }

    /**
     * Actualiza una calificacion
     *
     * @param studentId
     * @param grade calificacion a actualizar
     * @param index indice del arreglo en el que se hará la actualizacion
     */
    @Override
    public void requestUpdateGrade(String studentId, Double grade, int index) {
        Student student = persistenceStudents.searchStudent(studentId);
        if (student != null) {
            student.updateGrade(grade, index);
            persistenceRequests.addRequest(new Request(Request.Type.updateGrade, student, grade, index));
        }
    }

    /**
     * Obtiene el promedio de calificacion de un estudiante
     *
     * @param studentId
     * @return double
     */
    @Override
    public Double getAverage(String studentId) {
        Student student = persistenceStudents.searchStudent(studentId);
        if (student != null) {
            persistenceActions.addAction(new Action(Action.Type.getAverage, studentId));
            return student.getAverage();
        }
        return null;
    }

    /**
     * Lista el arreglo de calificaciones
     *
     * @param studentId
     * @return
     */
    @Override
    public ArrayList<Double> requestListGrades(String studentId) {
        Student student = persistenceStudents.searchStudent(studentId);
        if (student != null) {
            persistenceActions.addAction(new Action(Action.Type.listGrades, studentId));
            return student.listGrades();
        }
        return null;
    }

    /**
     * Deshace la ultima accion registrada
     */
    @Override
    public void undoAction() {
        persistenceActions.undoLastAction();
    }

    /**
     * Lista todos los estudiantes agregados al sistema y registra la accion
     *
     * @return arbol binario con los estudiantes
     */
    @Override
    public BinarySearchTree<Student> listStudentsByAverage() {
        persistenceActions.addAction(new Action(Action.Type.listStudents, null));
        return persistenceStudents.listStudents();
    }

    /**
     * Rota el rol de los estudiantes de un curso, recibe como parametro el id
     * del curso
     *
     * @param id String
     * @return Estudiante
     */
    @Override
    public Student rotateRol(String id) {
        Course course = persistenceCourses.getCourse(id);
        if (course != null) {
            persistenceActions.addAction(new Action(Action.Type.rotateRoles, id));
            return course.rotateRol();
        }
        return null;
    }
}
