package org.project;

import org.project.race.Race;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race(3, 5, 0.2);

        String bet;
        boolean validBet = false;
        do {
            System.out.println("Welcome to the snail race! Place your bet on the winning snail (Red, Green, Blue):");
            bet = scanner.nextLine();
            if (race.isValidBet(bet)) {
                validBet = true;
                race.setBet(bet);
            } else {
                System.out.println("Invalid bet. Please choose from Red, Green, or Blue.");
            }
        } while (!validBet);

        race.start();
        race.printWinner();
        race.printResult();

        scanner.close();
    }
}