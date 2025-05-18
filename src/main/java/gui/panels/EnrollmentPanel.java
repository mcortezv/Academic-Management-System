/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;

import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;
import interfaces.IPersistenceFacade;

import java.awt.Dimension;

/**
 *
 * @author david
 */
public class EnrollmentPanel extends Panel {
    private Button btnEnrollStudent;
    private Button btnEnrolledStudents;
    private Button btnWaitList;
    private IPersistenceFacade persistenceFacade;

    public EnrollmentPanel(MainFrame frame, NorthPanel northPanel, IPersistenceFacade persistenceFacade) {
        super(frame, northPanel);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnEnrollStudent =  new Button("Inscribir Alumno");
        btnEnrolledStudents =  new Button("Ver estudiantes inscritos");
        btnWaitList =  new Button("<html><div style='text-align: center;'>Ver lista de espera<br>de un curso</div></html>");

        //Buttons
        btnEnrollStudent.setPreferredSize(new Dimension(150, 30));
        btnEnrolledStudents.setPreferredSize(new Dimension(180, 40));
        btnWaitList.setPreferredSize(new Dimension(180, 40));

        //Panels
        centralPanel.add(btnEnrollStudent);
        southPanel.add(btnEnrolledStudents);
        southPanel.add(btnWaitList);

    }

}
