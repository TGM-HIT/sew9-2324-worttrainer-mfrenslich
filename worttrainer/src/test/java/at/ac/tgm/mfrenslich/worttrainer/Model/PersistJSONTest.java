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
        this.wortliste.addWord("Turtle", "https://i.pinimg.com/originals/f1/f4/13/f1f413d6d07912be6080c08b186630ac.jpg");
        this.wortliste.addWord("Dog", "https://b1157417.smushcdn.com/1157417/wp-content/uploads/2023/09/happy-dog-with-big-tongue-out.jpg?lossy=1&strip=1&webp=0");
        this.worttrainer = new Worttrainer(this.wortliste);
        this.worttrainer.chooseIndex(0);
        this.worttrainer.check("Turtle");
        this.persist = new PersistJSON(worttrainer);
        this.persist.save();
        this.persist.load();
        this.worttrainer01 = this.worttrainer;
    }

    @Test
    @DisplayName("01 aktuelles Wort wiederhergestellt")
    void rightWord() {
        assertEquals("Turtle", this.worttrainer01.getWorteintrag().getWord());
    }
    @Test
    @DisplayName("02 aktuelle URL wiederhergestellt")
    void rightURL() {
        assertEquals("https://i.pinimg.com/originals/f1/f4/13/f1f413d6d07912be6080c08b186630ac.jpg", worttrainer01.getWorteintrag().getUrl());
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
        assertEquals("Turtle, https://i.pinimg.com/originals/f1/f4/13/f1f413d6d07912be6080c08b186630ac.jpg\nDog, https://b1157417.smushcdn.com/1157417/wp-content/uploads/2023/09/happy-dog-with-big-tongue-out.jpg?lossy=1&strip=1&webp=0", worttrainer01.getList().toString());
    }
}