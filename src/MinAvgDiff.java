class Solution3333333333{
    public int minimumAverageDifference(int[] nums) {

        final int n = nums.length;
        long leftSum = 0;
        long rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int minI = -1;
        long minVal = Long.MAX_VALUE;
        long curVal;
        for (int i = 0; i < n - 1; ++i) {
            leftSum += nums[i];
            rightSum -= nums[i];
            curVal = Math.abs(leftSum / (i + 1) - rightSum / (n - i - 1));
            if (curVal < minVal) {
                minVal = curVal;
                minI = i;
            }
        }
        leftSum += nums[n - 1];
        curVal = leftSum / n;
        if (curVal < minVal) return n - 1;

        return minI;
    }
}