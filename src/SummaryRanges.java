import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

class SolutionVERyNeat {
    public List<String> summaryRanges(int[] nums) {
        String[] res = new String[25];
        int resPointer = 0;

        byte[] buf = new byte[30];

        final int n = nums.length;
        int cur = 0;
        while (cur < n) {
            int start = cur, firstDigit;
            while (cur < n - 1 && nums[cur] + 1 == nums[cur + 1]) ++cur;

            if (cur == start) {
                firstDigit = getChars(nums[start], 30, buf);
            } else {
                firstDigit = getChars(nums[cur], 30, buf);
                buf[firstDigit - 1] = (byte) '>';
                buf[firstDigit - 2] = (byte) '-';
                firstDigit = getChars(nums[start], firstDigit - 2, buf);
            }
            res[resPointer++] = new String(buf, firstDigit, 30 - firstDigit);

            ++cur;
        }

        return new MyDangerousList(res, resPointer);
    }


    static class MyDangerousList extends AbstractList<String> implements RandomAccess {

        final String[] arr;
        final int size;

        public MyDangerousList(String[] arr, int size) {
            this.arr = arr;
            this.size = size;
        }

        public String get(int index) {
            return arr[index];
        }

        public int size() {
            return size;
        }
    }

    /*
     ( stolen from java.lang.Integer )
     */
    static int getChars(int i, int index, byte[] buf) {
        int q, r;
        int charPos = index;

        boolean negative = i < 0;
        if (!negative) {
            i = -i;
        }

        // Generate two digits per iteration
        while (i <= -100) {
            q = i / 100;
            r = (q * 100) - i;
            i = q;
            buf[--charPos] = DigitOnes[r];
            buf[--charPos] = DigitTens[r];
        }

        // We know there are at most two digits left at this point.
        q = i / 10;
        r = (q * 10) - i;
        buf[--charPos] = (byte) ('0' + r);

        // Whatever left is the remaining digit.
        if (q < 0) {
            buf[--charPos] = (byte) ('0' - q);
        }

        if (negative) {
            buf[--charPos] = (byte) '-';
        }
        return charPos;
    }

    static final byte[] DigitTens = {
            '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
            '1', '1', '1', '1', '1', '1', '1', '1', '1', '1',
            '2', '2', '2', '2', '2', '2', '2', '2', '2', '2',
            '3', '3', '3', '3', '3', '3', '3', '3', '3', '3',
            '4', '4', '4', '4', '4', '4', '4', '4', '4', '4',
            '5', '5', '5', '5', '5', '5', '5', '5', '5', '5',
            '6', '6', '6', '6', '6', '6', '6', '6', '6', '6',
            '7', '7', '7', '7', '7', '7', '7', '7', '7', '7',
            '8', '8', '8', '8', '8', '8', '8', '8', '8', '8',
            '9', '9', '9', '9', '9', '9', '9', '9', '9', '9',
    };

    static final byte[] DigitOnes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    };
}