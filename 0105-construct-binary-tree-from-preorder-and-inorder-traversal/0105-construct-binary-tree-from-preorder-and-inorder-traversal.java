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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stk.push(root);
        int k=0;

        for (int i=1;i<preorder.length;i++)
        {
            TreeNode node = new TreeNode(preorder[i]);
            if(stk.peek().val != inorder[k])
            {
                stk.peek().left = node;
                stk.push(node);
            }
            else
            {
                TreeNode temp = null;
                while((!stk.isEmpty()) && stk.peek().val == inorder[k])
                {
                    temp = stk.pop();
                    k++;
                }
                temp.right=node;
                stk.push(node);
            }
        }
        return root;
    }
}