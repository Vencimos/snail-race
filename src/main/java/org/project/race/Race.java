package org.project.race;

import org.project.entity.Snail;

import java.util.Random;

public class Race {
    private Snail[] snails;
    private int numRounds;
    private double acceleratorChance;
    private String bet;
    private String winner;

    public Race(int numSnails, int numRounds, double acceleratorChance) {
        this.numRounds = numRounds;
        this.acceleratorChance = acceleratorChance;
        this.snails = new Snail[numSnails];
        this.snails[0] = new Snail("Red");
        this.snails[1] = new Snail("Green");
        this.snails[2] = new Snail("Blue");
        this.bet = "";
        this.winner = "";
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public boolean isValidBet(String bet) {
        return bet.equalsIgnoreCase("Red") || bet.equalsIgnoreCase("Green") || bet.equalsIgnoreCase("Blue");
    }

    public void start() {
        for (int round = 1; round <= numRounds; round++) {
            System.out.println("Round " + round + ":");
            Snail acceleratorSnail = null;
            if (Math.random() < acceleratorChance) {
                acceleratorSnail = snails[new Random().nextInt(snails.length)];
                System.out.println(acceleratorSnail.getColor() + " snail received an accelerator!");
            }
            for (Snail snail : snails) {
                int distance = snail.move(snail.equals(acceleratorSnail));
                System.out.println(snail.getColor() + " snail moved " + distance + " units.");
            }
            System.out.println();
        }
    }

    public void printWinner() {
        Snail winnerSnail = snails[0];
        for (Snail snail : snails) {
            if (snail.getDistance() > winnerSnail.getDistance()) {
                winnerSnail = snail;
            }
        }
        winner = winnerSnail.getColor();
        System.out.println("The winner is the " + winner + " snail!");
    }

    public void printResult() {
        if (winner.equalsIgnoreCase(bet)) {
            System.out.println("Congratulations! You won the bet!");
        } else {
            System.out.println("Sorry, you lost the bet. Better luck next time!");
        }
    }
}
