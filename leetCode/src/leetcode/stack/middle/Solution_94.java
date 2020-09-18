package leetcode.stack.middle;

//二叉树的中序遍历
import common.TreeNode;

import java.util.ArrayList;
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

//94. 二叉树的中序遍历
public class Solution_94 {
    //递归法
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        helper(root);
//        return list;
//    }
//    private void helper(TreeNode root){
//        if (root != null){
//            helper(root.left);
//            list.add(root.val);
//            helper(root.right);
//        }
//    }

    //迭代法 引入了Stack 运行时更消耗性能
    public List<Integer> inorderTraversal(TreeNode root) {
        //1.循环将左子树根节点赋值给当前节点
        //2.以当前节点为初始节点循环将当前节点推入栈，并将左子树节点赋值给当前节点
        //3.当当前节点为空时，结束循环后，弹出栈顶赋值给当前节点，取当前节点的值入队列
        //4.将当前节点的右分支根节点赋值给当前节点
        //5.只要当前节点不为空，或者栈不空，则当前节点不为空的情况下从2开始，为空时从3开始

        //二叉树遍历小技巧：左子树根节点和右子树根节点都先赋值给当前节点，在下次循环时再做对应处理
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !treeNodes.empty()){
            while(curr != null){
                treeNodes.push(curr);
                curr = curr.left;
            }
            curr = treeNodes.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    //莫尼斯遍历
}
