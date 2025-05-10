/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import interfaces.IPersistenceFacade;
import persistence.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class Main {

    public static void main(String[] args) {
        IPersistenceFacade persistenceFacade = loader();
        // MainMenu mainMenu = new MainMenu(persistenceFacade);
        // mainMenu.show();
    }

    public static IPersistenceFacade loader(){
        return new PersistenceFacade(
                new PersistenceStudents(),
                new PersistenceGrades(),
                new PersistenceCourses(),
                new PersistenceStudentsCourses(),
                new PersistenceRequests(),
                new PersistenceRoles(),
                new PersistenceWaitingListCourses(),
                new PersistenceActions()
        );
    }
}