package com.source;

import com.component.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Tree {
    static void traversal(TreeNode root, ArrayList<Integer> list){
        if(root == null){return;}
        traversal(root.left, list);

        traversal(root.right, list);
        list.add(root.val);
    }

    static ArrayList<TreeNode>  preorder(TreeNode root){
        ArrayList<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }

    static ArrayList<TreeNode> inorder(TreeNode root){
        ArrayList<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur);
                cur = cur.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(4);
        TreeNode left = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        ArrayList<TreeNode> list = inorder(root);
//        traversal(root,list);
        for(TreeNode i :list){
            System.out.print(i.val+" ");
        }
    }
}
