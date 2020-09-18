package leetcode.stack.middle;

import java.util.Stack;

//简化路径
public class Solution_71 {
    //使用堆栈
//    public String simplifyPath(String path) {
//        String strResult = "";
//        Stack<String> stack = new Stack();
//        for (String str : path.split("/")){
//            if(!"".equals(str) && !".".equals(str)){
//                if("..".equals(str)){
//                    if(!stack.empty()){
//                        stack.pop();

//                    continue;
//                }
//                stack.push(str);
//            }
//        }
//        for(String str : stack ){
//            strResult += '/';
//            strResult += str;
//        }
//        if (stack.empty()){
//            strResult += '/';
//        }
//        return strResult;
//    }

    //使用数组代替堆栈
    public String simplifyPath(String path) {
        String[] arrStr = path.split("/");
        int actualLength = 0;
        for(String str : arrStr){
            if(!"".equals(str) && !".".equals(str) && !"..".equals(str)){
                arrStr[actualLength++] = str;
            }else if("..".equals(str)){
                actualLength = (actualLength-1)>0?actualLength-1:0;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < actualLength; i++){
            stringBuilder.append("/").append(arrStr[i]);
        }
        if(stringBuilder.length() == 0){
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new  Solution_71().simplifyPath("/a/./b/../../c/"));
    }
}
