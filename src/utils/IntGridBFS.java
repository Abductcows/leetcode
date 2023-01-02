package utils;


import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class IntGridBFS {

    public interface GridComparator {
        boolean canMove(int[][] grid, int curRow, int curCol, int nextRow, int nextCol);
    }

    public interface GoalSpecifier {
        boolean isGoal(int[][] grid, int row, int col);
    }

    /**
     * y, x vectors
     * y === row
     * x === col
     */
    public final int[][] DIRECTIONS_UP_DOWN_LEFT_RIGHT = {{1, -1, 0, 0}, {0, 0, -1, 1}};
    public final int[][] DIRECTIONS_U_D_L_R_AND_DIAGONAL = {{1, -1, 0, 0, 1, 1, -1, -1}, {0, 0, -1, 1, -1, 1, -1, 1}};

    List<Long> gridBFS(int[][] grid, int startRow, int startCol,
                       GoalSpecifier goal,
                       int[][] movementVectors,
                       GridComparator canMove) {

        final int m = grid.length;
        final int n = grid[0].length;

        boolean reachedEnd = false;
        int moveCount = 0, layerNodesLeft = 1, nodesInNextLayer = 0;
        long[][] previous = Stream.generate(() -> new long[n]).limit(m).toArray(long[][]::new);

        Queue<Long> queue = new ArrayDeque<>();
        queue.add(yx2L(startRow, startCol));
        // todo
        return List.of();
    }

    long yx2L(int y, int x) {
        return (long) y << 32 | x;
    }

    int l2Y(long val) {
        return (int) (val >> 32);
    }

    int l2X(long val) {
        return (int) val;
    }
}