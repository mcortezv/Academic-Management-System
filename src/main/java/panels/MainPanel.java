/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class MainPanel extends JPanel{
    private JLabel label;

    public MainPanel() {
        label  = new JLabel("Main panel");
        add(label);
    }

}
