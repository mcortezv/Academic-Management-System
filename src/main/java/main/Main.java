/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import gui.MainFrame;
import interfaces.IPersistenceFacade;
import persistences.*;

/**
 *  Clase main que contiene el metodo que iniciará la logica contenida en el sistema
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class Main {
    
    /**
     * Metodo main que ejecutará la lógica contenida en el sistema
     * @param args 
     */
    public static void main(String[] args) {
        IPersistenceFacade persistenceFacade = loader();
        MainFrame mainMenu = new MainFrame(persistenceFacade);
        mainMenu.show();
    }
    
    /**
     * 
     * @return PersistenceFacade la persistencia para iniciar el sistema
     */
    public static IPersistenceFacade loader() {
        PersistenceStudents students = new PersistenceStudents();
        PersistenceCourses courses = new PersistenceCourses();
        PersistenceActions actions = new PersistenceActions(students, courses);
        return new PersistenceFacade(
                students,
                courses,
                new PersistenceStudentsCourses(),
                new PersistenceRequests(actions),
                actions
        );
    }
}
