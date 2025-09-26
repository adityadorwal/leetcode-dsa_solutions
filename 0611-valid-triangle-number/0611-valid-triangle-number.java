class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int result=0;
        if(size<3)return 0;
        for(int i=0;i<size-2;i++)
        {
            for(int j=i+1;j<size-1;j++)
            {
                int sum = nums[i]+nums[j];
                int left = j+1;
                int right = size-1;
                while(left<=right)
                {
                    int mid = (left+right)/2;
                    if(nums[mid]>=sum) right=mid-1;
                    else left=mid+1;
                }
                result+=(right-j);
            }
        }
        return result;
    }
}