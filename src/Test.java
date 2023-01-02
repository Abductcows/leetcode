class SolutionFakuoe {
    public int superEggDrop(int k, int n) {

        int backUpK = k;
        int count = 0;
        int length = n;

        while (length > 4 && k > 1) {
            ++count;
            --k;
            length = (length - 1) / 2;
        }

        if (k > 1) {
            if (length <= 2) return count + length;
            return count + length - 1;
        }

        return (n >> (backUpK - 1)) + count;
//
//        if (n >> (k - 2) == 4) return 3 + k - 2;
//
//        if (log <= k) return n == 2 ? 2 : Math.max(log, 1);
//
//        System.out.println("Log = " + log);
//
//        n = (n + 1) >> (k - 1);
//        System.out.println("n after division = " + n);
//        return n - 1 + k - 1;
    }
}