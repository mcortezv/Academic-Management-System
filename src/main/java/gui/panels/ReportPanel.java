/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;
import components.Student;
import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;
import interfaces.IPersistenceFacade;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import persistences.PersistenceStudents;
import structures.AVLTree;
import structures.ArrayList;

/**
 *
 * @author david
 */
public final class ReportPanel extends Panel {
    private Button btnListStudents;
    private Button btnListAverageStudents;
    private JTextArea txtAreaReportStudents;
    private JScrollPane jsp;
    private IPersistenceFacade persistenceFacade;

    public ReportPanel(MainFrame frame, NorthPanel northPanel, IPersistenceFacade persistenceFacade) {
        super(frame, northPanel);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnListStudents = new Button("Listar Estudiantes");
        btnListAverageStudents = new Button("Listar Estudiantes por Promedio");
        txtAreaReportStudents = new JTextArea(20, 100);
        txtAreaReportStudents.setMargin(new Insets(100, 0, 0, 0));
        txtAreaReportStudents.setLineWrap(true);
        txtAreaReportStudents.setWrapStyleWord(true);
        txtAreaReportStudents.setEditable(false);
        JScrollPane jsp = new JScrollPane(txtAreaReportStudents,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        btnListStudents.setBounds(300, 10, 170, 40);
        btnListAverageStudents.setBounds(600, 10, 170, 40);
        jsp.setBounds(75, 110, 10, 10);

        add(btnListStudents);
        add(btnListAverageStudents);
        add(jsp);


        btnListStudents.addActionListener((ActionEvent e) -> {
            showStudents();
        });

        btnListAverageStudents.addActionListener((ActionEvent e) -> {
            showStudentsByAverage();
        });
    }

    public void showStudents() {
        txtAreaReportStudents.setText("ESTUDIANTES REGISTRADOS EN EL SISTEMA\n");
        PersistenceStudents persistenceStudents = persistenceFacade.getPersistenceStudents();
        ArrayList<Student> students = persistenceStudents.listStudents();
        if (students.isEmpty()) {
            txtAreaReportStudents.setText("\nNo hay estudiantes registrados");
        } else {
            for (Student student: students){
                txtAreaReportStudents.append("\n" + student.toString() + "\n");
            }
        }
    }

    public void showStudentsByAverage() {
        txtAreaReportStudents.setText("ESTUDIANTES LISTADOS POR PROMEDIO\n");
        PersistenceStudents persistenceStudents = persistenceFacade.getPersistenceStudents();
        ArrayList<Student> studentsByAverage = persistenceStudents.listStudentsInOrderFromAVLTree();
        if (studentsByAverage.isEmpty()) {
            txtAreaReportStudents.setText("\nNo hay estudiantes registrados");
        } else {
                for (Student student: studentsByAverage){
                    txtAreaReportStudents.append("\n" + student.toString() + "\n");
                }
        }
    }
}
