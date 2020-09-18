package leetcode.stack.middle;

import java.util.Stack;

//检查替换后的词是否有效
public class Solution_1033 {
    public boolean isValid(String s) {
        if (s.length() == 2){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c != 'c'){
                stack.push(c);
            }else{
                if(stack.empty() || stack.pop() != 'b'){
                    return false;
                }
                if (stack.empty() || stack.pop() != 'a'){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
