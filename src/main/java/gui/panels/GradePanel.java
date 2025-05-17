/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;

import gui.MainFrame;
import gui.styles.Panel;
import gui.styles.Button;

import java.awt.Dimension;

/**
 *
 * @author david
 */
public class GradePanel extends Panel {
    Button btnAddGrade;
    Button btnUpdateGrade;
    Button btnDeleteGrade;
    Button btnListGrades;
    Button btnAverageStudent;

    public GradePanel(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);
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
