class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i,n=nums.length,p,q,sum;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(i=0;i<n-2;i++)
        {
            if(nums[i]>0)break;
            if(i!=0 && nums[i]==nums[i-1])
            continue;
            p=i+1;
            q=n-1;
            while(p<q)
            {
                sum=nums[i]+nums[p]+nums[q];
                if(sum==0)
                {
                    result.add(Arrays.asList(nums[i],nums[p],nums[q]));
                    p++;
                    q--;
                    while(p<q && nums[p]==nums[p-1])p++;
                    while(p<q && nums[q]==nums[q+1])q--;
                }
                else if(sum<0)
                p++;
                else
                q--;
            }
        }
        return(result);
    }
}