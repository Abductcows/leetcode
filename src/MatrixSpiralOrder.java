import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solutioan111 {
    public List<Integer> spiralOrder(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        var result = new ArrayList<Integer>(rows * cols);

        long count = 0, climit = (long) rows * cols;
        int hlimit = cols, vlimit = rows;
        while (true) {

            for (int j = cols - hlimit; j < hlimit - 1; j++) {
                result.add(matrix[rows - vlimit][j]);
                if (++count == climit) break;
            }
            for (int i = rows - vlimit; i < vlimit - 1; i++) {
                result.add(matrix[i][hlimit - 1]);
                if (++count == climit) break;
            }
            for (int j = hlimit - 1; j > cols - hlimit; j--) {
                result.add(matrix[vlimit - 1][j]);
                if (++count == climit) break;
            }
            for (int i = vlimit - 1; i > rows - vlimit; i--) {
                result.add(matrix[i][cols - hlimit]);
                if (++count == climit) break;
            }

            if (count == climit) break;
            if (rows == cols && rows % 2 == 1 && count == climit - 1) break;
            --vlimit;
            --hlimit;
        }

        if (rows == cols && rows % 2 == 1) {
            result.add(matrix[rows / 2][cols / 2]);
        }

        return result;
    }

    static void run(int[][] input) {
        long expectedSize = (long) input.length * input[0].length;
        System.out.println(Arrays.deepToString(input));
        List<Integer> result = new Solutioan111().spiralOrder(input);
        System.out.println(result);
        if (result.size() != expectedSize) System.out.println("Wrong size");
        System.out.println();
    }

    public static void main(String[] args) {
     //    Solution.run(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Solutioan111.run(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}});
    }
}