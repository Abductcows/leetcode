class SolutionMemLeak {

    int time = 1, mem1, mem2;

    public int[] memLeak(int _memory1, int _memory2) {

        this.mem1 = _memory1;
        this.mem2 = _memory2;

        // first subtract from the maximum until max - min < time
        subFromMaxUntilDiffLessThanTime();
        if (time > mem1 && time > mem2) return new int[]{time, mem1, mem2};

        // then subtract from each one taking turns each round
        int nextTime;
        int maxSub, minSub; // will be subtracted from max/min memory respectively

        nextTime = maxEvenOrOddICanSubtract(time, Math.max(mem1, mem2));
        maxSub = sumEveryOtherNumber(time, time % 2 == 0 ? countEvens(time, nextTime) : countOdds(time, nextTime));

        int possibleEndTime = nextTime;

        nextTime = maxEvenOrOddICanSubtract(time + 1, Math.min(mem1, mem2));
        minSub = sumEveryOtherNumber(time + 1, time % 2 == 0 ? countOdds(time + 1, nextTime) : countEvens(time + 1, nextTime));

        time = 1 + Math.max(possibleEndTime, nextTime);

        // done
        if (mem1 >= mem2) {
            mem1 -= maxSub;
            mem2 -= minSub;
        } else {
            mem2 -= maxSub;
            mem1 -= minSub;
        }

        return new int[]{time, mem1, mem2};
    }

    private void subFromMaxUntilDiffLessThanTime() {
        int diff = Math.abs(mem1 - mem2);
        if (time <= diff) {
            time = findNFast(diff) + 1;
            if (mem1 >= mem2) {
                mem1 -= (long) time * (time - 1) / 2;
            } else {
                mem2 -= (long) time * (time - 1) / 2;
            }
        }
    }

    /**
     * Finds the maximum integer n such that 1 + 2 + 3 + ... + n <= k
     */
    static int findNFast(int k) {
        return (int) (Math.sqrt(0.25 + 2L * k) - 0.5);
    }


    /**
     * Returns the max integer n such that: a + (a + 2) + (a + 4) + ... + n <= k
     * n always has the same parity as a
     */
    static int maxEvenOrOddICanSubtract(int a, int k) {
        int res = (int) ((Math.sqrt((long) a * (a - 2) + 4L * k + 1)) - 1);
        return (res - a % 2) / 2 * 2 + a % 2;
    }

    /**
     * Sums the first count terms of low, low + 2, low + 4...
     */
    static int sumEveryOtherNumber(int low, int count) {
        return count * (count + low - 1);
    }

    /**
     * Counts the number of odd integers in the range [low, high]
     * (Solution to 1523. Count Odd Numbers in an Interval Range)
     */
    static int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }

    /**
     * Counts the number of even integers in the range [low, high]
     */
    static int countEvens(int low, int high) {
        return countOdds(low + 1, high + 1);
    }
}