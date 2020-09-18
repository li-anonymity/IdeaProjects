package leetcode.stack.middle;

import common.TreeNode;

import java.util.*;

//二叉树的后序遍历
public class Solution_145 {
    //递归解法
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        helper(root);
//        return list;
//    }
//    public void helper(TreeNode root){
//        if(root == null){
//            return;
//        }
//        helper(root.left);
//        helper(root.right);
//        list.add(root.val);
//    }

    //栈解法1
//    public List<Integer> postorderTraversal(TreeNode root) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        LinkedList<Integer> output = new LinkedList<>();
//        if (root == null) {
//            return output;
//        }
//
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pollLast();
//            output.addFirst(node.val);
//            if (node.left != null) {
//                stack.add(node.left);
//            }
//            if (node.right != null) {
//                stack.add(node.right);
//            }
//        }
//        return output;
//    }

    //栈解法2 完全模拟递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if (curr != null){
                stack.push(curr);
                stack.push(null);
                if (curr.right != null){
                    stack.push(curr.right);
                }
                if(curr.left != null){
                    stack.push(curr.left);
                }
            }else{
                list.add(stack.pop().val);
            }
        }
        return list;
    }
}
