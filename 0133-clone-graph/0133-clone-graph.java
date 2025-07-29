/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        if(node == null)return null;

        map.put(node,new Node(node.val));
        queue.offer(node);


        while(!queue.isEmpty())
        {
            int len = queue.peek().neighbors.size();
            Node curr_node = queue.poll();

            for(int i=0;i<len;i++)
            {
                Node neigh = curr_node.neighbors.get(i);

                if(map.containsKey(neigh))
                map.get(curr_node).neighbors.add(map.get(neigh));
                else
                {
                    Node copied_node = new Node(neigh.val);
                    map.get(curr_node).neighbors.add(copied_node);
                    queue.offer(neigh);
                    map.put(neigh,copied_node);
                }
            }
        }
        return map.get(node);
    }
}