package Algorithm;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode root = head;
        int x = 0;
        while (l1 != null && l2 != null) {
            int a = l1.val + l2.val + x;
            x = 0;
            if (a >= 10) {
                x = 1;
                a = a-10;
            }
            head.next = new ListNode(a);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int a = l1.val + x;
            x = 0;
            if (a >= 10) {
                x = 1;
                a = a-10;
            }
            head.next = new ListNode(a);
            head = head.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int a = l2.val + x;
            x = 0;
            if (a >= 10) {
                x = 1;
                a = a-10;
            }
            head.next = new ListNode(a);
            head = head.next;
            l2 = l2.next;
        }

        if (x > 0) {
            head.next = new ListNode(x);
        }

        return root.next;
    }


}