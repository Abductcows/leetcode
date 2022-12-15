import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionMuchoGood {
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

        if (Arrays.equals(pFreqs, 97, 123, sFreqs, 97, 123)) {
            result.add(0);
        }
        final int limit = sL - pL + 1;
        for (int i = 1; i < limit; ++i) {
            --sFreqs[sChars[i - 1]];
            ++sFreqs[sChars[i + pL - 1]];
            if (Arrays.equals(pFreqs, 97, 123, sFreqs, 97, 123)) {
                result.add(i);
            }
        }

        return result;
    }
}