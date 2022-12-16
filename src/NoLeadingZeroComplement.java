class Solutionmakaria {
    public int findComplement(int num) {

        final int toKeepMask = (Integer.highestOneBit(num) << 1) - 1;
        return ~num & toKeepMask;
    }
}