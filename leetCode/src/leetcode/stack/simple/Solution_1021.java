package leetcode.stack.simple;

import java.util.Stack;

//删除最外层的括号
public class Solution_1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder strBuilder = new StringBuilder();
        Stack<Character> stack = new Stack();
        for(char c : S.toCharArray()){
            if (c == ')'){
                if (stack.size() > 1) {
                    strBuilder.append(')');
                }
                stack.pop();
            }else{
                stack.push('(');
                if (stack.size() > 1) {
                    strBuilder.append('(');
                }
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1021().removeOuterParentheses("(()())(())(()(()))"));
    }
}
