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
 /**************************************Solution Using Stack *************************** */
// class Solution {
//     public void reorderList(ListNode head) {
//         ListNode slow=head,fast=head;
//         Stack<ListNode> stk = new Stack<>();
//         stk.push(slow);

//         while(fast.next != null && fast.next.next != null)
//         {
//             slow=slow.next;
//             stk.push(slow);
//             fast = fast.next.next;
//         }
//         slow = slow.next;
//         ListNode last=null;

//         if(fast.next != null)
//         {
//             last = slow;;
//             slow=slow.next;
//             last.next = null;
//         }
//         while(slow!=null)
//         {
//             ListNode prev = stk.pop();
//             prev.next = last;
//             last = slow;
//             slow = slow.next;
//             last.next = prev;
//         }
//         head.next = last;
//     }    
// }



/************************************Solution by reversing the second half and merging it ********************** */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow.next;
        slow.next = null;

        while (curr != null)
        {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode first = head, second = prev;
        while (second != null)
        {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}
