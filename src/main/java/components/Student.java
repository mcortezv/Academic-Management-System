/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import persistences.PersistenceGrades;
import structures.ArrayList;
import interfaces.Identificable;

/**
 * Clase que representa un estudiante dentro del sistema
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class Student implements Identificable {

    private String id;
    private String fullName;
    private Contact contactDetails;
    private PersistenceGrades grades;
    private Role rol;

    /**
     * Constructor vacio del estudiante
     */
    public Student() {
    }

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param id
     * @param fullName
     * @param contactDetails
     * @param grades
     * @param rol
     */
    public Student(String id, String fullName, Contact contactDetails, PersistenceGrades grades, Role rol) {
        this.id = id;
        this.fullName = fullName;
        this.contactDetails = contactDetails;
        this.grades = grades;
        this.rol = rol;
    }

    /**
     * Obtiene el id del estudiante
     *
     * @return id del estudiante
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del estudiante
     *
     * @return nombre del estudiante
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Obtiene la instancia del contacto del estudiante
     *
     * @return instancia del contacto
     */
    public Contact getContactDetails() {
        return contactDetails;
    }

    /**
     * Obtiene el rol que el estudiante tiene asignado
     *
     * @return rol
     */
    public Role getRol() {
        return rol;
    }

    /**
     * Establece el id del estudiante al valor de su parametro
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Establece el nombre completo del estudiante al valor de su parametro
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Establece el contacto del estudiante al valor de su parametro
     *
     * @param contactDetails
     */
    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * Agrega la calificacion obtenida del parametro al arreglo de
     * calificaciones del estudiante
     *
     * @param grade
     */
    public void addGrade(Double grade) {
        grades.addGrade(grade);
    }

    /**
     * Actualiza una calificacion obtenida del parametro
     *
     * @param grade
     * @param index
     */
    public void updateGrade(Double grade, int index) {
        grades.updateGrade(grade, index);
    }

    /**
     * Calcula el promedio del calificacion del estudiante
     *
     * @return average
     */
    @Override
    public Double getAverage() {
        return grades.getAverage(0, 0.0);
    }

    /**
     * Lista todas las calificaciones del estudiante
     *
     * @return grades 
     */
    public ArrayList<Double> listGrades() {
        return grades.listGrades();
    }

    /**
     * Establece el rol del estudiante al valor de su parametro
     *
     * @param rol a asignar
     */
    public void setRol(Role rol) {
        this.rol = rol;
    }

    /**
     * Compara la instancia del estudiante con otro objeto que implementa la
     * interfaz
     *
     * @param o el objeto con el cual se compara el estudiante
     * @return
     */
    @Override
    public int compareTo(Identificable o) {
        return this.id.compareTo(o.getId());
    }

    /**
     * Metodo que regresa una cadena de texto con todos los atributos de la
     * instancia
     *
     * @return
     */
    @Override
    public String toString() {
        return "Estudiante{" + "Matricula: " + id + ", Nombre Completo: " + fullName + ", Datos de Contecto: " + contactDetails + ", Rol: " + rol + '}';
    }

}
