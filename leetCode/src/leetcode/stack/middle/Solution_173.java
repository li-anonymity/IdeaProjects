package leetcode.stack.middle;

import common.TreeNode;
import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//173. 二叉搜索树迭代器
class Solution_173 {
    //没管是否二叉搜索树，使用了前序遍历
//    List<Integer> listRes = new ArrayList<>();
//    int index = 0;
//    public Solution_173(TreeNode root) {
//        helper(root,listRes);
//        listRes.sort(Comparator.comparingInt(Integer::intValue));
//    }
//    private void helper(TreeNode root,List<Integer> listRes){
//        if(root != null){
//            listRes.add(root.val);
//            helper(root.left,listRes);
//            helper(root.right,listRes);
//        }
//    }
//    /** @return the next smallest number */
//    public int next() {
//        return listRes.get(index++);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return index < listRes.size();
//    }

    //使用中序遍历
//    List<Integer> listRes = new ArrayList<>();
//    int index = 0;
//    public Solution_173(TreeNode root) {
//        helper(root,listRes);
//    }
//
//    private void helper(TreeNode root,List<Integer> listRes){
//        if(root != null){
//            helper(root.left,listRes);
//            listRes.add(root.val);
//            helper(root.right,listRes);
//        }
//    }
//    /** @return the next smallest number */
//    public int next() {
//        return listRes.get(index++);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return index < listRes.size();
//    }

    //基于中序遍历的思想再进行优化
//    Stack<TreeNode> stack = new Stack<>();
//    int index = 0;
//    public Solution_173(TreeNode root) {
//        TreeNode curr = root;
//        while(curr != null){
//            stack.push(curr);
//            curr = curr.left;
//        }
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        TreeNode nextNode = stack.pop();
//        TreeNode curr = nextNode.right;
//        while(curr != null){
//            stack.push(curr);
//            curr = curr.left;
//        }
//        return nextNode.val;
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.empty();
//    }

    //用数组模拟栈
    List<TreeNode> stack = new ArrayList<>();
    public Solution_173(TreeNode root) {
        _leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = stack.remove(stack.size()-1);
        _leftmostInorder(nextNode.right);
        return nextNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()!=0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */