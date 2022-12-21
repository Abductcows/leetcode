import java.util.ArrayList;
import java.util.List;

class Solution91oop {

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
                //           runDFS(i, j);
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