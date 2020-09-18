package leetcode.stack.middle;

import common.tools.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//链表中的下一个更大节点
public class Solution_1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> valueList = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        int index = 0;
        while(curr != null){
            valueList.add(curr.val);
            resList.add(0);
            if(!stack.empty() && valueList.get(stack.peek()) < curr.val){
                resList.set(stack.pop(),curr.val);
            }
            stack.push(index++);
            curr = curr.next;
        }
        int[] res = new int[resList.size()];
        for(int i =0; i< res.length; i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
