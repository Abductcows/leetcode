class Solutionemnene {

    static final int RIGHT_ALIGN_OFFSET = 6;

    public String sortString(String s) {

        // todo

        byte[] res;
        int resultP = 0;
        int[] freqs = new int[26];
        for (byte aChar : (res = s.getBytes(java.nio.charset.StandardCharsets.US_ASCII))) ++freqs[aChar - 'a'];

        int occupied = 0; // lsb aligned a-z
        for (int i = 0; i < 26; ++i) occupied |= (-freqs[i] & Integer.MIN_VALUE) >>> (i + RIGHT_ALIGN_OFFSET);

        while (occupied > 0) {

            int smallestIndex = getSmallestIndex(occupied);
            res[resultP++] = (byte) ('a' + smallestIndex);
            if (--freqs[smallestIndex] == 0) occupied &= ~(1 << 25 - smallestIndex);

            while (true) {
                smallestIndex = getSmallestIndex(occupied & getToTheRightMask(smallestIndex));
                if (smallestIndex > 25) break;
                res[resultP++] = (byte) ('a' + smallestIndex);
                if (--freqs[smallestIndex] == 0) occupied &= ~(1 << 25 - smallestIndex);
            }

//            if (occupied == 0) break;
            int largestIndex = getLargestIndex(occupied);
            if (largestIndex < 0) break;
            res[resultP++] = (byte) ('a' + largestIndex);
            if (--freqs[largestIndex] == 0) occupied &= ~(1 << 25 - largestIndex);

            while (true) {
                largestIndex = getLargestIndex(occupied & getToTheLeftMask(largestIndex));
                if (largestIndex < 0) break;
                res[resultP++] = (byte) ('a' + largestIndex);
                if (--freqs[largestIndex] == 0) occupied &= ~(1 << 25 - largestIndex);
            }
        }

        return new String(res, 0, resultP);
    }

    int getSmallestIndex(int occupied) {
        return Integer.numberOfLeadingZeros(occupied) - 6;
    }

    int getLargestIndex(int occupied) {
        return 26 - 1 - Integer.numberOfTrailingZeros(occupied);
    }

    int getToTheRightMask(int letterIndex) {
        return -1 >>> 6 + 1 + letterIndex;
    }

    int getToTheLeftMask(int letterIndex) {
        return -1 << 26 - letterIndex;
    }

    public static void main(String[] args) {

        System.out.println(new Solutionemnene().sortString("jkzkydvxewqjfx"));
        System.out.println("defjkqvwxyzxkj expected");

        System.out.println(new Solutionemnene().sortString("accbaaccbabb"));
        System.out.println("abccbaabccba expected");
    }
}