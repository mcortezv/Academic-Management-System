/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.styles;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class Style {
    public static boolean DARK_MODE = true;
    public static final Color BACKGROUND_COLOR = DARK_MODE ? new Color(28, 28, 30) : new Color(250, 250, 252);
    public static final Color PANEL_COLOR = DARK_MODE ? new Color(40, 40, 42) : new Color(240, 240, 245);
    public static final Color BUTTON_COLOR = DARK_MODE ? new Color(138, 101, 255) : new Color(44, 62, 80);
    public static final Color BUTTON_COLOR_HOVER = DARK_MODE ? new Color(155, 121, 255) : new Color(52, 73, 94);
    public static final Color TEXT_COLOR = DARK_MODE ? new Color(235, 235, 235) : new Color(33, 33, 33);
    public static final Color INPUT_COLOR = DARK_MODE ? new Color(55, 55, 58) : new Color(255, 255, 255);

    public static final java.awt.Font TITLE_FONT = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16);
    public static final java.awt.Font LABEL_FONT = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 11);
    public static final java.awt.Font INPUT_FONT = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 10);
    public static final java.awt.Font BUTTON_FONT = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 11);
}