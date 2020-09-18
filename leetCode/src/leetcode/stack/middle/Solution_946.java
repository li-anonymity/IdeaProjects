package leetcode.stack.middle;

import java.util.Stack;

//验证栈序列
public class Solution_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int currIndex = 0;
        for(int i=0;i<pushed.length;i++){
            if(pushed[i] != popped[currIndex]){
                stack.push(pushed[i]);
                continue;
            }
            currIndex++;
            while(!stack.empty() && stack.peek() == popped[currIndex]){
                stack.pop();
                currIndex++;
            }
        }
        return stack.empty();
    }
}
