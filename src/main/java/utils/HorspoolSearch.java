package utils;

public class HorspoolSearch {

    private final int[] shiftValues = new int[123];

    private int firstOccurrence(String pattern, String text) {
        calcShiftValues(pattern);
        final int n = text.length(), m = pattern.length();

        int textIndex = m - 1;
        while (textIndex < n) {

            int patternIndex = m - 1;
            for (; patternIndex >= 0; --patternIndex) {
                char patternChar = pattern.charAt(patternIndex);
                char textChar = text.charAt(textIndex + patternIndex - m + 1);
                if (patternChar != textChar) {
                    textIndex += m + shiftValues[text.charAt(textIndex)];
                    break;
                }
            }

            if (patternIndex == -1) return textIndex - m + 1;
        }

        return -1;
    }

    // offset by -patternLength
    private void calcShiftValues(String pattern) {
        for (int i = pattern.length() - 2; i >= 0; --i) {
            int c = pattern.charAt(i);
            if (shiftValues[c] == 0) shiftValues[c] = -i - 1;
        }
    }
}