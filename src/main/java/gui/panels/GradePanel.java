/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;
import gui.MainFrame;
import gui.formsDialog.GradeFormDialog;
import gui.styles.Panel;
import gui.styles.Button;
import gui.styles.Style;
import interfaces.IPersistenceFacade;
import javax.swing.*;
import java.awt.Dimension;

/**
 *
 * @author david
 */
public class GradePanel extends Panel {
    private Button btnAddGrade;
    private Button btnUpdateGrade;
    private Button btnDeleteGrade;
    private Button btnGetAverage;
    private Button btnProcessNextRequest;
    private JTextArea textArea;
    private JScrollPane jps;
    private IPersistenceFacade persistenceFacade;

    public GradePanel(MainFrame frame, NorthPanel northPanel, IPersistenceFacade persistenceFacade) {
        super(frame, northPanel, persistenceFacade);
        this.persistenceFacade = persistenceFacade;
    }

    @Override
    public void startComponents() {
        btnAddGrade =  new Button("Añadir Calificaciones");
        btnUpdateGrade =  new Button("Actualizar Calificaciones");
        btnDeleteGrade =  new Button("Eliminar Calificaciones");
        btnGetAverage =  new Button("Soliciar Promedio");
        btnProcessNextRequest =  new Button("Procesar Cola Solicitud");
        textArea = new JTextArea(10, 19);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(Style.INPUT_FONT);
        jps = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Botones
        btnAddGrade.setPreferredSize(new Dimension(230, 40));
        btnUpdateGrade.setPreferredSize(new Dimension(230, 40));
        btnDeleteGrade.setPreferredSize(new Dimension(230, 40));
        btnGetAverage.setPreferredSize(new Dimension(230, 40));
        btnProcessNextRequest.setPreferredSize(new Dimension(230, 40));

        //Panels
        centralPanel.add(btnAddGrade);
        centralPanel.add(btnUpdateGrade);
        centralPanel.add(btnDeleteGrade);
        centralPanel.add(btnGetAverage);
        centralPanel.add(btnProcessNextRequest);
        centralPanel.add(jps);

        //button
        btnAddGrade.addActionListener(e -> {
            new GradeFormDialog(mainFrame, 0, persistenceFacade, this).setVisible(true);
        });

        btnUpdateGrade.addActionListener(e -> {
            new GradeFormDialog(mainFrame, 1, persistenceFacade, this).setVisible(true);
        });

        btnDeleteGrade.addActionListener(e -> {
            new GradeFormDialog(mainFrame, 2, persistenceFacade, this).setVisible(true);
        });

        btnGetAverage.addActionListener(e -> {
            new GradeFormDialog(mainFrame, 3, persistenceFacade, this).setVisible(true);
        });

        btnProcessNextRequest.addActionListener(e -> {
            new GradeFormDialog(mainFrame, 4, persistenceFacade, this).setVisible(true);
        });
    }

    public JTextArea getTextArea(){
        return textArea;
    }
}