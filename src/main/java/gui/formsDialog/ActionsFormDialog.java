/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.formsDialog;
import components.Action;
import gui.MainFrame;
import gui.styles.Dialog;
import gui.styles.Panel;
import gui.styles.Style;
import interfaces.IPersistenceFacade;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author david
 */
public final class ActionsFormDialog extends Dialog {
    private IPersistenceFacade persistence;
    private JTextArea textArea;
    private JScrollPane jsp;

    public ActionsFormDialog(MainFrame owner, int option, IPersistenceFacade persistence, Panel panel) {
        super(owner, "", true);
        this.persistence = persistence;
        setTitle("Deshacer Accion");
        setSize(350, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        textArea = new JTextArea(5, 5);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(Style.INPUT_FONT);
        jsp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Name field
        JPanel courseNamePanel = new JPanel();
        courseNamePanel.setLayout(new BoxLayout(courseNamePanel, BoxLayout.Y_AXIS));
        courseNamePanel.add(new JLabel("Ultima Accion:"));
        courseNamePanel.add(jsp);
        courseNamePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Action action = (Action) persistence.getPersistenceActions().getStack().peek();
        if (action != null){
            textArea.setText(action.getName());
        }


        // Create button
        Button btnAddCourse = new Button("Confirmar");
        btnAddCourse.addActionListener(e -> {
            persistence.undoAction();
            dispose();
        });

        // Add everything to the central panel
        centerPanel.add(courseNamePanel);
        southPanel.add(btnAddCourse);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
}