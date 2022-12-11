import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

class Solution91991 {

    final int up = 0b1;
    final int down = 0b10;
    final int left = 0b100;
    final int right = 0b1000;
    int[][] matrix, traversed, lengths;
    int rows, cols;

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        this.matrix = matrix;
        lengths = new int[rows][];
        for (int i = 0; i < rows; i++) {
            lengths[i] = new int[cols];
            Arrays.fill(lengths[i], 1);
        }
        initTraversed();

        int maxLength = 1;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; ++x) {
                if (traversed[y][x] != 0) {
                    maxLength = Math.max(maxLength, run(x, y));
                }
            }
        }
        return maxLength;
    }

    private void initTraversed() {

        traversed = new int[rows][];
        traversed[0] = new int[cols];
        Arrays.fill(traversed[0], down | left | right);
        traversed[rows - 1] = new int[cols];
        Arrays.fill(traversed[rows - 1], up | left | right);
        for (int i = 1; i < rows - 1; i++) {
            traversed[i] = new int[cols];
            Arrays.fill(traversed[i], 0b1111);
        }
        for (int i = 0; i < rows; i++) {
            traversed[i][cols - 1] &= ~right;
            traversed[i][0] &= ~left;
        }

        if (rows == 1) {
            for (int i = 0; i < cols; i++) {
                traversed[0][i] &= ~(up | down);
            }
        }
    }

    private int run(int startX, int startY) {
        ArrayDeque<Coords> currPath = new ArrayDeque<>(List.of(Coords.of(startX, startY)));
        int maxLength = 1;

        while (!currPath.isEmpty()) {
            Coords here = currPath.peekLast();
            int x = here.x;
            int y = here.y;

            updateDp(x, y);
            if ((traversed[y][x] & up) != 0 && y > 0) {
                if (matrix[y][x] < matrix[y - 1][x]) {
                    currPath.push(Coords.of(x, y - 1));
                }
                traversed[y][x] &= ~up;
            } else if ((traversed[y][x] & down) != 0 && y < rows - 1) {
                if (matrix[y][x] < matrix[y + 1][x]) {
                    currPath.push(Coords.of(x, y + 1));
                }
                traversed[y][x] &= ~down;
            } else if ((traversed[y][x] & left) != 0 && x > 0) {
                if (matrix[y][x] < matrix[y][x - 1]) {
                    currPath.push(Coords.of(x - 1, y));
                }
                traversed[y][x] &= ~left;
            } else if ((traversed[y][x] & right) != 0 && x < cols - 1) {
                if (matrix[y][x] < matrix[y][x + 1]) {
                    currPath.push(Coords.of(x + 1, y));
                }
                traversed[y][x] &= ~right;
            } else {
                currPath.pop();
            }

            maxLength = Math.max(maxLength, Math.max(lengths[y][x], currPath.size()));
        }

        return maxLength;
    }

    private void updateDp(int x, int y) {
        if (y > 0 && (traversed[y][x] & up) == 0 && matrix[y][x] < matrix[y - 1][x]) {
            lengths[y][x] = Math.max(lengths[y][x], 1 + lengths[y - 1][x]);
        }
        if (y < rows - 1 && (traversed[y][x] & down) == 0 && matrix[y][x] < matrix[y + 1][x]) {
            lengths[y][x] = Math.max(lengths[y][x], 1 + lengths[y + 1][x]);
        }
        if (x > 0 && (traversed[y][x] & left) == 0 && matrix[y][x] < matrix[y][x - 1]) {
            lengths[y][x] = Math.max(lengths[y][x], 1 + lengths[y][x - 1]);
        }
        if (x < cols - 1 && (traversed[y][x] & right) == 0 && matrix[y][x] < matrix[y][x + 1]) {
            lengths[y][x] = Math.max(lengths[y][x], 1 + lengths[y][x + 1]);
        }
    }

    public static void main(String[] args) {
        int[][] input;

        input = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1,}};
        System.out.println(new Solution91991().longestIncreasingPath(input));
        System.out.println("Should be 4");

        input = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(new Solution91991().longestIncreasingPath(input));
        System.out.println("Should be 4");

//        input = new int[][]{{1}};
//        System.out.println(new Solution().longestIncreasingPath(input));
//        System.out.println("Should be 1");
    }

    static class Coords {

        static Coords of(int x, int y) {
            return new Coords(x, y);
        }

        final int x, y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}