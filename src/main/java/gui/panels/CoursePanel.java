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
import java.awt.*;
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
        super(frame, northPanel, persistenceFacade);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnCreateCourse = new Button("Añadir Curso");
        btnDeleteCourse = new Button("Eliminar Curso");
        btnListCourses = new Button("Ver Cursos");
        btnRotateRole = new Button("Rotar Rol");
        mainCoursePanel = new JPanel();
        mainCoursePanel.setBackground(Color.WHITE);



        //comentarioxxx
        //Main course panel
        mainCoursePanel.setLayout(new FlowLayout());
        mainCoursePanel.setPreferredSize(new Dimension(200, 300));


        //Buttons
        btnCreateCourse.setPreferredSize(new Dimension(180, 40));
        btnDeleteCourse.setPreferredSize(new Dimension(180, 40));
        btnListCourses.setPreferredSize(new Dimension(180, 40));
        btnRotateRole.setPreferredSize(new Dimension(180, 40));
        //Create course button
        btnCreateCourse.addActionListener(e -> {
            new CourseFormDialog(mainFrame, 0,persistenceFacade).setVisible(true);
        });
        //Delete course button
        btnDeleteCourse.addActionListener(e -> {
            new CourseFormDialog(mainFrame, 1,persistenceFacade).setVisible(true);
        });
        //List courses button asdasda
        btnListCourses.addActionListener(e -> {
            courseTablePanel = new CourseTablePanel(this, persistenceFacade);
            repaint();
            showPanel(courseTablePanel);
        });
        //Rotate role in course button
        btnRotateRole.addActionListener(e -> {
            new CourseFormDialog(mainFrame, 2,persistenceFacade).setVisible(true);
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
        showPanel(centralPanel);
        add(southPanel, BorderLayout.SOUTH);
    }
}
