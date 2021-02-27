package Algorithm;

public class middleNode {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
