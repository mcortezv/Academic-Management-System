/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import components.Course;
import components.Student;
import persistences.PersistenceStudents;
import persistences.PersistenceStudentsCourses;
import persistences.PersistenceWaitingListCourses;
import structures.ArrayList;
import structures.BinarySearchTree;
import structures.HashDictionary;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IPersistenceFacade {

    void addStudent(Student student);

    Student searchStudentById(String id);

    Course addCourse(Course course);

    Course deleteCourse(Course course);

    HashDictionary<String, Course> lisCourses();

    void enrollStudentInCourse(String studentId, String courseId);

    PersistenceStudentsCourses showEnrolledStudentsInCourse(String id);

    PersistenceWaitingListCourses showWaitingListForCourse(String id);

    void processNextRequest();
    
    void requestAddGrade(String studentId, Double grade);

    void requestUpdateGrade(String studentId, Double grade, int index);

    Double getAverage(String studentId);

    ArrayList<Double> requestListGrades(String studentId);

    void undoAction();

    ArrayList<Student> listStudents();

    ArrayList<Student> listStudentsByAverage();

    Student rotateRol(String id);
    
    PersistenceStudents getPersistenceStudents();
}