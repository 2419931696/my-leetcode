package com.example.myleetcode.offer2;

import com.example.myleetcode.data.structure.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution07 {

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length-1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preorderIndex, int start, int end, Map<Integer, Integer> map) {
        if(preorderIndex > preorder.length-1) {
            return null;
        }
        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);
        int index = map.get(rootValue);
        if(index < start || index > end) {
            return null;
        }
        root.left = buildTreeHelper(preorder, inorder, preorderIndex+1, start, index, map);
        root.right = buildTreeHelper(preorder, inorder, preorderIndex+index-start+1, index+1, end, map);
        return root;
    }

    @Test
    public void buildTreeTest() {
        TreeNode treeNode = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(treeNode);
    }
}
