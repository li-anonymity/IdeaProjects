package leetcode.stack.middle;

import java.util.Stack;

//移掉k位数字
public class Solution_402 {
    //使用Stack消耗性能
//    public String removeKdigits(String num, int k) {
//        if(num.length() == k){
//            return "0";
//        }
//        Stack<Character> stack = new Stack<>();
//        int count = 0;
//        for(Character c: num.toCharArray()){
//            while(count < k && !stack.empty() && c < stack.peek() ){
//                stack.pop();
//                count++;
//            }
//            stack.push(c);
//        }
//        for (int i = k - count;i>0;i--){
//            stack.pop();
//        }
//        StringBuilder strBuilder = new StringBuilder();
//        boolean Nan0Checked = false;
//        for (Character c: stack){
//            if(c != '0'){
//                Nan0Checked = true;
//            }
//            if (Nan0Checked){
//                strBuilder.append(c);
//            }else{
//                continue;
//            }
//        }
//        if(strBuilder.length() == 0 ){
//            return "0";
//        }
//        return strBuilder.toString();
//    }

    //直接使用StringBuilder构造
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        StringBuilder strBuilder = new StringBuilder();
        int count = 0;
        for(Character c: num.toCharArray()){
            while(count < k && strBuilder.length() != 0 && c < strBuilder.charAt(strBuilder.length()-1)){
                strBuilder.deleteCharAt(strBuilder.length()-1);
                count++;
            }
            strBuilder.append(c);
        }
        for (int i = k - count;i>0;i--){
            strBuilder.deleteCharAt(strBuilder.length()-1);
        }
        while(strBuilder.length()>0){
            if(strBuilder.charAt(0) == '0' && strBuilder.length() != 1){
                strBuilder.deleteCharAt(0);
            }else{
                break;
            }
        }
        return strBuilder.toString();
    }
}
