/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import gui.MainFrame;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class EnrollmentPanel extends BasePanel{
    JButton btnEnrollStudent;
    JButton btnEnrolledStudents;
    JButton btnWaitList;

    public EnrollmentPanel(MainFrame frame) {
        super(frame);
    }

    @Override
    public void startComponents() {
        btnEnrollStudent =  new JButton("Inscribir Alumno");
        btnEnrolledStudents =  new JButton("Ver estudiantes inscritos");
        btnWaitList =  new JButton("<html><div style='text-align: center;'>Ver lista de espera<br>de un curso</div></html>");

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
