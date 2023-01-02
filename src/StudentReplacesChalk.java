class Solutionzkkekek {
    public int chalkReplacer(int[] chalk, int k) {

        final int n = chalk.length;
        if (n > 500 && n <= 10_000 && k >= 2 * n) {
            return withPrefixAndBinary(chalk, k);
        }
        return justSumAndMod(chalk, k);
    }

    private static int justSumAndMod(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; ++i) {
            sum += chalk[i];
        }
        int remainder = (int) (k % sum), i = 0;
        for (; i < chalk.length && remainder >= 0; ++i) {
            remainder -= chalk[i];
        }
        return i - 1;
    }

    private static int withPrefixAndBinary(int[] chalk, int k) {
        final int n = chalk.length;
        for (int i = 1; i < n; ++i) {
            chalk[i] += chalk[i - 1];
        }
        k = k % chalk[n - 1];
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (chalk[mid] > k) {
                if (mid == 0 || chalk[mid - 1] <= k) return mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}