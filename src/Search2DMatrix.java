import java.util.Arrays;

class Solutionnnn {
    public boolean searchMatrix(int[][] matrix, int target) {


        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0, r = m - 1;

        // find matrix row
        while (l < r - 1) {

            int mid = (l + r) / 2;
            if (matrix[mid][n - 1] == target) return true;
            if (matrix[mid][n - 1] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        boolean lookR = r > l, inR = false;
        if (lookR) {
            inR = Arrays.binarySearch(matrix[r], target) >= 0;
        }
        return Arrays.binarySearch(matrix[l], target) >= 0 || inR;
    }

    public static void main(String[] args) {
        var input = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(new Solutionnnn().searchMatrix(input, 13));
    }
}