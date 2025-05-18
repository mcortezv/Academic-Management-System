/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.styles;
import gui.MainFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public abstract class Dialog extends JDialog {

    protected JPanel centerPanel;
    protected JPanel southPanel;
    protected MainFrame mainFrame;

    public Dialog(MainFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();

    }

}
