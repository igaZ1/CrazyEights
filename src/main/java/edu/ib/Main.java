package edu.ib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class to start the program
 * card picture implementation - clubs, diamonds, spades, hearts
 */

public class Main extends Application {
    public static Image tylKarty = new Image("fxml/cards/cardback.png");
    public static ImageView widokTylKarty = new ImageView(tylKarty);
    /**
     * Clubs cards view
     */
    public static Image asTrefl = new Image("fxml/cards/aceofclubs.png");
    public static ImageView widokAsTrefl = new ImageView(asTrefl);
    public static Image krolTrefl = new Image("fxml/cards/kingofclubs.png");
    public static ImageView widokKrolaTrefl = new ImageView(krolTrefl);
    public static Image damaTrefl = new Image("fxml/cards/queenofclubs.png");
    public static ImageView widokDamyTrefl = new ImageView(damaTrefl);
    public static Image waletTrefl = new Image("fxml/cards/jackofclubs.png");
    public static ImageView widokWaletTrefl = new ImageView(waletTrefl);
    public static Image Trefl10 = new Image("fxml/cards/tenofclubs.png");
    public static ImageView widokTrefl10 = new ImageView(Trefl10);
    public static Image Trefl9 = new Image("fxml/cards/nineofclubs.png");
    public static ImageView widokTrefl9 = new ImageView(Trefl9);
    public static Image Trefl8 = new Image("fxml/cards/eightofclubs.png");
    public static ImageView widokTrefl8 = new ImageView(Trefl8);
    public static Image Trefl7 = new Image("fxml/cards/sevenofclubs.png");
    public static ImageView widokTrefl7 = new ImageView(Trefl7);
    public static Image Trefl6 = new Image("fxml/cards/sixofclubs.png");
    public static ImageView widokTrefl6 = new ImageView(Trefl6);
    public static Image Trefl5 = new Image("fxml/cards/fiveofclubs.png");
    public static ImageView widokTrefl5 = new ImageView(Trefl5);
    public static Image Trefl4 = new Image("fxml/cards/fourofclubs.png");
    public static ImageView widokTrefl4 = new ImageView(Trefl4);
    public static Image Trefl3 = new Image("fxml/cards/threeofclubs.png");
    public static ImageView widokTrefl3 = new ImageView(Trefl3);
    public static Image Trefl2 = new Image("fxml/cards/twoofclubs.png");
    public static ImageView widokTrefl2 = new ImageView(Trefl2);


    /**
     * Spades cards view
     */

    public static Image asPik = new Image("fxml/cards/aceofspades.png");
    public static ImageView widokAsPik = new ImageView(asPik);
    public static Image krolPik = new Image("fxml/cards/kingofspades.png");
    public static ImageView widokKrolaPik = new ImageView(krolPik);
    public static Image damaPik = new Image("fxml/cards/queenofspades.png");
    public static ImageView widokDamyPik = new ImageView(damaPik);
    public static Image waletPik = new Image("fxml/cards/jackofspades.png");
    public static ImageView widokWaletPik = new ImageView(waletPik);
    public static Image Pik10 = new Image("fxml/cards/tenofspades.png");
    public static ImageView widokPik0 = new ImageView(Pik10);
    public static Image Pik9 = new Image("fxml/cards/nineofspades.png");
    public static ImageView widokPik9 = new ImageView(Pik9);
    public static Image Pik8 = new Image("fxml/cards/eightofspades.png");
    public static ImageView widokPik8 = new ImageView(Pik8);
    public static Image Pik7 = new Image("fxml/cards/sevenofspades.png");
    public static ImageView widokPik7 = new ImageView(Pik7);
    public static Image Pik6 = new Image("fxml/cards/sixofspades.png");
    public static ImageView widokPik6 = new ImageView(Pik6);
    public static Image Pik5 = new Image("fxml/cards/fiveofspades.png");
    public static ImageView widokPik5 = new ImageView(Pik5);
    public static Image Pik4 = new Image("fxml/cards/fourofspades.png");
    public static ImageView widokPik4 = new ImageView(Pik4);
    public static Image Pik3 = new Image("fxml/cards/threeofspades.png");
    public static ImageView widokPik3 = new ImageView(Pik3);
    public static Image Pik2 = new Image("fxml/cards/twoofspades.png");
    public static ImageView widokPik2 = new ImageView(Pik2);

    /**
     * Hearts cards view
     */

    public static Image asKier = new Image("fxml/cards/aceofhearts.png");
    public static ImageView widokAsKier = new ImageView(asKier);
    public static Image krolKier = new Image("fxml/cards/kingofhearts.png");
    public static ImageView widokKrolaKier = new ImageView(krolKier);
    public static Image damaKier = new Image("fxml/cards/queenofhearts.png");
    public static ImageView widokDamyKier = new ImageView(damaKier);
    public static Image waletKier = new Image("fxml/cards/jackofhearts.png");
    public static ImageView widokWaletKier = new ImageView(waletKier);
    public static Image Kier10 = new Image("fxml/cards/tenofhearts.png");
    public static ImageView widokKier0 = new ImageView(Kier10);
    public static Image Kier9 = new Image("fxml/cards/nineofhearts.png");
    public static ImageView widokKier9 = new ImageView(Kier9);
    public static Image Kier8 = new Image("fxml/cards/eightofhearts.png");
    public static ImageView widokKier8 = new ImageView(Kier8);
    public static Image Kier7 = new Image("fxml/cards/sevenofhearts.png");
    public static ImageView widokKier7 = new ImageView(Kier7);
    public static Image Kier6 = new Image("fxml/cards/sixofhearts.png");
    public static ImageView widokKier6 = new ImageView(Kier6);
    public static Image Kier5 = new Image("fxml/cards/fiveofhearts.png");
    public static ImageView widokKier5 = new ImageView(Kier5);
    public static Image Kier4 = new Image("fxml/cards/fourofhearts.png");
    public static ImageView widokKier4 = new ImageView(Kier4);
    public static Image Kier3 = new Image("fxml/cards/threeofhearts.png");
    public static ImageView widokKier3 = new ImageView(Kier3);
    public static Image Kier2 = new Image("fxml/cards/twoofhearts.png");
    public static ImageView widokKier2 = new ImageView(Kier2);

    /**
     * Diamonds cards view
     */

    public static Image asKaro = new Image("fxml/cards/aceofdiamonds.png");
    public static ImageView widokAsKaro = new ImageView(asKaro);
    public static Image krolKaro = new Image("fxml/cards/kingofdiamonds.png");
    public static ImageView widokKrolaKaro = new ImageView(krolKaro);
    public static Image damaKaro = new Image("fxml/cards/queenofdiamonds.png");
    public static ImageView widokDamyKaro = new ImageView(damaKaro);
    public static Image waletKaro = new Image("fxml/cards/jackofdiamonds.png");
    public static ImageView widokWaletKaro = new ImageView(waletKaro);
    public static Image Karo10 = new Image("fxml/cards/tenofdiamonds.png");
    public static ImageView widokKaro0 = new ImageView(Karo10);
    public static Image Karo9 = new Image("fxml/cards/nineofdiamonds.png");
    public static ImageView widokKaro9 = new ImageView(Karo9);
    public static Image Karo8 = new Image("fxml/cards/eightofdiamonds.png");
    public static ImageView widokKaro8 = new ImageView(Karo8);
    public static Image Karo7 = new Image("fxml/cards/sevenofdiamonds.png");
    public static ImageView widokKaro7 = new ImageView(Karo7);
    public static Image Karo6 = new Image("fxml/cards/sixofdiamonds.png");
    public static ImageView widokKaro6 = new ImageView(Karo6);
    public static Image Karo5 = new Image("fxml/cards/fiveofdiamonds.png");
    public static ImageView widokKaro5 = new ImageView(Karo5);
    public static Image Karo4 = new Image("fxml/cards/fourofdiamonds.png");
    public static ImageView widokKaro4 = new ImageView(Karo4);
    public static Image Karo3 = new Image("fxml/cards/threeofdiamonds.png");
    public static ImageView widokKaro3 = new ImageView(Karo3);
    public static Image Karo2 = new Image("fxml/cards/twoofdiamonds.png");
    public static ImageView widokKaro2 = new ImageView(Karo2);

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * calling starting the program
     */

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartGame.fxml"));
        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }


}
