package Algorithm;

public class deleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode temp = head;
        ListNode pre;
        while (head.next != null) {
            pre = head;
            head = head.next;
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
        }
        return temp;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
