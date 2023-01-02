class Solutionlell {
    public int removeElement(int[] nums, int val) {
        int occurences = 0;
        final int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == val) {
                ++occurences;
            } else {
                nums[i - occurences] = nums[i];
            }
        }
        return n - occurences;
    }
}