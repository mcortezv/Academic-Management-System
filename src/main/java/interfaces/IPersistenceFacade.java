/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import components.Course;
import components.Student;
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

    void listEnrolledInCourse(String id);

    void showWaitingListForCourse(String id);

    void addGrade(String studentId, Double grade);

    void updateGrade(String studentId, Double grade, int index);

    Double getAverage(String studentId);

    ArrayList<Double> listGrades(String studentId);

    void undoAction();

    BinarySearchTree<Student> listStudentsByAverage();

    Student rotateRol(String id);
}