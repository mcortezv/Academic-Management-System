/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;

import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;
import java.awt.Dimension;

/**
 *
 * @author david
 */
public class EnrollmentPanel extends Panel {
    Button btnEnrollStudent;
    Button btnEnrolledStudents;
    Button btnWaitList;

    public EnrollmentPanel(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);
    }

    @Override
    public void startComponents() {
        btnEnrollStudent =  new Button("Inscribir Alumno");
        btnEnrolledStudents =  new Button("Ver estudiantes inscritos");
        btnWaitList =  new Button("<html><div style='text-align: center;'>Ver lista de espera<br>de un curso</div></html>");

        //Buttons
        btnEnrollStudent.setPreferredSize(new Dimension(175, 30));
        btnEnrolledStudents.setPreferredSize(new Dimension(175, 40));
        btnWaitList.setPreferredSize(new Dimension(180, 40));

        //Panels
        centralPanel.add(btnEnrollStudent);
        southPanel.add(btnEnrolledStudents);
        southPanel.add(btnWaitList);

    }

}
