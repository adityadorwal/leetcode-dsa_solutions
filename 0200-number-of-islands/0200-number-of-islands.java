class Solution {
    public void dfs(char[][] grid ,int i,int j, int r_len, int c_len )
    {
        if(i<0 || j<0 || i>=r_len || j>=c_len || grid[i][j]=='0')return;

        grid[i][j] = '0';

        dfs(grid,i-1,j,r_len,c_len);
        dfs(grid,i,j-1,r_len,c_len);
        dfs(grid,i,j+1,r_len,c_len);
        dfs(grid,i+1,j,r_len,c_len);
    }
    public int numIslands(char[][] grid) {
        int row_len = grid.length , col_len = grid[0].length;
        int islands =0;
        for(int i=0 ; i<row_len ; i++)
        {
            for(int j=0 ; j<col_len ; j++)
            {
                if(grid[i][j]=='1')
                {
                    islands++;
                    dfs(grid,i,j,row_len,col_len);
                }
            }
        }
        return islands;
    }
}