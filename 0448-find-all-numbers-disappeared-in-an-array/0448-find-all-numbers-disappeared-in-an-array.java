class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int size = nums.length+1;
        int arr[] = new int[size];
        for(int i:nums)
        {
            arr[i] = 1;
        }
        for(int i=1;i<size;i++)
        {
            if(arr[i]==0)result.add(i);
        }
        return result;
    }
}