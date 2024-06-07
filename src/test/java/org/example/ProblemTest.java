package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {
    @Test
    public void notEmpty()
    {
        Problem problem = new Problem(5, 1, 1, 10);
        Result result = problem.Solve(10);
        assertFalse(result.przedmioty_w_plecaku.isEmpty());
    }

    @Test
    public void isEmpty()
    {
        Problem problem = new Problem(5, 1, 1, 10);
        Result result = problem.Solve(0);
        assertTrue(result.przedmioty_w_plecaku.isEmpty());
    }

    @Test
    public void upper_lower_bound() {
        Problem problem = new Problem(5, 1, 1, 10);
        for (int i = 0; i < problem.liczba_przedmiotow - 1; i++) {
            assertTrue(problem.lista_przedmiotow.get(i).waga >= problem.lowerBound && problem.lista_przedmiotow.get(i).waga <= problem.upperBound);
            assertTrue(problem.lista_przedmiotow.get(i).wartosc >= problem.lowerBound && problem.lista_przedmiotow.get(i).wartosc <= problem.upperBound);
        }
    }

    @Test
    public void instance()
    {
        Problem problem = new Problem(5, 2, 1, 10);
        int suma_wag = 13;
        int suma_wartosc = 16;
        int capacity = 13;
        Result result = problem.Solve(capacity);
        assertEquals(suma_wag, result.waga_totalna);
        assertEquals(suma_wartosc, result.wartosc_totalna);

    }

}