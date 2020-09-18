package leetcode.stack.simple;

import java.util.HashMap;
import java.util.Stack;

//下一个更大的元素I
public class Solution_496 {
    private HashMap<Integer,Integer> resultMapping = new HashMap<>();
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        getResultMapping(nums2);
        for(int i = 0; i < nums1.length; i++){
            if (resultMapping.containsKey(nums1[i])){
                nums1[i] = resultMapping.get(nums1[i]);
            }else{
                nums1[i] = -1;
            }
        }
        return nums1;
    }
    private void getResultMapping(int[] nums){
        Stack<Integer> stack = new Stack<>();
        for(int item : nums){
            while(!stack.empty() && (stack.peek() < item)){
                resultMapping.put(stack.pop(),item);
            }
            stack.push(item);
        }
    }
}
