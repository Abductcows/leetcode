
class Solution444444444 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode counter = head; counter.next != null; counter = counter.next) ++length;
        int i = 0;
        while (i++ < length / 2 + length % 2) head = head.next;
        return head;
    }
}