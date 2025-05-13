package panels;

import formsDialog.StudentFormDialog;
import gui.MainFrame;
import interfaces.IPersistenceFacade;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import persistences.PersistenceStudents;



/**
 *
 * @author david
 */
public class StudentPanel extends BasePanel{
    private JButton btnAddStudent;
    private JButton btnDeleteStudent;
    private JButton btnSearchStudent;
    private IPersistenceFacade persistence;
    public StudentPanel(MainFrame frame, IPersistenceFacade persistence) {
        super(frame);
        this.persistence = persistence;

    }

    @Override
    public void startComponents() {
        btnAddStudent = new JButton("Añadir estudiante");
        btnDeleteStudent = new JButton("Eliminar estudiante");
        btnSearchStudent = new JButton("Buscar Estudiante");

        //Buttons
        btnAddStudent.setPreferredSize(new Dimension(150, 30));
        btnDeleteStudent.setPreferredSize(new Dimension(150, 30));
        btnSearchStudent.setPreferredSize(new Dimension(150, 30));
            //Add student button
            btnAddStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame,persistence, 0).setVisible(true);
            });
            //Delete student button
            btnDeleteStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame,persistence, 1).setVisible(true);
            });
            //Search student button
            btnSearchStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame,persistence, 2).setVisible(true);
            });

        //Paneles
        centralPanel.add(btnAddStudent);        
        centralPanel.add(btnDeleteStudent);
        centralPanel.add(btnSearchStudent);

    }
    
}