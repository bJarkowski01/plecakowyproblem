package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public int waga_totalna;
    public int wartosc_totalna;
    public List<Przedmiot> przedmioty_w_plecaku = new ArrayList<Przedmiot>();
    public int ilosc_w_przedmiotow_w_plecaku = 0;

    public void DodajPrzemiot(int wartosc, int waga, int nr)
    {
        przedmioty_w_plecaku.add(new Przedmiot(wartosc, waga, nr));
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Waga całkowita:").append(waga_totalna).append("\n");
        result.append("Wartosc całkowita:").append(wartosc_totalna).append("\n");
        for (int i = 0; i < ilosc_w_przedmiotow_w_plecaku; i++)
            result.append("Nr:").append(przedmioty_w_plecaku.get(i).nr).append("\t")
                    .append("Waga:").append(przedmioty_w_plecaku.get(i).waga).append("\t")
                    .append("Wartość:").append(przedmioty_w_plecaku.get(i).wartosc).append("\t")
                    .append("Stosunek:").append(przedmioty_w_plecaku.get(i).stosunek).append("\n");
        return result.toString();
    }
}
