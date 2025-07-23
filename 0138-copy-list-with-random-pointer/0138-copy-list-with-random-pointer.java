/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map <Integer,Node> m1 = new HashMap<>();
        Map <Node,Integer> m2 = new HashMap<>();
        Map <Integer,Node> m3 = new HashMap<>();


        Node dummy = new Node(0);
        Node Copied_head = dummy;
        int i=0;
        while(head!=null)
        {
            Node node = new Node(head.val);
            dummy.next = node;
            dummy = dummy.next;
            m3.put(i,dummy);

            m2.put(head,i);
            m1.put(i,head.random);


            i++;
            head = head.next;
        }
        dummy = Copied_head.next;
        System.out.println(m2);
        System.out.println(m1);
        System.out.println(m3);
        for (int j=0;j<i;j++)
        {
            head = m1.get(j);
            if(head ==null)
            dummy.random =null;
            else
            dummy.random = m3.get(m2.get(head)); 
            dummy=dummy.next;
        }
        return(Copied_head.next);
    }
}