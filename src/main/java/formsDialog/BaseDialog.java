/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formsDialog;

import gui.MainFrame;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public abstract class BaseDialog extends JDialog {

    protected JPanel centerPanel;
    protected JPanel southPanel;
    protected MainFrame mainFrame;

    public BaseDialog(MainFrame owner, int option) {
        
        super(owner, " ", true);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();

    }

}
