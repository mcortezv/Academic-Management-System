/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import formsDialog.CourseFormDialog;
import formsDialog.StudentFormDialog;
import gui.MainFrame;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class CoursePanel extends BasePanel {
    JButton btnCreateCourse;
    JButton btnDeleteCourse;
    JButton btnListCourses;

    public CoursePanel(MainFrame frame) {
        super(frame);
    }

    @Override
    public void startComponents() {
        btnCreateCourse =  new JButton("Añadir curso");
        btnDeleteCourse =  new JButton("Eliminar curso");
        btnListCourses =  new JButton("Ver cursos");

        //Buttons
        btnCreateCourse.setPreferredSize(new Dimension(150, 30));;
        btnDeleteCourse.setPreferredSize(new Dimension(150, 30));;
        btnListCourses.setPreferredSize(new Dimension(150, 30));;
            //Create course button
            btnCreateCourse.addActionListener(e -> { 
                new CourseFormDialog(mainFrame, 0).setVisible(true);
            });
            //Delete course button
            btnDeleteCourse.addActionListener(e -> { 
                new CourseFormDialog(mainFrame, 1).setVisible(true);
            });

        //Panels
        centralPanel.add(btnCreateCourse);
        centralPanel.add(btnDeleteCourse);
        southPanel.add(btnListCourses);

    }

}
