/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import formsDialog.CourseFormDialog;
import formsDialog.StudentFormDialog;
import gui.MainFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class CoursePanel extends BasePanel {

    private JButton btnCreateCourse;
    private JButton btnDeleteCourse;
    private JButton btnListCourses;
    private JPanel mainCoursePanel;
    private CourseTablePanel courseTablePanel;

    public CoursePanel(MainFrame frame) {
        super(frame);
    }

    @Override
    public void startComponents() {
        btnCreateCourse = new JButton("Añadir curso");
        btnDeleteCourse = new JButton("Eliminar curso");
        btnListCourses = new JButton("Ver cursos");
        mainCoursePanel = new JPanel();
        courseTablePanel = new CourseTablePanel(mainFrame.getIPersistenceFacade().lisCourses(), this);
        
        //Main course panel
        mainCoursePanel.setLayout(new FlowLayout());
        mainCoursePanel.setPreferredSize(new Dimension(200, 300));
        mainCoursePanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 0, 150));

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
        //List courses button asdasda
        btnListCourses.addActionListener(e -> {
            showPanel(courseTablePanel);
        });

        //Panels
        mainCoursePanel.add(btnCreateCourse);
        mainCoursePanel.add(btnDeleteCourse);
        mainCoursePanel.add(btnListCourses);
        centralPanel.add(mainCoursePanel);
        

    }

    private void showPanel(JPanel nuevoPanel) {
        removeAll();
        add(nuevoPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void showCoursePanel() {
        showPanel(mainCoursePanel);
        add(southPanel, BorderLayout.SOUTH);
        
    }

}
