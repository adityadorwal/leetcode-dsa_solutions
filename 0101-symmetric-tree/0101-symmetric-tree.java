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
    public boolean check(TreeNode leftroot,TreeNode rightroot)
    {
        if(leftroot == null && rightroot == null)return true;
        if((leftroot == null || rightroot == null) || (leftroot.val != rightroot.val))return false;
        return(check(leftroot.left,rightroot.right) && check(leftroot.right,rightroot.left));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null)return true;
        if(root.left == null || root.right == null)return false;
        return (check(root.left,root.right));
    }
}