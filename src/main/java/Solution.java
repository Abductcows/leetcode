class Solution {
    public int minFlipsMonoIncr(String s) {

        int zero = 0, one = 0;

        for (byte c : s.getBytes(java.nio.charset.StandardCharsets.US_ASCII)) {
            one += c - 48;
            zero += 49 - c;
            zero += ((one - zero) & ((one - zero) >> 31));
        }

        return zero;
    }
}