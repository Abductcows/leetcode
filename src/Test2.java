import java.util.HashMap;

class Solutionzkekke {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        final int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int val = nums[i];
            Integer prev = lastSeen.get(val);
            lastSeen.put(val, i);
            if (prev == null) continue;
            if (i - prev <= k) return true;
        }

        return false;
    }
}