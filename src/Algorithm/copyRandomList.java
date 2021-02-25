package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。

 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

 返回复制链表的头节点。

 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

 val：一个表示 Node.val 的整数。
 random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 你的代码 只 接受原链表的头节点 head 作为传入参数。


 */
public class copyRandomList {

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int index = 0;
        List<Node> nodes = new ArrayList<>();
        Node h = new Node(temp.val);
        Node result = h;
        Node x = result;
        map.put(temp, index++);
        nodes.add(h);
        while (temp.next != null) {
            temp = temp.next;
            h.next = new Node(temp.val);
            h = h.next;
            map.put(temp, index++);
            nodes.add(h);
        }

        while (head != null) {
            if (head.random != null && map.containsKey(head.random)) {
                int temXp = map.get(head.random);
                result.random = nodes.get(temXp);
            }
            head = head.next;
            result = result.next;
        }

        return x;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.random = b;
        a.next = b;
        b.random = b;
        copyRandomList(a);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
