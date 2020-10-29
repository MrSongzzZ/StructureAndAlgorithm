package Algorithm;

import struts.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *  示例：
 *
 *  给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 *  返回链表 4->5.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class getKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        //第一种方法 遍历 寻找
//        ListNode root = head;
//        List<ListNode> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head);
//            head = head.getNext();
//        }
//        return list.get(list.size() - k);


        //第二种方法 双指针
        ListNode root = head;
        while (k > 0) {
            head = head.getNext();
            k--;
        }
        while (head != null) {
            head = head.getNext();
            root = root.getNext();
        }
        return root;
    }
}
