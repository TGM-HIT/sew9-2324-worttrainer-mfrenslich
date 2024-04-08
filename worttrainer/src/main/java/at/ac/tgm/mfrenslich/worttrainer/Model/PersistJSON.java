package at.ac.tgm.mfrenslich.worttrainer.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

/**
 * Klasse PersistJSON.
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */
public class PersistJSON extends Persist {

    /**
     * Konstruktor der Klasse PersistJSON.
     *
     * @param trainer Der Rechtschreibtrainer der übergeben wird.
     */
    public PersistJSON(Worttrainer trainer) {
        super(trainer);
    }

    /**
     * Methode: save, speichert eine Worttrainersession.
     */
    @Override
    public void save() {
        // Erstellt ein JSONObject aus dem Worttrainer-Objekt
        JSONObject jsonObject = new JSONObject(trainer);
        FileWriter fileWriter = null;
        try {
            // Öffnet eine FileWriter, um die JSON-Daten in eine Datei zu schreiben
            fileWriter = new FileWriter("persist.json");
            // Schreibt die JSON-Daten in die Datei
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            // Behandelt Ausnahmen, die beim Schreiben auftreten können
            e.printStackTrace();
        } finally {
            // Schließt den FileWriter sicher, wenn er nicht mehr benötigt wird
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    // Behandelt Ausnahmen, die beim Schließen auftreten können
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }

    /**
     * Methode: load, lädt eine Worttrainersession.
     */
    public void load() {
        try {
            // Öffnet einen Reader, um die JSON-Daten aus der Datei zu lesen
            Reader input = new FileReader("persist.json");
            // Erstellt eine neue Instanz von Gson
            Gson gson = new Gson();
            // Definiert den Typ des Objekts, das aus der JSON-Datenstruktur deserialisiert werden soll
            Type type = new TypeToken<Worttrainer>(){}.getType();
            // Deserialisiert/Wandelt die JSON-Daten in ein Worttrainer-Objekt um
            trainer = gson.fromJson(input, type);
        } catch (IOException e) {
            // Behandelt Exceptions, die beim Lesen der Datei auftreten können
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
