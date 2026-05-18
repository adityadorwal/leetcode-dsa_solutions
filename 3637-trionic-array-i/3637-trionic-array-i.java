class Solution {
    public boolean isTrionic(int[] nums) {
        int a=0;
        int n = nums.length;
        while(a+1<n && nums[a]<nums[a+1])a++;
        if(a==0 || (a+1<n && (nums[a]==nums[a+1])))return false;
        int b=a;
        while(b+1<n && nums[b]>nums[b+1])b++;
        if(b==a || (b+1<n && (nums[b]==nums[b+1])))return false;
        int c=b;
        while(c+1<n && nums[c]<nums[c+1])c++;
        if(c==b || (c+1<n && (nums[c]==nums[c+1])))return false;
        return (c==n-1);
    }
}