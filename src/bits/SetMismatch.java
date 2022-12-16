package bits;


class Solution123111111111 {
    public int[] findErrorNums(int[] nums) {
        final int N = nums.length;
        final int MASK = Integer.MIN_VALUE;
        int acc = 0, dupeVal = -1;
        for (int i = 0; i < N; ++i) {
            int indexVal = (nums[i] & ~MASK) - 1;
            if ((nums[indexVal] & MASK) == 0) {
                nums[indexVal] |= MASK;
            } else {
                dupeVal = indexVal + 1;
            }
            acc = acc ^ (indexVal + 1) ^ (i + 1);
        }
        return new int[]{dupeVal, acc ^ dupeVal};
    }
}
