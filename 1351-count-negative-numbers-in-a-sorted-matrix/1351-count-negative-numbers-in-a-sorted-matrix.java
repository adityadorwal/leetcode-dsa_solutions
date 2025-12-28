class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int j=0;
        int result = 0;
        for(int i = m-1;i>=0;i--)
        {
            while(j<n && grid[i][j]>=0)j++;
            if(j==n)break;
            else result += n-j;
        }
        return result;
    }
}