class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subarray = 0;
        int n = nums.length,c=0;
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++)
        {
            if(nums[i] == 0)
            {
                System.out.println(i+ " "+c+1);
                c++;
                subarray+=c;
                continue;
            }
            c=0;
        }
        for(int i:arr)System.out.print(i+" ");
        return subarray;
    }
}