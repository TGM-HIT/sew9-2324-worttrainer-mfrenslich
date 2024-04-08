package at.ac.tgm.mfrenslich.worttrainer.View;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Klasse Frame.
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */
public class Frame extends JFrame {
    /**
     * Konstruktor der Klasse Frame.
     *
     * @param panel Das Layout.
     */
    public Frame(JPanel panel) {
        super("Worttrainer"); //  Worttrainer wird als Titel festgelegt
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 600, 450);
        this.setVisible(true);
    }
}