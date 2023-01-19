package utils;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetUtils {

    public static void main(String[] args) {
        String sentence;

        sentence = "Hello world haha";
        for (SentenceWordIterator it = new SentenceWordIterator(sentence); it.hasNext(); ) {
            String word = it.next();
            System.out.println(word);
        }
        sentence = "oneword";
        for (SentenceWordIterator it = new SentenceWordIterator(sentence); it.hasNext(); ) {
            String word = it.next();
            System.out.println(word);
        }
        sentence = "two  spaces";
        for (SentenceWordIterator it = new SentenceWordIterator(sentence); it.hasNext(); ) {
            String word = it.next();
            System.out.println(word);
        }
        sentence = "";
        for (SentenceWordIterator it = new SentenceWordIterator(sentence); it.hasNext(); ) {
            String word = it.next();
            System.out.println(word);
        }
    }

    static class SentenceWordIterator implements Iterator<String> {

        final byte[] sentence;
        final int limit;
        int cur = 0;

        public SentenceWordIterator(String sentence) {
            this.sentence = sentence.trim().getBytes();
            this.limit = this.sentence.length;
        }

        @Override
        public boolean hasNext() {
            return cur < limit;
        }

        @Override
        public String next() {
            int start = cur;
            while (cur < limit && sentence[cur] != ' ') ++cur;
            while (cur < limit - 1 && sentence[++cur] == ' ') ;
            return new String(sentence, start, cur - start);
        }
    }

    // 123 elements
    final int[] fastCharFreqArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    static final List<Character> digits = IntStream.range(48, 58).boxed().map(i -> (char) i.intValue()).collect(Collectors.toList());

    public static int countElements(ListNode head) {
        if (head == null) return 0;
        if (head.next == null) return 1;
        if (head.next.next == null) return 2;
        int count = 0;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            ++count;
            fast = fast.next;
        }
        if (fast.next == null) {
            return 2 * count - 1;
        }
        return 2 * count;
    }

    Iterator<String> wordIterator(String sentence) {
        return new SentenceWordIterator(sentence);
    }

    void postOrderIterEarlyStop(TreeNode root, Predicate<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> toPop = new Stack<>();

        for (TreeNode current = root; current != null; stack.push(current), current = current.left) ;

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.right == null) {
                if (action.test(stack.pop())) return;
                continue;
            }
            TreeNode nextPop = toPop.peek();
            if (top == nextPop) {
                if (action.test(stack.pop())) return;
                toPop.pop();
            } else {
                toPop.push(top);
                for (TreeNode current = top.right; current != null; stack.push(current), current = current.left) ;
            }
        }
    }

    void postOrderIter(TreeNode root, Consumer<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> toPop = new Stack<>();

        for (TreeNode current = root; current != null; stack.push(current), current = current.left) ;

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.right == null) {
                action.accept(stack.pop());
                continue;
            }
            TreeNode nextPop = toPop.peek();
            if (top == nextPop) {
                action.accept(stack.pop());
                toPop.pop();
            } else {
                toPop.push(top);
                for (TreeNode current = top.right; current != null; stack.push(current), current = current.left) ;
            }
        }
    }


    void inorderIterDepthed(TreeNode root, BiConsumer<TreeNode, Integer> action) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<Integer> depths = new ArrayDeque<>();

        int depth = 0;
        for (TreeNode current = root; current != null; current = current.left) {
            stack.push(current);
            depths.push(depth++);
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            int topDepth = depths.pop();
            action.accept(top, topDepth);
            for (TreeNode current = top.right; current != null; current = current.left) {
                stack.push(current);
                depths.push(topDepth + 1);
            }
        }
    }

    void inorderIter(TreeNode root, Consumer<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        for (TreeNode current = root; current != null; stack.push(current), current = current.left) ;

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            action.accept(top);
            for (TreeNode current = top.right; current != null; stack.push(current), current = current.left) ;
        }
    }

    void inorderIterEarlyStop(TreeNode root, Predicate<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        for (TreeNode current = root; current != null; stack.push(current), current = current.left) ;

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (action.test(top)) {
                return;
            }
            for (TreeNode current = top.right; current != null; stack.push(current), current = current.left) ;
        }
    }

    void preorderIter(TreeNode root, Consumer<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        for (TreeNode current = root; current != null;
             action.accept(current), stack.push(current), current = current.left)
            ;

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            for (TreeNode current = top.right; current != null;
                 action.accept(current), stack.push(current), current = current.left)
                ;
        }
    }

    void preorderIterEarlyStop(TreeNode root, Predicate<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        for (TreeNode current = root; current != null; current = current.left) {
            if (action.test(current)) return;
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            for (TreeNode current = top.right; current != null; current = current.left) {
                if (action.test(current)) return;
                stack.push(current);
            }
        }
    }

    @SuppressWarnings("unchecked")
    static <E> E[] decodeArray(String array,
                               List<Character> elementStartChars,
                               List<Character> elementEndChars,
                               Function<String, E> converter) {
        if (array.startsWith(" ")) {
            array = array.trim();
        }
        final int n = array.length();
        ArrayList<E> result = new ArrayList<>();

        int cur = 1;
        while (cur < n) {
            while (cur < n && !elementStartChars.contains(array.charAt(cur))) {
                ++cur;
            }
            if (cur == n) break;
            int length = 1;
            while (cur + length < n) {
                char c = array.charAt(cur + length);
                if (elementEndChars.contains(c) || c == ']' && cur + length == n - 1) break;
                ++length;
            }
            result.add(converter.apply(array.substring(cur, cur + length)));
            cur += length;
        }

        E[] r = (E[]) new Object[result.size()];
        for (int i = 0; i < r.length; ++i) {
            r[i] = result.get(i);
        }
        return r;
    }

    public static int[][] decode2DIntArray(String array) {
        Object[] result = decodeArray(array, List.of('['), List.of(']'), LeetUtils::decodeIntArray);
        return Arrays.stream(result)
                .map(o -> (int[]) o)
                .toArray(int[][]::new);
    }

    public static int[] decodeIntArray(String array) {
        Object[] result = decodeArray(array, digits, List.of(' ', ','), Integer::parseInt);
        return Arrays.stream(result)
                .mapToInt(o -> (Integer) o)
                .toArray();
    }

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
