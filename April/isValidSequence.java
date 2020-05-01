/*
link : https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null)
            return arr.length == 0;
       return isValid(root, arr, 0);
    }
    
    private static boolean isValid(TreeNode node, int[] arr,int i){
        // check for the value
        if (node.val != arr[i])
            return false;
        
        // if it is last compaarision it must be leaf
        if(i == arr.length -1)
            return node.left == null && node.right == null;
        
        // traveling left node
        if(node.left != null && isValid(node.left, arr, i+1))
            return true;
        
        // traveling right node
        if(node.right != null && isValid(node.right, arr, i+1))
            return true;
        return false;
    }
}
