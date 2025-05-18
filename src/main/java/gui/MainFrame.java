/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import gui.styles.Button;
import gui.styles.Style;
import interfaces.IPersistenceFacade;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import gui.panels.CoursePanel;
import gui.panels.EnrollmentPanel;
import gui.panels.GradePanel;
import gui.panels.MainPanel;
import gui.panels.NorthPanel;
import gui.panels.ReportPanel;
import gui.panels.StudentPanel;

/**
 *
 * @author david
 */
public final class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private Button btnStudents;
    private Button btnCourse;
    private Button btnEnrollments;
    private Button btnGrades;
    private Button btnReport;
    private Button btnInUse;
    private MainPanel mainPanel;
    private JPanel centralPanel;
    private NorthPanel northPanel;
    private StudentPanel studentPanel;
    private CoursePanel coursePanel;
    private EnrollmentPanel enrollmentPanel;
    private GradePanel gradePanel;
    private ReportPanel reportPanel;
    private final IPersistenceFacade persistenciaFacade;    

    public MainFrame(IPersistenceFacade persistenciaFacade) {
        this.persistenciaFacade = persistenciaFacade;
        startComponents();
        setTitle("Gestion de estudiantes");
        setSize(1280, 720);
        setJMenuBar(menuBar);
        add(centralPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public IPersistenceFacade getIPersistenceFacade(){
        return persistenciaFacade;
    }

    public void startComponents() {
        menuBar = new JMenuBar();
        btnStudents = new Button("Estudiantes");
        btnCourse = new Button("Cursos");
        btnEnrollments = new Button("Inscripciones");
        btnGrades = new Button("Calificaciones");
        btnReport = new Button("Reportes");
        
        //Main panel
        mainPanel = new MainPanel(persistenciaFacade);
        
        //North panel
        northPanel = new NorthPanel();

        //Central Panel
        centralPanel = new JPanel();
        centralPanel.add(mainPanel);
        centralPanel.setBackground(Style.PANEL_COLOR);
        add(centralPanel, BorderLayout.CENTER);

        // Initialize panels
        studentPanel = new StudentPanel(this, northPanel, persistenciaFacade);
        coursePanel = new CoursePanel(this, northPanel , persistenciaFacade);
        enrollmentPanel = new EnrollmentPanel(this, northPanel , persistenciaFacade);
        gradePanel = new GradePanel(this, northPanel , persistenciaFacade);
        reportPanel = new ReportPanel(this, northPanel, persistenciaFacade);
        reportPanel.startComponents();
        
        add(northPanel, BorderLayout.NORTH);
        northPanel.add(btnStudents);
        northPanel.add(btnCourse);
        northPanel.add(btnEnrollments);
        northPanel.add(btnGrades);
        northPanel.add(btnReport);
        
        //Buttons
        btnStudents.setPreferredSize(new Dimension(170, 40));
        btnCourse.setPreferredSize(new Dimension(170, 40));
        btnEnrollments.setPreferredSize(new Dimension(170, 40));
        btnGrades.setPreferredSize(new Dimension(170, 40));
        btnReport.setPreferredSize(new Dimension(170, 40));
        btnStudents.addActionListener(e -> showPanel(studentPanel));
        btnStudents.addActionListener(e -> {
            btnInUse = btnStudents;
            northPanel.setInUseButton(btnInUse);
        });
        btnCourse.addActionListener(e -> showPanel(coursePanel));
        btnCourse.addActionListener(e -> {
            btnInUse = btnCourse;
            northPanel.setInUseButton(btnInUse);
        });
        btnEnrollments.addActionListener(e -> showPanel(enrollmentPanel));
        btnEnrollments.addActionListener(e -> {
            btnInUse = btnEnrollments;
            northPanel.setInUseButton(btnInUse);
        });
        btnGrades.addActionListener(e -> showPanel(gradePanel));
        btnGrades.addActionListener(e -> {
            btnInUse = btnGrades;
            northPanel.setInUseButton(btnInUse);
        });
        btnReport.addActionListener(e -> showPanel(reportPanel));
        btnReport.addActionListener(e -> {
            btnInUse = btnReport;
            northPanel.setInUseButton(btnInUse);
        });

    }

    //Cambia el valor del panel por el nuevo panel
    private void showPanel(JPanel nuevoPanel) {
        centralPanel.removeAll();
        centralPanel.add(nuevoPanel, BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

    public void showMainPanel() {
        showPanel(mainPanel);
    }

}
