package com.company;

import java.util.*;

class Solution {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, HashSet<Integer>> map= new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new HashSet<Integer>());
            }
            map.get(nums[i]).add(i);
        }
        int count = 0;
        Set<Integer> keys=map.keySet();
        for(Integer key:keys){
            HashSet<Integer> value=map.get(key);
            count += value.size()*(value.size()-1)/2;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1,1,3};
        System.out.println(Solution.numIdenticalPairs(nums));
    }
}
