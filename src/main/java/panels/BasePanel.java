/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import gui.MainFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public abstract class BasePanel extends JPanel {

    protected JButton btnBack;
    protected JPanel centralPanel;
    protected JPanel southPanel;
    protected JPanel westPanel;
    protected MainFrame mainFrame;


    public BasePanel(MainFrame frame) {
        mainFrame = frame;
        btnBack = new JButton("Volver");
        setLayout(new BorderLayout());
        centralPanel = new JPanel();
        southPanel = new JPanel();
        westPanel = new JPanel();
        centralPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        centralPanel.setPreferredSize(new Dimension(200, 300));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 0, 150)); 
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(500, 45));

        startComponents();
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        add(westPanel, BorderLayout.WEST);
        southPanel.add(btnBack);
        //Boton
        btnBack.addActionListener(e -> frame.showMainPanel());

    }

    public abstract void startComponents();

}
