package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetUtils {

    // 123 elements
    final int[] fastCharFreqArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    static final List<Character> digits = IntStream.range(48, 58).boxed().map(i -> (char) i.intValue()).collect(Collectors.toList());

    public static int countElements(ListNode head) {
        if (head == null) return 0;
        int count = 1;
        for (ListNode current = head; current.next != null; current = current.next, ++count) ;
        return count;
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

    public static void main(String[] args) {
        String test;

        test = "";
        System.out.println(Arrays.toString(decodeIntArray(test)));
        test = "[]";
        System.out.println(Arrays.toString(decodeIntArray(test)));
        test = "[15]";
        System.out.println(Arrays.toString(decodeIntArray(test)));
        test = "[1, 2]";
        System.out.println(Arrays.toString(decodeIntArray(test)));

        test = "[[]]";
        System.out.println(Arrays.deepToString(decode2DIntArray(test)));
        test = "[[1,5],[8,12],[15,24],[25,26]]";
        System.out.println(Arrays.deepToString(decode2DIntArray(test)));
        test = "[[0,2],[5,10],[13,23],[24,25]]";
        System.out.println(Arrays.deepToString(decode2DIntArray(test)));
        System.out.println();
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
