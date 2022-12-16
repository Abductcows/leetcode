import java.util.Arrays;

class S0lution {

    int[] nums;
    int n;

    public int[] searchRange(int[] nums, int target) {
        this.n = nums.length;
        this.nums = nums;

        int someTargetIndex = Arrays.binarySearch(nums, target);
        if (someTargetIndex < 0) return new int[]{-1, -1};

        int leftmost, rightmost;
        leftmost = rightmost = someTargetIndex;

        int newLeftmost = myBinSearchLeft(0, leftmost - 1, target);
        if (newLeftmost >= 0) leftmost = newLeftmost;

        int newRightmost = myBinSearchRight(rightmost + 1, n - 1, target);
        if (newRightmost >= 0) rightmost = newRightmost;

        return new int[]{leftmost, rightmost};
    }

    private int myBinSearchRight(int l, int r, int target) {

        while (l < r - 1) {
            int mid = (l + r) / 2;

            if (nums[mid] < target) {
                l = mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                if (mid == n - 1) return mid;
                if (nums[mid + 1] == target) {
                    l = mid;
                } else {
                    return mid;
                }
            }
        }
        if (l + 1 == r || l == r) {
            if (nums[r] == target) return r;
            if (nums[l] == target) return l;
        }

        return -1;
    }

    int myBinSearchLeft(int l, int r, int target) {

        while (l < r - 1) {
            int mid = (l + r) / 2;

            if (nums[mid] < target) {
                l = mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                if (mid == 0) return mid;
                if (nums[mid - 1] == target) {
                    r = mid;
                } else {
                    return mid;
                }
            }
        }

        if (l + 1 == r || l == r) {
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input, output;

//        input = new int[]{5,7,7,8,8,10};
//        output = new Solution().searchRange(input, 8);
//        System.out.println(Arrays.toString(output));

        input = new int[]{2,2};
        output = new S0lution().searchRange(input, 2);
        System.out.println(Arrays.toString(output));
    }
}