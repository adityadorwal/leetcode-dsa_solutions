class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length;
        Integer arr[] = new Integer[n];
        int result[] = new int[2];
        int k=0;
        for(int i=0;i<n;i++)
        {
            int num = nums[i];
            if(arr[num] != null)
            {
                result[k++] = num;
            }
            else
            arr[num] = num;
        }
        return result;
    }
}