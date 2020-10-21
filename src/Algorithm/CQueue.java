package Algorithm;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * peek 返回栈顶值 pop 删除栈顶元素 返回值
 */

import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
//        while (!stack2.empty()) {
//            stack1.push(stack2.pop());
//        }
        stack1.push(value);
    }

    public int deleteHead() {
//        if (stack2.empty()) {
//            if (stack1.empty()) {
//                return -1;
//            } else {
//                while (!stack1.empty()) {
//                    stack2.push(stack1.pop());
//                }
//                return stack2.pop();
//            }
//        } else {
//            return stack2.pop();
//        }

        //上面代码优化
        if (!stack2.empty()) {
            return stack2.pop();
        }

        if (stack1.empty()) {
            return -1;
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
