import java.util.ArrayList;
import java.util.List;

class Solution91oop {

    final int PACIFIC = Integer.MIN_VALUE;
    final int ATLANTIC = Integer.MIN_VALUE >> 1;
    final int BOTH = PACIFIC | ATLANTIC;

    int m, n;
    byte[][] canFlow;
    int[][] heights;

    final int[] dR = {-1, 1, 0, 0};
    final int[] dC = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        final int m = heights.length;
        final int n = heights[0].length;
        this.m = m;
        this.n = n;
        this.heights = heights;

        return List.of();
    }
}