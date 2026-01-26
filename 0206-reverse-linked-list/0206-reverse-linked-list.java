/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previousNode=null;
        ListNode nextNode=null;
        while(head!=null)
        {
            nextNode=head.next;
            head.next=previousNode;
            previousNode=head;
            head=nextNode;

        }
        return(previousNode);
        
    }
}