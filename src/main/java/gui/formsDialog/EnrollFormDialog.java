/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.formsDialog;
import components.Course;
import components.Student;
import gui.MainFrame;
import gui.styles.Dialog;
import gui.styles.TextField;
import interfaces.IPersistenceFacade;
import structures.ArrayList;
import structures.HashDictionary;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author david
 */
public class EnrollFormDialog extends Dialog {
    private HashDictionary<String, Course> courseHashDictionary;
    private ArrayList<String> coursesKeys;
    private JComboBox<String> comboBox;
    private TextField idField;
    private IPersistenceFacade persistenceFacade;

    public EnrollFormDialog(MainFrame owner, int option, IPersistenceFacade persistenceFacade) {
        super(owner, "", true);
        courseHashDictionary = persistenceFacade.lisCourses();
        coursesKeys = courseHashDictionary.getKeys();
        comboBox = new JComboBox<>();
        switch (option) {
            case 0 -> {
                setTitle("Inscribir estudiante");
                caseEnrollStudent();
            }
            case 1 ->{
                setTitle("Estudiantes inscritos");

            }
            default -> {
            }
        }
    }

    public void caseEnrollStudent() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del estudiante:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Course field
        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 56, 0));
        coursePanel.add(new JLabel("Clase:   "));
        for (String clave : coursesKeys) {
            comboBox.addItem(clave);
        }

        coursePanel.add(comboBox);
        coursePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Enroll button
        Button btnEnroll = new Button("Inscribir a la clase");
        btnEnroll.addActionListener(e -> {
            enrolledStudents();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        centerPanel.add(coursePanel);
        southPanel.add(btnEnroll);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void enrolledStudents() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
    }

    public void enrollStudentAction(){
        String id = idField.getText().trim();
        Course courseSelected = (Course) comboBox.getSelectedItem();
        Student student = persistenceFacade.searchStudentById(id);
        JOptionPane.showMessageDialog(centerPanel, "Estudiante inscrito a la clase"+comboBox.getSelectedItem());
    }
}