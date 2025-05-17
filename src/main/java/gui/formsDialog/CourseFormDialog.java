/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.formsDialog;

import gui.MainFrame;
import gui.styles.Button;
import gui.styles.Dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class CourseFormDialog extends Dialog {

    public CourseFormDialog(MainFrame owner, int option) {
        super(owner, option);

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
        JTextField courseNameField = new JTextField(15);
        courseNamePanel.add(courseNameField);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create button
        Button btnAddCourse = new Button("Crear curso");
        btnAddCourse.addActionListener(e -> {
            //Verifica que no exista un curso ya con el mismo nombre
            //añade el curso a la lista de cursos
            //si regresa true se despliega un Joptionpane "Añadido"
            //si regresa false se despliega un Joptionpane "error ya existe un curso con ese nombre"
            dispose();
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
        JTextField courseNameField = new JTextField(15);
        courseNamePanel.add(courseNameField);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Create button
        Button btnDelete = new Button("Eliminar curso");
        btnDelete.addActionListener(e -> {
            //Verifica que exista un curso con ese nombre
            //ejecuta "eliminar" de la lista de cursos
            //si regresa true se despliega un Joptionpane "Eliminado"
            //si regresa false se despliega un Joptionpane "error no se encontró el curso"
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(courseNamePanel);
        southPanel.add(btnDelete);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

    }
    
    public void caseRotateRol(){
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        // Name field
        JPanel courseNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        courseNamePanel.add(new JLabel("Nombre del curso:   "));
        JTextField courseNameField = new JTextField(15);
        courseNamePanel.add(courseNameField);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        // Create button
        Button btnRotate = new Button("Rotar rol");
        btnRotate.addActionListener(e -> {
            
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(courseNamePanel);
        southPanel.add(btnRotate);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        
    }

}
