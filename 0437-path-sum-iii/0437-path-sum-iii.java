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
    int target;
    Map<Long, Integer> prefix = new HashMap<>();

    public int dfs(TreeNode node, long currSum) {
        if (node == null) return 0;

        currSum += node.val;

        int count = prefix.getOrDefault(currSum - target, 0);

        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum);
        count += dfs(node.right, currSum);

        prefix.put(currSum, prefix.get(currSum) - 1);

        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        prefix.put(0L, 1);
        return dfs(root, 0);
    }
}
