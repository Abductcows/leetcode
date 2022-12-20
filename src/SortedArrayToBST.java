import static utils.LeetUtils.TreeNode;

class SolutionOppai {

    int[] nums;
    int n;

    public TreeNode sortedArrayToBST(int[] nums) {

        n = nums.length;
        this.nums = nums;

        TreeNode root = new TreeNode();
        run(root, 0, n - 1);
        return root;
    }

    private void run(TreeNode root, int l, int r) {

        int mid = (l + r) / 2;
        root.val = nums[mid];

        if (l < mid) {
            root.left = new TreeNode();
            run(root.left, l, mid - 1);
        }
        if (mid < r) {
            root.right = new TreeNode();
            run(root.right, mid + 1, r);
        }
    }
}