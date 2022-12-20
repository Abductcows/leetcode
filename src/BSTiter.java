import java.util.Stack;

import static utils.LeetUtils.TreeNode;

class BSTIterator {
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = st.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushAll(TreeNode root) {
        for (; root != null; st.push(root), root = root.left) ;
    }
}
