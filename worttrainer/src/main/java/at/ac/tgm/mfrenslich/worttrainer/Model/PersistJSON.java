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
        JSONObject jsonObject = new JSONObject(trainer);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("persist.json");
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
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
            Reader input = new FileReader("persist.json");
            Gson gson = new Gson();
            Type type = new TypeToken<Worttrainer>(){}.getType();
            trainer = gson.fromJson(input, type);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
