package at.ac.tgm.mfrenslich.worttrainer.Model;

import java.util.LinkedList;

/**
 * Klasse Wortliste.
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */
public class Wortliste {
    private LinkedList<Worteintrag> list;

    /**
     * Konstruktor der Klasse Wortliste.
     */
    public Wortliste() {
        this.list = new LinkedList<>();
    }

    /**
     * Methode: addWord, erstellt ein Wort und fügt es der Liste hinzu.
     *
     * @param wort Das Wort welches hinzugefügt wird.
     * @param url  Die URL welche hinzugefügt wird.
     * @throws IllegalArgumentException Exception die geworfen wird wenn die Werte ungültig sind.
     */
    public void addWord(String wort, String url) throws IllegalArgumentException {
        Worteintrag worteintrag = new Worteintrag(wort, url);
        this.list.addLast(worteintrag);
    }

    /**
     * Methode: getWord, gibt ein Worteintrag zurück.
     *
     * @param index Der Worteintrag aus der Stelle der Liste.
     * @return Der Worteintrag aus der Stelle der Liste.
     * @throws IndexOutOfBoundsException Exception die ausgegeben wird, wenn der Index nicht gültig ist.
     */
    public Worteintrag getWord(int index) throws IndexOutOfBoundsException {
        if (index < this.list.size() && index >= 0) {
            return this.list.get(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Methode: deleteWord, löscht ein Wort aus der Liste.
     *
     * @param word Das Wort welches aus der Liste gelöscht werden soll.
     * @return Gibt true oder false zurück.
     * @throws IllegalArgumentException Exception die ausgegeben wird wenn das Wort ungültig ist.
     */
    public boolean deleteWord(String word) throws IllegalArgumentException {
        boolean success = false;
        if (word == null) {
            throw new IllegalArgumentException("Kein gültiges Wort");
        }
        if (word.length() < 2) {
            throw new IllegalArgumentException("Kein gültiges Wort");
        }
        for (Worteintrag we : this.list) {
            if (we.getWord().equals(word)) {
                success = true;
                this.list.remove();
            }
        }
        return success;
    }

    /**
     * Methode: toString, gibt einen Text zurück.
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Worteintrag we : this.list) {
            text.append(we.toString()).append("\n");
        }
        return text.toString();
    }

    /**
     * Methode: getList, gibt eine Liste zurück.
     *
     * @return Die List mit den Wortpaaren.
     */
    public LinkedList<Worteintrag> getList() {
        return this.list;
    }
}
