/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;

import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;
import interfaces.IPersistenceFacade;
import java.awt.Dimension;

/**
 *
 * @author david
 */
public class GradePanel extends Panel {
    private Button btnAddGrade;
    private Button btnUpdateGrade;
    private Button btnDeleteGrade;
    private Button btnListGrades;
    private Button btnAverageStudent;
    private IPersistenceFacade persistenceFacade;

    public GradePanel(MainFrame frame, NorthPanel northPanel, IPersistenceFacade persistenceFacade) {
        super(frame, northPanel, persistenceFacade);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnAddGrade =  new Button("Añadir Calificaciones");
        btnUpdateGrade =  new Button("Actualizar Calificaciones");
        btnDeleteGrade =  new Button("Elimnar Calificaciones");
        btnListGrades =  new Button("Ver Calificaciones");
        btnAverageStudent =  new Button("Obtener Promedio");

        //Botones
        btnAddGrade.setPreferredSize(new Dimension(230, 40));
        btnUpdateGrade.setPreferredSize(new Dimension(230, 40));
        btnDeleteGrade.setPreferredSize(new Dimension(230, 40));
        btnListGrades.setPreferredSize(new Dimension(230, 40));
        btnAverageStudent.setPreferredSize(new Dimension(230, 40));

        //Panels
        centralPanel.add(btnAddGrade);
        centralPanel.add(btnUpdateGrade);
        centralPanel.add(btnDeleteGrade);
        centralPanel.add(btnAverageStudent);

    }
}