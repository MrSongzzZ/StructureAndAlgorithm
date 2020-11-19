package Algorithm;

import struts.ListNode;

/**
 * k个一组翻转链表
 * 1-2-3-4-5  k=3
 * 2-1-3-4-5
 *
 * 1-2-3-4-5  k=2
 * 3-2-1-4-5
 *
 */
public class KreverseLinkNode {

    public static ListNode reverse(ListNode root, int k) {

        int x = 0;
        ListNode temp = null;
        ListNode preTemp = null;
        ListNode head = null;
        while (root != null) {
            if (x == 0) {
                temp = root;
            }
            x++;
            ListNode rootNext = root.getNext();
            if (x == k) {
                ListNode now = temp;//当前节点
                ListNode preNode = preTemp;//当前节点上一个节点
                ListNode tempPre = null;
                ListNode tempHead = null;
                while (x > 0) {
                    x--;
                    if (tempPre == null) {
                        tempPre = now;
                    }
                    ListNode next = now.getNext();
                    now.setNext(preNode);
                    preNode = now;
                    now = next;
                    if (preTemp == null && x == 0) {
                        head = preNode;

                    }
                    if (x == 0) {
                        tempHead = preNode;
                    }

                }
                if (preTemp != null) {
                    preTemp.setNext(tempHead); //当前分段的头节点
                }
                preTemp = tempPre;
                preTemp.setNext(rootNext);//当前分段的尾节点
            }
            root = rootNext;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode first = root;
        root.setNext(new ListNode(2));
        root = root.getNext();
        root.setNext(new ListNode(3));
        root = root.getNext();
        root.setNext(new ListNode(4));
        root = root.getNext();
        root.setNext(new ListNode(5));
        root = root.getNext();
        root.setNext(new ListNode(6));
        root = root.getNext();
        root.setNext(new ListNode(7));
        root = root.getNext();
        root.setNext(new ListNode(8));
        root = root.getNext();
        root.setNext(new ListNode(9));
        root = root.getNext();
        root.setNext(new ListNode(10));
        System.out.println(first);
//        reverse(first, 3);
        reverse(first, 2);
    }
}
