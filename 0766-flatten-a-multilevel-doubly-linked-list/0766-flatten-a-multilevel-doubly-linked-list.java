/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node lastnode(Node head)
    {
        Node curr = head , prevnode=null,temp;
        while(curr!=null)
        {
            prevnode = curr;
            if(curr.child == null)
            curr = curr.next;
            else
            {
                temp = lastnode(curr.child);
                temp.next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr = temp.next;
                if(curr!=null)
                curr.prev = temp;
                prevnode = temp;
            }
        }
        return prevnode;
    }
    public Node flatten(Node head) {
        Node curr = head,temp=null;
        while(curr!=null)
        {
            if(curr.child == null)
            curr = curr.next;
            else
            {
                temp = lastnode(curr.child);
                temp.next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr = temp.next;
                
                if(curr!=null)
                curr.prev = temp;
            }
        }
        curr = head;
        while(curr != null)
        {
            System.out.print(curr.val+" ");
            temp = curr;
            curr = curr.next;
        }
        System.out.println(curr);
        while(temp != head && temp!=null)
        {
            System.out.print(temp.val+" ");
            temp = temp.prev;
        }
        return head;
    }
}