package leetcode.stack.middle;

public class Solution_456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length == 0){
            return false;
        }
        int min = nums[0],pre = nums[0];
        for (int i=1;i<nums.length;i++){
            int curr = nums[i];
            if(curr < pre && curr > min){
                System.out.println(min+" " +pre +" "+curr);
                return true;
            }
            pre = curr;
            min = Math.min(curr,min);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={-1,3,2,0};
        new Solution_456().find132pattern(nums);
    }
}
