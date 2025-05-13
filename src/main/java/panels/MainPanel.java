/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class MainPanel extends JPanel{
    private JLabel label;
    private JButton btnUndo;
    private JPanel centerPanel;
    private JPanel soutPanel;

    public MainPanel() {
        setLayout(new BorderLayout());
        label  = new JLabel("Main panel");
        btnUndo = new JButton("Deshacer ultima accion");
        btnUndo.setPreferredSize(new Dimension(180, 30));
        
        //Panels 
            //centralPanel
        centerPanel = new JPanel(new  FlowLayout(FlowLayout.LEFT));
        centerPanel.setPreferredSize(new Dimension(500, 300));
        centerPanel.add(label);
            //soutPanel
        soutPanel = new JPanel(new  FlowLayout(FlowLayout.LEFT));
        soutPanel.add(btnUndo);
            
        add(centerPanel, BorderLayout.CENTER);
        add(soutPanel, BorderLayout.SOUTH);
        
    }

}
