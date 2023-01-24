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
        @Param({"64", "10000", "50000", "1000000", "20000000"/*"300000000", "1000000000"*/})
        public long elements;

        public int[] data;

        @Setup
        public void setUp() {
            data = new Random(elements).ints().limit(elements).toArray();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 4, warmups = 1)
    @Warmup(iterations = 2)
    @Measurement(iterations = 15)
    @Timeout(time = 1, timeUnit = TimeUnit.HOURS)
    public int[] testQuicksort(Data d) {
        int[] cp = Arrays.copyOf(d.data, d.data.length);
        Arrays.sort(cp);
        return cp;
    }


    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 4, warmups = 0)
    @Warmup(iterations = 2)
    @Measurement(iterations = 15)
    @Timeout(time = 1, timeUnit = TimeUnit.HOURS)
    public int[] testHeapsort(Data d) {
        int[] cp = Arrays.copyOf(d.data, d.data.length);
        MinHeap heap = new MinHeap(cp);
        return heap.heapSort();
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
