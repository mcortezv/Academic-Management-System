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
 * Clase de persistencia que almacena acciones en una pila
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceActions {

    private final Stack<Action> actions;
    private final PersistenceStudents persistenceStudents;
    private final PersistenceCourses persistenceCourses;

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param persistenceStudents estudiantes
     * @param persistenceCourses cursos
     */
    public PersistenceActions(PersistenceStudents persistenceStudents, PersistenceCourses persistenceCourses) {
        actions = new Stack<>();
        this.persistenceStudents = persistenceStudents;
        this.persistenceCourses = persistenceCourses;
    }

    /**
     * Metodo que añade la accion accion recibida al parametro a la pila de
     * acciones
     *
     * @param action accion a añadir a la pila
     */
    public void addAction(Action action) {
        actions.push(action);
    }

    /**
     * Metodo que remueve la ultima accion añadida a la pila de acciones
     */
    public void undoLastAction() {
        if (!actions.isEmpty()) {
            Action lastAction = actions.pop();
            performUndo(lastAction);
        }
    }

    /**
     * Metodo que realiza la accion contraria al tipo de la accion recibida a su
     * parametro
     *
     * @param action accion a deshacer
     */
    public void performUndo(Action action) {
        switch (action.getType()) {
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
                throw new PersistenceActionsException("La ultima accion no cumple los requisitos para ser deshecha: " + action.getType());
            }
        }
    }
}
