package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class MinStack {

    Stack<Integer> stack = null;
    Stack<Integer> stack1 = null;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(x, min);
        stack1.push(min);
    }

    public void pop() {
        stack1.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return !stack1.isEmpty()  ? stack1.peek() : 0;
    }
}
