import static utils.LeetUtils.ListNode;

class SolutionNEEEEe {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(-777, head);
        ListNode parent = fakeHead;

        while (parent.next != null && parent.next.next != null) {

            ListNode child = parent.next;
            ListNode next = child.next;
            if (next.val != child.val) {
                parent = parent.next;
                continue;
            }

            while (parent.next != null && parent.next.next != null && parent.next.val == parent.next.next.val) {
                child = parent.next;
                next = child.next;
                while (next != null && next.val == child.val) {
                    next = next.next;
                }
                parent.next = next;
            }
        }

        return fakeHead.next;
    }
}