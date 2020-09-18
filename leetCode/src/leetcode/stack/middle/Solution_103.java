package leetcode.stack.middle;

import common.tools.ConvertArrTo2xTree;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//二叉树的锯齿形层次遍历
public class Solution_103 {
    //使用Stack，很慢
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        if(root == null){
//            return new ArrayList<List<Integer>>();
//        }
//        List<List<Integer>> listResult = new ArrayList<List<Integer>>();
//        boolean left_to_right = true;//当前层是否从左至右遍历
//        Stack<TreeNode> stack_l_to_r = new Stack<>();//存储从先入左节点，后入右节点的层
//        Stack<TreeNode> stack_r_to_l = new Stack<>();//存储从先入右节点，后入左节点的层
//        stack_r_to_l.push(root);
//        List<Integer> levelList = new ArrayList<>();
//        while (!stack_l_to_r.empty() || !stack_r_to_l.empty()){
//            if(left_to_right){
//                while(!stack_r_to_l.empty()){
//                    TreeNode tempNode = stack_r_to_l.pop();
//                    levelList.add(tempNode.val);
//                    if(tempNode.left != null){
//                        stack_l_to_r.push(tempNode.left);
//                    }
//                    if(tempNode.right != null){
//                        stack_l_to_r.push(tempNode.right);
//                    }
//                }
//            }else{
//                while(!stack_l_to_r.empty()){
//                    TreeNode tempNode = stack_l_to_r.pop();
//                    levelList.add(tempNode.val);
//                    if(tempNode.right != null){
//                        stack_r_to_l.push(tempNode.right);
//                    }
//                    if(tempNode.left != null){
//                        stack_r_to_l.push(tempNode.left);
//                    }
//                }
//            }
//            listResult.add(levelList);
//            levelList = new ArrayList<>();
//            left_to_right = !left_to_right;
//        }
//        return listResult;
//    }

    //改进，使用双端队列
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> listResult = new ArrayList<List<Integer>>();
        List<TreeNode> nodes_queue = new ArrayList<>();
        LinkedList<Integer> level_list = new LinkedList<>();
        nodes_queue.add(root);
        nodes_queue.add(null);
        boolean left_to_right = true;
        while(nodes_queue.size() != 0){
            TreeNode currNode = nodes_queue.remove(0);
            if (currNode != null){
                if(left_to_right){
                    level_list.addLast(currNode.val);
                }else{
                    level_list.addFirst(currNode.val);
                }

                if(currNode.left != null){
                    nodes_queue.add(currNode.left);
                }
                if(currNode.right != null){
                    nodes_queue.add(currNode.right);
                }
            }else{
                left_to_right = !left_to_right;
                if(nodes_queue.size() != 0){
                    nodes_queue.add(null);
                }
                listResult.add(level_list);
                level_list = new LinkedList<>();
            }
        }
        return listResult;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,9,20,null,null,15,7};
        TreeNode treeNode = ConvertArrTo2xTree.convert(array);
        System.out.println(new Solution_103().zigzagLevelOrder(treeNode));
    }
}
