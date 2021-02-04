package edu.ib;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * determines who currently has what cards
 */
public class DystrybucjaKart {
    /**
     * @return returns a full deck of cards
     */
    /*
    okresla kto ma jakie karty na dany moment
    gracz1
    gracz2
    stol - talia do pobrania i wylozone karty
     */
    public static ArrayList<Karta> talia() {

        ArrayList<Karta> talia = new ArrayList<Karta>();

        int[] ran = new int[13];
        int[] kol = new int[4];

        Image Pik5 = new Image("fxml/cards/fiveofspades.png");
        String[] Kolory = {"clubs", "hearts", "spades", "diamonds"};
        String[] Rangi = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};

        for (int i = 0; i < Rangi.length; i++) {
            for (int j = 0; j < Kolory.length; j++) {

                ImageView obrazek = new ImageView("fxml/cards/" + Rangi[i] + "of" + Kolory[j] + ".png");
                Karta karta = new Karta(Kolory[j], Rangi[i], obrazek);
                karta.setObrazek(obrazek);
                talia.add(karta);

            }
        }
        return talia;
    }

    /**
     * @param talia a deck of cards
     * @return returns a shuffled deck of cards
     */
    public static ArrayList<Karta> tasowansko(ArrayList<Karta> talia) {

        Collections.shuffle(talia);

        for (int i = 0; i < talia.size(); i++) {

            System.out.println(talia.get(i));

        }
        return talia;
    }

    /**
     * @param talia        a deck of cards
     * @param liczbaGraczy determines the number of players
     * @param gracz        determines one player
     * @param stol         table with the cards used for the game
     * @return returns the cards dealt to the players and to the table
     */
    public static ArrayList<Karta>[] rozdanie(ArrayList<Karta> talia, int liczbaGraczy, Gracz[] gracz, Stol stol) {

        ArrayList[] stosy = new ArrayList[3];
        ArrayList<Karta> stosOczekujacy = talia;

        for (int i = 0; i < liczbaGraczy; i++) {

            ArrayList<Karta> proPlayer = new ArrayList<Karta>();

            for (int j = 0; j < 8; j++) {

                proPlayer.add(talia.get(0));
                talia.remove(0);

            }
            gracz[i].setKarty(proPlayer);
        }

        stol.setOczekujace(talia);

        stosy[0] = gracz[0].getKarty();
        stosy[1] = gracz[1].getKarty();
        stosy[2] = stol.getOczekujace();
        return stosy;

    }
}