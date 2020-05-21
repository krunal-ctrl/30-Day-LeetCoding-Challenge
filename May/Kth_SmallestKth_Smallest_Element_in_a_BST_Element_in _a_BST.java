/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
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
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k, new int[] {0});
    }
    private static int helper(TreeNode node, int k, int[] kth) {
        if (node.left != null) {
           int left = helper(node.left, k, kth);
            if (kth[0] == k)
                return left;
        }
        kth[0]++;
        if (kth[0] == k) 
            return node.val;
        if (node.right != null) {
            int right = helper(node.right, k, kth);
            if (kth[0] == k)
                return right;
        }
        return -1;
    }
}
