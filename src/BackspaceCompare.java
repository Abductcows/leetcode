class Solutionzzeez {
    public boolean backspaceCompare(String s, String t) {

        byte[] sc = s.getBytes();
        byte[] tc = t.getBytes();

        int si = sc.length - 1, ti = tc.length - 1;
        while (true) {
            ti = getNextChar(tc, ti);
            si = getNextChar(sc, si);
            if (si < 0 && ti < 0) return true;
            if (si < 0 ^ ti < 0 || sc[si] != tc[ti]) return false;
            --ti;
            --si;
        }
    }

    private static int getNextChar(byte[] chars, int cur) {
        if (cur < 0 || chars[cur] != '#') return cur;
        int i = cur - 1;
        int backspaces = 1;
        while (i >= 0) {
            if (backspaces == 0 && chars[i] != '#') break;
            if (chars[i] == '#') {
                ++backspaces;
            } else {
                --backspaces;
            }
            --i;
        }
        return i;
    }
}