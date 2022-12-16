import static utils.LeetUtils.TreeNode;

class Solution333333333 {

    int low, high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;

        if (root == null) return 0;
        return my(root);
    }

    int my(TreeNode cur) {
        int curSum = 0;
        boolean lowB = cur.val >= low, highB = cur.val <= high;

        if (lowB && cur.left != null) {
            curSum += my(cur.left);
        }
        if (highB && cur.right != null) {
            curSum += my(cur.right);
        }
        if (lowB && highB) {
            curSum += cur.val;
        }
        return curSum;
    }

}