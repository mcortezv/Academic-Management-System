/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

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
    JButton btnAddCourse;
    JButton btnDeleteCourse;
    JButton btnListCourses;

    public CoursePanel(MainFrame frame) {
        super(frame);
    }

    @Override
    public void startComponents() {
        btnAddCourse =  new JButton("Añadir curso");
        btnDeleteCourse =  new JButton("Eliminar curso");
        btnListCourses =  new JButton("Ver cursos");

        //Buttons
        btnAddCourse.setPreferredSize(new Dimension(150, 30));;
        btnDeleteCourse.setPreferredSize(new Dimension(150, 30));;
        btnListCourses.setPreferredSize(new Dimension(150, 30));;

        //Panels
        centralPanel.add(btnAddCourse);
        centralPanel.add(btnDeleteCourse);
        southPanel.add(btnListCourses);

    }

}
