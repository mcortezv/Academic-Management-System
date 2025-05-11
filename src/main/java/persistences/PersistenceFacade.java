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
 *
 * @author Cortez, Manuel;
 */
public class PersistenceFacade implements IPersistenceFacade {
    private PersistenceStudents persistenceStudents;
    private PersistenceCourses persistenceCourses;
    private PersistenceStudentsCourses persistenceStudentsCourses;
    private PersistenceRequests persistenceRequests;
    private PersistenceActions persistenceActions;

    public PersistenceFacade(PersistenceStudents persistenceStudents, PersistenceCourses persistenceCourses,
                             PersistenceStudentsCourses persistenceStudentsCourses, PersistenceRequests persistenceRequests,
                             PersistenceActions persistenceActions){
        this.persistenceStudents = persistenceStudents;
        this.persistenceCourses = persistenceCourses;
        this.persistenceStudentsCourses = persistenceStudentsCourses;
        this.persistenceRequests = persistenceRequests;
        this.persistenceActions = persistenceActions;
    }

    @Override
    public void addStudent(Student student) {
        persistenceActions.addAction( new Action(Action.Type.addStudent, student));
        persistenceStudents.addStudent(student);
    }

    @Override
    public Student searchStudentById(String id) {
        persistenceActions.addAction( new Action(Action.Type.searchStudent, id));
        return persistenceStudents.searchStudent(id);
    }

    @Override
    public BinarySearchTree<Student> listStudents() {
        persistenceActions.addAction( new Action(Action.Type.listStudents, null));
        return persistenceStudents.listStudents();
    }

    @Override
    public void addGrade(Double grade) {

    }

    @Override
    public void updateGrade(Double grade, int index) {

    }

    @Override
    public Double getAverage() {
        return null;
    }

    @Override
    public ArrayList<Double> listGrades() {
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        persistenceActions.addAction( new Action(Action.Type.addCourse, course));
        return persistenceCourses.addCourse(course);
    }

    @Override
    public Course deleteCourse(Course course) {
        persistenceActions.addAction( new Action(Action.Type.removeCourse, course));
        return persistenceCourses.removeCourse(course);
    }

    @Override
    public HashDictionary<String, Course> lisCourses() {
        persistenceActions.addAction( new Action(Action.Type.listCourses, null));
        return persistenceCourses.listCourses();
    }

    @Override
    public void undoAction(){
        persistenceActions.undoLastAction();
    }
}