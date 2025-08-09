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

//************************** DFS Approch ****************************** */
// class Solution {
//     public int minDepth(TreeNode root) {
//         if(root == null)
//         return 0;
//         int left = minDepth(root.left);
//         int right = minDepth(root.right);
//         if(left == 0 && right == 0)return 1;
//         if(left == 0)return right+1;
//         if(right == 0)return left+1;
//         return (Math.min(left,right)+1);
//     }
// }

//*****************************BFS Approch************************************** */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
