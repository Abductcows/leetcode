import java.util.Arrays;

class SolutionOhSoClose {

    // stupid, try dp like eratosthenes sieve; continue on True and on False, set all + k^2 <= n to True
    static boolean[] winner = new boolean[(int) 1e5 + 1];

    static {

        int[] squares = getSquares(100_000);

        System.out.println("Squares: " + Arrays.toString(squares));
        for (int i = 1; i < 100_000 + 1; ++i) {

            boolean canWin = false;
            for (int j = squares.length - 1; j >= 0; --j) {

                if (squares[j] == i) {
                    canWin = true;
                    break;
                }

                if (i - squares[j] > 0) {
                    canWin |= !winner[i - squares[j]];
                }
            }
            winner[i] = canWin;
        }
    }

    public boolean winnerSquareGame(int n) {

        return winner[n];
    }


    static int[] getSquares(int n) {

        if (n <= 3) return new int[]{1};
        final int max = (int) Math.floor(Math.sqrt(n));
        int[] result = new int[max];
        int previous = 1;
        result[1] = 1;
        for (int i = 1; i < max; ++i) {
            result[i] = result[i - 1] + (previous << 1) + 1;
            ++previous;
        }
        return result;
    }
}