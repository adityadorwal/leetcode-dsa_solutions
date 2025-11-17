class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[n+n];
        int k=0;
        for(int i=0;i<(n+n);i+=2)
        {
            arr[i]=nums[k];
            arr[i+1]=nums[k+n];
            k++;
        }
        return arr;
    }
}