package ru.ovchinnikov;

import static java.lang.Math.min;

public class WaterCalculator {

    public static long calculateWaterAmount(final int[] landscape) {
        validate(landscape);
        if (landscape.length == 0) {
            return 0;
        }
        final int[] leftBorderHeight = new int[landscape.length];
        final int[] rightBorderHeight = new int[landscape.length];
        populateBorderHeights(landscape, leftBorderHeight, rightBorderHeight);
        return doCalculateWaterAmount(landscape, leftBorderHeight, rightBorderHeight);
    }

    private static void validate(final int[] landscape) {
        if (landscape.length > 32_000) {
            throw new IllegalArgumentException("Landscape should not contain more than 32000 elements!");
        }
        for (int height : landscape) {
            if (height < 0) {
                throw new IllegalArgumentException("Landscape heights should not be negative!");
            }
            if (height > 32_000) {
                throw new IllegalArgumentException("Landscape heights should not be higher than 32000!");
            }
        }
    }

    private static void populateBorderHeights(final int[] landscape,
                                              final int[] leftBorderHeight,
                                              final int[] rightBorderHeight) {
        int currentLeftHeight = landscape[0];
        int currentRightHeight = landscape[landscape.length - 1];
        for (int i = 0; i < landscape.length; i++) {
            if (currentLeftHeight < landscape[i]) {
                leftBorderHeight[i] = landscape[i];
                currentLeftHeight = landscape[i];
            } else {
                leftBorderHeight[i] = currentLeftHeight;
            }
            final int rightIdx = landscape.length - i - 1;
            if (currentRightHeight < landscape[rightIdx]) {
                rightBorderHeight[rightIdx] = landscape[rightIdx];
                currentRightHeight = landscape[rightIdx];
            } else {
                rightBorderHeight[rightIdx] = currentRightHeight;
            }
        }
    }

    private static long doCalculateWaterAmount(final int[] landscape,
                                               final int[] leftBorderHeight,
                                               final int[] rightBorderHeight) {
        long amount = 0;
        for (int i = 0; i < landscape.length; i++) {
            amount += min(leftBorderHeight[i], rightBorderHeight[i]) - landscape[i];
        }
        return amount;
    }
}
