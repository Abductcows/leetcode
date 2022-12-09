import com.sun.source.tree.Tree;

class Solution {
    
    class MNN {
        
        final int max;
        final TreeNode next;
        
        public MNN(int max, TreeNode next) {
            this.max = max;
            this.next = next;
        }
        
        public MNN(int max) {
            this(max, null);
        }
    }
    
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(
                mad(root, true).max,
                mad(root, false).max
        );
    }


    MNN mad(TreeNode current, boolean goLeft) {
        
        TreeNode node, next = null;
        int nextAttempt;
        boolean foundNext = false;
        if (goLeft) {
            
            if (current.left == null) new MNN(0);
            for (node = current.left; node.left != null; node = node.left) {
                if (node.right != null && !foundNext) {
                    foundNext = true;
                    next = node.right;
                }
            }
            if (!foundNext) return new MNN(0);
            nextAttempt = mad(next, false);
        } else {
            if (current.right == null) return 0;
            for (node = current.right; node.right != null; node = node.right);
            nextAttempt = mad(node, true);
        }

        return Math.max(
                Math.abs(current.val - node.val),
                nextAttempt
        );
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}