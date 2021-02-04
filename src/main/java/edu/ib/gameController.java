package edu.ib;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static edu.ib.DystrybucjaKart.*;
import static edu.ib.Gra.zagranie;

/**
 * view with playing the game
 */
public class gameController {

    private Gracz gamer = new Gracz();
    private Gracz npc = new Gracz();
    private Stol stol = new Stol();
    private Karta aktywna = new Karta();
    ArrayList<Karta> wylozone = new ArrayList<>();

    /**
     * @param czyZagranoKarta if a player puts out a card he can't draw another card
     * @param czyZagranoKartanpc if NPC puts out a card
     * @param czyBrakKartynpc if NPC has no matching card
     */

    boolean czyZagranoKarta = false;
    boolean czyZagranoKartanpc = false;
    boolean czyBrakKartynpc = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane GamePane;

    @FXML
    private ImageView gracz;

    @FXML
    private ImageView NPCsmieszne;

    @FXML
    private Button btnKartyOczekujace;


    @FXML
    private TextArea idWygrana;


    @FXML
    private Button btnKartaAktywna;

    @FXML
    private ImageView kartaAktywna;

    @FXML
    private Button btnKartaNPC1;

    @FXML
    private ImageView imageKartaNPC1;

    @FXML
    private Button btnKartaNPC2;

    @FXML
    private ImageView imageKartaNPC2;

    @FXML
    private Button btnKartaNPC3;

    @FXML
    private ImageView imageKartaNPC3;

    @FXML
    private Button btnKartaNPC4;

    @FXML
    private ImageView imageKartaNPC4;

    @FXML
    private Button btnKartaNPC5;

    @FXML
    private ImageView imageKartaNPC5;

    @FXML
    private Button btnKartaNPC6;

    @FXML
    private ImageView imageKartaNPC6;

    @FXML
    private Button btnKartaNPC7;

    @FXML
    private ImageView imageKartaNPC7;

    @FXML
    private Button btnKartaNPC8;

    @FXML
    private ImageView imageKartaNPC8;

    @FXML
    private Button btnKartaGracz1;

    @FXML
    private ImageView imageKartaGracz1;

    @FXML
    private Button btnKartaGracz2;

    @FXML
    private ImageView imageKartaGracz2;

    @FXML
    private Button btnKartaGracz3;

    @FXML
    private ImageView imageKartaGracz3;

    @FXML
    private Button btnKartaGracz4;

    @FXML
    private ImageView imageKartaGracz4;

    @FXML
    private Button btnKartaGracz5;

    @FXML
    private ImageView imageKartaGracz5;

    @FXML
    private Button btnKartaGracz6;

    @FXML
    private ImageView imageKartaGracz6;

    @FXML
    private Button btnKartaGracz7;

    @FXML
    private ImageView imageKartaGracz7;

    @FXML
    private Button btnKartaGracz8;

    @FXML
    private ImageView imageKartaGracz8;

    @FXML
    private Button btnTasowanie;

    @FXML
    private Button btnPass;

    @FXML
    private Button btnDzwonki;

    @FXML
    private Button btnSerce;

    @FXML
    private Button btnZaladz;

    @FXML
    private Button btnWino;

    @FXML
    private TextArea idKomunikat;


    @FXML
    void KartaNPC(ActionEvent event) {
    }

    @FXML
    void imKartaGracz(MouseEvent event) {
    }

    @FXML
    void imKartaNPC(MouseEvent event) {
    }

    @FXML
    void kartaAktywna(ActionEvent event) {
    }

    @FXML
    void Dzwonki(ActionEvent event) {

        btnDzwonki.setVisible(false);
        btnSerce.setVisible(false);
        btnZaladz.setVisible(false);
        btnWino.setVisible(false);
        aktywna.setKolor("diamonds");

    }

    /**
     * showing the choice of the suit of cards when playing an eight
     */

    @FXML
    void Zaladz(ActionEvent event) {
        btnDzwonki.setVisible(false);
        btnSerce.setVisible(false);
        btnZaladz.setVisible(false);
        btnWino.setVisible(false);
        aktywna.setKolor("clubs");
    }

    @FXML
    void serce(ActionEvent event) {
        btnDzwonki.setVisible(false);
        btnSerce.setVisible(false);
        btnZaladz.setVisible(false);
        btnWino.setVisible(false);
        aktywna.setKolor("hearts");
    }

    @FXML
    void wino(ActionEvent event) {
        btnDzwonki.setVisible(false);
        btnSerce.setVisible(false);
        btnZaladz.setVisible(false);
        btnWino.setVisible(false);
        aktywna.setKolor("spades");
    }

    @FXML
    void tasowanie(ActionEvent event) {

        Karta akt = aktywna;
        ArrayList<Karta> wylozone = stol.getWylozone();
        wylozone.remove(akt);

        ArrayList<Karta> wylozonePotasowane = tasowansko(wylozone);
        ArrayList<Karta> oczekujace = stol.getOczekujace();

        for (int i = 0; i < wylozonePotasowane.size(); i++) {
            oczekujace.add(wylozonePotasowane.get(i));
        }

        stol.setOczekujace(oczekujace);
    }

    /**
     * prevents the player from cheating
     * adds a card to the player who has not made a move on his turn
     */

    @FXML
    void pass(ActionEvent event) {
        if (czyZagranoKarta == false) {
            int ileKartMaGracz = gamer.getKarty().size();
            if (ileKartMaGracz < 8) {

                ArrayList<Karta> kartyGracza = gamer.getKarty();
                ArrayList<Karta> oczekujace = stol.getOczekujace();
                Karta nowaKarta = stol.getOczekujace().get(0);
                oczekujace.remove(nowaKarta);
                kartyGracza.add(nowaKarta);
                gamer.setKarty(kartyGracza);
                stol.setOczekujace(oczekujace);
                Platform.runLater(() -> idKomunikat.clear());

            } else {

                Platform.runLater(() -> idKomunikat.clear());
                System.out.println("Max liczba kart");
                Platform.runLater(() -> idKomunikat.appendText("Max liczba kart"));

            }
        }
        restartWidokuKart();

        czyZagranoKartanpc = false;
        czyZagranoKarta = false;
        czyBrakKartynpc = true;

        if (czyZagranoKartanpc == false) {
            for (int i = 0; i <= 8; i++) {

                Karta kartanpc = npc.getKarty().get(i);
                Karta[] Kar = new Karta[2];
                Kar = zagranie(aktywna, kartanpc, czyZagranoKartanpc);
                ArrayList<Karta> stareWylozone = stol.getWylozone();

                if (Kar[1] != null) {

                    wylozone.add(kartanpc);
                    stol.setWylozone(wylozone);
                    npc.getKarty().remove(kartanpc);
                    czyZagranoKartanpc = true;
                    czyBrakKartynpc = false;

                }
                stol.setAktywna(Kar[0]);
                aktywna = Kar[0];
                ImageView k = aktywna.getObrazek();
                k.setFitHeight(90);
                k.setFitWidth(90);
                btnKartaAktywna.setPrefSize(90, 90);
                btnKartaAktywna.setGraphic(k);

                restartWidokuKartNpc();
            }

            czyZagranoKartanpc = true;
            restartWidokuKartNpc();
        }
    }


    /**
     * checking if the card hidden under the button (but not the button itself!)
     * it can be played - it matches the color or the rank
     * if the color or the rank matches the card from the button must be removed (beacuse it was used)
     */

    @FXML
    void kartaGracz(ActionEvent event) {

        Karta kartaGracza = gamer.getKarty().get(0);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();

        if (Kar[1] != null) {

            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());

        } else {

            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));

        }

        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }

    @FXML
    void kartaGracz2(ActionEvent event) {
        Karta kartaGracza = gamer.getKarty().get(1);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();
        if (Kar[1] != null) {
            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());
        } else {
            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));
        }

        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }

    @FXML
    void kartaGracz3(ActionEvent event) {
        Karta kartaGracza = gamer.getKarty().get(2);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();
        if (Kar[1] != null) {
            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());
        } else {
            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));
        }

        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }

    @FXML
    void kartaGracz4(ActionEvent event) {
        Karta kartaGracza = gamer.getKarty().get(3);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();
        if (Kar[1] != null) {
            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());
        } else {
            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));
        }

//        System.out.println("ile wyłożonych: "+stol.getWylozone().size());
        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }

    @FXML
    void kartaGracz5(ActionEvent event) {
        Karta kartaGracza = gamer.getKarty().get(4);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();
        if (Kar[1] != null) {
            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());
        } else {
            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));
        }

//        System.out.println("ile wyłożonych: "+stol.getWylozone().size());
        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }

    @FXML
    void kartaGracz6(ActionEvent event) {
        Karta kartaGracza = gamer.getKarty().get(5);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();
        if (Kar[1] != null) {
            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());
        } else {
            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));
        }

//        System.out.println("ile wyłożonych: "+stol.getWylozone().size());
        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }

    @FXML
    void kartaGracz7(ActionEvent event) {

        Karta kartaGracza = gamer.getKarty().get(6);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();

        if (Kar[1] != null) {

            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());

        } else {

            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));

        }

        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }

    @FXML
    void kartaGracz8(ActionEvent event) {

        Karta kartaGracza = gamer.getKarty().get(7);
        Karta[] Kar = new Karta[2];
        Kar = zagranie(aktywna, kartaGracza, czyZagranoKarta);
        ArrayList<Karta> stareWylozone = stol.getWylozone();

        if (Kar[1] != null) {

            wylozone.add(kartaGracza);
            stol.setWylozone(wylozone);
            gamer.getKarty().remove(kartaGracza);
            czyZagranoKarta = true;
            Platform.runLater(() -> idKomunikat.clear());

        } else {

            Platform.runLater(() -> idKomunikat.clear());
            Platform.runLater(() -> idKomunikat.appendText("Zla karta"));

        }

        stol.setAktywna(Kar[0]);
        aktywna = Kar[0];
        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        restartWidokuKart();
    }


    @FXML
    void kartyOczekujace(ActionEvent event) {
        if (czyZagranoKarta == false) {

            int ileKartMaGracz = gamer.getKarty().size();

            if (ileKartMaGracz < 8) {
                ArrayList<Karta> kartyGracza = gamer.getKarty();
                ArrayList<Karta> oczekujace = stol.getOczekujace();
                Karta nowaKarta = stol.getOczekujace().get(0);
                oczekujace.remove(nowaKarta);
                kartyGracza.add(nowaKarta);
                gamer.setKarty(kartyGracza);
                stol.setOczekujace(oczekujace);
                Platform.runLater(() -> idKomunikat.clear());

            } else {

                Platform.runLater(() -> idKomunikat.clear());
                System.out.println("Maksymalna liczba kart");
                Platform.runLater(() -> idKomunikat.appendText("Maksymalna liczba kart"));

            }
        }
        czyZagranoKarta = true;
        restartWidokuKart();

        if (czyZagranoKartanpc == false) {

            int ileKartMaGracz = npc.getKarty().size();

            if (ileKartMaGracz < 8) {

                ArrayList<Karta> kartyGracza = npc.getKarty();
                ArrayList<Karta> oczekujace = stol.getOczekujace();
                Karta nowaKarta = stol.getOczekujace().get(0);
                oczekujace.remove(nowaKarta);
                kartyGracza.add(nowaKarta);
                npc.setKarty(kartyGracza);
                stol.setOczekujace(oczekujace);
                Platform.runLater(() -> idKomunikat.clear());

            } else {

                Platform.runLater(() -> idKomunikat.clear());
                System.out.println("Maksymalna liczba kart");
                Platform.runLater(() -> idKomunikat.appendText("Maksymalna liczba kart"));

            }
        }

        czyZagranoKartanpc = true;
        restartWidokuKartNpc();


    }

    @FXML
    void pictureOfCard(MouseEvent event) { }

    /**
     * initialize the game
     * dealing the cards to the players and to the table
     */
    @FXML
    void initialize() {
        assert GamePane != null : "fx:id=\"GamePane\" was not injected: check your FXML file 'Game.fxml'.";
        assert gracz != null : "fx:id=\"gracz\" was not injected: check your FXML file 'Game.fxml'.";
        assert NPCsmieszne != null : "fx:id=\"NPCsmieszne\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartyOczekujace != null : "fx:id=\"btnKartyOczekujace\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaAktywna != null : "fx:id=\"btnKartaAktywna\" was not injected: check your FXML file 'Game.fxml'.";
        assert kartaAktywna != null : "fx:id=\"kartaAktywna\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC1 != null : "fx:id=\"btnKartaNPC1\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC1 != null : "fx:id=\"imageKartaNPC1\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC2 != null : "fx:id=\"btnKartaNPC2\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC2 != null : "fx:id=\"imageKartaNPC2\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC3 != null : "fx:id=\"btnKartaNPC3\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC3 != null : "fx:id=\"imageKartaNPC3\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC4 != null : "fx:id=\"btnKartaNPC4\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC4 != null : "fx:id=\"imageKartaNPC4\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC5 != null : "fx:id=\"btnKartaNPC5\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC5 != null : "fx:id=\"imageKartaNPC5\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC6 != null : "fx:id=\"btnKartaNPC6\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC6 != null : "fx:id=\"imageKartaNPC6\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC7 != null : "fx:id=\"btnKartaNPC7\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC7 != null : "fx:id=\"imageKartaNPC7\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaNPC8 != null : "fx:id=\"btnKartaNPC8\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaNPC8 != null : "fx:id=\"imageKartaNPC8\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz1 != null : "fx:id=\"btnKartaGracz1\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz1 != null : "fx:id=\"imageKartaGracz1\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz2 != null : "fx:id=\"btnKartaGracz2\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz2 != null : "fx:id=\"imageKartaGracz2\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz3 != null : "fx:id=\"btnKartaGracz3\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz3 != null : "fx:id=\"imageKartaGracz3\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz4 != null : "fx:id=\"btnKartaGracz4\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz4 != null : "fx:id=\"imageKartaGracz4\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz5 != null : "fx:id=\"btnKartaGracz5\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz5 != null : "fx:id=\"imageKartaGracz5\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz6 != null : "fx:id=\"btnKartaGracz6\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz6 != null : "fx:id=\"imageKartaGracz6\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz7 != null : "fx:id=\"btnKartaGracz7\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz7 != null : "fx:id=\"imageKartaGracz7\" was not injected: check your FXML file 'Game.fxml'.";
        assert btnKartaGracz8 != null : "fx:id=\"btnKartaGracz8\" was not injected: check your FXML file 'Game.fxml'.";
        assert imageKartaGracz8 != null : "fx:id=\"imageKartaGracz8\" was not injected: check your FXML file 'Game.fxml'.";
        assert idWygrana != null : "fx:id=\"idWygrana\" was not injected: check your FXML file 'Game.fxml'.";
        assert idKomunikat != null : "fx:id=\"idKomunikat\" was not injected: check your FXML file 'Game.fxml'.";

        idWygrana.setVisible(false);


        ArrayList<Karta> oczekujace = talia();
        ArrayList<Karta> srajace = talia();
        oczekujace = tasowansko(oczekujace);

        Gracz[] gracze = {gamer, npc};

        ArrayList<Karta>[] stosy = new ArrayList[3];
        stosy = rozdanie(oczekujace, 2, gracze, stol);

        gamer.setKarty(stosy[0]);
        npc.setKarty(stosy[1]);
        stol.setOczekujace(stosy[2]);

        aktywna = stol.getOczekujace().get(0);
        wylozone.add(aktywna);
        oczekujace.remove(aktywna);
        stol.setWylozone(wylozone);
        stol.setAktywna(aktywna);
        stol.setOczekujace(oczekujace);

        ImageView ch = aktywna.getObrazek();
        ch.setFitHeight(117);
        ch.setFitWidth(87);
        btnKartaAktywna.setGraphic(ch);

        restartWidokuKart();
    }

    /**
     * setting the card view for the player
     */
    public void restartWidokuKart() {

        btnDzwonki.setVisible(false);
        btnSerce.setVisible(false);
        btnZaladz.setVisible(false);
        btnWino.setVisible(false);

        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        int ileKartMaGracz = gamer.getKarty().size();

        //--------------karta1
        if (ileKartMaGracz >= 1) {
            btnKartaGracz1.setVisible(true);
            gamer.getKarty().get(0).getObrazek();
            k = gamer.getKarty().get(0).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz1.setGraphic(k);
        } else {
            btnKartaGracz1.setVisible(false);
            czyWygrana();
        }
        //--------------karta2

        if (ileKartMaGracz >= 2) {
            btnKartaGracz2.setVisible(true);
            gamer.getKarty().get(1).getObrazek();
            k = gamer.getKarty().get(1).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz2.setGraphic(k);
        } else {
            btnKartaGracz2.setVisible(false);
        }
        //--------------karta3

        if (ileKartMaGracz >= 3) {
            btnKartaGracz3.setVisible(true);
            gamer.getKarty().get(2).getObrazek();
            k = gamer.getKarty().get(2).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz3.setGraphic(k);
        } else {
            btnKartaGracz3.setVisible(false);
        }
        //--------------karta4

        if (ileKartMaGracz >= 4) {
            btnKartaGracz4.setVisible(true);
            gamer.getKarty().get(3).getObrazek();
            k = gamer.getKarty().get(3).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz4.setGraphic(k);
        } else {
            btnKartaGracz4.setVisible(false);
        }
        //--------------karta5

        if (ileKartMaGracz >= 5) {
            btnKartaGracz5.setVisible(true);
            gamer.getKarty().get(4).getObrazek();
            k = gamer.getKarty().get(4).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz5.setGraphic(k);
        } else {
            btnKartaGracz5.setVisible(false);
        }

        //--------------karta6

        if (ileKartMaGracz >= 6) {
            btnKartaGracz6.setVisible(true);
            gamer.getKarty().get(5).getObrazek();
            k = gamer.getKarty().get(5).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz6.setGraphic(k);
        } else {
            btnKartaGracz6.setVisible(false);
        }
        //--------------karta7

        if (ileKartMaGracz >= 7) {
            btnKartaGracz7.setVisible(true);
            gamer.getKarty().get(6).getObrazek();
            k = gamer.getKarty().get(6).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz7.setGraphic(k);
        } else {
            btnKartaGracz7.setVisible(false);
        }
        //--------------karta8

        if (ileKartMaGracz >= 8) {
            btnKartaGracz8.setVisible(true);
            gamer.getKarty().get(7).getObrazek();
            k = gamer.getKarty().get(7).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
            btnKartaGracz8.setGraphic(k);
        } else {
            btnKartaGracz8.setVisible(false);
        }

        czyAktywnaTo8();

        czyWygrana();

    }

    /**
     * setting the card view for the NPC, but not visible to the player
     */
    public void restartWidokuKartNpc() {

        btnDzwonki.setVisible(false);
        btnSerce.setVisible(false);
        btnZaladz.setVisible(false);
        btnWino.setVisible(false);

        ImageView k = aktywna.getObrazek();
        k.setFitHeight(90);
        k.setFitWidth(90);
        btnKartaAktywna.setPrefSize(90, 90);
        btnKartaAktywna.setGraphic(k);

        int ileKartManpc = npc.getKarty().size();

        //--------------karta1
        if (ileKartManpc >= 1) {
            btnKartaNPC1.setVisible(true);
            npc.getKarty().get(0).getObrazek();
            k = npc.getKarty().get(0).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC1.setGraphic(k);
        } else {
            btnKartaNPC1.setVisible(false);
            czyWygrana();
        }
        //--------------karta2

        if (ileKartManpc >= 2) {
            btnKartaNPC2.setVisible(true);
            npc.getKarty().get(1).getObrazek();
            k = npc.getKarty().get(1).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC2.setGraphic(k);
        } else {
            btnKartaNPC2.setVisible(false);
        }
        //--------------karta3

        if (ileKartManpc >= 3) {
            btnKartaNPC3.setVisible(true);
            npc.getKarty().get(2).getObrazek();
            k = npc.getKarty().get(2).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC3.setGraphic(k);
        } else {
            btnKartaNPC3.setVisible(false);
        }
        //--------------karta4

        if (ileKartManpc >= 4) {
            btnKartaNPC4.setVisible(true);
            npc.getKarty().get(3).getObrazek();
            k = npc.getKarty().get(3).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC4.setGraphic(k);
        } else {
            btnKartaNPC4.setVisible(false);
        }
        //--------------karta5

        if (ileKartManpc >= 5) {
            btnKartaNPC5.setVisible(true);
            npc.getKarty().get(4).getObrazek();
            k = npc.getKarty().get(4).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC5.setGraphic(k);
        } else {
            btnKartaNPC5.setVisible(false);
        }

        //--------------karta6

        if (ileKartManpc >= 6) {
            btnKartaNPC6.setVisible(true);
            npc.getKarty().get(5).getObrazek();
            k = npc.getKarty().get(5).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC6.setGraphic(k);
        } else {
            btnKartaNPC6.setVisible(false);
        }
        //--------------karta7

        if (ileKartManpc >= 7) {
            btnKartaNPC7.setVisible(true);
            npc.getKarty().get(6).getObrazek();
            k = npc.getKarty().get(6).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC7.setGraphic(k);
        } else {
            btnKartaNPC7.setVisible(false);
        }
        //--------------karta8

        if (ileKartManpc >= 8) {
            btnKartaNPC8.setVisible(true);
            npc.getKarty().get(7).getObrazek();
            k = npc.getKarty().get(7).getObrazek();
            k.setFitHeight(90);
            k.setFitWidth(90);
//            btnKartaNPC8.setGraphic(k);
        } else {
            btnKartaNPC8.setVisible(false);
        }

        czyAktywnaTo8();
        czyWygrana();

    }

    /**
     * checking who won
     */
    private void czyWygrana() {

        int ileKartMaGracz = gamer.getKarty().size();

        if (ileKartMaGracz == 0) {

            System.out.println("Wygrana gracza");
            btnKartyOczekujace.setVisible(false);
            Platform.runLater(() -> idWygrana.clear());
            Platform.runLater(() -> idWygrana.appendText("Gratulacje, Wygrales"));
            idWygrana.setVisible(true);
        }

        int ileKartManpc = npc.getKarty().size();

        if (ileKartManpc == 0) {

            System.out.println("Wygrana NPC");
            btnKartyOczekujace.setVisible(false);
            Platform.runLater(() -> idWygrana.clear());
            Platform.runLater(() -> idWygrana.appendText("Wygrana NPC"));
            idWygrana.setVisible(true);
        }

    }

    /**
     * checking if an eight has been played
     */
    private void czyAktywnaTo8() {

        Karta akt = aktywna;
        String rangaAktywnej = akt.getRanga();
        String osiem = "eight";
        int jedna = 0;

        if (rangaAktywnej == osiem && czyZagranoKarta == true) {

            btnDzwonki.setVisible(true);
            btnSerce.setVisible(true);
            btnZaladz.setVisible(true);
            btnWino.setVisible(true);

        } else if (rangaAktywnej == osiem && czyZagranoKartanpc == true) {

            Random rand = new Random();
            int a = rand.nextInt(4) + 1;

            if (a == 1 && jedna == 0) {

                btnDzwonki.setVisible(true);
                aktywna.setKolor("diamonds");
                jedna++;

            } else if (a == 2 && jedna == 0) {

                aktywna.setKolor("hearts");
                btnSerce.setVisible(true);
                jedna++;

            } else if (a == 3 && jedna == 0) {

                aktywna.setKolor("clubs");
                btnZaladz.setVisible(true);
                jedna++;

            } else if (a == 4 && jedna == 0) {

                aktywna.setKolor("spades");
                btnWino.setVisible(true);
                jedna++;

            }
        } else {

            btnDzwonki.setVisible(false);
            btnSerce.setVisible(false);
            btnZaladz.setVisible(false);
            btnWino.setVisible(false);

        }
    }

}


