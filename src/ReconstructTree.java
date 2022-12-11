import java.util.ArrayDeque;

class Solution {

    int n;
    public TreeNode recoverFromPreorder(String traversal) {

        HCR current;
        int cursor = 0;
        final int n = traversal.length();
        this.n = n;
        TreeNode root = null;
        ArrayDeque<HCR> queue = new ArrayDeque<>();
        while (cursor < n) {
            current = findNext(cursor, traversal);
            queue.add(current);

            cursor = current.cursor;
        }

        return root;
    }

    HCR findNext(int cur, String s) {
        int depth = 0;
        while (s.charAt(cur + depth) == '-') ++depth;
        cur += depth;

        int i = 0;
        for (; cur + i < n && s.charAt(cur + i) != '-'; ++i) ;
        String num = s.substring(cur, cur + i);
        return new HCR(
                cur + i,
                Integer.parseInt(num),
                depth
        );
    }

    static class HCR {
        int cursor;
        int element;
        int depth;

        public HCR(int cursor, int element, int depth) {
            this.cursor = cursor;
            this.element = element;
            this.depth = depth;
        }
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

    public static void main(String[] args) {
        String input = "1-2--3--4-5--6--7";
        System.out.println(new Solution().recoverFromPreorder(input));
    }
}