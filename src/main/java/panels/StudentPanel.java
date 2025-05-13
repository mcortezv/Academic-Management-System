package panels;

import formsDialog.StudentFormDialog;
import gui.MainFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author david
 */
public class StudentPanel extends BasePanel{
    private JButton btnAddStudent;
    private JButton btnDeleteStudent;
    private JButton btnSearchStudent;

    public StudentPanel(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);

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
                new StudentFormDialog(mainFrame, null, 0).setVisible(true);
            });
            //Delete student button
            btnDeleteStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame, null, 1).setVisible(true);
            });
            //Search student button
            btnSearchStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame, null, 2).setVisible(true);
            });

        //Paneles
        centralPanel.add(btnAddStudent);        
        centralPanel.add(btnDeleteStudent);
        centralPanel.add(btnSearchStudent);
    }
}