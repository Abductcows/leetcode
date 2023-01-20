package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeapTest {

    MinHeap heap;
    static final int RAND_SEED = 10101;
    static Random rand = new Random(RAND_SEED);

    static List<Integer> randomIntListSizes = new ArrayList<>(List.of(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            15, 16, 17,
            20, 28, 29, 31, 32, 33,
            62, 63, 64,
            127, 128, 129,
            500, 511, 512, 513,
            1000, 1023, 1024, 1025
    ));

    static {
        for (int i = 0; i < 100; ++i) {
            randomIntListSizes.add(100 + rand.nextInt(4096));
        }
    }

    static List<Named<int[]>> getSomeInts() {
        return randomIntListSizes
                .stream()
                .map(len ->
                        Named.of("Size " + len, IntStream.generate(rand::nextInt).limit(len).toArray()))
                .collect(Collectors.toList());
    }

    @BeforeEach
    void setUp() {
        heap = new MinHeap();
        rand = new Random(RAND_SEED);
    }

    @ParameterizedTest
    @MethodSource("getSomeInts")
    void pop(int[] testData) {

        int n = testData.length;
        int[] expected = Arrays.copyOf(testData, n);
        Arrays.sort(expected);

        for (int num : testData) heap.add(num);

        for (int i = 0; i < n; ++i) {
            assertEquals(expected[i], heap.pop());
        }
    }

    @ParameterizedTest
    @MethodSource("getSomeInts")
    void buildHeap(int[] testData) {
        int n = testData.length;
        int[] expected = Arrays.copyOf(testData, n);
        Arrays.sort(expected);

        heap = new MinHeap(testData);
        n = heap.size();

        for (int i = 0; i < n; ++i) {
            assertEquals(expected[i], heap.pop());
        }
    }

}