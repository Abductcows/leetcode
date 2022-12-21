class SolutionDubious {

    static int[] tens = new int[10];

    static {
        int val = 1;
        for (int i = 9; i >= 0; --i) {
            tens[i] = val;
            val *= 10;
        }
    }

    public int myAtoi(String s) {

        int n = s.length();
        int cur = 0;
        if (s.startsWith(" ")) {
            while (cur < n && s.charAt(cur) == ' ') ++cur;
        }
        if (cur == n) return 0;

        int sign = 1;
        if (s.charAt(cur) == '-') {
            sign = -1;
            ++cur;
        } else if (s.charAt(cur) == '+') {
            ++cur;
        }

        String theDigits = justTheDigits(s, cur);
        n = theDigits.length();
        if (n == 0) return 0;

        if (theDigits.length() > 10) {
            return maxClamped(sign);
        }

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            int digit = theDigits.charAt(i) - '0';
            int coefficient = tens[10 - n + i];
            sum += digit * coefficient;
            if (sum < 0 || n == 10 && i == 0 && digit > 2) {
                return maxClamped(sign);
            }
        }

        return sum * sign;
    }

    public int maxClamped(int sign) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    public String justTheDigits(String s, int start) {

        final int n = s.length();
        char c;
        int cur;
        for (; start < n && s.charAt(start) == '0'; ++start) ;
        for (cur = start;
             cur < n &&
                     cur - start <= 11 &&
                     (c = s.charAt(cur)) >= '0' &&
                     c <= '9';
             ++cur)
            ;
        return s.substring(start, cur);
    }
}