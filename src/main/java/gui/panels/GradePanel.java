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
        super(frame, northPanel);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnAddGrade =  new Button("Añadir calificaciones");
        btnUpdateGrade =  new Button("Actualizar calificaciones");
        btnDeleteGrade =  new Button("Elimnar calificaciones");
        btnListGrades =  new Button("Ver calificaciones");
        btnAverageStudent =  new Button("Obtener promedio");

        //Botones
        btnAddGrade.setPreferredSize(new Dimension(180, 30));
        btnUpdateGrade.setPreferredSize(new Dimension(180, 30));
        btnDeleteGrade.setPreferredSize(new Dimension(180, 30));
        btnListGrades.setPreferredSize(new Dimension(180, 30));
        btnAverageStudent.setPreferredSize(new Dimension(180, 30));

        //Panels
        centralPanel.add(btnAddGrade);
        centralPanel.add(btnUpdateGrade);
        centralPanel.add(btnDeleteGrade);
        centralPanel.add(btnAverageStudent);

    }

}
