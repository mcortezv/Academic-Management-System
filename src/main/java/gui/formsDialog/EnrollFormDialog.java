/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.formsDialog;
import components.Course;
import components.Student;
import gui.MainFrame;
import gui.panels.EnrollmentPanel;
import gui.styles.Dialog;
import gui.styles.TextField;
import interfaces.IPersistenceFacade;
import persistences.exceptions.PersistenceCoursesException;
import structures.ArrayList;
import structures.HashDictionary;
import javax.swing.*;
import java.awt.*;
import persistences.PersistenceCourses;
import persistences.PersistenceStudents;
import validators.Validator;

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
    private EnrollmentPanel panel;
    private Student student;
    private Course course;

    public EnrollFormDialog(MainFrame owner, int option, IPersistenceFacade persistenceFacade, EnrollmentPanel panel) {
        super(owner, "", true);
        this.panel = panel;
        this.persistenceFacade = persistenceFacade;
        courseHashDictionary = persistenceFacade.lisCourses();
        coursesKeys = courseHashDictionary.getKeys();
        comboBox = new JComboBox<>();
        switch (option) {
            case 0 -> {
                setTitle("Inscribir Estudiante");
                caseEnrollStudent();
            }
            case 1 -> {
                setTitle("Estudiantes Inscritos");
                caseListEnrolledStudents();
            }
            case 2 -> {
                setTitle("Estudiantes Espera");
                caseWaitingListStudents();
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
        idPanel.add(new JLabel("Matricula del Estudiante:   "));
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
        Button btnEnroll = new Button("Inscribir a la Clase");
        btnEnroll.addActionListener(e -> {
            enrollStudentAction();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        centerPanel.add(coursePanel);
        southPanel.add(btnEnroll);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void caseListEnrolledStudents() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

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
        Button btnEnroll = new Button("Listar");
        btnEnroll.addActionListener(e -> {
            enrolledStudents();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(coursePanel);
        southPanel.add(btnEnroll);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void caseWaitingListStudents() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

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
        Button btnEnroll = new Button("Listar");
        btnEnroll.addActionListener(e -> {
            waitingListStudents();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(coursePanel);
        southPanel.add(btnEnroll);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void enrollStudentAction() {
        String idStudent = idField.getText().trim();
        if (!Validator.validateId(idStudent)) {
            JOptionPane.showMessageDialog(centerPanel, "Id de Estudiante Invalido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PersistenceStudents students = persistenceFacade.getPersistenceStudents();
        student = students.searchStudent(idStudent);
        if (student != null) {
            String idCourse = (String) comboBox.getSelectedItem();
            PersistenceCourses courses = persistenceFacade.getPersistenceCourses();
            course = courses.getCourseById(idCourse);
            try {
                course = courses.getCourseById(idCourse);
            } catch (persistences.exceptions.PersistenceCoursesException ex) {
                JOptionPane.showMessageDialog(null, "Curso No Encontrado ");
                return;
            }
            assert course != null;
            if (course.getEnrolledStudents().contains(student)){
                JOptionPane.showMessageDialog(null, "Este Estudiante Ya Esta Inscrito en Este Curso: " + comboBox.getSelectedItem());
            } else {
                persistenceFacade.enrollStudentInCourse(idStudent, idCourse);
            }
        }
    }

    public void enrolledStudents() {
        String idCourse = (String) comboBox.getSelectedItem();
        if (!Validator.validateId(idCourse)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del curso invalido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<Student> students = persistenceFacade.showEnrolledStudentsInCourseArrayList(idCourse);
        if (students.isEmpty()) {
            panel.getTextArea().setText("");
            JOptionPane.showMessageDialog(null, "No Hay Estudiantes Inscritos: " + comboBox.getSelectedItem());
        } else {
            panel.getTextArea().setText("");
            for (Student studentEnrolledStudents : students) {
                panel.getTextArea().append("\n" + studentEnrolledStudents.toString() + "\n");
            }
        }

    }

    public void waitingListStudents() {
        String idCourse = (String) comboBox.getSelectedItem();
        if (!Validator.validateId(idCourse)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del curso invalido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Course course = persistenceFacade.getPersistenceCourses().getCourseById(idCourse);
        if(course == null){
            JOptionPane.showMessageDialog(centerPanel, "El curso no ha sido encontradp", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<Student> students = course.getWaitingListArrayList();
        if (students.isEmpty()) {
            panel.getTextArea().setText("");
            JOptionPane.showMessageDialog(null, "No Hay Estudiantes En Lista de Espera: " + comboBox.getSelectedItem());
        } else {
            panel.getTextArea().setText("");
            for (Student studentWaitingList : students) {
                panel.getTextArea().append("\n" + studentWaitingList.toString() + "\n");
            }
        }
    }
}
