package edu.ib;

import java.util.ArrayList;

/**
 * The player has the cards and the ability to play
 */
public class Gracz {

    private ArrayList<Karta> karty;
    public Gracz() {

    }
    public Gracz(ArrayList<Karta> karty) {
        this.karty = karty;
    }

    public ArrayList<Karta> getKarty() {
        return karty;
    }

    public void setKarty(ArrayList<Karta> karty) {
        this.karty = karty;
    }


}
