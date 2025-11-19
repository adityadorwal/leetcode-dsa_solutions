class Solution {
    public int findFinalValue(int[] nums, int original) {
        int arr[] = new int[1001];
        for(int i:nums)arr[i]=1;
        while(original <= 1001 && arr[original] == 1)original *=2;
        return original;
    }
}