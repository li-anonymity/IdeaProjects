package leetcode.stack.middle;

import java.util.LinkedList;
import java.util.Stack;

public class Solution_150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> integers = new LinkedList<>();
        int second = 0;
        int first = 0;
        for(String item : tokens){
            while(integers.size()<2){
                integers.addFirst(0);
            }
            if("+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item)){
                second = integers.pollLast();
                first = integers.pollLast();
                switch (item){
                    case "+":
                        integers.addLast(first + second);
                        break;
                    case "-":
                        integers.addLast(first - second);
                        break;
                    case "*":
                        integers.addLast(first * second);
                        break;
                    case "/":
                        integers.addLast(first / second);
                        break;
                }
            }else {
                integers.addLast(Integer.parseInt(item));
            }
        }
        return integers.pollLast();
    }

    public static void main(String[] args) {
        String[] Tokens = {"2","1","+","3","*"};
        System.out.println(new Solution_150().evalRPN(Tokens));
    }
}
