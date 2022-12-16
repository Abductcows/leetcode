class Solutionfinal {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        return 31 + Integer.bitCount(num) - Integer.numberOfLeadingZeros(num);
    }
}