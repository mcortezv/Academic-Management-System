/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.formsDialog;
import gui.MainFrame;
import gui.panels.GradePanel;
import gui.styles.Dialog;
import interfaces.IPersistenceFacade;
import javax.swing.*;
import java.awt.*;
import gui.styles.TextField;

/**
 *
 * @author david
 */
public class GradeFormDialog extends Dialog {
    private TextField idStudent;
    private TextField grade;
    private TextField indexGrade;
    private IPersistenceFacade persistenceFacade;
    private GradePanel panel;
    
    public GradeFormDialog(MainFrame owner, int option, IPersistenceFacade persistenceFacade, GradePanel panel) {
        super(owner, "", true);
        this.panel = panel;
        this.persistenceFacade = persistenceFacade;
        switch (option) {
            case 0 -> {
                setTitle("Añadir Califcacion");
                caseAddGrade();
            }
            case 1 ->{
                setTitle("Actualizar Califcacion");
                caseUpdateGrade();
            }
            case 2 ->{
                setTitle("Eliminar Calificacion");
                caseDeleteGrade();
            }
            case 3 ->{
                setTitle("Procesar Solicitud");
                caseProcessNextRequest();
            }
        }
    }

    public void caseAddGrade() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del Estudiante:  "));
        idStudent = new TextField(12);
        idPanel.add(idStudent);
        idPanel.add(new JLabel("Nueva Calificacion:           "));
        grade = new TextField(12);
        idPanel.add(grade);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Enroll button
        Button btnAddGrade = new Button("Agregar Calificacion");
        btnAddGrade.addActionListener(e -> {
            addGrade();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnAddGrade);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void caseUpdateGrade() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del Estudiante:  "));
        idStudent = new TextField(12);
        idPanel.add(idStudent);
        idPanel.add(new JLabel("Nueva Calificacion:           "));
        grade = new TextField(12);
        idPanel.add(grade);
        idPanel.add(new JLabel("Indice de la Calificacion:  "));
        indexGrade = new TextField(12);
        idPanel.add(indexGrade);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Enroll button
        Button btnAddGrade = new Button("Actualizar Calificacion");
        btnAddGrade.addActionListener(e -> {
            updateGrade();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnAddGrade);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void caseDeleteGrade(){
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del Estudiante:  "));
        idStudent = new TextField(12);
        idPanel.add(idStudent);
        idPanel.add(new JLabel("Indice de la Calificacion:  "));
        indexGrade = new TextField(12);
        idPanel.add(indexGrade);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Enroll button
        Button btnAddGrade = new Button("Eliminar Calificacion");
        btnAddGrade.addActionListener(e -> {
            deleteGrade();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnAddGrade);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void caseProcessNextRequest(){
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del Estudiante:  "));
        idStudent = new TextField(12);
        idPanel.add(idStudent);
        idPanel.add(new JLabel("Nueva Calificacion:           "));
        grade = new TextField(12);
        idPanel.add(grade);
        idPanel.add(new JLabel("Indice de la Calificacion:  "));
        indexGrade = new TextField(12);
        idPanel.add(indexGrade);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Enroll button
        Button btnAddGrade = new Button("Procesar Solicitud");
        btnAddGrade.addActionListener(e -> {
            processNextRequest();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnAddGrade);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void addGrade(){

    }

    public void updateGrade(){

    }

    public void deleteGrade(){

    }

    public void processNextRequest(){

    }
}
