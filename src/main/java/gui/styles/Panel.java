/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.styles;

import gui.MainFrame;
import gui.panels.NorthPanel;

import java.awt.*;
import java.awt.Button;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public abstract class Panel extends JPanel {
    protected MainFrame mainFrame;
    protected JPanel centralPanel;
    protected JPanel southPanel;
    protected java.awt.Button btnBack;
    protected NorthPanel northPanel;


    public Panel(MainFrame frame, NorthPanel northPanel) {
        setBackground(Style.BACKGROUND_COLOR);
        mainFrame = frame;
        this.northPanel = northPanel;
        btnBack = new Button("Volver");
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        southPanel = new JPanel();
        centralPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        centralPanel.setPreferredSize(new Dimension(200, 300));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(20, 170, 0, 150)); 
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(500, 45));
        centralPanel.setBackground(Color.WHITE);
        southPanel.setBackground(Color.WHITE);

        startComponents();
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(btnBack);
        //Boton
        btnBack.addActionListener(e -> frame.showMainPanel());
        btnBack.addActionListener(e -> {
           this.northPanel.erraseRectangle();
        });

    }

    public abstract void startComponents();

}
