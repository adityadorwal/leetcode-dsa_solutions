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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        // System.out.println(root.val+ " " + targetSum);
        if(root.left == null && root.right == null && targetSum-root.val == 0)return true;
        boolean l1=false,l2=false;
        if(root.left!=null)l1 = hasPathSum(root.left,targetSum-root.val);
        if(root.right!=null)l2 = hasPathSum(root.right,targetSum-root.val);
        return(l1 || l2);
    }
}