import static utils.LeetUtils.ListNode;

class Solution444444444 {

    public ListNode middleNode(ListNode head) {
        int length = 0;
        for (ListNode counter = head; counter.next != null; counter = counter.next) ++length;
        int i = 0;
        while (i++ < length / 2 + length % 2) head = head.next;
        return head;
    }
}