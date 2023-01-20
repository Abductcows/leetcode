class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int[] count = new int[101];
        int m = mat.length, n = mat[0].length;

        for (int startRow = 0; startRow < m; ++startRow) {
            for (int offset = 0, limit = Math.min(m - startRow, n); offset < limit; ++offset) {
                ++count[mat[startRow + offset][offset]];
            }
            for (int offset = 0, countP = 1, limit = Math.min(m - startRow, n); offset < limit; ++offset) {
                while (count[countP] == 0) ++countP;
                mat[startRow + offset][offset] = countP;
                --count[countP];
            }
        }

        for (int startCol = 0; startCol < n; ++startCol) {
            for (int offset = 0, limit = Math.min(n - startCol, m); offset < limit; ++offset) {
                ++count[mat[offset][startCol + offset]];
            }
            for (int offset = 0, countP = 1, limit = Math.min(n - startCol, m); offset < limit; ++offset) {
                while (count[countP] == 0) ++countP;
                mat[offset][startCol + offset] = countP;
                --count[countP];
            }
        }

        return mat;
    }
}