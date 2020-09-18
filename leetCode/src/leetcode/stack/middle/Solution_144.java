package leetcode.stack.middle;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//144. 二叉树的前序遍历
public class Solution_144 {
    //使用递归的方式
//    List<Integer> listRes = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        helper(root);
//        return listRes;
//    }
//
//    private void helper(TreeNode root){
//        if(root != null){
//            listRes.add(root.val);
//            helper(root.left);
//            helper(root.right);
//        }
//    }
    //使用迭代的方式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> listRes = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> rightNodesStack = new Stack<>();
        while(curr != null || !rightNodesStack.empty()){
            while(curr != null){
                listRes.add(curr.val);
                if(curr.right != null){
                    rightNodesStack.push(curr.right);
                }
                curr = curr.left;
            }
            if (!rightNodesStack.empty()){
                curr = rightNodesStack.pop();
            }
        }
        return listRes;
    }
}
