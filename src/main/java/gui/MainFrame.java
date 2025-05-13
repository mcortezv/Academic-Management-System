/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import interfaces.IPersistenceFacade;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import panels.CoursePanel;
import panels.EnrollmentPanel;
import panels.GradePanel;
import panels.MainPanel;
import panels.NorthPanel;
import panels.ReportPanel;
import panels.StudentPanel;
import persistences.*;

/**
 *
 * @author david
 */
public final class MainFrame extends JFrame {

    private final IPersistenceFacade persistence;
    private JMenuBar menuBar;
    private JButton btnStudents;
    private JButton btnCourse;
    private JButton btnEnrollments;
    private JButton btnGrades;
    private JButton btnReport;
    private MainPanel mainPanel;
    private JPanel centralPanel;
    private JPanel northPanel;
    private StudentPanel studentPanel;
    private CoursePanel coursePanel;
    private EnrollmentPanel enrollmentPanel;
    private GradePanel gradePanel;
    private ReportPanel reportPanel;

    public MainFrame(IPersistenceFacade persistence) {
        startComponetns();
        this.persistence = persistence;
        setTitle("Gestion de estudiantes");
        setSize(800, 500);
        setJMenuBar(menuBar);
        add(centralPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void startComponetns() {
        menuBar = new JMenuBar();
        btnStudents = new JButton("Estudiantes");
        btnCourse = new JButton("Cursos");
        btnEnrollments = new JButton("Inscripciones");
        btnGrades = new JButton("Calificaciones");
        btnReport = new JButton("Reportes");

        //Main panel
        mainPanel = new MainPanel();

        // Initialize panels
        studentPanel = new StudentPanel(this, persistence);
        coursePanel = new CoursePanel(this);
        enrollmentPanel = new EnrollmentPanel(this);
        gradePanel = new GradePanel(this);
        reportPanel = new ReportPanel(this);

        //Buttons
        btnStudents.addActionListener(e -> showPanel(studentPanel));
        btnCourse.addActionListener(e -> showPanel(coursePanel));
        btnEnrollments.addActionListener(e -> showPanel(enrollmentPanel));
        btnGrades.addActionListener(e -> showPanel(gradePanel));
        btnReport.addActionListener(e -> showPanel(reportPanel));

        //Central Panel
        centralPanel = new JPanel();
        centralPanel.add(mainPanel);
        add(centralPanel, BorderLayout.CENTER);

        //North panel
        northPanel = new NorthPanel();
        northPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(northPanel, BorderLayout.NORTH);
        northPanel.add(btnStudents);
        northPanel.add(btnCourse);
        northPanel.add(btnEnrollments);
        northPanel.add(btnGrades);
        northPanel.add(btnReport);

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
