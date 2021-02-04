package edu.ib;

import javafx.application.Platform;

/**
 * determnes the rules of the game
 */
public class Gra {

    /**
     * @param aktywna the last used card to which we select the next card
     * @param kartaGracza cards dealt to the player that he can use
     * @param czyZagranoKarta if the card has been played
     * @return the last card played turns into 'aktywna'
     *  the method determines the rules of the game - using eights, adding and removing cards
     *  determines the turn of the game
     */
    public static Karta[] zagranie(Karta aktywna, Karta kartaGracza, boolean czyZagranoKarta) {

        Karta[] Kar = new Karta[2];
        boolean czyMozna = false;
        if (czyZagranoKarta == false) {
            if (kartaGracza.getKolor().equals(aktywna.getKolor())) {

                Kar[0] = kartaGracza;
                Kar[1] = aktywna;
                return Kar;

            } else if (kartaGracza.getRanga().equals(aktywna.getRanga())) {

                Kar[0] = kartaGracza;
                Kar[1] = aktywna;
                return Kar;

            } else if (kartaGracza.getRanga().equals("eight")) { // 8 can always be used

                Kar[0] = kartaGracza;
                Kar[1] = aktywna;
                return Kar;

            } else {

                Kar[0] = aktywna;
                Kar[1] = null;
                System.out.println("Zła karta.");
                return Kar;
            }
        } else {

            System.out.println("Druga karta");
            String rangaAktywnej = aktywna.getRanga();
            String rangaKartyGracza = kartaGracza.getRanga();
            String kolorAktywnej = aktywna.getKolor();
            String kolorKartyGracza = kartaGracza.getKolor();
            String[] Rangi = {
                    "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
            String[] Kolory = {"clubs", "hearts", "spades", "diamonds"};

            int indexRangiKartyGracza = -1;
            int indexRangiAktywnej = -1;
            int indexKoloruKartyGracza = -1;
            int indexKoloruAktywnej = -1;

            if (kartaGracza.getRanga().equals("eight")) {  // 8 can always be used

                Kar[0] = kartaGracza;
                Kar[1] = aktywna;
                czyMozna = true;

            } else if (kartaGracza.getKolor().equals(aktywna.getKolor())) {

                for (int i = 0; i < Rangi.length; i++) {
                    if (rangaKartyGracza == Rangi[i]) {

                        indexRangiKartyGracza = i;

                    }
                    if (rangaAktywnej == Rangi[i]) {

                        indexRangiAktywnej = i;

                    }
                }
/**
 * color matching
 * checking the matching the cards by colors
 */
                if (Math.abs(indexRangiAktywnej - indexRangiKartyGracza) <= 1) {

                    czyMozna = true;

                }
            } else if (kartaGracza.getRanga().equals(aktywna.getRanga())) {
                for (int i = 0; i < Rangi.length; i++) {
                    if (kolorKartyGracza == Kolory[i]) {

                        indexKoloruKartyGracza = i;

                    }
                    if (kolorAktywnej == Kolory[i]) {

                        indexKoloruAktywnej = i;

                    }
                }
/**
 * rank matching
 * checking the matching the cards by rank
 */
                if (Math.abs(indexKoloruKartyGracza - indexKoloruAktywnej) <= 1) {

                    czyMozna = true;

                }
            } else {

                czyMozna = false;

            }
            if (czyMozna == false) {

                Kar[0] = aktywna;
                Kar[1] = null;
                System.out.println("Zła karta.");
                //To do usuniecia:
                return Kar;

            } else {

                Kar[0] = kartaGracza;
                Kar[1] = aktywna;
                return Kar;

            }
        }
    }
}
