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
        super(frame, northPanel, persistenceFacade);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnEnrollStudent =  new Button("Inscribir Alumno");
        btnEnrolledStudents =  new Button("Ver Estudiantes Inscritos");
        btnWaitList =  new Button("Ver Lista de Espera");

        //Buttons
        btnEnrollStudent.setPreferredSize(new Dimension(230, 40));
        btnEnrolledStudents.setPreferredSize(new Dimension(230, 40));
        btnWaitList.setPreferredSize(new Dimension(230, 40));

        //Panels
        centralPanel.add(btnEnrollStudent);
        centralPanel.add(btnEnrolledStudents);
        centralPanel.add(btnWaitList);

    }

}
