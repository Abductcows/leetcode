class Solutionzeta {

    public String toHex(int num) {
        if (num == 0) return "0";
        char[] lookup = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] res = new char[8];
        int i = 7;
        for (; i >= 0 && num != 0; --i) {
            res[i] = lookup[num & 0b1111];
            num >>>= 4;
        }
        return new String(res, i + 1, 8 - i - 1);
    }
}