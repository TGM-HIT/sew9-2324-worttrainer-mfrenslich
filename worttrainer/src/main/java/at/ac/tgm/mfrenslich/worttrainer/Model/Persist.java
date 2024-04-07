package at.ac.tgm.mfrenslich.worttrainer.Model;

/**
 * Abstrakte Klasse Persist.
 *
 * @author Maximilian Frenslich
 * @version 07.04.2024
 */
public abstract class Persist {
    protected Worttrainer trainer;

    public abstract void save();

    public abstract void load();

    /**
     * Gibt den Rechtschreibtrainer zurück.
     *
     * @return der Rechtschreibtrainer.
     */
    public Worttrainer getTrainer() {
        return trainer;
    }

    /**
     * Konstruktor der Klasse Persist.
     *
     * @param trainer Der Rechtschreibtrainer der übergeben wird.
     */
    public Persist(Worttrainer trainer) {
        this.trainer = trainer;
    }
}
