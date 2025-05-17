package gui.panels;

import gui.formsDialog.StudentFormDialog;
import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;

import java.awt.Dimension;

/**
 *
 * @author david
 */
public class StudentPanel extends Panel {
    private Button btnAddStudent;
    private Button btnDeleteStudent;
    private Button btnSearchStudent;

    public StudentPanel(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);

    }

    @Override
    public void startComponents() {
        btnAddStudent = new Button("Añadir estudiante");
        btnDeleteStudent = new Button("Eliminar estudiante");
        btnSearchStudent = new Button("Buscar Estudiante");

        //Buttons
        btnAddStudent.setPreferredSize(new Dimension(175, 30));
        btnDeleteStudent.setPreferredSize(new Dimension(175, 30));
        btnSearchStudent.setPreferredSize(new Dimension(175, 30));
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