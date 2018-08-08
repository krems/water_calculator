package ru.ovchinnikov;


import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.ovchinnikov.WaterCalculator.calculateWaterAmount;


class WaterCalculatorTest {
    @Test
    void should_calculate_water_amount__when_landscape_is_valid_updating_both_borders() {
        final int[] landscape = {6, 2, 3, 4, 8, 4, 0, 3, 1};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(12, waterAmount);
    }

    @Test
    void should_calculate_water_amount__when_landscape_is_valid_updating_right_border() {
        final int[] landscape = {5, 2, 3, 4, 5, 4, 0, 3, 1};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(9, waterAmount);
    }

    @Test
    void should_calculate_water_amount__when_landscape_is_valid_updating_left_border() {
        final int[] landscape = {1, 3, 0, 4, 5, 4, 3, 2, 5};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(9, waterAmount);
    }

    @Test
    void should_return_zero__when_landscape_is_of_length_one() {
        final int[] landscape = {5};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void should_return_zero__when_landscape_is_of_length_zero() {
        final int[] landscape = {};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void should_throw_illegal_argument_exception__when_landscape_contains_negative_height() {
        final int[] landscape = {3, -2, 0};

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    void should_throw_illegal_argument_exception__when_landscape_contains_height_bigger_than_32000() {
        final int[] landscape = {3, 2, 32001, 700};

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    void should_throw_illegal_argument_exception__when_landscape_contains_more_than_32000_elements() {
        final int[] landscape = new int[32001];

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    void should_return_zero__when_landscape_is_of_zeros() {
        final int[] landscape = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void should_return_zero__when_landscape_is_of_max_length_but_flat() {
        final int[] landscape = generate(() -> 32_000).limit(32_000).toArray();

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void should_return_zero__when_landscape_is_a_pyramid() {
        final int[] landscape = {0, 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }
}
