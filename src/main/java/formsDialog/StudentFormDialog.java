package formsDialog;

import gui.MainFrame;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class StudentFormDialog extends JDialog{
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    
    public StudentFormDialog(MainFrame owner, int option) {
        super(owner, " ", true);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        switch (option){
            case 0:
                setTitle("Añadir estudiante");
                addStudent();
                break;
            case 1:
                setTitle("Eliminar estudiante");
                deleteStudent();
                break;
            case 2:
                setTitle("Buscar estudiante");
                searchStudent();
                break;
            default:
                break;
                
        }
        
       
    }
    
    public void addStudent(){
        setSize(400, 300);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name field
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Nombre Completo:   "));
        JTextField nameField = new JTextField(20);
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
        JTextField phoneField = new JTextField(15);
        phonePanel.add(phoneField);

        // Email field
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:                    "));
        JTextField emailField = new JTextField(20);
        emailPanel.add(emailField);

        // Address field
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addressPanel.add(new JLabel("Direccion postal:"));
        JTextField addressField = new JTextField(20);
        addressPanel.add(addressField);

        // Add button
        JButton btnadd = new JButton("Añadir");
        btnadd.addActionListener(e -> {
            //verifica que los datos ingresados sean corectos mediante REGEX
            //Ejecuta "añadir" de la lista de estudiantes
            dispose(); 
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
    
    
    public void deleteStudent(){
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del estudiante:   "));
        JTextField idField = new JTextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        // Delete button                                                                                                            
        JButton btnDelete = new JButton("Eliminar estudiante");
        btnDelete.addActionListener(e -> {
            //se ejecuta "eliminar" de la lista de estudiantes
            //si regresa true se despliega un Joptionpane "eliminado"
            //si regresa false se despliega un Joptionpane "error no se encontro al estudainte"
            dispose(); 
        });
        
        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    public void searchStudent(){
        setSize(350, 150);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        // Id field
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Matricula del estudiante:   "));
        JTextField idField = new JTextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        // Delete button
        JButton btnSearch = new JButton("Buscar");
        btnSearch.addActionListener(e -> {
            
            dispose(); 
        });
        
        // Add everything to the central panel
        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
}