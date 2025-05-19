/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.panels;
import gui.styles.Button;
import gui.styles.Style;
import interfaces.IPersistenceFacade;
import java.awt.*;
import javax.swing.*;
import structures.Stack;

/**
 *
 * @author david
 */
public class MainPanel extends JPanel {
    private IPersistenceFacade persistenceFacade;
    private Button btnUndo;
    private JPanel centerPanel;
    private JPanel southPanel;
    private final Image imagen;
    private JLabel titulo;
    private JTextArea actionsArea;
    private JScrollPane jps;

    public MainPanel(IPersistenceFacade persistenceFacade) {
        this.persistenceFacade = persistenceFacade;
        this.imagen = new ImageIcon("").getImage();
        setLayout(new BorderLayout());
        titulo = new JLabel("Historial de Acciones", JLabel.LEFT);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        actionsArea = new JTextArea(25, 30);
        actionsArea.setLineWrap(true);
        actionsArea.setWrapStyleWord(true);
        actionsArea.setEditable(false);
        jps = new JScrollPane(actionsArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jps.setPreferredSize(new Dimension(300, 200));
        btnUndo = new Button("Deshacer Ultima Accion");
        btnUndo.setPreferredSize(new Dimension(220, 40));

        //Panels
        //centralPanel
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setPreferredSize(new Dimension(750, 400));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        centerPanel.setBackground(Style.PANEL_COLOR);
        centerPanel.add(titulo);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(jps);
        //centerPanel.setOpaque(false);

        //soutPanel
        southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0));
        southPanel.add(btnUndo);
        southPanel.setBackground(Style.PANEL_COLOR);
        //soutPanel.setOpaque(false);

        //Buttons
        //Undo Action
        btnUndo.addActionListener(e -> {
            persistenceFacade.undoAction();
        });

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    public void updateText(String text) {
        actionsArea.setText(text);
        actionsArea.setCaretPosition(actionsArea.getDocument().getLength());
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