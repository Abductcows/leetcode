import java.util.Arrays;

class Solution12331 {
    public int missingNumber(int[] nums) {
        final int n = nums.length;
        return (n * (n + 1) >> 1) - Arrays.stream(nums).sum();
    }
}