/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Course;
import structures.HashDictionary;

/**
 * Clase de persistencia que almacena cursos en un Diccionario
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceCourses {

    private HashDictionary<String, Course> courses;

    /**
     * Constructor que inicializa el atributo de la clase
     */
    public PersistenceCourses() {
        this.courses = new HashDictionary<>(10);
    }

    /**
     * Agrega un curso recibido del parametro a el diccionario
     *
     * @param course
     * @return course
     */
    public Course addCourse(Course course) {
        courses.put(course.getId(), course);
        return course;
    }

    /**
     * Remueve del diccionario el curso recibido del parametro
     *
     * @param course
     * @return course, null si no se encontro en el diccionario
     */
    public Course removeCourse(Course course) {
        if (courses.remove(course.getId())) {
            return course;
        }
        return null;
    }

    /**
     * Regresa la lista de cursos del sistema
     *
     * @return courses
     */
    public HashDictionary<String, Course> listCourses() {
        return courses;
    }
}
