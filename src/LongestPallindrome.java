class Solutionp000 {
    public int longestPalindrome(String[] words) {

        final int[] found = new int[26 * 26];
        int maxLength = 0;
        for (String word : words) {
            final int i1 = word.charAt(0) - 'a';
            final int i2 = word.charAt(1) - 'a';
            final int selfIndex = 26 * i1 + i2;
            final int matchIndex = 26 * i2 + i1;
            if (found[matchIndex] == 0) {
                ++found[selfIndex];
            } else {
                --found[matchIndex];
                maxLength += 4;
            }
        }

        for (int i = 0; i < 26; ++i) {
            if (found[27 * i] > 0) {
                return maxLength + 2;
            }
        }
        return maxLength;
    }
}