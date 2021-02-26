package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 *
 */
public class rotateRight {

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        k = k % nodeList.size();
        if (k == 0) {
            return nodeList.get(0);
        }
        nodeList.get(nodeList.size() - 1).next = nodeList.get(0);
        if (k < nodeList.size()) {
            nodeList.get(nodeList.size() - 1 - k).next = null;
        }
        return nodeList.get(nodeList.size() - k);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode first = root;
        root.next = new ListNode(2);
//        root = root.next;
//        root.next = new ListNode(3);
//        root = root.next;
//        root.next = new ListNode(4);
//        root = root.next;
//        root.next = new ListNode(5);
//        root = root.next;
//        root.next = new ListNode(6);
//        root = root.next;
//        root.next = new ListNode(7);
//        root = root.next;
//        root.next = new ListNode(8);
//        root = root.next;
//        root.next = new ListNode(9);
//        root = root.next;
//        root.next = new ListNode(10);
        System.out.println(first);
//        reverseKGroup(first, 3);
        rotateRight(first, 2);
    }
}
