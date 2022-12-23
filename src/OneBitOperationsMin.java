class Solutionkkekel {

    //todo
    public int minimumOneBitOperations(int n) {

        int[] o = new int[32];
        int[] z = new int[32];
        int flippedIndex = 31 - Integer.numberOfLeadingZeros(n);
        populateOZ(n, o, z, flippedIndex + 1);
        int extra = (1 << flippedIndex) - 1;
        return z[flippedIndex] + extra;
    }

    private void populateOZ(int n, int[] o, int[] z, int limit) {

        z[0] = n & 1;
        o[0] = ~n & 1;

        if ((n & 2) == 0) {
            z[1] = 0;
            o[1] = 2 - o[0];
        } else {
            o[1] = 0;
            z[1] = 2 - o[0];
        }

        for (int i = 2; i < limit; ++i) {

            if ((n & (1 << i)) == 0) {
                o[i] = 2 * o[i - 1] - o[i - 2] + z[i - 2];
                z[i] = 0;
            } else {
                o[i] = 0;
                z[i] = z[i - 1] + z[i - 2] + o[i - 1] - o[i - 2];
            }
        }
    }
}