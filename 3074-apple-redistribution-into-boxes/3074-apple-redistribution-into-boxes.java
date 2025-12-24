class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int result;
        int sum=0;
        int k = capacity.length-1;
        for(int i:apple)
        {
            sum = sum+i;
            while(sum>0)sum = sum-capacity[k--];
        }
        return capacity.length-1-k;
    }
}