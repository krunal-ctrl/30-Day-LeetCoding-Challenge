/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Note:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int genPop = 1;
        while (!queue.isEmpty()) {
            if (genPop == 0) {
                genPop = queue.size();
            }
            TreeNode n = queue.remove();
            genPop--;
            int target = -1;
            if (n.left != null) {
                if (n.left.val == x) {
                    target =  y;
                } else if (n.left.val == y) {
                    target = x;
                } else {
                queue.add(n.left);
                }
            }
                
            if (n.right != null) {
                if (n.right.val == target) return false;
                
                if (n.right.val == x) {
                    target =  y;
                } else if (n.right.val == y) {
                    target = x;
                } else {
                queue.add(n.right);
                }
            }
            
            if (target != -1) {
                while (genPop > 0) {
                    n = queue.remove();
                    genPop--;
                    if (n.left != null && n.left.val == target) return true;
                    if (n.right != null && n.right.val == target) return true;
                }
                return false;
            }
        }
        return false;
    }
}
