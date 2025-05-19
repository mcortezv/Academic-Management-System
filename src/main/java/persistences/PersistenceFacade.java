/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.*;
import components.dtos.*;
import interfaces.IPersistenceFacade;
import structures.*;

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
        persistenceActions.addAction(new Action(Action.Type.addStudent, student, "Estudiante (" + student.getId() + ") añadido"));
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
        persistenceActions.addAction(new Action(Action.Type.addCourse, course, "Curso (" + course.getName() + ") añadido"));
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
        persistenceActions.addAction(new Action(Action.Type.removeCourse, course, "Curso (" + course.getName() + ") eliminado"));
        return persistenceCourses.removeCourse(course);
    }

    /**
     * Lista todos los cursos
     *
     * @return cursos del sistema
     */
    @Override
    public HashDictionary<String, Course> lisCourses() {
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
            persistenceActions.addAction(new Action(Action.Type.enrollStudentInCourse, new StudentCourseDTO(student, course), "Etudiante (" + student.getId() + ") inscrito"));
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
            return course.getEnrolledStudents();
        }
        return null;
    }

    /**
     * Lista todos los estudiantes inscritos en un curso.
     *
     * @param id
     * @return cursos del sistema
     */
    @Override
    public ArrayList<Student> showEnrolledStudentsInCourseArrayList(String id) {
        Course course = persistenceCourses.getCourse(id);
        if (course != null) {
            return course.getEnrolledStudentsArrayList();
        }
        return null;
    }

    /**
     * Lista tods los cursos
     *
     * @param id
     * @return cursos del sistema
     */
    @Override
    public PersistenceWaitingListCourses showWaitingListForCourse(String id) {
        Course course = persistenceCourses.getCourse(id);
        if (course != null) {
            return course.getWaitingList();
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ArrayList<Student> showWaitingListForCourseArrayList(String id) {
        Course course = persistenceCourses.getCourse(id);
        if (course != null) {
            return course.getWaitingListArrayList();
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
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO(student, grade, -1);
        if (student != null) {
            student.addGrade(grade);
            persistenceRequests.addRequest(new Request(Request.Type.addGrade, studentGradeDTO));
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
        StudentGradeDTO studentGradeDTO = new StudentGradeDTO(student, grade, index);
        if (student != null) {
            student.updateGrade(grade, index);
            persistenceRequests.addRequest(new Request(Request.Type.updateGrade, studentGradeDTO));
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
    public ArrayList<Student> listStudents() {
        return persistenceStudents.listStudents();
    }

    /**
     * Lista todos los estudiantes agregados al sistema y registra la accion
     *
     * @return arbol binario con los estudiantes
     */
    @Override
    public ArrayList<Student> listStudentsByAverage() {
        return persistenceStudents.listStudentsInOrderFromAVLTree();
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
            persistenceActions.addAction(new Action(Action.Type.rotateRoles, id, "Lider del curso (" + course.getId() + ") rotado"));
            return course.rotateRol();
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public PersistenceStudents getPersistenceStudents() {
        return this.persistenceStudents;
    }

    /**
     *
     * @return
     */
    @Override
    public PersistenceRequests getPersistenceRequests() {
        return this.persistenceRequests;
    }

    /**
     *
     * @return
     */
    @Override
    public PersistenceCourses getPersistenceCourses() {
        return this.persistenceCourses;
    }

    @Override
    public PersistenceActions getPersistenceActions() {
        return this.persistenceActions;
    }

    @Override
    public Course getCourseByName(String name) {
        return persistenceCourses.getCourseByName(name);
    }
}
