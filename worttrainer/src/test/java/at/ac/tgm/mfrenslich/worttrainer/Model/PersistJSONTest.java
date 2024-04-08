package at.ac.tgm.mfrenslich.worttrainer.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersistJSONTest {

    private Wortliste wortliste;
    private Worteintrag worteintrag;
    private Persist persist;
    private Worttrainer worttrainer, worttrainer01;

    @BeforeEach
    void setup() {
        this.wortliste = new Wortliste();
        this.wortliste.addWord("Maus", "https://www.peta.de/wp-content/uploads/2009/03/Maus-house-mouse-gf306cec1c_1280-c-pixabay.jpg");
        this.wortliste.addWord("Igel", "https://image.geo.de/30154986/t/4L/v3/w1440/r0/-/igel-geolino-shutterstock-jpg--88472-.jpg");
        this.worttrainer = new Worttrainer(this.wortliste);
        this.worttrainer.chooseIndex(0);
        this.worttrainer.check("Maus");
        this.persist = new PersistJSON(worttrainer);
        this.persist.save();
        this.persist.load();
        this.worttrainer01 = this.worttrainer;
    }

    @Test
    @DisplayName("01 aktuelles Wort wiederhergestellt")
    void rightWord() {
        assertEquals("Maus", this.worttrainer01.getWorteintrag().getWord());
    }
    @Test
    @DisplayName("02 aktuelle URL wiederhergestellt")
    void rightURL() {
        assertEquals("https://www.peta.de/wp-content/uploads/2009/03/Maus-house-mouse-gf306cec1c_1280-c-pixabay.jpg", worttrainer01.getWorteintrag().getUrl());
    }
    @Test
    @DisplayName("03 games played wiederhergestellt")
    void gamesPlayed() {
        assertEquals(1,this.worttrainer01.getGamesPlayed());
    }
    @Test
    @DisplayName("04 games won wiederhergestellt")
    void gamesWon() {
        assertEquals(1,this.worttrainer01.getGamesWon());
    }
    @Test
    @DisplayName("05 liste wiederhergestellt")
    void getList() {
        assertEquals("Maus, https://www.peta.de/wp-content/uploads/2009/03/Maus-house-mouse-gf306cec1c_1280-c-pixabay.jpg\nIgel, https://image.geo.de/30154986/t/4L/v3/w1440/r0/-/igel-geolino-shutterstock-jpg--88472-.jpg", worttrainer01.getList().toString());
    }
}