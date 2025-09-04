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

    public void dfs(Deque<Node> que,HashMap<Integer,Node> map)
    {
        if(que.isEmpty())return;

        Node temp=que.poll();
        Node node=map.get(temp.val);

        for(Node i:temp.neighbors)
        {
            int val = i.val;
            if(!map.containsKey(val))
            {
                Node new_node = new Node(val);
                que.offer(i);
                map.put(val,new_node);
            }
            node.neighbors.add(map.get(val));
        }
        dfs(que,map);
    }
    
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Node dummy = new Node(node.val);
        Deque<Node> que = new ArrayDeque<>();
        HashMap<Integer,Node> map = new HashMap<>();

        Node head=dummy;
        que.offer(node);
        
        map.put(node.val,dummy);
    
        dfs(que,map);

        return head;
    }
}