/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Course;
import structures.HashDictionary;

/**
 *
 * @author Sebas
 */
public class PersistenceCourses {
    private HashDictionary<String, Course> courses;

    public PersistenceCourses(){
        this.courses = new HashDictionary<String, Course>(10);
    }

    public Course addCourse(Course course){
        courses.put(course.getId(), course);
        return course;
    }

    public Course removeCourse(Course course){
        if (courses.remove(course.getId())){
            return course;
        }
        return null;
    }

    public HashDictionary<String, Course> listCourses(){
        return courses;
    }
}