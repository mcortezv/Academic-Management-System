/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;
import components.Course;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import gui.styles.Button;
import gui.styles.Style;
import interfaces.IPersistenceFacade;
import structures.HashDictionary;

/**
 *
 * @author david
 */
public class CourseTablePanel extends JPanel {
    private JPanel centralPanel;
    private JPanel southPanel;
    private Button btnBack;
    private IPersistenceFacade persistenceFacade;

    private HashDictionary<String, Course> cursosDictionary;

    public CourseTablePanel(HashDictionary<String, Course> courses, CoursePanel coursePanel, IPersistenceFacade persistenceFacade) {
        this.persistenceFacade = persistenceFacade;
        setLayout(new BorderLayout());
        setBackground(Style.PANEL_COLOR);
        centralPanel = new JPanel();
        southPanel = new JPanel();
        btnBack = new Button("Volver");
        centralPanel.setPreferredSize(new Dimension(200, 500));
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(500, 45));
        String[] columnNames = {"Id", "Nombre", "Tutor", "Estudiantes Inscritos"};

        //Boton
        btnBack.addActionListener(e -> coursePanel.showCoursePanel());
        southPanel.add(btnBack);

        //Table model
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        if (courses != null) {
            this.cursosDictionary = courses;
            for (Course course : cursosDictionary.getValues()) {
                Object[] row = {
                    course.getId(),
                    course.getName(),
                    course.getTutor()
                };
                model.addRow(row);
            }

        } else {
            Object[] row = {
                " ",
                " ",
                " "
            };
            model.addRow(row);
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 100));
        table.setDefaultEditor(Object.class, null);
        table.getTableHeader().setReorderingAllowed(false);
        centralPanel.add(scrollPane, BorderLayout.CENTER);

        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

    }

    public void initComponents() {

    }

}
