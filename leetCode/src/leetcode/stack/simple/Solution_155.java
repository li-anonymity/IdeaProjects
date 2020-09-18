package leetcode.stack.simple;

import java.util.Stack;

//最小栈
class Solution_155 {
    //原解法
//    private Stack<Integer> stack = null;
//    private int cacheMin = 0;
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack();
//    }
//
//    public void push(int x) {
//        if(stack.empty()){
//            cacheMin = x;
//        }
//        cacheMin = Math.min(stack.push(x),cacheMin);
//    }
//
//    public void pop() {
//        if(stack.empty()?null:stack.pop() == cacheMin){
//            cacheMin = stack.empty()?0:stack.peek();
//            for (int i = 0; i < stack.size(); i++){
//                cacheMin = Math.min(stack.get(i),cacheMin);
//            }
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return cacheMin;
//    }

    //引入最小辅助栈，效率更低了
    private Stack<Integer> stack = null;
    private Stack<Integer> minStack = null;
    /** initialize your data structure here. */
    public Solution_155() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        if(stack.empty()){
            minStack.push(stack.push(x));
        }else{
            minStack.push(Math.min(stack.push(x),minStack.peek()));
        }
    }

    public void pop() {
        if(!stack.empty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution_155 object = new Solution_155();
        object.push(-2);
        object.push(0);
        object.push(-3);
        System.out.println(object.getMin());
        object.pop();
        System.out.println(object.top());
        System.out.println(object.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
