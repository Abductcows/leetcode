import java.util.Arrays;

class Solutiondjejje {
    public int[] answerQueries(int[] nums, int[] queries) {

        final int n = nums.length, m = queries.length;
        int[] result = new int[m];

        Arrays.sort(nums);
        for (int i = 1; i < n; ++i) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < m; ++i) {
            result[i] = Math.abs(1 + Arrays.binarySearch(nums, queries[i]));
        }

        return result;
    }
}