/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import gui.MainFrame;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author david
 */
public class GradePanel extends BasePanel{
    JButton btnAddGrade;
    JButton btnUpdateGrade;
    JButton btnDeleteGrade;
    JButton btnListGrades;
    JButton btnAverageStudent;

    public GradePanel(MainFrame frame, NorthPanel northPanel) {
        super(frame, northPanel);
    }

    @Override
    public void startComponents() {
        btnAddGrade =  new JButton("Añadir calificaciones");
        btnUpdateGrade =  new JButton("Actualizar calificaciones");
        btnDeleteGrade =  new JButton("Elimnar calificaciones");
        btnListGrades =  new JButton("Ver calificaciones");
        btnAverageStudent =  new JButton("Obtener promedio");

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
