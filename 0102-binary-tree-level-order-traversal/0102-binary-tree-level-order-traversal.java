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
        int i,queue_size;
        while(!queue.isEmpty())
        {
            queue_size = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(i=0;i<queue_size;i++)
            {
                TreeNode temp=queue.poll();
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
                inner.add(temp.val);
            }
            list.add(inner);
        }
        return list;
    }
}