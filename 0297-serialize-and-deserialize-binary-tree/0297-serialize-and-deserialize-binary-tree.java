// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */

//***********************Working but uses more space and time complexity******************** */
// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         if(root == null)return"null";
//         String str="";
//         queue.offer(root);
//         str += Integer.toString(root.val);

//         while(!queue.isEmpty())
//         {
//             int size = queue.size();
//             for(int i=0;i<size;i++)
//             {
//                 TreeNode temp = queue.poll();
//                 if(temp.left!=null)
//                 {
//                     queue.offer(temp.left);
//                     str += ","+Integer.toString(temp.left.val);
//                 }
//                 else
//                 str += ",null";
//                 if(temp.right!=null)
//                 {
//                     queue.offer(temp.right);
//                     str += ","+Integer.toString(temp.right.val);
//                 }
//                 else
//                 str += ",null";
//             }
//         }
//         return str;
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         String [] result = data.split(",");
//         if(result[0] .equals("null"))return null;

//         TreeNode root = new TreeNode(Integer.parseInt(result[0]));

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         int k=1;
//         while(!queue.isEmpty())
//         {
//             int size = queue.size();
//             for(int i=0;i<size;i++)
//             {
//                 TreeNode node = queue.poll();
//                 if(result[k].equals("null"))node.left = null;
//                 else
//                 {
//                     TreeNode new_left_node = new TreeNode(Integer.parseInt(result[k]));
//                     node.left = new_left_node;
//                     queue.offer(new_left_node);
//                 }
//                 k++;
//                 if(result[k].equals("null"))node.right = null;
//                 else
//                 {
//                     TreeNode new_right_node = new TreeNode(Integer.parseInt(result[k]));
//                     node.right = new_right_node;
//                     queue.offer(new_right_node);
//                 }
//                 k++;
//             }
//         }
//         return root;
//     }
// }

// // Your Codec object will be instantiated and called as such:
// // Codec ser = new Codec();
// // Codec deser = new Codec();
// // TreeNode ans = deser.deserialize(ser.serialize(root));


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 //**************************More ENhanced and fast version************************** */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if (node == null)
            {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        String[] parts = sb.toString().split(",");
        int end = parts.length - 1;
        while (end >= 0 && parts[end].equals("null"))
        {
            end--;
        }

        return String.join(",", Arrays.copyOfRange(parts, 0, end + 1));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < parts.length)
        {
            TreeNode node = queue.poll();

            if (i < parts.length && !parts[i].equals("null"))
            {
                node.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(node.left);
            }
            i++;

            if (i < parts.length && !parts[i].equals("null"))
            {
                node.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
