package leetcode.stack.middle;

import java.util.Stack;

public class Solution_856 {
    public int scoreOfParentheses(String S) {
        //堆栈法
//        Stack<String> stack = new Stack<>();
//        for(Character s : S.toCharArray()){
//            if(s == ')'){
//                String top = stack.pop();
//                if("(".equals(top)){
//                    if(stack.empty() || "(".equals(stack.peek())){
//                        stack.push("1");
//                    }else{
//                        stack.push(Integer.toString(Integer.parseInt(stack.pop()) + 1));
//                    }
//                }else{
//                    stack.pop();
//                    if(stack.empty() || "(".equals(stack.peek())){
//                        stack.push(Integer.toString(Integer.parseInt(top)*2));
//                    }else{
//                        stack.push(Integer.toString(Integer.parseInt(stack.pop()) + Integer.parseInt(top)*2));
//                    }
//                }
//            }else{
//                stack.push("(");
//            }
//        }
//        return Integer.parseInt(stack.pop());
        //层级计算法 化整为零的思想
        int ans = 0,bal = 0;
        Character preChar = null;
        for(Character s : S.toCharArray()){
            if(s == '('){
                bal++;
            }else{
                bal--;
                if(preChar == '('){
                    ans += 1 << bal;
                }
            }
            preChar = s;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_856().scoreOfParentheses("((((((())))()())))"));
    }
}
