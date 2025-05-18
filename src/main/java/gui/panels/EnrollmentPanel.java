/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;
import gui.MainFrame;
import gui.formsDialog.EnrollFormDialog;
import gui.styles.Panel;
import gui.styles.Button;
import interfaces.IPersistenceFacade;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author david
 */
public class EnrollmentPanel extends Panel {
    private Button btnEnrollStudent;
    private Button btnEnrolledStudents;
    private Button btnWaitList;
    private JTextArea textArea;
    private JScrollPane jps;
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
        textArea = new JTextArea(18, 21);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        jps = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Buttons
        btnEnrollStudent.setPreferredSize(new Dimension(230, 40));
        btnEnrolledStudents.setPreferredSize(new Dimension(230, 40));
        btnWaitList.setPreferredSize(new Dimension(230, 40));

        //Panels
        centralPanel.add(btnEnrollStudent);
        centralPanel.add(btnEnrolledStudents);
        centralPanel.add(btnWaitList);
        centralPanel.add(jps);

        //button
        btnEnrollStudent.addActionListener(e -> {
            new EnrollFormDialog(mainFrame, 0, persistenceFacade, this).setVisible(true);
        });

        btnEnrolledStudents.addActionListener(e -> {
            new EnrollFormDialog(mainFrame, 1, persistenceFacade, this).setVisible(true);
        });

        btnWaitList.addActionListener(e -> {
            new EnrollFormDialog(mainFrame, 2, persistenceFacade, this).setVisible(true);
        });
    }

    public JTextArea getTextArea(){
        return textArea;
    }
}
