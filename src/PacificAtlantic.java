import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    static class MyCoord {

        int i, j;

        static MyCoord of(int i, int j) {
            return indices[i][j];
        }

        private MyCoord(int i, int j) {
            this.i = i;
            this.j = j;
        }

        static MyCoord[][] indices = new MyCoord[200][];

        static {
            for (int i = 0; i < 200; ++i) {
                indices[i] = new MyCoord[200];
                for (int j = 0; j < 200; ++j) {
                    indices[i][j] = new MyCoord(i, j);
                }
            }
        }
    }

    final int PACIFIC = 1;
    final int ATLANTIC = 2;
    final int BOTH = 3;

    int m, n;
    byte[][] canFlow;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        final int m = heights.length;
        final int n = heights[0].length;
        this.m = m;
        this.n = n;
        this.heights = heights;
        canFlow = new byte[m][];
        populateInitialFlows(m, n);

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                runDFS(i, j);
            }
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (canFlow[i][j] == BOTH) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    void runDFS(int row, int col) {

        if (canFlow[row][col] == BOTH) return;
        Stack<MyCoord> stack = new Stack<>();

        while (canFlow[row][col] != BOTH && !stack.isEmpty()) {
            MyCoord currCoords = stack.pop();
            final int i = currCoords.i, j = currCoords.j;
            final int thisH = heights[i][j];
            if (i < m - 1) {
                if (heights[i][j] >= heights[i + 1][j]) {
                    stack.push(MyCoord.of(i + 1, j));
                } else if (heights[i][j] <= heights[i + 1][j]) {
                    canFlow[i + 1][j] |= canFlow[i][j];
                }
            }
            if (i > 0) {
                if (heights[i][j] >= heights[i - 1][j]) {
                    stack.addLast(MyCoord.of(i - 1, j));
                } else if (heights[i][j] <= heights[i - 1][j]) {
                    canFlow[i - 1][j] |= canFlow[i][j];
                }
            }
            if (j < n - 1) {
                if (heights[i][j] >= heights[i][j + 1]) {
                    stack.addLast(MyCoord.of(i, j + 1));
                } else if (heights[i][j] <= heights[i][j + 1]) {
                    canFlow[i][j + 1] |= canFlow[i][j];
                }
            }
            if (j > 0) {
                if (heights[i][j] >= heights[i][j - 1]) {
                    stack.push(MyCoord.of(i, j - 1));
                } else if (heights[i][j] <= heights)
            }

        }
    }


    private void populateInitialFlows(int m, int n) {
        for (int i = 0; i < m; ++i) {
            canFlow[i] = new byte[n];
        }
        for (int col = 0; col < n; ++col) {
            canFlow[0][col] |= PACIFIC;
            canFlow[m - 1][col] |= ATLANTIC;
        }
        for (int row = 0; row < m; ++row) {
            canFlow[row][0] |= PACIFIC;
            canFlow[row][n - 1] |= ATLANTIC;
        }
    }
}