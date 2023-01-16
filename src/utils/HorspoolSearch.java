package utils;

public class HorspoolSearch {

    private int[] shiftValues = null;
    private int patternLength;

    private int firstOccurence(String pattern, String text) {
        return firstOccurrence(pattern, text, null);
    }

    private int firstOccurrence(String pattern, String text, int[] shiftValues) {
        if (shiftValues == null) {
            this.shiftValues = shiftValues = new int[128];
            calcShiftValues(pattern);
        }
        patternLength = pattern.length();

        int textIndex = patternLength - 1;
        int n = text.length();

        while (textIndex < n) {

            int i = patternLength - 1;
            while (i >= 0) {
                char patternChar = pattern.charAt(i);
                char textChar = text.charAt(
                        textIndex + i - patternLength + 1
                );
                if (patternChar != textChar) {
                    textIndex += patternLength + shiftValues[text.charAt(textIndex)];
                    break;
                }
                i--;
            }

            if (i == -1) {
                return textIndex - patternLength + 1;
            }
        }

        return -1;
    }

    private int firstOccurrenceInsensitive(String pattern, String text) {
        shiftValues = new int[128];
        patternLength = pattern.length();
        calcShiftValues(pattern);

        int textIndex = patternLength - 1;
        int n = text.length();

        while (textIndex < n) {

            int i = patternLength - 1;
            while (i >= 0) {
                char patternChar = pattern.charAt(i);
                char textChar = text.charAt(
                        textIndex + i - patternLength + 1
                );
                if (!(Character.toLowerCase(patternChar) == Character.toLowerCase(textChar))) {
                    textIndex += patternLength + shiftValues[text.charAt(textIndex)];
                    break;
                }
                i--;
            }

            if (i == -1) {
                return textIndex - patternLength + 1;
            }
        }

        return -1;
    }

    // offset by patternLength
    private void calcShiftValues(String pattern) {

        for (int i = patternLength - 2; i >= 0; i--) {
            char c = pattern.charAt(i);
            if (shiftValues[c] == 0) {
                shiftValues[c] = -i - 1;
            }
        }
    }
}
