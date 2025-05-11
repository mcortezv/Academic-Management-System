/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formsDialog;

import gui.MainFrame;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class StudentFormDialog extends JDialog{
    private JPanel centerPanel;
    private JPanel southPanel;

    public StudentFormDialog(MainFrame owner) {
        super(owner, "Añadir estudiante", true);
        setSize(400, 300);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        centerPanel = new JPanel();
        southPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Name field
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(new JLabel("Nombre Completo:   "));
        JTextField nameField = new JTextField(20);
        namePanel.add(nameField);
        namePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0)); 

        // Section label
        JLabel sectionLabel = new JLabel("--------  Informacion de contacto  --------");
        sectionLabel.setFont(sectionLabel.getFont().deriveFont(Font.BOLD));
        sectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        sectionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0)); 

        // Phone field
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        phonePanel.add(new JLabel("Telefono:              "));
        JTextField phoneField = new JTextField(15);
        phonePanel.add(phoneField);

        // Email field
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.add(new JLabel("Email:                    "));
        JTextField emailField = new JTextField(20);
        emailPanel.add(emailField);

        // Address field
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addressPanel.add(new JLabel("Direccion postal:"));
        JTextField addressField = new JTextField(20);
        addressPanel.add(addressField);

        // Add button
        JButton saveButton = new JButton("Añadir");
        saveButton.addActionListener(e -> {


            dispose(); 
        });

        // Add everything to the main panel
        centerPanel.add(namePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(sectionLabel);
        centerPanel.add(phonePanel);
        centerPanel.add(emailPanel);
        centerPanel.add(addressPanel);
        centerPanel.add(Box.createVerticalStrut(15));
        southPanel.add(saveButton);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
}
