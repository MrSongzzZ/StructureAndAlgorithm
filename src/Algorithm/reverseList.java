package Algorithm;

import struts.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * 0 <= 节点个数 <= 5000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode root = null;
        while (head != null) {
            ListNode temp = head.getNext();
            head.setNext(root);
            root = head;
            head = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.setNext(new ListNode(2));
        ListNode next = root.getNext();
        next.setNext(new ListNode(3));
        next = next.getNext();
        next.setNext(new ListNode(4));
        next = next.getNext();
        next.setNext(new ListNode(5));
        root = reverseList(root);
        System.out.println("end");
    }
}
