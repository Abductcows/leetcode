import java.util.Arrays;

class Lolution {

    public int search(int[] nums, int target) {
        final int n = nums.length;
        boolean isOffset = nums[n - 1] < nums[0];
        int indexOf;
        if (isOffset) {
            int l = 0, r = n - 1;
            while (nums[l] < nums[l + 1]) {
                int mid = (l + r) / 2;
                if (nums[mid] > nums[r]) {
                    l = mid;
                } else if (nums[mid] < nums[r]) {
                    r = mid;
                }
            }
            indexOf = Arrays.binarySearch(nums, 0, l + 1, target);
            if (indexOf >= 0) return indexOf;
            indexOf = Arrays.binarySearch(nums, l + 1, n, target);
        } else {
            indexOf = Arrays.binarySearch(nums, target);
        }

        return indexOf >= 0 ? indexOf : -1;
    }

    public static void main(String[] args) {

        var input = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Lolution().search(input, 0));
    }
}