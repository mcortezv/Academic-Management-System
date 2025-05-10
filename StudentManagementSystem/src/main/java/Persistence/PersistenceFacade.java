/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;
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
    private PersistenceGrades persistenceGrades;
    private PersistenceCourses persistenceCourses;
    private PersistenceStudentsCourses persistenceStudentsCourses;
    private PersistenceRequests persistenceRequests;
    private PersistenceRoles persistenceRoles;
    private PersistenceWaitingListCourses persistenceWaitingListCourses;
    private PersistenceActions persistenceActions;

    public PersistenceFacade(PersistenceStudents persistenceStudents, PersistenceGrades persistenceGrades,
                             PersistenceCourses persistenceCourses, PersistenceStudentsCourses persistenceStudentsCourses,
                             PersistenceRequests persistenceRequests, PersistenceRoles persistenceRoles,
                             PersistenceWaitingListCourses persistenceWaitingListCourses, PersistenceActions persistenceActions){
        this.persistenceStudents = persistenceStudents;
        this.persistenceGrades = persistenceGrades;
        this.persistenceCourses = persistenceCourses;
        this.persistenceStudentsCourses = persistenceStudentsCourses;
        this.persistenceRequests = persistenceRequests;
        this.persistenceRoles = persistenceRoles;
        this.persistenceWaitingListCourses = persistenceWaitingListCourses;
        this.persistenceActions = persistenceActions;
    }

    @Override
    public void addStudent(Student student) {
        persistenceStudents.addStudent(student);
    }

    @Override
    public Student searchStudentById(String id) {
        return persistenceStudents.searchStudent(id);
    }

    @Override
    public BinarySearchTree<Student> listStudents() {
        return persistenceStudents.listStudents();
    }

    @Override
    public void addGrade(double grade) {
        persistenceGrades.addGrade(grade);
    }

    @Override
    public void updateGrade(double grade, int index) {
        persistenceGrades.updateGrade(grade, index);
    }

    @Override
    public double getAverage(double[] grades) {
        return persistenceGrades.getAverage();
    }

    @Override
    public ArrayList<Double> listGrades() {
        return persistenceGrades.listGrades();
    }

    @Override
    public Course addCourse(Course course) {
        return persistenceCourses.addCourse(course);
    }

    @Override
    public Course deleteCourse(Course course) {
        return persistenceCourses.removeCourse(course);
    }

    @Override
    public HashDictionary<String, Course> lisCourses() {
        return persistenceCourses.listCourses();
    }
}