class Solution {
    public String repeatLimitedString(String s, int k) {


        byte[] res;
        int resP = 0;
        int[] freqs = new int[26];
        for (byte aChar : (res = s.getBytes(java.nio.charset.StandardCharsets.US_ASCII))) ++freqs[aChar - 'a'];


        for (int i = 25; i >= 0; --i) {

            // groups of k chars with
            while (freqs[i] > k) {
                // place k largest chars
                for (int _j = 0; _j < k; ++_j) res[resP++] = (byte) ('a' + i);
                freqs[i] -= k;

                int j = i - 1;

                for (; freqs[j] == 0; --j) ;
                int inBetweenCharIndex = 25 - Integer.numberOfTrailingZeros(occupieFlags & toTheLeftMask);
                if (inBetweenCharIndex < 0) return new String(res, 0, resP);
                res[resP++] = (byte) ('a' + inBetweenCharIndex);
            }
            // last 0 < c <= k chars
            for (int _j = freqs[i]; _j > 0; --_j) res[resP++] = (byte) ('a' + i);
        }


        return new String(res, 0, resP);
    }
}