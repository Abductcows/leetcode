class Solution {

    int m, n;
    IntQueue q = new IntQueue();

    public int[][] rotateGrid(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0, limit = Math.min(m, n) / 2, div = (m + n - 2) << 1; i < limit; ++i, div -= 8, q.reset()) {
            rotate(grid, i, i, k % div);
        }

        return grid;
    }

    public void rotate(int[][] matrix, int row, int col, int k) {
        for (int i = col; i < n - col; ++i) q.add(matrix[row][i]);
        for (int i = row + 1; i < m - row - 1; ++i) q.add(matrix[i][n - col - 1]);
        for (int i = n - col - 1; i >= col; --i) q.add(matrix[m - row - 1][i]);
        for (int i = m - row - 1 - 1; i > row; --i) q.add(matrix[i][col]);
        for (int i = 0; i < k; ++i) q.add(q.poll());
        for (int i = col; i < n - col; ++i) matrix[row][i] = q.poll();
        for (int i = row + 1; i < m - row - 1; ++i) matrix[i][n - col - 1] = q.poll();
        for (int i = n - col - 1; i >= col; --i) matrix[m - row - 1][i] = q.poll();
        for (int i = m - row - 1 - 1; i > row; --i) matrix[i][col] = q.poll();
    }


    static class IntQueue {
        int head = 0, tail = 255;
        int[] data = new int[256];

        void reset() {
            head = 0;
            tail = 255;
        }

        void add(int e) {
            tail = tail + 1 & 255;
            data[tail] = e;
        }

        int poll() {
            int e = data[head];
            head = head + 1 & 255;
            return e;
        }
    }
}