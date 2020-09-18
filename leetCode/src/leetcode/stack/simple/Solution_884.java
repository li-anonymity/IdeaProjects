package leetcode.stack.simple;

import java.util.Stack;

//比较含退格的字符串
public class Solution_884 {
    public boolean backspaceCompare(String S, String T) {
        boolean bResult = false;
        Stack<Character> SStack= new Stack<Character>();
        Stack<Character> TStack= new Stack<Character>();
        for(int i=0;i< S.length();i++){
            char a = S.charAt(i);
            if ('#' == a) {
                if(!SStack.isEmpty()){
                    SStack.pop();
                }
            }else {
                SStack.push(a);
            }
        }
        for(int i=0;i< T.length();i++){
            char a = T.charAt(i);
            if ('#' == a) {
                if(!TStack.isEmpty()){
                    TStack.pop();
                }
            }else {
                TStack.push(a);
            }
        }
        bResult = SStack.equals(TStack);
        return bResult;
    }

    public static void main(String[] args) {
        System.out.println("result is " + new Solution_884().backspaceCompare("ab##","c#d#"));
    }
}
