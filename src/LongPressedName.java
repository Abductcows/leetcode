class Solutionxaxa {
    public boolean isLongPressedName(String name, String typed) {

        if (typed.length() < name.length()) return false;
        byte[] nc = name.getBytes(), tc = typed.getBytes();
        final int nlimit = nc.length, tlimit = tc.length;

        int ni = 0, ti = 0;
        while (ni < nlimit) {
            if (ti == tlimit || nc[ni] != tc[ti]) return false;

            // consume extras on last press of same letter
            if (ni < nlimit - 1 && nc[ni + 1] != nc[ni]) {
                while (ti < tlimit && tc[ti] == nc[ni]) {
                    ++ti;
                }
            } else {
                ++ti;
            }
            ++ni;
        }

        // trailing long presses
        while (ti < tlimit) {
            if (tc[ti++] != nc[nlimit - 1]) {
                return false;
            }
        }
        return true;
    }
}