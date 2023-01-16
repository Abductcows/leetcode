class Solutiontodo1 {

    ///todo
    public void duplicateZeros(int[] nums) {
        int n = nums.length, zeroCount = 0;
        for (int i = 0; i < n && i + zeroCount <= n; ++i) {
            if (nums[i] == 0) {
                ++zeroCount;
            }
        }

        int cur = n - 1 - zeroCount;
        while (zeroCount > 0) {
            if (nums[cur] == 0) {
                nums[cur + zeroCount--] = 0;
            }
            nums[cur + zeroCount] = nums[cur--];
        }
    }

    public static void main(String[] args) {
        int[] input;

        input = new int[]{0, 0, 0, 0, 0, 0, 0};
        new Solutiontodo1().duplicateZeros(input);
        System.out.println("Input: [0, 0, 0, 0, 0, 0, 0]");
        System.out.print("Output: ");
        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
