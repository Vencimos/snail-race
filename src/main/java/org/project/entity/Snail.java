package org.project.entity;

import java.util.Random;

public class Snail {
    private String color;
    private int distance;

    public Snail(String color) {
        this.color = color;
        this.distance = 0;
    }

    public int move(boolean hasAccelerator) {
        int distanceMoved = new Random().nextInt(4);
        if (hasAccelerator) {
            distanceMoved *= 2;
        }
        this.distance += distanceMoved;
        return distanceMoved;
    }

    public String getColor() {
        return color;
    }

    public int getDistance() {
        return distance;
    }
}
