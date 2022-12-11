import java.util.Arrays;

class Solution111221 {
    public boolean isHappy(int n) {
        int[] previous = new int[10];
        Arrays.fill(previous, -1);
        while (true) {
            if (n < 10) {
                if (previous[n] < 0) {
                    previous[n] = 1;
                } else {
                    return n == 1;
                }
            }
            n = sumDigitsSquared(n);
        }
    }

    private int sumDigitsSquared(int n) {
        int sum = 0;
        int digit, newN;
        while (n > 0) {
            newN = n / 10;
            digit = n - 10 * newN;
            sum += digit * digit;
            n = newN;
        }
        return sum;
    }
}