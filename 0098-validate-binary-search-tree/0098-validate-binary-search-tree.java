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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode temp = null;
        while(root != null || !stk.isEmpty())
        {
            while(root!=null)
            {
                stk.push(root);
                root= root.left;
            }
            root = stk.pop();
            if (temp!=null && temp.val>=root.val)return false;
            temp = root;
            root = temp.right;
        }
        return true;
    }
}