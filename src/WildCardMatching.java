import java.util.HashMap;

class Solution2 {


    /// wrong

    int patternLength = 0;
    HashMap<Character, Integer> shiftValues = null;

    public boolean isMatch(String s, String p) {


        var asteriskIndex = p.indexOf('*');
        if (asteriskIndex >= 0) {
            p = p.substring(0, asteriskIndex);
        }
        patternLength = p.length();
        shiftValues = calcShiftValues(p);
        int textIndex = patternLength - 1;

        int i = patternLength - 1;


        while (i >= 0) {

            char pC = p.charAt(i);
            if (pC == '?') {
                --i;
                continue;
            }
            char tC = s.charAt(
                    textIndex + i - patternLength + 1
            );
            if (tC != pC) {
                break;
            }
            --i;
        }

        if (asteriskIndex >= 0) {
            return i == -1;
        }
        return i == -1 && s.length() == patternLength;
    }


    HashMap<Character, Integer> calcShiftValues(String pattern) {

        final int length = pattern.length();
        var result = new HashMap<Character, Integer>();

        for (int i = length - 2; i >= 0; --i) {
            char c = pattern.charAt(i);
            int finalI = i;
            result.computeIfAbsent(c, character -> length - 1 - finalI);
        }

        return result;
    }

    Integer getShiftValue(char c) {
        Integer shiftValue = shiftValues.get(c);
        if (shiftValue == null) {
            return patternLength;
        }
        return shiftValue;
    }

    public static void main(String[] args) {
        var solver = new Solution2();
        System.out.println(solver.isMatch("aa", "a"));
        System.out.println("Should be false");
    }
}