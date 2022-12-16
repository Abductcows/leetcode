import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionMuchogood {
    public List<Integer> findAnagrams(String s, String p) {

        final int pL = p.length(), sL = s.length();
        if (pL > sL) return List.of();
        ArrayList<Integer> result = new ArrayList<>();

        byte[] pChars = p.getBytes();
        byte[] sChars = s.getBytes();
        int[] pFreqs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] sFreqs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < pL; ++i) {
            ++pFreqs[pChars[i]];
            ++sFreqs[sChars[i]];
        }

        boolean lastWas = false;
        if (Arrays.equals(pFreqs, 97, 123, sFreqs, 97, 123)) {
            result.add(0);
            lastWas = true;
        }
        final int limit = sL - pL + 1;
        for (int i = 1; i < limit; ++i) {
            byte c1 = sChars[i - 1];
            byte c2 = sChars[i + pL - 1];
            --sFreqs[c1];
            ++sFreqs[c2];

            if (!lastWas && c1 == c2) {
                lastWas = false;
                continue;
            }
            if (lastWas && c1 == c2 || Arrays.equals(pFreqs, 97, 123, sFreqs, 97, 123)) {
                result.add(i);
                lastWas = true;
            } else {
                lastWas = false;
            }
        }

        return result;
    }
}