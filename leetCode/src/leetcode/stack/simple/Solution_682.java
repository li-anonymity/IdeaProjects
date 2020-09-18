package leetcode.stack.simple;

import java.util.Stack;

//棒球比赛
public class Solution_682 {
    //原始解法
//    public int calPoints(String[] ops) {
//        int iResult = 0;
//        Stack<Integer> stack = new Stack();
//        for(String item : ops){
//            if ("C".equals(item)){
//                if (!stack.empty()){
//                    stack.pop();
//                }
//            }else if ("D".equals(item)){
//                if (stack.size() >0){
//                    stack.push(stack.peek()*2);
//                }else{
//                    stack.push(0);
//                }
//            }else if ("+".equals(item)){
//                if (stack.size() >=2){
//                    stack.push(stack.peek()+stack.get(stack.size()-2));
//                }else{
//                    stack.push(stack.peek());
//                }
//            }else{
//                int temp = Integer.parseInt(item);
//                stack.push(temp);
//            }
//        }
//        while(stack.size() > 0){
//            iResult += stack.pop();
//        }
//        return iResult;
//    }

    public int calPoints(String[] ops) {
        int iResult = 0;
        Stack<Integer> stack = new Stack();
        for(String item : ops){
            if ("C".equals(item)){
                if (!stack.empty()){
                    iResult -= stack.pop();
                }
            }else if ("D".equals(item)){
                if (stack.size() >0){
                    iResult += stack.push(stack.peek()*2);
                }else{
                    stack.push(0);
                }
            }else if ("+".equals(item)){
                int add = 0;
                if (stack.size() >=2){
                    add = stack.get(stack.size()-2);
                }
                iResult += stack.push(stack.peek() + add);
            }else{
                iResult += stack.push(Integer.parseInt(item));
            }
        }
        return iResult;
    }

    public static void main(String[] args) {
        String[] abc = {"5","2","C","D","+"};
        System.out.println(new Solution_682().calPoints(abc));
    }
}
