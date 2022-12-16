import java.util.ArrayList;
import java.util.Arrays;

class Solutionzxc {
    public int[] sortByBits(int[] arr) {

        final int n = arr.length;
        ArrayList<Integer> copy = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            copy.add(arr[i]);
        }
        copy.sort((i1, i2) -> {
            int unb1 = i1, unb2 = i2;
            int bc = Integer.bitCount(unb1) - Integer.bitCount(unb2);
            if (bc != 0) return bc;
            int bh = Integer.highestOneBit(unb1) >> (63 - Integer.numberOfLeadingZeros(unb2));
            if (bh != 1) return bh - 1;
            return i1.compareTo(i2);
        });
        for (int i = 0; i < n; ++i) {
            arr[i] = copy.get(i);
        }
        return arr;
    }

    public int[] sortByBits2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10001;
        }
        return arr;
    }
}