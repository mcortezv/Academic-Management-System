/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.formsDialog;
import components.Action;
import components.Request;
import components.Student;
import components.dtos.StudentGradeDTO;
import gui.MainFrame;
import gui.panels.GradePanel;
import gui.styles.Dialog;
import gui.styles.Style;
import interfaces.IPersistenceFacade;
import javax.swing.*;
import java.awt.*;
import gui.styles.TextField;
import persistences.exceptions.PersistenceCoursesException;
import validators.Validator;

/**
 *
 * @author david
 */
public class GradeFormDialog extends Dialog {
    private TextField inputIdStudent;
    private TextField inputGrade;
    private TextField inputIndexGrade;
    private IPersistenceFacade persistenceFacade;
    private JTextArea textArea;
    private JScrollPane jsp;
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
                setTitle("Solicitar Promedio");
                caseGetAverage();
            }
            case 4 ->{
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
        inputIdStudent = new TextField(12);
        idPanel.add(inputIdStudent);
        idPanel.add(new JLabel("Nueva Calificacion:           "));
        inputGrade = new TextField(12);
        idPanel.add(inputGrade);
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
        inputIdStudent = new TextField(12);
        idPanel.add(inputIdStudent);
        idPanel.add(new JLabel("Nueva Calificacion:           "));
        inputGrade = new TextField(12);
        idPanel.add(inputGrade);
        idPanel.add(new JLabel("Indice de la Calificacion:  "));
        inputIndexGrade = new TextField(12);
        idPanel.add(inputIndexGrade);
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
        inputIdStudent = new TextField(12);
        idPanel.add(inputIdStudent);
        idPanel.add(new JLabel("Indice de la Calificacion:  "));
        inputIndexGrade = new TextField(12);
        idPanel.add(inputIndexGrade);
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

    public void caseGetAverage(){
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del Estudiante:  "));
        inputIdStudent = new TextField(12);
        idPanel.add(inputIdStudent);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Enroll button
        Button btnAddGrade = new Button("Solicitar Promedio");
        btnAddGrade.addActionListener(e -> {
            getAverage();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnAddGrade);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void caseProcessNextRequest(){
        setTitle("Solicitudes");
        setSize(350, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        textArea = new JTextArea(5, 5);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(Style.INPUT_FONT);
        jsp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Name field
        JPanel courseNamePanel = new JPanel();
        courseNamePanel.setLayout(new BoxLayout(courseNamePanel, BoxLayout.Y_AXIS));
        courseNamePanel.add(new JLabel("Siguiente Solicitud:"));
        courseNamePanel.add(jsp);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Request request = (Request) persistenceFacade.getPersistenceRequests().getNextRequest();
        if (request != null){
            StudentGradeDTO studentGradeDTO = (StudentGradeDTO) request.getData();
            Student student = studentGradeDTO.getStudent();
            if (request.getType() == Request.Type.addGrade){
                textArea.setText("Agregar Calificacion al Estudiante: " + student.getFullName());
            } else if (request.getType() == Request.Type.updateGrade){
                textArea.setText("Actualizar Calificaciones al Estudiante: " + student.getFullName());
            } else if (request.getType() == Request.Type.removeGrade){
                textArea.setText("Eliminar Calificacion al Estudiante: " + student.getFullName());
            } else {
                textArea.setText("Obtener Promedio del Estudiante: " + student.getFullName());
            }
        }

        // Create button
        Button btnAddCourse = new Button("Confirmar");
        btnAddCourse.addActionListener(e -> {
            persistenceFacade.undoAction();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(courseNamePanel);
        southPanel.add(btnAddCourse);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void addGrade(){
        String id = inputIdStudent.getText().trim();
        if (!Validator.validateId(id)) {
            JOptionPane.showMessageDialog(centerPanel, "Id de Estudiante Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (persistenceFacade.searchStudentById(id) == null){
                return;
            }
            Double gradeDouble = Double.parseDouble(inputGrade.getText().trim());
            if (!Validator.validateDecimalGrade(gradeDouble)) {
                JOptionPane.showMessageDialog(centerPanel, "Calificacion Invalida (Escala 10.0)", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                persistenceFacade.requestAddGrade(id, gradeDouble);
                JOptionPane.showMessageDialog(null, "Solicitud Agregar Calificacion Enviada");
            }
        }
    }

    public void updateGrade(){
        String id = inputIdStudent.getText().trim();
        if (!Validator.validateId(id)) {
            JOptionPane.showMessageDialog(centerPanel, "Id de Estudiante Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (persistenceFacade.searchStudentById(id) == null){
                return;
            }
            Double gradeDouble = Double.parseDouble(inputGrade.getText().trim());
            if (!Validator.validateDecimalGrade(gradeDouble)) {
                JOptionPane.showMessageDialog(centerPanel, "Calificacion Invalida (Escala 10.0)", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int index = Integer.parseInt(inputIndexGrade.getText().trim());
                persistenceFacade.requestUpdateGrade(id, gradeDouble, index);
                JOptionPane.showMessageDialog(null, "Solicitud Actualizar Calificacion Enviada");
            }
        }
    }

    public void deleteGrade(){
        String id = inputIdStudent.getText().trim();
        if (!Validator.validateId(id)) {
            JOptionPane.showMessageDialog(centerPanel, "Id de Estudiante Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (persistenceFacade.searchStudentById(id) == null){
                return;
            }
            int index = Integer.parseInt(inputIndexGrade.getText().trim());
            persistenceFacade.requestUpdateGrade(id, 0.0, index);
            JOptionPane.showMessageDialog(null, "Solicitud Eliminar Calificacion Enviada");
        }
    }

    public void getAverage(){
        String id = inputIdStudent.getText().trim();
        if (!Validator.validateId(id)) {
            JOptionPane.showMessageDialog(centerPanel, "Id de Estudiante Invalido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (persistenceFacade.searchStudentById(id) == null){
                return;
            }
            Double grade = persistenceFacade.getAverage(id);
            if (grade == 0.0){
                JOptionPane.showMessageDialog(null, "El Estudiante No Tiene Calificaiciones Todavia");
            } else {
                Student student = persistenceFacade.searchStudentById(id);
                panel.getTextArea().setText("El Estudiante: " + student.getFullName() + " Tiene un Promedio de: " + grade);
            }
        }
    }

    public void processNextRequest(){
        persistenceFacade.processNextRequest();
    }
}
