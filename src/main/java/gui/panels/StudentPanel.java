package gui.panels;
import gui.formsDialog.StudentFormDialog;
import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;
import interfaces.IPersistenceFacade;
import java.awt.Dimension;

/**
 *
 * @author david
 */
public class StudentPanel extends Panel {
    private Button btnAddStudent;
    private Button btnDeleteStudent;
    private Button btnSearchStudent;
    private IPersistenceFacade persistenceFacade;

    public StudentPanel(MainFrame frame, NorthPanel northPanel, IPersistenceFacade persistenceFacade) {
        super(frame, northPanel, persistenceFacade);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnAddStudent = new Button("Añadir Estudiante");
        btnDeleteStudent = new Button("Eliminar Estudiante");
        btnSearchStudent = new Button("Buscar Estudiante");

        //Buttons
        btnAddStudent.setPreferredSize(new Dimension(180, 40));
        btnDeleteStudent.setPreferredSize(new Dimension(180, 40));
        btnSearchStudent.setPreferredSize(new Dimension(180, 40));
            //Add student button
            btnAddStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame, persistenceFacade, 0).setVisible(true);
            });
            //Delete student button
            btnDeleteStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame, persistenceFacade, 1).setVisible(true);
            });
            //Search student button
            btnSearchStudent.addActionListener(e -> { 
                new StudentFormDialog(mainFrame, persistenceFacade, 2).setVisible(true);
            });

        //Paneles
        centralPanel.add(btnAddStudent);        
        centralPanel.add(btnDeleteStudent);
        centralPanel.add(btnSearchStudent);
    }
}