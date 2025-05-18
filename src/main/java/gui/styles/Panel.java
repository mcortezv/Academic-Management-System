/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.styles;
import gui.MainFrame;
import gui.panels.NorthPanel;
import interfaces.IPersistenceFacade;
import java.awt.*;
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
    protected Button btnBack;
    protected Button btnUndo;
    protected NorthPanel northPanel;

    public Panel(MainFrame frame, NorthPanel northPanel, IPersistenceFacade persistenceFacade) {
        setBackground(Style.BACKGROUND_COLOR);
        mainFrame = frame;
        this.northPanel = northPanel;
        btnBack = new Button("Volver");
        btnUndo = new Button("Deshacer Ultima Accion");
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        southPanel = new JPanel();
        centralPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        centralPanel.setPreferredSize(new Dimension(600, 500));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(40, 170, 0, 150));
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(500, 50));
        centralPanel.setBackground(Color.WHITE);
        southPanel.setBackground(Color.WHITE);

        startComponents();
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(btnBack);
        southPanel.add(btnUndo);
        //Boton
        btnBack.addActionListener(e -> frame.showMainPanel());
        btnBack.addActionListener(e -> {
           this.northPanel.erraseRectangle();
        });

        btnUndo.addActionListener(e -> {
            persistenceFacade.undoAction();
        });

    }

    public abstract void startComponents();
}