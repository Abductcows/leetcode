import java.util.Arrays;

class SolutionDelta {

    final int right = 1;
    final int left = -1;
    int[][] slopes;
    int m, n;

    public int[] findBall(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        slopes = grid;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rabbitHole(i);
        }
        return result;
    }


    int rabbitHole(int startC) {
        int row = 0;
        int col = startC;

        while (true) {

            if (slopes[row][col] == right) {
                if (col == n - 1 || slopes[row][col + 1] == left) return -1;
                ++col;
            } else {
                if (col == 0 || slopes[row][col - 1] == right) return -1;
                --col;
            }
            if (row++ == m - 1) return col;
        }
    }

    public static void main(String[] args) {
        var input = new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}};
        System.out.println(Arrays.toString(new SolutionDelta().findBall(input)));
    }
}