package leetcode.stack.middle;

import java.util.Stack;

//739.每日温度
public class Solution_739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
//        Stack<Integer> stack = new Stack<>();
//        for(int i = 0; i < T.length; i++){
//            while (true){
//                if(stack.empty()){
//                    stack.push(i);
//                    break;
//                }else{
//                    int topIndex = stack.peek();
//                    if(T[topIndex] < T[i]){
//                        res[stack.pop()] = i - topIndex;
//                    }else{
//                        stack.push(i);
//                        break;
//                    }
//                }
//            }
//        }
        //使用数组模拟栈
//        int[] stack = new int[T.length];
//        int currTop = 0;
//        stack[currTop] = 0;
//        for(int i = 1; i < T.length; i++){
//            while(currTop > -1 && T[stack[currTop]] < T[i]){
//                res[stack[currTop]] = i - stack[currTop--];;
//            }
//            stack[++currTop] = i;
//        }
//        return res;

        //以上都是单调栈的解法，下面使用kmp算法
        res[T.length-1] = 0;
        for(int i = T.length -2; i>=0; i--){
            int skip = 1;
            while(T[i] > T[i+skip]){
                skip = skip + res[i+skip];
                if(res[i+skip] == 0){
                    break;
                }
            }
            if(res[i+skip] == 0){
                res[i] = 0;
            }else {
                res[i] = skip;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {73,74,75,71,69,72,76,73};
        int[] res = new Solution_739().dailyTemperatures(a);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
