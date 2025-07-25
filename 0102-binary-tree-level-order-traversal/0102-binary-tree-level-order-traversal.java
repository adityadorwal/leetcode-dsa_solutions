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
   
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Queue<TreeNode> new_queue = new LinkedList<>();
            List<Integer> inner = new ArrayList<>();
            while(!queue.isEmpty())
            {
                TreeNode temp=queue.poll();
                if(temp.left!=null)new_queue.offer(temp.left);
                if(temp.right!=null)new_queue.offer(temp.right);
                inner.add(temp.val);
            }
            queue = new_queue;
            list.add(inner);
        }
        return list;
    }
}