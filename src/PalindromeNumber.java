class Solutionneezmd {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int digitCount = 0;
        while (x > 0) {
            int temp = x / 10;
            digits[digitCount++] = x - temp * 10;
            x = temp;
        }
        final int limit = digitCount / 2;
        for (int i = 0; i < limit; ++i) {
            if (digits[i] != digits[digitCount - i - 1]) return false;
        }
        return true;
    }
}