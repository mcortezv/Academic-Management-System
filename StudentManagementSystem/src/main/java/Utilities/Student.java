
package Utilities;

import Persistence.PersistenceGrades;

/**
 *
 * @author Sebas
 */
public class Student {
    private int id;
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
    public Student(int id, String fullName, Contact contactDetails,PersistenceGrades grades, Role rol){   
        this.id = id;
        this.fullName = fullName;
        this.contactDetails = contactDetails;
        this.grades = grades;
        this.rol = rol;
    }
    /**
     * 
     * @return 
     */
    public int getId() {
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
     * @param id 
     */
    public void setId(int id) {
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
    
}
