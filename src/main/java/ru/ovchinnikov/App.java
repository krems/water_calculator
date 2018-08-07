package ru.ovchinnikov;

import static ru.ovchinnikov.WaterCalculator.calculateWaterAmount;

public class App {

    public static void main(final String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("You should supply landscape as a program argument");
        }
        final int[] landscape = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            landscape[i] = Integer.parseInt(args[i]);
        }
        final long waterAmount = calculateWaterAmount(landscape);
        System.out.println(waterAmount);
    }
}
