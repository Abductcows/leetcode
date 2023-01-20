package benchmark;

import org.openjdk.jmh.annotations.*;
import utils.MinHeap;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HeapsortVsDualPivotQuicksort {

    @State(Scope.Benchmark)
    public static class Data {
        @Param({"1000", "10000", "25000", "1000000", "300000000", /*"1000000000"*/})
        public long elements;

        public int[] data;

        @Setup
        public void setUp() {
            data = new Random(10092).ints().limit(elements).toArray();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 0)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public int[] testQuicksort(Data d) {
        int[] cp = Arrays.copyOf(d.data, d.data.length);
        Arrays.sort(cp);
        return cp;
    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1, warmups = 0)
    @Warmup(iterations = 0)
    @Measurement(iterations = 1)
    public int[] testHeapsort(Data d) {
        int[] cp = Arrays.copyOf(d.data, d.data.length);
        MinHeap heap = new MinHeap(cp);
        return heap.heapSort();
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
