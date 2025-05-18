/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;
import gui.formsDialog.CourseFormDialog;
import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;
import interfaces.IPersistenceFacade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class CoursePanel extends Panel {
    private Button btnCreateCourse;
    private Button btnDeleteCourse;
    private Button btnListCourses;
    private Button btnRotateRole;
    private JPanel mainCoursePanel;
    private CourseTablePanel courseTablePanel;
    private IPersistenceFacade persistenceFacade;

    public CoursePanel(MainFrame frame, NorthPanel northPanel, IPersistenceFacade persistenceFacade) {
        super(frame, northPanel);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnCreateCourse = new Button("Añadir curso");
        btnDeleteCourse = new Button("Eliminar curso");
        btnListCourses = new Button("Ver cursos");
        btnRotateRole = new Button("Rotar rol de estudiante");
        mainCoursePanel = new JPanel();
        courseTablePanel = new CourseTablePanel(mainFrame.getIPersistenceFacade().lisCourses(), this, persistenceFacade);
        
        
        //comentarioxxx
        //Main course panel
        mainCoursePanel.setLayout(new FlowLayout());
        mainCoursePanel.setPreferredSize(new Dimension(200, 300));
        mainCoursePanel.setBorder(BorderFactory.createEmptyBorder( 0, 0, 0, 0));

        //Buttons
        btnCreateCourse.setPreferredSize(new Dimension(150, 30));
        btnDeleteCourse.setPreferredSize(new Dimension(150, 30));
        btnListCourses.setPreferredSize(new Dimension(150, 30));
        btnRotateRole.setPreferredSize(new Dimension(150, 30));
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
        //Rotate role in course button
        btnRotateRole.addActionListener(e -> {
            new CourseFormDialog(mainFrame, 0).setVisible(true);
        });

        //Panels
        mainCoursePanel.add(btnCreateCourse);
        mainCoursePanel.add(btnDeleteCourse);
        mainCoursePanel.add(btnListCourses);
        mainCoursePanel.add(btnRotateRole);
        centralPanel.setLayout(new BorderLayout());
        centralPanel.add(mainCoursePanel, BorderLayout.CENTER);
        
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
