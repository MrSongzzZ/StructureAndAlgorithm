package Algorithm;

import java.util.Stack;

public class mergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {
        Stack<ListNode> nodes = new Stack<>();
        for (int i = 0; i < lists.length; i+=2) {
            if (i + 1 >= lists.length) {
                nodes.push(lists[i]);
                break;
            } else {
                nodes.push(mergeK(lists[i], lists[i + 1]));
            }
        }

        while (nodes.size() > 1) {
            ListNode a = nodes.pop();
            ListNode b = nodes.pop();
            nodes.push(mergeK(a, b));
        }
        return nodes.size() > 0 ? nodes.pop() : null;
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) {
//            return null;
//        }
//        if (lists.length == 1) {
//            return lists[0];
//        }
//        ListNode head = mergeK(lists[0], lists[1]);
//        for (int i = 2; i < lists.length; i++) {
//            head = mergeK(head, lists[i]);
//        }
//        return head;
//    }
//
    public ListNode mergeK(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode root = new ListNode(0);
        ListNode pre = root;
        while (a != null && b != null) {
            if (a.val > b.val) {
                root.next = b;
                b = b.next;
            } else {
                root.next = a;
                a = a.next;
            }
            root = root.next;
        }
        while (a != null) {
            root.next = a;
            a = a.next;
            root = root.next;
        }

        while (b != null) {
            root.next = b;
            b = b.next;
            root = root.next;
        }

        return pre.next;
    }
}
