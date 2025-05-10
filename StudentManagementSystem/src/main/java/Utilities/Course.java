
package Utilities;

import Persistence.PersistenceStudentsCourses;
import Persistence.PersistenceWaitingListCourse;
import Persistence.PersistenceRoles;

/**
 *
 * @author Sebas
 */
public class Course {
    
    private String id;
    private String name;
    private Student tutor;
    private PersistenceStudentsCourses enrolledStudents;
    private PersistenceWaitingListCourse waitingList;
    private PersistenceRoles studentsWithAssignedRole;
    
    /**
     * 
     */
    public Course(){}
    /**
     * 
     * @param id
     * @param name
     * @param tutor
     * @param enrolledStudents
     * @param waitingList
     * @param studentsWithAssignedRole 
     */
    public Course(String id, String name, Student tutor, 
            PersistenceStudentsCourses enrolledStudents, 
            PersistenceWaitingListCourse waitingList, PersistenceRoles studentsWithAssignedRole){     
        this.id = id;
        this.name = name;
        this.enrolledStudents = enrolledStudents;
        this.waitingList = waitingList;
        this.studentsWithAssignedRole = studentsWithAssignedRole;
    }
    /**
     * 
     * @return 
     */
    public String getId() {
        return id;
    }
    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @return 
     */
    public Student getTutor() {
        return tutor;
    }

    /**
     * 
     * @param id 
     */        
    public void setId(String id) {
        this.id = id;
    }
    /**
     * 
     * @param name 
     */
    public void setNombre(String name) {
        this.name = name;
    }
    /**
     * 
     * @param tutor 
     */
    public void setTutor(Student tutor) {
        this.tutor = tutor;
    }        
    
    /**
     * 
     */
    public void rotateRol(){
        
    }

      
    /**
     * toString
     * @return 
     */
    
    @Override
    public String toString() {
        return "Curso{" + "Id: " + id + ", Nombre: " + name + ", tutor: " + tutor;
    }
  
}
