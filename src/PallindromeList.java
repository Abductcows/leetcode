import java.util.ArrayDeque;

import static utils.LeetUtils.ListNode;

class Solation {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        int n = countElements(head);

        ArrayDeque<Integer> stack = new ArrayDeque<>(n / 2);
        stack.push(head.val);

        ListNode current = head.next;
        int i;

        final int limit = n / 2;
        for (i = 1; i < limit; current = current.next, ++i) stack.push(current.val);

        if (n % 2 == 1) current = current.next;
        for (i = 0; i < limit; current = current.next, ++i) {
            if (stack.pop() != current.val) return false;
        }

        return true;
    }

    public static int countElements(ListNode head) {
        if (head == null) return 0;
        int count = 1;
        for (ListNode current = head; current.next != null; current = current.next, ++count) ;
        return count;
    }

    public static void main(String[] args) {

    }
}