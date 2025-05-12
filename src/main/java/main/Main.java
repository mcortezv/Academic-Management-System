/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import gui.MainFrame;
import interfaces.IPersistenceFacade;
import persistences.*;

/**
 *
 
@author Cortez, Manuel;*/
public class Main {

    public static void main(String[] args) {
        IPersistenceFacade persistenceFacade = loader();
        MainFrame mainMenu = new MainFrame(persistenceFacade);
        mainMenu.show();
    }

    public static IPersistenceFacade loader() {
        PersistenceStudents students = new PersistenceStudents();
        PersistenceCourses courses = new PersistenceCourses();
        PersistenceActions actions = new PersistenceActions(students, courses);

        return new PersistenceFacade(
                students,
                courses,
                new PersistenceStudentsCourses(),
                new PersistenceRequests(),
                actions
        );
    }

}