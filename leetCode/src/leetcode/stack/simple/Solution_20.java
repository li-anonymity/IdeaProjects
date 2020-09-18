package leetcode.stack.simple;

import java.util.HashMap;
import java.util.Stack;

//有效的括号
public class Solution_20 {
    //原方法
//    public boolean isValid(String s) {
//        if ("".equals(s)){
//            return true;
//        }
//
//        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()){
//            if (c == '(' || c == '{' || c == '['){
//                stack.push(c);
//            }
//            if (stack.empty()){
//                return false;
//            }
//            switch (c) {
//                case ')':
//                    if (stack.pop() != '(') {
//                        return false;
//                    }
//                    break;
//                case '}':
//                    if (stack.pop() != '{') {
//                        return false;
//                    }
//                    break;
//                case ']':
//                    if (stack.pop() != '[') {
//                        return false;
//                    }
//            }
//        }
//
//        if (!stack.empty()){
//            return false;
//        }
//        return true;
//    }

    //基于原方法的改进  更慢了，内存占用更多，可能是因为hashmap引入的复杂度
    //还有个改进方案是如果用数组模拟Stack，就能减少Stack的操作带来的性能损耗
    public boolean isValid(String s) {
        if ("".equals(s)){
            return true;
        }
        if (s.length() % 2 !=0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> characterCharacterHashMap = new HashMap<>();
        characterCharacterHashMap.put(')','(');
        characterCharacterHashMap.put(']','[');
        characterCharacterHashMap.put('}','{');
        for (char c : s.toCharArray()){
            if (!characterCharacterHashMap.containsKey(c)){
                stack.push(c);
                continue;
            }
            if(characterCharacterHashMap.get(c) != (stack.empty() ? '#' : stack.pop())){
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_20().isValid("()"));
    }
}
