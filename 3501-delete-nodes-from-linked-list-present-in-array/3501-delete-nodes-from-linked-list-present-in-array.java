// Alternate approach (skip head first)
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> remove = new HashSet<>();
        for (int x : nums) remove.add(x);
        // Skip initial nodes
        while (head != null && remove.contains(head.val)) {
            head = head.next;
        }
        // Now head is either null or first node to keep
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (remove.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
