/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;

import gui.styles.Button;
import gui.styles.Label;
import gui.styles.Style;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class MainPanel extends JPanel{
    private Label label;
    private Button btnUndo;
    private Button btnMode;
    private JPanel centerPanel;
    private JPanel soutPanel;

    public MainPanel() {
        setLayout(new BorderLayout());

        label  = new Label("Main panel");
        btnUndo = new Button("Deshacer ultima accion");
        btnMode = new Button("Modo Oscuro");
        btnUndo.setPreferredSize(new Dimension(180, 30));
        btnMode.setPreferredSize(new Dimension(150, 30));

        //Panels
            //centralPanel
        centerPanel = new JPanel(new  FlowLayout(FlowLayout.LEFT));
        centerPanel.setPreferredSize(new Dimension(790, 350));
        centerPanel.add(label);
        centerPanel.setBackground(Style.PANEL_COLOR);


            //soutPanel
        soutPanel = new JPanel(new  FlowLayout(FlowLayout.LEFT));
        soutPanel.add(btnUndo);
        soutPanel.add(btnMode);
        soutPanel.setBackground(Style.PANEL_COLOR);

        //Buttons
            //Undo Action
        btnUndo.addActionListener(e -> {
            //Desacer acciones
        });

        btnMode.addActionListener(e -> {
            if (!Style.DARK_MODE){
                Style.DARK_MODE = true;
                btnMode.setText("Modo Claro");
            } else {
                Style.DARK_MODE = false;
                btnMode.setText("Modo Oscuro");
            }
            revalidate();
            repaint();
        });

        add(centerPanel, BorderLayout.CENTER);
        add(soutPanel, BorderLayout.SOUTH);


    }

    private void updateColors() {
        centerPanel.setBackground(Style.PANEL_COLOR);
        soutPanel.setBackground(Style.PANEL_COLOR);

        label.setForeground(Style.TEXT_COLOR);

        btnUndo.setBackground(Style.BUTTON_COLOR_HOVER);
        btnUndo.setForeground(Style.TEXT_COLOR);

        btnMode.setBackground(Style.BUTTON_COLOR);
        btnMode.setForeground(Style.TEXT_COLOR);
    }


}
