package leetcode.stack.simple;

import java.util.Stack;

// 删除字符串中的所有相邻重复项
public class Soulution_1047 {
    //原方法
//    public String removeDuplicates(String S) {
//        Stack<Character> stack = new Stack();
//        for(char c:S.toCharArray()){
//            if(!stack.empty() && c == stack.peek()){
//                stack.pop();
//            }else{
//                stack.push(c);
//            }
//        }
//        StringBuilder strBuilder = new StringBuilder();
//        for(char c : stack){
//            strBuilder.append(c);
//        }
//        return strBuilder.toString();
//    }

    //改进直接使用StringBuilder
    public String removeDuplicates(String S) {
        StringBuilder strBuilder = new StringBuilder();
        for(char c:S.toCharArray()){
            if((strBuilder.length() != 0) && (c == strBuilder.charAt(strBuilder.length()-1))){
                strBuilder.deleteCharAt(strBuilder.length()-1);
            }else{
                strBuilder.append(c);
            }
        }
        return strBuilder.toString();
    }
}
