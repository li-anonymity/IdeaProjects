package leetcode.stack.middle;

import java.util.Arrays;
import java.util.Stack;

//下一个更大元素②
public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        int [] arrResult= new int[nums.length];
        Arrays.fill(arrResult, -1);
        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index <= 2*(nums.length - 1); index++){
            while(!stack.empty() && nums[stack.peek()] < nums[index % nums.length]){
                arrResult[stack.pop()] = nums[index % nums.length];
            }
            stack.push(index % nums.length);
        }
        return arrResult;
    }
}
