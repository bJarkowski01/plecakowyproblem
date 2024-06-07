package org.example;
import java.util.*;

public class Problem {
    public int n; //liczba_rodzajow_przedmiotow
    public int seed; //ziarno
    public int lowerBound; //dolna granica losowanych liczb
    public int upperBound; //gorna granica losowanych liczb
    public List<Przedmiot> lista_przedmiotow = new ArrayList<Przedmiot>();
    public int liczba_przedmiotow = 1;

    public Problem(int n, int seed, int lowerBound, int upperBound)
    {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        Random random = new Random(seed);
        for(int i = 0 ; i < n ; i ++)
        {
            int waga = random.nextInt(upperBound - lowerBound) + lowerBound;
            int wartosc = random.nextInt(upperBound - lowerBound) + lowerBound;
            int nr = this.liczba_przedmiotow++;
            lista_przedmiotow.add(new Przedmiot(wartosc, waga, nr));
        }
        //Collections.sort(lista_przedmiotow, new StosunekComparator());

    }
    class StosunekComparator implements Comparator<Przedmiot> {
        @Override
        public int compare(Przedmiot a, Przedmiot b) {
            return Float.compare(b.stosunek, a.stosunek);
        }
    }

    public Result Solve(int capacity)
    {
        Result result = new Result();
        Collections.sort(lista_przedmiotow, new StosunekComparator());
        for(int i = 0 ; i < liczba_przedmiotow - 1 ; i ++)
        {
            while(capacity>=lista_przedmiotow.get(i).waga)
            {
                result.DodajPrzemiot(lista_przedmiotow.get(i).wartosc, lista_przedmiotow.get(i).waga, lista_przedmiotow.get(i).nr);
                capacity -= lista_przedmiotow.get(i).waga;
                result.waga_totalna += lista_przedmiotow.get(i).waga;
                result.wartosc_totalna += lista_przedmiotow.get(i).wartosc;
                result.ilosc_w_przedmiotow_w_plecaku++;
            }
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < liczba_przedmiotow-1; i++)
            result.append("Nr:").append(lista_przedmiotow.get(i).nr).append("\t")
                    .append("Waga:").append(lista_przedmiotow.get(i).waga).append("\t")
                    .append("Wartość:").append(lista_przedmiotow.get(i).wartosc).append("\t")
                    .append("Stosunek:").append(lista_przedmiotow.get(i).stosunek).append("\n");
        return result.toString();
    }


}


