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
    public boolean search_under_root(TreeNode root, TreeNode s)
    {
        if(root == null)return false;
        if(root == s)return true;
        return(search_under_root(root.left,s) || search_under_root(root.right,s));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if((root == p))return root;
        if((root == q))return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)return(root);
        if(left != null)return left;
        if(right != null)return right;
        return null;
    }
}