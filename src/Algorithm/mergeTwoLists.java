package Algorithm;

/**
 * q21
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class mergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode result = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        while (l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l1Next = new ListNode(1);
        l1 = l1Next;
        l1Next.next = new ListNode(2);
        l1Next = l1Next.next;
        l1Next.next = new ListNode(4);

        ListNode l2 = null;
        ListNode l2Next = new ListNode(1);
        l2 = l2Next;
        l2Next.next = new ListNode(3);
        l2Next = l2Next.next;
        l2Next.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }
}
