import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


class Solutioneee {

    static class TreeNode {
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

    int n;

    public TreeNode recoverFromPreorder(String traversal) {

        this.n = traversal.length();
        var nodes = parseString(traversal);

        var root = new TreeNode(nodes.get(0).element);
        ArrayDeque<HCR> stack = new ArrayDeque<>(List.of(nodes.get(0)));
        ArrayDeque<TreeNode> nodeStack = new ArrayDeque<>(List.of(root));
        int i = 1, limit = nodes.size();
        while (i < limit) {

            HCR currentInfo = nodes.get(i);
            HCR lastInfo = stack.peekFirst();

            if (currentInfo.depth == lastInfo.depth) {
                nodeStack.pop();
                nodeStack.pollFirst().right = new TreeNode(currentInfo.element);
                stack.pop();
                stack.pop();
            } else if (currentInfo.depth == lastInfo.depth + 1) {
                TreeNode newNode = new TreeNode(currentInfo.element);
                if (nodeStack.size() == 1 && nodeStack.peekFirst().left != null) {
                    nodeStack.pollFirst().right = newNode;
                } else {
                    nodeStack.peekFirst().left = newNode;
                }
                nodeStack.push(newNode);
                stack.push(currentInfo);
            } else {
                while (currentInfo.depth != stack.peekFirst().depth + 1) {
                    stack.pop();
                    nodeStack.pop();
                }
            }

            ++i;
        }


        return root;
    }

    ArrayList<HCR> parseString(String traversal) {
        ArrayList<HCR> result = new ArrayList<>();
        HCR current;
        int cursor = 0;
        while (cursor < n) {
            current = findNext(cursor, traversal);
            result.add(current);
            cursor = current.cursor;
        }

        return result;
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


    static void preorder(TreeNode root) {
        if (root == null) {
            System.out.printf("null,");
            return;
        }
        System.out.printf("%d,", root.val);
        preorder(root.left);
        preorder(root.right);
    }


    public static void main(String[] args) {
        String input;
        TreeNode result;
//        String input = "1-2--3--4-5--6--7";
//        var result = new Solution().recoverFromPreorder(input);
//        Solution.preorder(result);
//        System.out.println();
        input = "1-2--3---4-5--6---7";
        result = new Solutioneee().recoverFromPreorder(input);
        System.out.println("Expected: [1,2,5,3,null,6,null,4,null,7]");
        Solutioneee.preorder(result);
    }
}