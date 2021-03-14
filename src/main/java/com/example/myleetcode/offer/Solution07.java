package com.example.myleetcode.offer;

import com.example.myleetcode.data.structure.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class Solution07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length, map);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preorderIndex, int inorderStart, int inorderEnd, Map<Integer, Integer> map) {
        if(preorderIndex >= preorder.length) {
            return null;
        }
        int curr = preorder[preorderIndex];
        TreeNode head = new TreeNode(curr);
        // 换成map
//        int mid = -1;
//        for (int i = inorderStart; i < inorderEnd; i++) {
//            if(inorder[i] == curr) {
//                mid = i;
//                break;
//            }
//        }
//        if(mid == -1) {
//            return null;
//        }
        int mid = map.get(curr);
        if(mid < inorderStart || mid > inorderEnd) {
            return null;
        }
        head.left = buildTreeHelper(preorder, inorder, preorderIndex+1, inorderStart, mid, map);
        head.right = buildTreeHelper(preorder, inorder, preorderIndex+(mid - inorderStart)+1, mid+1, inorderEnd, map);
        return head;
    }

    @Test
    public void buildTreeTest() {
        TreeNode treeNode = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(treeNode);
    }
}
