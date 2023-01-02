import java.util.AbstractList;
import java.util.List;

class SolutionLZLLE {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int[] result = new int[k];
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = l + r >>> 1;
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.arraycopy(arr, l, result, 0, k);

        return new DangerList(result);
    }

    static class DangerList extends AbstractList<Integer> {

        final int[] backing;
        final int n;

        public DangerList(int[] backing) {
            this.backing = backing;
            this.n = backing.length;
        }

        @Override
        public Integer get(int index) {
            return backing[index];
        }

        @Override
        public int size() {
            return n;
        }
    }
}