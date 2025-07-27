class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        for (int num : nums2)
        {
            while (!stk.isEmpty() && num > stk.peek())
            {
                map.put(stk.pop(), num);
            }
            stk.push(num);
        }
        while(!stk.isEmpty())map.put(stk.pop(),-1);
        
        for (int i =0;i<nums1.length;i++)
        {
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}