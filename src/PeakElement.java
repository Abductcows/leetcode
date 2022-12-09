class Solution555 {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        if (n == 1 || nums[0] > nums[1]) return nums[0];
        if (nums[n-1] > nums[n-2]) return nums[n-1];

        int l = 0, r = n - 1;

        while (true) {

            if (l > n) throw new IllegalStateException("idk man");

            return 1;
        }
    }
}