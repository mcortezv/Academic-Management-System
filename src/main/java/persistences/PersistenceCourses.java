/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.*;
import structures.HashDictionary;

/**
 * Clase de persistencia que almacena cursos en un Diccionario
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public final class PersistenceCourses {
    private HashDictionary<String, Course> courses;

    /**
     * Constructor que inicializa el atributo de la clase
     */
    public PersistenceCourses() {
        this.courses = new HashDictionary<>(10);
        populateCourses();
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
     * Regresa el curso correspondiente al id que recibe como parametro.
     *
     * @return courses
     */
    public Course getCourse(String id){
        return courses.get(id);
    }

    /**
     * Regresa la lista de cursos del sistema
     *
     * @return courses
     */
    public HashDictionary<String, Course> listCourses() {
        return courses;
    }
    
    public void populateCourses() {
        Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Student student1 = new Student("2222BBBB", "Sebas", datosContacto);
        Course course = new Course("1111AAAA","cursoA",student1);
        courses.put("1111AAAA", course);
    }
    /**
     * 
     * @param name
     * @return 
     */
    public Course getCourseByName(String name){
        for (String key : courses.getKeys()) {
        Course course = courses.get(key);
        if (course.getName().equalsIgnoreCase(name.trim())) {
            return course;
        }
    }
    return null;
    }
}
