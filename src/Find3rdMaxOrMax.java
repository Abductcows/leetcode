class Solutionkzke {
    // todo do it without longs
    public int thirdMax(int[] nums) {

        long[] sortedTop3 = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};

        int count = 0;
        for (int num : nums) {
            if (num > sortedTop3[0] && placeMax(sortedTop3, num)) {
                ++count;
            }
        }

        int index = count >= 3 ? 0 : 2;
        return (int) sortedTop3[index];
    }

    boolean placeMax(long[] cur, int val) {

        if (val > cur[2]) {
            cur[0] = cur[1];
            cur[1] = cur[2];
            cur[2] = val;
        } else if (val == cur[2]) {
            return false;
        } else if (val > cur[1]) {
            cur[0] = cur[1];
            cur[1] = val;
        } else if (val == cur[1]) {
            return false;
        } else {
            cur[0] = val;
        }
        return true;
    }
}