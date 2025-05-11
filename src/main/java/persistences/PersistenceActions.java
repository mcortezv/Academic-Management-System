/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Action;
import components.Course;
import components.Student;
import persistences.exceptions.PersistenceActionsException;
import structures.Stack;

/**
 * Clase de persistencia que implementa una pila 
 * @author Sebas
 */
public class PersistenceActions {
    private final Stack<Action> actions;
    private final PersistenceStudents persistenceStudents;
    private final PersistenceCourses persistenceCourses;

    /**
     * 
     * @param persistenceStudents
     * @param persistenceCourses 
     */
    public PersistenceActions(PersistenceStudents persistenceStudents, PersistenceCourses persistenceCourses){
        actions = new Stack<>();
        this.persistenceStudents = persistenceStudents;
        this.persistenceCourses  = persistenceCourses;
    }
    /**
     * 
     * @param action 
     */
    public void addAction(Action action){
        actions.push(action);
    }

    /**
     * 
     */
    public void undoLastAction(){
        if(!actions.isEmpty()){
            Action lastAction = actions.pop();
            performUndo(lastAction);
        }        
    }

    /**
     * 
     * @param action 
     */
    public void performUndo(Action action){
        switch(action.getType()){
            case addStudent -> {
                Student studentToRemove = (Student) action.getData();
                persistenceStudents.removeStudent(studentToRemove);
            }
            case removeStudent -> {
                Student studentToAdd = (Student) action.getData();  
                persistenceStudents.addStudent(studentToAdd);
            }
            case addCourse -> {
                Course courseToRemove = (Course) action.getData();
                persistenceCourses.removeCourse(courseToRemove);
            }
            case removeCourse -> {
                Course courseToadd = (Course) action.getData();
                persistenceCourses.addCourse(courseToadd);
            }
            default -> {
                throw  new PersistenceActionsException("La ultima accion no cumple los requisitos para ser deshecha: " + action.getType());
            }
        }   
    }
}