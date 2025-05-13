package formsDialog;

import components.Contact;
import components.Student;
import gui.MainFrame;
import interfaces.IPersistenceFacade;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import persistences.PersistenceStudents;
import persistences.exceptions.PersistenceStudentsException;
import validators.Validator;

/**
 *
 * @author david
 */
public final class StudentFormDialog extends JDialog {

    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField idField;
    private PersistenceStudents persistence;
    private Student student;
    private Contact contact;

    public StudentFormDialog(MainFrame owner, IPersistenceFacade persistence, int option) {
        super(owner, " ", true);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.persistence = new PersistenceStudents();
        switch (option) {
            case 0 -> {
                setTitle("Añadir estudiante");
                addStudent();
            }
            case 1 -> {
                setTitle("Eliminar estudiante");
                deleteStudent();
            }
            case 2 -> {
                setTitle("Buscar estudiante");
                searchStudent();
            }
            default -> {
            }

        }

    }

    public void addStudent() {
        setSize(400, 300);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name field
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Nombre Completo:   "));
        nameField = new JTextField(20);
        namePanel.add(nameField);
        namePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        //contact information label
        JLabel sectionLabel = new JLabel("--------  Informacion de contacto  --------");
        sectionLabel.setFont(sectionLabel.getFont().deriveFont(Font.BOLD));
        sectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        sectionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        // Phone field
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        phonePanel.add(new JLabel("Telefono:              "));
        phoneField = new JTextField(15);
        phonePanel.add(phoneField);

        // Email field
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:                    "));
        emailField = new JTextField(20);
        emailPanel.add(emailField);

        // Address field
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addressPanel.add(new JLabel("Direccion postal:"));
        addressField = new JTextField(20);
        addressPanel.add(addressField);

        // Add button
        JButton btnadd = new JButton("Añadir");
        btnadd.addActionListener(e -> {
            try {
                actionBtnAddStudent();
            } catch (PersistenceStudentsException ex) {
                System.out.println("Error al agregar el estudiante: " + ex.getMessage());
            }
        });

        // Add everything to the central panel
        centerPanel.add(namePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(sectionLabel);
        centerPanel.add(phonePanel);
        centerPanel.add(emailPanel);
        centerPanel.add(addressPanel);
        centerPanel.add(Box.createVerticalStrut(15));
        southPanel.add(btnadd);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    /**
     *
     */
    public void actionBtnAddStudent() {
        String name = nameField.getText().trim();
        String phoneNumber = phoneField.getText().trim();
        String email = emailField.getText().trim();
        String adressField = addressField.getText().trim();

        if (!Validator.validateName(name)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del estudiante invalido");
            throw new PersistenceStudentsException("Nombre de estudiante invalido");
        }
        if (!Validator.validatePhone(phoneNumber)) {
            JOptionPane.showMessageDialog(centerPanel, "Numero de telefono invalido");
            throw new PersistenceStudentsException("Numero de telefono invalido");
        }
        if (!Validator.validateEmail(email)) {
            JOptionPane.showMessageDialog(centerPanel, "Correo electronico invalido");
            throw new PersistenceStudentsException("Correo electronico invalido");
        }
        if (!Validator.validateStreetNumber(adressField)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del estudiante invalido");
            throw new PersistenceStudentsException("Direccion invalida");
        }
        contact = new Contact(phoneNumber, email, adressField);
        student = new Student(name, contact);
        persistence.addStudent(student);
        JOptionPane.showMessageDialog(centerPanel, "Estudiante agregado con exito");
        dispose();

    }

    public void deleteStudent() {
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del estudiante:   "));
        idField = new JTextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Delete button
        JButton btnDelete = new JButton("Eliminar estudiante");
        btnDelete.addActionListener(e -> {
            try {
                actionBtnDeleteStudent();
            } catch (PersistenceStudentsException ex) {
                System.out.println("Error al intentar eliminar el estudiante: " + ex.getMessage());
            }
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnDelete);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void actionBtnDeleteStudent() {
        String id = idField.getText().trim();
        if (!Validator.validateId(id)) {
            JOptionPane.showMessageDialog(centerPanel, "Id de estudiante invalido");
            throw new PersistenceStudentsException("Id del estudiante invalido");
        }
        student = persistence.searchStudent(id);
        persistence.removeStudent(student);
        JOptionPane.showMessageDialog(centerPanel, "Estudiante removido con exito");
    }

    public void searchStudent() {
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del estudiante:   "));
        idField = new JTextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Delete button
        JButton btnSearch = new JButton("Buscar");
        btnSearch.addActionListener(e -> {
            try{
                actionBtnSearchStudent();
            }catch(PersistenceStudentsException ex){
                System.out.println("Error al intentar buscar al estudiante: " + ex.getMessage());
            }
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnSearch);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void actionBtnSearchStudent() {
        String id = idField.getText().trim();
        if (!Validator.validateId(id)) {
            JOptionPane.showMessageDialog(centerPanel, "Id de estudiante invalido");
            throw new PersistenceStudentsException("Id del estudiante invalido");
        }
        student = persistence.searchStudent(id);

        JOptionPane.showMessageDialog(centerPanel, student.toString(),"Estudiante encontrado: ",1);

    }
}