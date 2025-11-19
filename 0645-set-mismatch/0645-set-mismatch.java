class Solution {
    public int[] findErrorNums(int[] nums) {
        int size = nums.length+1;
        int arr[] = new int[size];
        for(int i:nums)
        {
            if(arr[i]==1)arr[i]=-1;
            else arr[i]=1;
        }
        int result[] = new int[2];
        for(int i=0;i<size;i++)
        {
            if(arr[i]==-1)result[0]=i;
            else if(arr[i]==0) result[1]=i;
        }
        return result;
    }
}