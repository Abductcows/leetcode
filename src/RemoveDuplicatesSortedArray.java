class Solutionzmen {
    public int removeDuplicates(int[] nums) {

        final int n = nums.length;

        int previous = 101;
        int uniques = 0;
        for (int num : nums) {
            if (num == previous) continue;
            previous = num;
            nums[uniques++] = num;
        }

        return uniques;
    }
}