package leetcode.stack.simple;

import java.util.LinkedList;
import java.util.Queue;

//利用队列实现栈
class Solution_225 {
    //双队列实现
//    private Queue<Integer> queue = null;
//    private Queue<Integer> tempQueue = null;
//    private int top;
//    /** Initialize your data structure here. */
//    public Solution_225() {
//        queue = new LinkedList<>();
//        tempQueue = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        queue.add(x);
//        top = x;
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        while(queue.size() > 1){
//            top = queue.peek();
//            tempQueue.add(queue.remove());
//        }
//        int bResult = queue.remove();
//        //骚操作啊 避免了引用指向同一对象从而互相影响
//        Queue<Integer> temp = queue;
//        queue = tempQueue;
//        tempQueue = temp;
//        return bResult;
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return top;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue.isEmpty();
//    }

    //单队列实现
    private Queue<Integer> queue = null;
    private int top;
    /** Initialize your data structure here. */
    public Solution_225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for(int i = 0; i< queue.size() - 1; i++){
            top = queue.peek();
            queue.add(queue.remove());
        }
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Solution_225 a = new Solution_225();
        a.push(1);
        a.push(2);
        a.top();
        a.pop();
        a.empty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
