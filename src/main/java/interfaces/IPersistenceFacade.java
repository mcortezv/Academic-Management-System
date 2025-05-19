/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import components.*;
import persistences.*;
import structures.*;

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

    ArrayList<Student> showEnrolledStudentsInCourseArrayList(String id);

    PersistenceWaitingListCourses showWaitingListForCourse(String id);

    ArrayList<Student> showWaitingListForCourseArrayList(String id);

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

    PersistenceRequests getPersistenceRequests();

    PersistenceCourses getPersistenceCourses();
    
    PersistenceActions getPersistenceActions();
    
    Course getCourseByName(String name);
}