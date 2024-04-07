package at.ac.tgm.mfrenslich.worttrainer.Model;

import java.util.Random;

/**
 * Klasse Rechtschreibtrainer
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */
public class Worttrainer {
    private Wortliste list;
    private Worteintrag worteintrag;
    private int gamesPlayed, gamesWon;

    /**
     * Konstruktor der Klasse Rechtschreibtrainer.
     *
     * @param list Die Liste welche übergeben wird.
     * @throws IllegalArgumentException Exception die bei ungültigen Werten ausgegeben wird.
     */
    public Worttrainer(Wortliste list) {
        this.list = list;
    }

    /**
     * Methode: randomWord, wählt ein zufälliges Wort aus der Liste aus.
     *
     * @throws IllegalArgumentException Exception die bei einer ungültigen Liste ausgegeben wird.
     */
    public void chooseRandom() throws IllegalArgumentException {
        if (this.list.getList().isEmpty()) {
            throw new IllegalArgumentException("Leere Liste!");
        }
        Random r1 = new Random();
        worteintrag = this.list.getWord(r1.nextInt(this.list.getList().size()));
    }

    /**
     * Methode: chooseIndex, wählt ein Wort anhand eines Indexes aus.
     *
     * @param index Der Index mit dem das Wort ausgewählt wird.
     * @throws IllegalArgumentException  Falls die Liste leer ist.
     * @throws IndexOutOfBoundsException Falls der Index ungültig ist.
     */
    public void chooseIndex(int index) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (this.list.getList().isEmpty()) {
            throw new IllegalArgumentException("Ungültige Liste!");
        }
        if (index < 0 || index >= this.list.getList().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.worteintrag = this.list.getWord(index);
        }
    }

    /**
     * Methode: check, überprüft, ob das übergebene Wort mit dem aktuellen übereinstimmt.
     *
     * @param word Das übergebene Wort.
     * @return Gibt true oder false zurück.
     */
    public boolean check(String word) {
        this.gamesPlayed++;
        if (word.equals(this.worteintrag.getWord())) {
            this.gamesWon++;
            return true;
        }
        return false;
    }

    /**
     * Methode: checkIgnoreCase, überprüft, ob das übergebene Wort mit dem aktuellen übereinstimmt.
     *
     * @param word Das übergebene Wort.
     * @return Gibt true oder false zurück.
     */
    public boolean checkIgnoreCase(String word) {
        this.gamesPlayed++;
        if (word.equalsIgnoreCase(this.worteintrag.getWord())) {
            this.gamesWon++;
            return true;
        }
        return false;
    }

    /**
     * Methode: toString, gibt einen Text zurück.
     */
    @Override
    public String toString() {
        String text = this.gamesPlayed + ", " + this.gamesWon + "\n";
        text += this.list.toString();
        return text;
    }


    public void setList(Wortliste list) {
        this.list = list;
    }

    public Wortliste getList() {
        return list;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public void setGamesPlayed(int zahl) {
        this.gamesPlayed = zahl;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int zahl) {
        this.gamesWon = zahl;
    }

    public Worteintrag getWorteintrag() {
        return worteintrag;
    }
}