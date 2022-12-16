class SolutionNN {
    public int findMin(int[] nums) {

        final int n = nums.length;
        if (nums[n - 1] >= nums[0]) return nums[0];

        int l = 0, r = n - 1;
        while (nums[l] < nums[l + 1]) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            }
        }

        return nums[l + 1];
    }
}