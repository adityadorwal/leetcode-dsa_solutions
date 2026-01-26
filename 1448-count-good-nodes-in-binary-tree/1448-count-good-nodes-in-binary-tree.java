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
    public int traverse(TreeNode root , int max_val)
    {
        if(root == null)return 0;
        int k=0;
        if(root.val >= max_val)
        {
            max_val = root.val;
            k++;
        }
        return (traverse(root.left,max_val)+traverse(root.right,max_val)+k);
        
    }
    public int goodNodes(TreeNode root) {
        return traverse(root,root.val);
    }
}