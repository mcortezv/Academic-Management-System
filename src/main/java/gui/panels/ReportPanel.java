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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import persistences.PersistenceStudents;
import structures.AVLTree;

/**
 *
 * @author david
 */
public final class ReportPanel extends Panel {
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
        this.setLayout(new BorderLayout());
        btnListAverageStudents = new Button("Listar estudiantes");
        btnListAverageStudents.setPreferredSize(new Dimension(170, 30));

        txtAreaReportStudents = new JTextArea(50, 40);
        txtAreaReportStudents.setLineWrap(true);
        txtAreaReportStudents.setWrapStyleWord(true);
        txtAreaReportStudents.setEditable(false);

        jsp = new JScrollPane(txtAreaReportStudents);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(btnListAverageStudents, BorderLayout.NORTH);
        this.add(jsp, BorderLayout.CENTER);

        btnListAverageStudents.addActionListener((ActionEvent e) -> {
            showStudents();
        });
    }

    public void showStudents() {
        txtAreaReportStudents.setText("ESTUDIANTES REGISTRADOS EN EL SISTEMA\n");
        PersistenceStudents persistenceStudents = persistenceFacade.getPersistenceStudents();
        persistenceStudents.populateStudents();
        AVLTree<Student> studentsByAverage = persistenceStudents.getStudentsByAverage();
        if (studentsByAverage == null) {
            txtAreaReportStudents.setText("\nNo hay estudiantes registrados");
        } else {
            String studentsData = studentsByAverage.listInOrderToString();
            if (studentsData.isEmpty()) {
                txtAreaReportStudents.append("\nEl árbol está vacío.");
            } else {
                txtAreaReportStudents.append(studentsByAverage.listInOrderToString());
            }
        }

    }
}
