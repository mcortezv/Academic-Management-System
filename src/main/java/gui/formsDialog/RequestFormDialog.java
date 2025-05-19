/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.formsDialog;
import components.Course;
import gui.MainFrame;
import gui.styles.Dialog;
import gui.styles.TextField;
import interfaces.IPersistenceFacade;
import persistences.exceptions.PersistenceCoursesException;
import validators.Validator;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author david
 */
public final class RequestFormDialog extends Dialog {
    private TextField courseNameField;
    private IPersistenceFacade persistence;

    public RequestFormDialog(MainFrame owner, int option, IPersistenceFacade persistence) {
        super(owner, "", true);
        this.persistence = persistence;
        switch (option) {
            case 0:
                setTitle("Añadir curso");
                caseAddCourse();
                break;
            case 1:
                setTitle("Eliminar curso");
                caseDeleteCourse();
                break;
            case 2:
                setTitle("Rotar rol (lider del grupo)");
                caseRotateRol();
                break;
            default:
                break;

        }
    }

    public void caseAddCourse() {
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name field
        JPanel courseNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        courseNamePanel.add(new JLabel("Nombre del curso:   "));
        courseNameField = new TextField(15);
        courseNamePanel.add(courseNameField);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create button
        Button btnAddCourse = new Button("Crear curso");
        btnAddCourse.addActionListener(e -> {
            addCourse();
        });

        // Add everything to the central panel
        centerPanel.add(courseNamePanel);
        southPanel.add(btnAddCourse);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void caseDeleteCourse() {
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name field
        JPanel courseNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        courseNamePanel.add(new JLabel("Nombre del curso:   "));
        courseNameField = new TextField(15);
        courseNamePanel.add(courseNameField);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create button
        Button btnDelete = new Button("Eliminar curso");
        btnDelete.addActionListener(e -> {
            removeCourse();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(courseNamePanel);
        southPanel.add(btnDelete);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

    }

    public void caseRotateRol() {
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name field
        JPanel courseNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        courseNamePanel.add(new JLabel("Nombre del curso:   "));
        courseNameField = new TextField(15);
        courseNamePanel.add(courseNameField);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create button
        Button btnRotate = new Button("Rotar rol");
        btnRotate.addActionListener(e -> {
            rotateRol();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(courseNamePanel);
        southPanel.add(btnRotate);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

    }

    public void addCourse() {
        String name = courseNameField.getText().trim();
        if (!Validator.validateName(name)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del curso invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceCoursesException("Nombre de Curso Invalido");
        }
        Course course = new Course(name);
        persistence.addCourse(course);
        //mainFrame.getMainPanel().updateText(persistence.getPersistenceActions().getStack().getAllElementsAsString());
        JOptionPane.showMessageDialog(centerPanel, "Curso agregado con exito");
        dispose();
    }

    public void removeCourse() {
        String name = courseNameField.getText().trim();
        if (!Validator.validateName(name)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del curso invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceCoursesException("Nombre de Curso Invalido");
        }
        Course course = persistence.getCourseByName(name);
        if (course == null) {
            JOptionPane.showMessageDialog(centerPanel, "Curso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        persistence.deleteCourse(course);
        JOptionPane.showMessageDialog(centerPanel, "Curso eliminado con exito");
        dispose();
    }

    public void rotateRol() {
        String name = courseNameField.getText().trim();
        if (!Validator.validateName(name)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del curso invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceCoursesException("Nombre de Curso Invalido");
        }
        Course course = persistence.getCourseByName(name);
        if (course == null) {
            JOptionPane.showMessageDialog(centerPanel, "Curso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            
        }

        if (persistence.rotateRol(course.getId()) == null) {
            JOptionPane.showMessageDialog(centerPanel,"No hay un nuevo tutor asignado, no se pudo rotar el rol ");
        } else {
            JOptionPane.showMessageDialog(centerPanel, persistence.rotateRol(course.getId()).toString(), "Rol de lider rotado con exito, nuevo tutor: ", 1);
            dispose();
        }
    }
}