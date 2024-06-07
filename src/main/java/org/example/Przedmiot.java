package org.example;

public class Przedmiot {
    public int wartosc;
    public int waga;
    public int nr;
    public float stosunek;

    public Przedmiot(int wartosc, int waga, int nr) {
        this.wartosc = wartosc;
        this.waga = waga;
        this.nr = nr;
        this.stosunek = (float) wartosc / waga;
    }
}
