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
//************************************************Recursive Solution*********************************** */
class Solution {
    public boolean check(TreeNode leftroot,TreeNode rightroot)
    {
        if(leftroot == null && rightroot == null)return true;
        if((leftroot == null || rightroot == null) || (leftroot.val != rightroot.val))return false;
        return(check(leftroot.left,rightroot.right) && check(leftroot.right,rightroot.left));
    }
    public boolean isSymmetric(TreeNode root) {
        return (check(root.left,root.right));
    }
}

//***************************************************Iterative Solution********************************* */

// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return true;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root.left);
//         queue.add(root.right);

//         while (!queue.isEmpty())
//         {
//             TreeNode t1 = queue.poll();
//             TreeNode t2 = queue.poll();
//             if (t1 == null && t2 == null) continue;
//             if (t1 == null || t2 == null) return false;
//             if (t1.val != t2.val) return false;
//             queue.add(t1.left);
//             queue.add(t2.right);
//             queue.add(t1.right);
//             queue.add(t2.left);
//         }
//         return true;
//     }
// }
