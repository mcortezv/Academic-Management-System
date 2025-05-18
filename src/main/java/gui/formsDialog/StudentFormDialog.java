package gui.formsDialog;
import components.Contact;
import components.Student;
import gui.MainFrame;
import gui.styles.Button;
import gui.styles.TextField;
import interfaces.IPersistenceFacade;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private TextField nameField;
    private TextField phoneField;
    private TextField emailField;
    private TextField streetField;
    private TextField streetNumberField;
    private TextField districtField;
    private TextField idField;
    private IPersistenceFacade persistence;
    private Student student;
    private Contact contact;    

    public StudentFormDialog(MainFrame owner, IPersistenceFacade persistence, int option) {        
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.persistence = persistence;
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
        setSize(660, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name field
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Nombre Completo:   "));
        nameField = new TextField(20);
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
        phoneField = new TextField(15);
        phonePanel.add(phoneField);

        // Email field
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:                 "));
        emailField = new TextField(20);
        emailPanel.add(emailField);

        // Address field
        JPanel streetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        streetPanel.add(new JLabel("Calle:                 "));
        streetField = new TextField(20);        
        streetPanel.add(streetField);
        
        JPanel streetNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));        
        streetNumberPanel.add(new JLabel("Numero:                "));
        streetNumberField = new TextField(20);
        streetNumberPanel.add(streetNumberField);
        
        JPanel districtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));        
        districtPanel.add(new JLabel("Distrito:              "));
        districtField = new TextField(20);
        districtPanel.add(districtField);
                                                                        
        
        
        // Add button
        Button btnadd = new Button("Añadir");
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
        centerPanel.add(streetPanel);
        centerPanel.add(streetNumberPanel);
        centerPanel.add(districtPanel);
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
        String street = streetField.getText().trim();
        String streetNumber =streetNumberField.getText().trim();
        String district = districtField.getText().trim();
        
        if (!Validator.validateName(name)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del estudiante invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceStudentsException("Nombre de Estudiante Invalido");
        }
        if (!Validator.validatePhone(phoneNumber)) {
            JOptionPane.showMessageDialog(centerPanel, "Numero de telefono invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceStudentsException("Numero de Telefono Invalido");
        }
        if (!Validator.validateEmail(email)) {
            JOptionPane.showMessageDialog(centerPanel, "Correo electronico invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceStudentsException("Correo Electronico Invalido");
        }
        if (!Validator.validateStreet(street)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del estudiante invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceStudentsException("Calle Invalida");
        }
        if (!Validator.validateStreetNumber(streetNumber)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del estudiante invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceStudentsException("Numero de Calle Invalido");
        }
        if (!Validator.validateDistric(district)) {
            JOptionPane.showMessageDialog(centerPanel, "Nombre del estudiante invalido", "Error", JOptionPane.ERROR_MESSAGE);
            throw new PersistenceStudentsException("Distrito Invalido");
        }
        contact = new Contact(phoneNumber, email, street);
        
        student = new Student(name, contact);
        persistence.addStudent(student);
        JOptionPane.showMessageDialog(centerPanel, "Estudiante agregado con exito");
        dispose();

    }

    public void deleteStudent() {
        setSize(400, 200);
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

        // Delete button
        Button btnDelete = new Button("Eliminar estudiante");
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
        Student student = persistence.searchStudentById(id);
        persistence.getPersistenceStudents().removeStudent(student);
        JOptionPane.showMessageDialog(centerPanel, "Estudiante removido con exito");
    }

    public void searchStudent() {
        setSize(400, 200);
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

        // Delete button
        Button btnSearch = new Button("Buscar");
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
        Student student = persistence.searchStudentById(id);
        JOptionPane.showMessageDialog(centerPanel, student.toString(),"Estudiante encontrado: ",1);

    }
}