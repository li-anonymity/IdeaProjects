package leetcode.stack.simple;

import java.util.Stack;

//利用栈实现队列
class Solution_232 {
    Stack<Integer> stack = null;
    Stack<Integer> reverseStack = null;
    /** Initialize your data structure here. */
    public Solution_232() {
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (reverseStack.empty()){
            while(!stack.empty()){
                reverseStack.push(stack.pop());
            }
        }
        return reverseStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (reverseStack.empty()){
            while(!stack.empty()){
                reverseStack.push(stack.pop());
            }
        }
        return reverseStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return reverseStack.empty() && stack.empty() ;
    }
}