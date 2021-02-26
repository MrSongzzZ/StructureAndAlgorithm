package Algorithm;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int index = 0;
        ListNode temp = head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode lastHead = result;
        while (head != null) {
            if (index < k) {//找n个出来
                head = head.next;
                index++;
            }
            if (index == k) {//开始翻转
                ListNode tempHead = null;
                ListNode r = temp;
                for (int i = 0; i < k; i++) {
                    ListNode tempNext = temp.next;
                    temp.next = tempHead;
                    tempHead = temp;
                    temp = tempNext;
                }
                r.next = head;
                lastHead.next = tempHead; //0>3
                index = 0;
                temp = head;
                lastHead = r;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode first = root;
        root.next = new ListNode(2);
        root = root.next;
        root.next = new ListNode(3);
        root = root.next;
        root.next = new ListNode(4);
        root = root.next;
        root.next = new ListNode(5);
        root = root.next;
        root.next = new ListNode(6);
        root = root.next;
        root.next = new ListNode(7);
        root = root.next;
        root.next = new ListNode(8);
        root = root.next;
        root.next = new ListNode(9);
        root = root.next;
        root.next = new ListNode(10);
        System.out.println(first);
//        reverseKGroup(first, 3);
        reverseKGroup(first, 2);
    }
}
