import java.util.Arrays;
import java.util.Comparator;

class Solution2222 {

    static class mP implements Comparable<mP> {

        int count;
        final char c;

        mP(char c) {
            this.c = c;
        }

        @Override
        public int compareTo(mP o) {
            return Integer.compare(o.count, count);
        }
    }

    public String frequencySort(String s) {
        final int n = s.length();
        if (n <= 1) return "";
        mP[] os = new mP[123];
        for (int i = 48; i < 123; ++i) {
            os[i] = new mP((char) i);
        }

        final byte[] b = s.getBytes();
        for (int i = 0; i < n; ++i) {
            ++os[b[i]].count;
        }

        Arrays.sort(os, 48, 123, Comparator.naturalOrder());
        int currIndex = 0;
        for (int ch = 48; ch < 123; ++ch) {
            int chars = os[ch].count;
            Arrays.fill(b, currIndex, currIndex + chars, (byte) os[ch].c);
            currIndex += chars;
        }
        return new String(b);
    }
}