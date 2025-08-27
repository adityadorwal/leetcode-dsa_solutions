class Solution {
    public int dfs(int[][] grid , int i ,int j , int r_len ,  int c_len)
    {
        if(i<0 || j<0 || i>=r_len || j>=c_len || grid[i][j]==0)return 0;
        grid[i][j]=0;
        return (1+
        dfs(grid,i+1,j,r_len,c_len)+
        dfs(grid,i,j+1,r_len,c_len)+
        dfs(grid,i,j-1,r_len,c_len)+
        dfs(grid,i-1,j,r_len,c_len));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0 ; i<grid.length ; i++)
        {
            for(int j=0 ; j<grid[0].length ; j++)
            {
                if(grid[i][j] == 1)
                {
                    max = Math.max(max,dfs(grid,i,j,grid.length,grid[0].length));
                }
            }
        }
        return max;
    }
}