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
    public void traversal(TreeNode root,ArrayList<Integer> temp)
    {
        if(root == null)return;
        if(root.left == null && root.right == null) temp.add(root.val);
        else
        {
            traversal(root.left,temp);
            traversal(root.right,temp);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        traversal(root1,arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        traversal(root2,arr2);
        if(arr1.size() != arr2.size())return false;
        for(int i=0;i<arr1.size();i++)
        {
            if(arr1.get(i)-arr2.get(i) != 0)return false;
        }
        return true;
    }
}