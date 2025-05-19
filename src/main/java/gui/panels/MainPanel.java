/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;
import interfaces.IPersistenceFacade;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author david
 */
public class MainPanel extends JPanel {
    private IPersistenceFacade persistenceFacade;
    private JPanel centerPanel;
    private JPanel soutPanel;
    private final Image imagen;

    public MainPanel(IPersistenceFacade persistenceFacade) {
        this.persistenceFacade = persistenceFacade;
        this.imagen = new ImageIcon("src/main/java/assets/mainFrame.png").getImage();
        setLayout(new BorderLayout());

        //Panels
        //centralPanel
        centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPanel.setPreferredSize(new Dimension(1200, 550));

        centerPanel.setOpaque(false);

        //soutPanel
        soutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        soutPanel.setOpaque(false);


        add(centerPanel, BorderLayout.CENTER);
        add(soutPanel, BorderLayout.SOUTH);
    }

    /**
     * Sobrescribe el metodo paintComponent para dibujar la imagen de fondo.
     *
     * @param g Objeto Graphics utilizado para dibujar la imagen
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}