class SolutionMZMEM {

    static char[] punctuation = {'.', '!', ','};

    public int countValidWords(String sentence) {

        int count = 0;
        String[] tokens = sentence.trim().split(" ");
        // System.out.println(Arrays.toString(tokens));
        for (String token : tokens) {
            final int n = token.length();
            if (n == 0) continue;
            boolean isValid = true;
            int hyphenCount = 0;
            for (int i = 0; i < n; ++i) {
                char c = token.charAt(i);
                if (in(punctuation, c)) {
                    if (i != n - 1) {
                        isValid = false;
                        break;
                    }
                } else if (c == '-') {
                    if (++hyphenCount == 2 || i == 0 || i == n - 1
                            || !letter(token.charAt(i - 1))
                            || !letter(token.charAt(i + 1))) {
                        isValid = false;
                        break;
                    }
                } else if (!letter(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) ++count;
        }

        return count;
    }

    boolean in(char[] chars, char c) {
        return chars[0] == c
                || chars[1] == c
                || chars[2] == c;
    }

    boolean letter(char c) {
        return 'a' <= c && c <= 'z';
    }
}