package at.ac.tgm.mfrenslich.worttrainer.Model;

import org.apache.commons.validator.routines.UrlValidator;

/**
 * Klasse Worteintrag.
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */
public class Worteintrag {
    private String word = "";
    private String url = "";

    /**
     * Konstruktor der Klasse Worteintrag
     *
     * @param word Das Wort des Worteintrages.
     * @param url  Die URL des Worteintrages.
     * @throws IllegalArgumentException Exception die geworfen wird wenn die Werte nicht stimmen.
     */
    public Worteintrag(String word, String url) throws IllegalArgumentException {
        setWord(word);
        setUrl(url);
    }

    /**
     * Methode: checkURL, überprüft, ob es sich um eine gültige URL handelt.
     *
     * @param url Die URL die überprüft wird.
     * @return Gibt true oder false zurück.
     */
    public static boolean checkURL(String url) {
        String[] schemes = {"http", "https", "ftp"};
        UrlValidator validator = new UrlValidator(schemes);
        return validator.isValid(url);
    }

    /**
     * Methode: getWord, gibt ein Wort zurück.
     *
     * @return word das Wort was zurückgegeben wird.
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Methode: getURL, gibt eine URL zurück.
     *
     * @return url die URL welche zurückgegeben wird.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Methode: setWord, legt ein Wort fest.
     *
     * @param word Das Wort welches übergeben wird.
     * @throws IllegalArgumentException Exception die geworfen wird, wenn das Wort nicht gültig ist.
     */
    public void setWord(String word) throws IllegalArgumentException {
        if (word == null) {
            throw new IllegalArgumentException("Kein gültiges Wort");
        }
        if (word.length() >= 2) {
            this.word = word;
        } else {
            throw new IllegalArgumentException("Kein gültiges Wort");
        }
    }

    /**
     * Methode: setURL, legt eine URL fest.
     *
     * @param url Die URL welche übergeben wird.
     * @throws IllegalArgumentException Exception die geworfen wird, wenn das Wort nicht gültig ist.
     */
    public void setUrl(String url) throws IllegalArgumentException {
        if (Worteintrag.checkURL(url)) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("Keine gültige URL");
        }
    }

    /**
     * Methode: toString, gibt einen Text zurück vom Wort und der URL.
     */
    @Override
    public String toString() {
        return this.word + ", " + this.url;
    }
}
