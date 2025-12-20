class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i=0;
        int n=nums.length;
        int n1,n2;
        while(i<n)
        {
            int curr = nums[i];
            n1 = nums[i];
            while(i<n-1 && nums[i]+1==nums[i+1]) i++;
            n2 = nums[i];
            if(n1 == n2)result.add(Integer.toString(n1));
            else result.add(n1+"->"+n2);
            i++;
        }
        return result;
    }
}