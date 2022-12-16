class SolutionMuchoGood2 {
    public int binaryGap(int n) {
        if ((n & (n - 1)) == 0) return 0;

        int max = 1;
        n >>>= (Integer.numberOfTrailingZeros(n & -n));
        int rm1;
        do {
            rm1 = n & -n;
            if (rm1 == 0) break;
            int rs = Integer.numberOfTrailingZeros(rm1) + 1;
            max = Math.max(max, rs);
            n >>>= rs;
        } while (rm1 > 0);

        return max;
    }

}