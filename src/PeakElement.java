class Solpution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) return nums[0] > nums[1] ? 0 : 1;
        int l = 0, r = n - 1;

        while (l < r - 1) {

            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid - 1]) {
                if (nums[mid] > nums[mid + 1]) return mid;
                l = mid;
            } else {
                r = mid;
            }
        }

        return nums[l] > nums[r] ? l : r;
    }

    public static void main(String[] args) {
        int[] input;
        int output;

        input = new int[]{1, 2, 3};
        output = new Solpution().findPeakElement(input);
        System.out.println(output);
    }
}