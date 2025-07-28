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
class Solution{
    public int all_path_sum(TreeNode root,ArrayList<Integer> arr)
    {
        if(root.left == null && root.right == null) return root.val;

        if(root.left != null && root.right != null)
        {
            int left = all_path_sum(root.left,arr);
            int right = all_path_sum(root.right,arr);
            int max = Math.max(left,right);
            arr.add(max);
            arr.add(max+root.val);
            // arr.add(root.val);
            arr.add(left+right+root.val);
            return(Math.max(root.val,max+root.val));
        }
        else if(root.left != null)
        {
            int left = all_path_sum(root.left,arr);
            arr.add(left);
            arr.add(left+root.val);
            // arr.add(root.val);
            return(Math.max(root.val,left+root.val));
        }
        else
        {
            int right = all_path_sum(root.right,arr);
            arr.add(right);
            arr.add(right+root.val);
            // arr.add(root.val);
            return(Math.max(root.val,right+root.val));
        }
    }
    public int maxPathSum(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(all_path_sum(root,arr));
        System.out.println(arr);
        return (Collections.max(arr));

    }
}