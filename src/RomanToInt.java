class SolutionRomantic {

    static final int[] vals = new int['Z' + 1];
    static final int[] previous = new int['Z' + 1];

    static {
        vals['I'] = 1;
        vals['V'] = 5;
        vals['X'] = 10;
        vals['L'] = 50;
        vals['C'] = 100;
        vals['D'] = 500;
        vals['M'] = 1000;

        previous['V'] = 'I';
        previous['X'] = 'I';
        previous['L'] = 'X';
        previous['C'] = 'X';
        previous['D'] = 'C';
        previous['M'] = 'C';
    }

    public int romanToInt(String s) {

        byte[] chars = s.getBytes();
        final int n = chars.length;

        int sum = 0;

        for (int i = n - 1; i >= 0; --i) {

            byte c = chars[i];
            sum += vals[c];
            if (i > 0 && chars[i - 1] == previous[c]) {
                sum -= vals[previous[c]];
                --i;
            }
        }


        return sum;
    }
}