import java.util.Arrays;

class Solution {

    public static int[] memLeak(int memory1, int memory2) {

        int time = 1;
        int diff = Math.abs(memory1 - memory2);

        if (time <= diff) {
            time = findNFast(1, diff);
            if (memory1 >= memory2) {
                memory1 -= (long) time * (time + 1) / 2;
            } else {
                memory2 -= (long) time * (time + 1) / 2;
            }
            ++time;
        }

        while (memory1 >= time && memory2 >= time) {
            if (memory1 >= memory2) {
                memory1 -= time;
            } else {
                memory2 -= time;
            }
            ++time;
        }

        while (memory1 >= time) {
            memory1 -= time++;
        }

        while (memory2 >= time) {
            memory2 -= time++;
        }

        return new int[]{time, memory1, memory2};
    }

    public static int[] memLeakNew(int memory1, int memory2) {

        int time = 1;
        int diff = Math.abs(memory1 - memory2);

        if (time <= diff) {
            time = findNFast(1, diff);
            if (memory1 >= memory2) {
                memory1 -= (long) time * (time + 1) / 2;
            } else {
                memory2 -= (long) time * (time + 1) / 2;
            }
            ++time;
        }

        if (time % 2 == 1) {
            if (memory1 >= memory2) {
                memory1 -= time++;
            } else {
                memory2 -= time++;
            }
        }


        int steps;
        if (memory1 >= memory2) {
            steps = findNEvens(time, memory1) + 1;
            int sub = steps * (steps + 1 + time);
            memory2 -= sub;
            memory1 -= sub + time;
        } else {
            steps = findNEvens(time, memory2) + 1;
            int sub = steps * (steps + 1 + time);
            memory1 -= sub;
            memory2 -= sub + time;
        }

        return new int[]{time + steps + 1, memory1, memory2};
    }

    static int findNFast(int start, int k) {
        if (start > k) throw new IllegalArgumentException();
        return (int) (Math.sqrt(0.25 - start + (start * start) + 2.0 * k) - 0.5);
    }

    static int findNEvens(int s, int k) {
        if (s > k || s % 2 == 1) throw new IllegalArgumentException();
        return (int) (
                Math.sqrt(k + ((s - 1) * (s - 1)) / 4.0)
                        - s / 2.0 - 0.5
        );
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(memLeak(8, 11)));
        System.out.println(Arrays.toString(memLeakNew(8, 11)));
    }
}
