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


 // ******************************REcursive Approch ***************************************************
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         ListNode curr = head,temp;
//         int i=1;
//         temp=curr;
//         while(curr!=null)
//         {
//             if(i==k)
//             {
//                 ListNode nextnode,prev=reverseKGroup(curr.next,k);
//                 while(i-- != 0)
//                 {
//                     nextnode = temp.next;
//                     temp.next = prev;
//                     prev = temp;
//                     temp = nextnode;
//                 }
//                 return prev;
//             }
//             i++;
//             curr = curr.next;
//         }
//         return head;
//     }
// }


//************************************Iterative Approch  *****************************************************

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy, curr = head;

        while (true)
        {
            ListNode temp = curr;
            int count = 0;
            while (temp != null && count < k)
            {
                temp = temp.next;
                count++;
            }
            if (count < k) break;
            ListNode prev = null, nextnode;
            ListNode groupStart = curr;
            for (int i = 0; i < k; i++)
            {
                nextnode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextnode;
            }
            prevGroupEnd.next = prev;
            groupStart.next = curr;
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }
}
