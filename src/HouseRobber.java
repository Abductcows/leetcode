class SolutionDPhehe {
    public int rob(int[] nums) {
        final int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] vals = new int[n];
        vals[0] = nums[0];
        vals[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; ++i) {
            vals[i] = Math.max(nums[i] + vals[i - 2], vals[i - 1]);
        }

        return vals[n - 1];
    }
}