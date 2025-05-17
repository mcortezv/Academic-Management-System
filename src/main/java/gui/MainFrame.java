/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import interfaces.IPersistenceFacade;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import persistences.PersistenceFacade;

/**
 *
 * @author david
 */
public class MainFrame extends JFrame {

    private JMenuBar menuBar;
    private JButton btnStudents;
    private JButton btnCourse;
    private JButton btnEnrollments;
    private JButton btnGrades;
    private JButton btnReport;
    private JButton btnInUse;
    private MainPanel mainPanel;
    private JPanel centralPanel;
    private NorthPanel northPanel;
    private StudentPanel studentPanel;
    private CoursePanel coursePanel;
    private EnrollmentPanel enrollmentPanel;
    private GradePanel gradePanel;
    private ReportPanel reportPanel;
    private IPersistenceFacade persistenciaFacade;

    public MainFrame(IPersistenceFacade persistenciaFacade) {
        this.persistenciaFacade = persistenciaFacade;
        starComponetns();
        setTitle("Gestion de estudiantes");
        setSize(800, 500);
        setJMenuBar(menuBar);
        add(centralPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public IPersistenceFacade getIPersistenceFacade(){
        return persistenciaFacade;
    }

    public void starComponetns() {
        menuBar = new JMenuBar();
        btnStudents = new JButton("Estudiantes");
        btnCourse = new JButton("Cursos");
        btnEnrollments = new JButton("Inscripciones");
        btnGrades = new JButton("Calificaciones");
        btnReport = new JButton("Reportes");
        setBackground(Color.WHITE);

        //Main panel
        mainPanel = new MainPanel();
        mainPanel.setBackground(Color.WHITE);
        
        //North panel
        northPanel = new NorthPanel();
        
        //Central Panel
        centralPanel = new JPanel();
        centralPanel.add(mainPanel);
        add(centralPanel, BorderLayout.CENTER);

        // Initialize panels
        studentPanel = new StudentPanel(this, northPanel);
        coursePanel = new CoursePanel(this, northPanel);
        enrollmentPanel = new EnrollmentPanel(this, northPanel);
        gradePanel = new GradePanel(this, northPanel);
        reportPanel = new ReportPanel(this, northPanel);

        add(northPanel, BorderLayout.NORTH);
        northPanel.add(btnStudents);
        northPanel.add(btnCourse);
        northPanel.add(btnEnrollments);
        northPanel.add(btnGrades);
        northPanel.add(btnReport);
        
        //Buttons
        btnStudents.setPreferredSize(new Dimension(120, 25));
        btnCourse.setPreferredSize(new Dimension(120, 25));
        btnEnrollments.setPreferredSize(new Dimension(120, 25));
        btnGrades.setPreferredSize(new Dimension(120, 25));
        btnReport.setPreferredSize(new Dimension(120, 25));
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
