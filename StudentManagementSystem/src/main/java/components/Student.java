/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;
import persistence.PersistenceGrades;
import structures.ArrayList;

/**
 *
 * @author Sebas
 */
public class Student implements Comparable<Student> {
    private String id;
    private String fullName;
    private Contact contactDetails;
    private PersistenceGrades grades;
    private Role rol;

    /**
     * 
     */
    public Student(){}

    /**
     * 
     * @param id
     * @param fullName
     * @param contactDetails
     * @param grades
     * @param rol 
     */
    public Student(String id, String fullName, Contact contactDetails,PersistenceGrades grades, Role rol){
        this.id = id;
        this.fullName = fullName;
        this.contactDetails = contactDetails;
        this.grades = grades;
        this.rol = rol;
    }

    /**
     * 
     * @return id String
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @return 
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @return 
     */
    public Contact getContactDetails() {
        return contactDetails;
    }

    /**
     * 
     * @return 
     */
    public Role getRol() {
        return rol;
    }

    /**
     * 
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @param fullName 
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 
     * @param contactDetails 
     */
    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void addGrade(Double grade) {
        grades.addGrade(grade);
    }

    public void updateGrade(Double grade, int index) {
        grades.updateGrade(grade, index);
    }

    public Double getAverage() {
        return grades.getAverage(0, 0.0);
    }

    public ArrayList<Double> listGrades() {
        return grades.listGrades();
    }

    /**
     * 
     * @param rol 
     */
    public void setRol(Role rol) {
        this.rol = rol;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Estudiante{" + "Matricula: " + id + ", Nombre Completo: " + fullName + ", Datos de Contecto: " + contactDetails + ", Rol: " + rol + '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}