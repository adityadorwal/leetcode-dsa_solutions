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
    public TreeNode createTree(int[] nums, int start, int end)
    {
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(start==end)return root;
        if(start<end)
        {
            root.left = createTree(nums,start,mid-1);
            root.right = createTree(nums,mid+1,end);
            return root;
        }
        return null;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return(createTree(nums,0,nums.length-1));
    }
}