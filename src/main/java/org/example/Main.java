package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilosc przedmiotow: ");
        int n = scanner.nextInt();
        System.out.println("Podaj ziarno:");
        int seed = scanner.nextInt();
        System.out.println("Podaj pojemnosc plecaka:");
        int capacity = scanner.nextInt();

        Problem problem = new Problem(n,seed,1,10);
        System.out.println(problem.toString());
        //problem.Solve(20);
        System.out.println(problem.Solve(capacity).toString());
    }
}