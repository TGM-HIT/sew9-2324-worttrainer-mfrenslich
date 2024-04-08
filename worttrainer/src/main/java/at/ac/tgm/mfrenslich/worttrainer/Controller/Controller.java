package at.ac.tgm.mfrenslich.worttrainer.Controller;

import at.ac.tgm.mfrenslich.worttrainer.Model.*;
import at.ac.tgm.mfrenslich.worttrainer.View.Frame;
import at.ac.tgm.mfrenslich.worttrainer.View.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * Klasse Controller.
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */

public class Controller implements ActionListener {
    private Panel panel;
    private Frame frame;
    private Worttrainer trainer;
    private Persist persist;

    /**
     * Konstruktor: Initialisiert den Controller und alle erforderlichen Komponenten.
     */
    public Controller() {
        trainer = new Worttrainer(new Wortliste());
        persist = new PersistJSON(trainer);
        persist.load(); // Laden der persistierten Daten
        trainer = persist.getTrainer(); // Aktualisieren des Trainers aus den geladenen Daten

        // Initialisierung des Panels und des Frames
        panel = new Panel(this);
        frame = new Frame(panel);

        // Aktualisierung der Statistik im Panel
        panel.statistikAktualisieren(trainer.getGamesPlayed(), trainer.getGamesWon());

        // Anzeigen des ersten Wortes
        this.showWord();
    }

    /**
     * Methode: actionPerformed, wird aufgerufen, wenn eine Aktion ausgeführt wird.
     *
     * @param e Das ActionEvent-Objekt, das die ausgelöste Aktion repräsentiert.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Zurücksetzen")) {
            this.reset();
            persist.save(); // Speichern der Daten nach dem Zurücksetzen
        } else if (e.getActionCommand().equals("Wort hinzufügen")) {
            this.addWord();
            persist.save(); // Speichern der Daten nach dem Hinzufügen eines neuen Wortes
        } else {
            this.check();
            persist.save(); // Speichern der Daten nach Überprüfen des eingegebenen Wortes
        }
    }

    /**
     * Main-Methode: Erstellt eine Instanz des Controllers und startet das Programm.
     *
     * @param args Die Eingabeparameter der Anwendung (werden in diesem Fall nicht verwendet).
     */
    public static void main(String[] args) {
        Controller control = new Controller();
    }

    /**
     * Methode: addWord, fügt ein neues Wort zur Wortliste hinzu.
     */
    public void addWord() {
        // Eingabe des neuen Wortes und seiner URL über einen Dialog
        String wort = JOptionPane.showInputDialog(null, "Geben Sie das Wort ein: ");
        String url = JOptionPane.showInputDialog(null, "Geben Sie die URL ein: ");

        if (wort != null && url != null) {
            // Überprüfen, ob der Trainer initialisiert ist
            if (trainer == null) {
                try {
                    // Erstellen einer neuen Wortliste und eines Trainers
                    Wortliste liste = new Wortliste();
                    liste.addWord(wort, url);
                    trainer = new Worttrainer(liste);
                    this.showWord();
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            } else {
                // Hinzufügen des neuen Worts zur vorhandenen Wortliste
                Wortliste liste = trainer.getList();
                try {
                    liste.addWord(wort, url);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                    liste = null;
                }
                // Aktualisieren des Trainers mit der aktualisierten Wortliste
                if (liste != null) {
                    trainer.setList(liste);
                }
            }
        }
    }

    /**
     * Methode: showWord, zeigt ein zufälliges Wort und das dazugehörige Bild an.
     */
    public void showWord() {
        if (trainer != null) {
            trainer.chooseRandom();
            Worteintrag zufall = trainer.getWorteintrag();
            URL url = null;
            try {
                url = new URL(zufall.getUrl());
            } catch (MalformedURLException e1) {
                JOptionPane.showMessageDialog(null, "URL nicht gefunden: " + e1.getMessage());
                try {
                    // Löschen des fehlerhaften Eintrags aus der Wortliste
                    Wortliste liste = trainer.getList();
                    liste.deleteWord(trainer.getWorteintrag().getWord());
                } catch (IllegalArgumentException e2) {
                    trainer = null;
                }
            }
            if (url != null) panel.changePicture(url); // Anzeigen des Bildes im Panel
        }
    }

    /**
     * Methode: check, überprüft das eingegebene Wort und gibt eine entsprechende Rückmeldung aus.
     */
    public void check() {
        String wort = panel.getTextFromTextField();
        if (trainer.check(wort)) {
            JOptionPane.showMessageDialog(null, "Das Wort ist richtig!");
            this.showWord();
        } else {
            trainer.setGamesPlayed(trainer.getGamesPlayed() - 1);
            if (trainer.checkIgnoreCase(wort)) {
                trainer.setGamesWon(trainer.getGamesWon() - 1);
                JOptionPane.showMessageDialog(null, "Das Wort ist falsch geschrieben!");
            } else {
                JOptionPane.showMessageDialog(null, "Das Wort ist falsch!");
            }
        }
        panel.statistikAktualisieren(trainer.getGamesPlayed(), trainer.getGamesWon());
    }

    /**
     * Methode: reset, setzt die Spielstatistik auf die Standardwerte zurück.
     */
    public void reset() {
        trainer.setGamesPlayed(0);
        trainer.setGamesWon(0);
        panel.statistikAktualisieren(0, 0);
    }
}
