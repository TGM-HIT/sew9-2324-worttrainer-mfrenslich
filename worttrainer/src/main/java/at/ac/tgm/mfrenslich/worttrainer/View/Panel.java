package at.ac.tgm.mfrenslich.worttrainer.View;

import at.ac.tgm.mfrenslich.worttrainer.Controller.Controller;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

/**
 * Klasse Panel.
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */
public class Panel extends JPanel {
    private JButton buttons[];
    private JLabel labels[];
    private JTextField textfeld;
    private JLabel imageLabel;
    private Controller control;

    /**
     * Konstruktor der Klasse Panel.
     *
     * @param control Der Controller.
     */
    public Panel(Controller control) {
        // Setzt den Controller für die Steuerung der Benutzeroberfläche
        this.control = control;
        // Setzt das Layout des Panels auf BorderLayout
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        // Erstellt und konfiguriert JLabels für die Anzeige von Informationen
        labels = new JLabel[5];
        labels[0] = new JLabel("Errate das Wort!", SwingConstants.CENTER);
        labels[1] = new JLabel("Richtige Woerter:", SwingConstants.LEFT);
        labels[2] = new JLabel("0", SwingConstants.CENTER);
        labels[3] = new JLabel("Anzahl Woerter:", SwingConstants.LEFT);
        labels[4] = new JLabel("0", SwingConstants.CENTER);
        for (int i = 0; i < 5; i++) {
            labels[i].setOpaque(true);
            labels[i].setBackground(new Color(200, 200, 200));
            labels[i].setPreferredSize(new Dimension(60, 60));
        }

        // Erstellt und konfiguriert JButtons für die Interaktion des Benutzers
        buttons = new JButton[2];
        buttons[0] = new JButton("Zuruecksetzen");
        buttons[0].setActionCommand("Zurücksetzen");
        buttons[1] = new JButton("Wort hinzufuegen");
        buttons[1].setActionCommand("Wort hinzufügen");
        for (int i = 0; i < 2; i++) {
            this.buttons[i].addActionListener(this.control);
        }

        // Erstellt ein JLabel für die Anzeige von Bildern
        imageLabel = new JLabel(new ImageIcon(), SwingConstants.CENTER);

        // Erstellt ein JTextField für die Eingabe von Text
        textfeld = new JTextField();
        this.textfeld.addActionListener(this.control);

        // Erstellt und konfiguriert JPanels für die Organisation der Komponenten
        JPanel oben = new JPanel(new GridLayout(2, 1));
        JPanel unten = new JPanel(new GridLayout(2, 1));
        JPanel unten1 = new JPanel(new GridLayout(1, 3));
        JPanel unten2 = new JPanel(new GridLayout(1, 3));

        // Fügt Komponenten zu den entsprechenden Panels hinzu
        oben.add(labels[0]);
        oben.add(textfeld);
        unten1.add(labels[1]);
        unten1.add(labels[2]);
        unten1.add(buttons[0]);
        unten2.add(labels[3]);
        unten2.add(labels[4]);
        unten2.add(buttons[1]);
        // Fügt die Panels mit den Komponenten zum Haupt-Panel hinzu, das BorderLayout verwendet
        this.add(oben, BorderLayout.PAGE_START);
        this.add(imageLabel, BorderLayout.CENTER);
        unten.add(unten1);
        unten.add(unten2);
        this.add(unten, BorderLayout.PAGE_END);
    }

    /**
     * Gibt den Text aus dem Textfeld zurück
     *
     * @return Der Text
     */
    public String getTextFromTextField() {
        return textfeld.getText();
    }

    /**
     * Die Statistik wird aktualisiert
     *
     * @param statistikGesamt  Die Anzahl Wörter
     * @param statistikRichtig Die Anzahl der richtigen Wörter
     */
    public void statistikAktualisieren(int statistikGesamt, int statistikRichtig) {
        // Aktualisiert die Anzeige der Statistik
        labels[2].setText(String.valueOf(statistikRichtig));
        labels[4].setText(String.valueOf(statistikGesamt));
    }

    /**
     * Diese Methode ändert das Bild auf das neue Bild
     * mit der Hilfe der übergebenen URL
     *
     * @param url Die URL
     */
    public void changePicture(URL url) {
        // Lädt das Bild von der angegebenen URL und passt es an die Größe des Panels an
        ImageIcon icon = new ImageIcon(url);
        Image image = icon.getImage();
        float verhaeltnis = (float) this.getHeight() / 1.6f / (float) image.getHeight(this);
        float width = (float) image.getWidth(this) * verhaeltnis;
        float height = (float) this.getHeight() / 1.6f;
        image = image.getScaledInstance((int) width, (int) height, Image.SCALE_SMOOTH);
        // Setzt das Bild im Bild-Label
        imageLabel.setIcon(new ImageIcon(image));
    }
}
