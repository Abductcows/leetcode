import static utils.LeetUtils.ListNode;

class Solution11111111111111 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode currentOdd = head;
        ListNode evenHead = head.next, currentEven = head.next;
        ListNode current = head.next.next;
        boolean oddI = true;

        while (current != null) {

            if (oddI) {
                currentOdd.next = current;
                currentOdd = current;
            } else {
                currentEven.next = current;
                currentEven = current;
            }
            current = current.next;
            oddI = !oddI;
        }
        currentOdd.next = evenHead;
        currentEven.next = null;
        return head;
    }
}