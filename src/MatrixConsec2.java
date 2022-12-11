import java.util.Arrays;

class Solution1101001 {


    int maxLength = 1;
    int[][] nums, lengths;


    public int longestIncreasingPath(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        nums = matrix;
        lengths = new int[rows][];
        for (int i = 0; i < rows; ++i) {
            lengths[i] = new int[cols];
            Arrays.fill(lengths[i], 1);
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < rows; ++j) {
                run(i, j);
            }
        }

        return maxLength;
    }

    void run(int i, int j) {
        if (i > 0 && nums[i][j] < nums[i-1][j]) {

        }
    }
}