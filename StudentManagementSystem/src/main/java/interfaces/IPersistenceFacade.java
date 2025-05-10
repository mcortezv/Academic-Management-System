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

    BinarySearchTree<Student> listStudents();

    void addGrade(double grade);

    void updateGrade(double grade, int index);

    double getAverage(double[] grades);

    ArrayList<Double> listGrades();

    Course addCourse(Course course);

    Course deleteCourse(Course course);

    HashDictionary<String, Course> lisCourses();
}