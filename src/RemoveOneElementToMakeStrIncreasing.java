class Solutionmanes {
    public boolean canBeIncreasing(int[] nums) {

        int offenderIndex = -1;
        final int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] >= nums[i + 1]) {
                if (offenderIndex < 0) {
                    offenderIndex = i;
                } else {
                    return false;
                }
            }
        }

        return offenderIndex <= 0 ||
                offenderIndex == n - 2 ||
                nums[offenderIndex - 1] < nums[offenderIndex + 1] ||
                nums[offenderIndex] < nums[offenderIndex + 2];
    }
}