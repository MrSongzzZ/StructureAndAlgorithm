package Algorithm;

import struts.ListNode;

/**
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
        ListNode root = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.getVal() > l2.getVal()) {
            root = l2;
            l2 = l2.getNext();
        } else {
            root = l1;
            l1 = l1.getNext();
        }

        ListNode head = root;

        while (l1 != null && l2 != null) {
            if (l1.getVal() > l2.getVal()) {
                root.setNext(l2);
                l2 = l2.getNext();
            } else {
                root.setNext(l1);
                l1 = l1.getNext();
            }
            root = root.getNext();
        }

        if (l1 != null) {
            root.setNext(l1);
        }

        if (l2 != null) {
            root.setNext(l2);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l1Next = new ListNode(1);
        l1 = l1Next;
        l1Next.setNext(new ListNode(2));
        l1Next = l1Next.getNext();
        l1Next.setNext(new ListNode(4));

        ListNode l2 = null;
        ListNode l2Next = new ListNode(1);
        l2 = l2Next;
        l2Next.setNext(new ListNode(3));
        l2Next = l2Next.getNext();
        l2Next.setNext(new ListNode(4));
        mergeTwoLists(null, null);
    }
}
