package leetcode.stack.middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//字符串解码
public class Solution_394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        LinkedList<Character> tempList = new LinkedList<>();
        Stack<Character> tempStack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(isCharacter(c) && tempStack.empty()){
                res.append(c);
                continue;
            }
            if(c != ']'){
                tempStack.push(c);
            }else{
                boolean onlyDigital = false;
                while(!tempStack.empty()){
                    if(onlyDigital){
                        int level = 0;
                        int sum = 0;
                        while (!tempStack.empty()){
                            if(isDigital(tempStack.peek())){
                                sum += (tempStack.pop() - '0')*Math.pow(10, level);
                                level++;
                            }else{
                                break;
                            }
                        }
                        List<Character> tmp = new LinkedList<>(tempList);
                        for(int i = 0; i < sum-1;i++){
                            tempList.addAll(tmp);
                        }
                        if(tempStack.empty()){
                            for(Character temp : tempList){
                                res.append(temp);
                            }
                        }else{
                            for(Character temp : tempList){
                                tempStack.push(temp);
                            }
                        }
                        tempList.clear();
                        break;
                    }
                    if(tempStack.peek() != '['){
                        tempList.addFirst(tempStack.pop());
                    }else{
                        tempStack.pop();
                        onlyDigital = true;
                    }
                }
            }
        }
        return res.toString();
    }

    public boolean isCharacter(Character c){
        return 'a' <= c && c <= 'z';
    }

    public boolean isDigital(Character c){
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println(new Solution_394().decodeString("100[leetcode]"));
    }
}
