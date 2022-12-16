import java.util.ArrayDeque;

import static utils.LeetUtils.ListNode;

class SolutionRoyale {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ArrayDeque<ListNode> lastN = new ArrayDeque<>();
        if (n == 1 && head.next == null) return null;

        ListNode fakeHead = new ListNode(0, head);
        for (ListNode current = fakeHead; current.next != null; current = current.next) {
            if (lastN.size() == n) {
                lastN.removeLast();
            }
            lastN.addFirst(current);
        }

        ListNode parent = lastN.removeLast();
        ListNode child = lastN.pollLast();

        if (child != null) {
            parent.next = child.next;
        } else {
            parent.next = null;
        }

        if (parent == fakeHead) {
            return fakeHead.next;
        }
        return head;
    }

}