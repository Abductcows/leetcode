class Solutionmmzme {
    public int firstMissingPositive(int[] nums) {
        final int n = nums.length;
        boolean[] exist = new boolean[n + 2];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                exist[num] = true;
            }
        }

        for (int i = 1; i <= n; ++i) {
            if (!exist[i]) return i;
        }

        return n + 1;
    }
}