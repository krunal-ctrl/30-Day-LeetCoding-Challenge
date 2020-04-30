/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;    
        for(int i=0;i<preorder.length;i++){
           root = tree(root,preorder[i]);
        }
        return root;
    }
    
    private static TreeNode tree (TreeNode root,int n){
        
        if(root==null){
            TreeNode temp=new TreeNode(n);
            return temp;
        }
        
        if(root.val > n)
            root.left=tree(root.left,n);
        else
            root.right=tree(root.right,n);
        
        return root;
    }
        
}
