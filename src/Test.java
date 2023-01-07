import java.util.Arrays;

class Solution {

    int[] tasks;

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        final int n = tasks.length;
        this.tasks = tasks;
        int i = 0, res = 0;
        while (i < tasks.length) {
            int j = findNext(i, n - 1);
            if (j == i + 1) return -1;
            res += (j - i + 2) / 3;
            i = j;
        }
        return res;
    }


    int findNext(int l, int r) {

        int task = tasks[l];
        int lin = l + 1, limit = Math.min(l + 30, r);
        for (; lin < limit; ++lin) {
            if (tasks[lin] != task) return lin;
        }
        l = limit;
        while (l + 1 < r) {

            int mid = l + (r - l) / 2;

            if (tasks[mid] == task) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return 1 + tasks[r] == task ? r : l;
    }
}