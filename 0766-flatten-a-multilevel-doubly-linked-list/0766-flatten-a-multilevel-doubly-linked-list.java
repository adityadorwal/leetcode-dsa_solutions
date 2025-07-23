/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// class Solution {
//     public Node lastnode(Node head)
//     {
//         Node curr = head , prevnode=null,temp;
//         while(curr!=null)
//         {
//             prevnode = curr;
//             if(curr.child == null)
//             curr = curr.next;
//             else
//             {
//                 temp = lastnode(curr.child);
//                 temp.next = curr.next;
//                 curr.next = curr.child;
//                 curr.child.prev = curr;
//                 curr.child = null;
//                 curr = temp.next;
//                 if(curr!=null)
//                 curr.prev = temp;
//                 prevnode = temp;
//             }
//         }
//         return prevnode;
//     }
//     public Node flatten(Node head) {
//         Node curr = head,temp=null;
//         while(curr!=null)
//         {
//             if(curr.child == null)
//             curr = curr.next;
//             else
//             {
//                 temp = lastnode(curr.child);
//                 temp.next = curr.next;
//                 curr.next = curr.child;
//                 curr.child.prev = curr;
//                 curr.child = null;
//                 curr = temp.next;
                
//                 if(curr!=null)
//                 curr.prev = temp;
//             }
//         }
//         return head;
//     }
// }


// Same Code with less size but still idk why it uses more memory

class Solution {
    public Node lastnode(Node head)
    {
        Node curr = head , prevnode=null,temp,nextnode;
        while(curr!=null)
        {
            prevnode = curr;
            if(curr.child == null)
            curr = curr.next;
            else
            {
                nextnode = curr.next;
                temp = lastnode(curr.child);
                temp.next = nextnode;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr = nextnode;

                if(curr!=null)
                curr.prev = temp;

                prevnode = temp;
            }
        }
        return prevnode;
    }
    public Node flatten(Node head) {
        lastnode(head);
        return head;
    }
}
