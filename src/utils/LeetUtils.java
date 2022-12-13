package utils;

public class LeetUtils {

    public static int countElements(ListNode head) {
        if (head == null) return 0;
        int count = 1;
        for (ListNode current = head; current.next != null; current = current.next, ++count) ;
        return count;
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
}
