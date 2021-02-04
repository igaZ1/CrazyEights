package edu.ib;

import java.util.ArrayList;


public class Stol  {

    private ArrayList<Karta> oczekujace;
    private ArrayList<Karta> wylozone;
    /**
     * deck on the table
     * cards laid out on the table
     */
    private Karta aktywna;

    public Stol() {
        this.oczekujace = oczekujace;
        this.wylozone = wylozone;
        this.aktywna = aktywna;
    }

    public ArrayList<Karta> getOczekujace() {
        return oczekujace;
    }

    public void setOczekujace(ArrayList<Karta> oczekujace) {

        this.oczekujace = oczekujace;
    }

    public ArrayList<Karta> getWylozone() {
        return wylozone;
    }

    public void setWylozone(ArrayList<Karta> wylozone) {
        this.wylozone = wylozone;
    }

    public void dodaj(Karta karta){
        wylozone.add(karta);
    }

    public Karta getAktywna() {
        return aktywna;
    }

    public void setAktywna(Karta aktywna) {
        this.aktywna = aktywna;
    }

}
