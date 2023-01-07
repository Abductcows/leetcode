import java.util.Arrays;

class Solutionzllelek {
    public int triangleNumber(int[] nums) {

        final int n = nums.length;
        if (n < 3) return 0;
        Arrays.sort(nums);
        int result = 0;

        for (int i = 2; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    result += r-- - l;
                } else {
                    ++l;
                }
            }
        }

        return result;
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                array[k++] = array[i++];
            } else {
                array[k++] = array[j++];
            }
        }
        while (i <= mid) {
            array[k++] = array[i++];
        }
        while (j <= high) {
            array[k++] = array[j++];
        }
    }

    public static void main(String[] args) {
        int[] val = {4, 2, 3, 4};
        System.out.println(Arrays.toString(val));
    }
}