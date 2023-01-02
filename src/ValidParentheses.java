class SolutionGrande {

    static byte[] matches = new byte[126];
    static final byte[] opening = {'(', '[', '{'};

    static {
        matches[')'] = '(';
        matches[']'] = '[';
        matches['}'] = '{';
    }

    public boolean isValid(String s) {
        byte[] chars = s.getBytes();
        final int n = chars.length;
        byte[] stack = new byte[n / 2];
        int i = 0, limit = n / 2 - 1;
        for (byte c : chars) {
            if (in(opening, c)) {
                if (i > limit) return false;
                stack[i++] = c;
            } else {
                if (i == 0 || stack[--i] != matches[c]) {
                    return false;
                }
            }
        }
        return i == 0;
    }

    boolean in(byte[] array, byte target) {
        return array[0] == target || array[1] == target || array[2] == target;
    }
}