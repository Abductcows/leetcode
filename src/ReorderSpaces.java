class Solutionllepeoo {

    static final String spaces = "   ".repeat(25);

    public String reorderSpaces(String s) {

        final int n = s.length();
        String[] words = new String[51];
        int spaceCount = 0, wordCount = 0;
        StringBuilder result = new StringBuilder(2 * n + 1);

        int cur = 0;
        while (cur < n) {
            while (cur < n && s.charAt(cur) == ' ') {
                ++spaceCount;
                ++cur;
            }
            int wordStart = cur;
            while (cur < n && s.charAt(cur) != ' ') ++cur;
            if (cur > wordStart) {
                words[wordCount++] = s.substring(wordStart, cur);
            }
        }

        int spacesBetweenEach, remaining;

        if (wordCount == 1) {
            spacesBetweenEach = 0;
            remaining = spaceCount;
        } else {
            spacesBetweenEach = spaceCount / (wordCount - 1);
            remaining = spaceCount % (wordCount - 1);
        }

        for (int i = 0; i < wordCount - 1; ++i) {
            result.append(words[i]);
            result.append(spaces, 0, spacesBetweenEach);
        }
        result.append(words[wordCount - 1]);
        result.append(spaces, 0, remaining);

        return result.toString();
    }
}