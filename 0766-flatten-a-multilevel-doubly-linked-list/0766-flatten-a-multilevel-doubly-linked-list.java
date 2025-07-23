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
        lastnode(head);
        return head;
    }
}

// class Solution {
//     public Node flatten(Node head) {
//         flattenList(head);
//         return head;
//     }
//     private Node flattenList(Node head) {
//         Node curr = head;
//         Node last = null; // This will track the last node in the flattened list

//         while (curr != null) {
//             Node next = curr.next; // Store next node (because we might overwrite it)
            
//             // If current node has a child, we need to flatten the child list
//             if (curr.child != null) {
//                 // Recursively flatten the child list
//                 Node childHead = curr.child;
//                 Node childTail = flattenList(childHead); // Get the last node of the child list

//                 // Splice the child list into the main list

//                 // Connect current node to the head of the child list
//                 curr.next = childHead;
//                 childHead.prev = curr;

//                 // Clear the child pointer
//                 curr.child = null;

//                 // If the next node exists, connect it to the tail of the child list
//                 if (next != null) {
//                     childTail.next = next;
//                     next.prev = childTail;
//                 }

//                 // Move current pointer to next (after the inserted child list)
//                 last = childTail;
//                 curr = next; // Continue from where the child list ended
//             } else {
//                 // No child → just move to the next node
//                 last = curr;
//                 curr = next;
//             }
//         }

//         // Return the last node we reached (tail of the current flattened segment)
//         return last;
//     }
// }
