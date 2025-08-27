/****************************************Graph Based solution *************************************** */
// class Solution {
//     public int dfs(int[][]grid , int i, int j, int r_len, int c_len)
//     {
//         if(i<0 || j<0 || i>=r_len || j>=c_len || grid[i][j]==0)return 1;
//         if(grid[i][j]==-1)return 0;
//         grid[i][j]=-1;
//         return (dfs(grid,i+1,j,r_len,c_len)+
//         dfs(grid,i,j+1,r_len,c_len)+
//         dfs(grid,i,j-1,r_len,c_len)+
//         dfs(grid,i-1,j,r_len,c_len));
//     }
//     public int islandPerimeter(int[][] grid) {
//         for(int i=0 ; i<grid.length ; i++)
//         {
//             for(int j=0 ; j<grid[0].length ; j++)
//             {
//                 if(grid[i][j] == 1)return dfs(grid,i,j,grid.length,grid[0].length);
//             }
//         }
//         return 0;
//     }
// }


/************************************FASt Mathmatical Solution*************************************** */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length , cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // Check the four sides of land cell
                    // Top
                    if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                    // Bottom
                    if (i == rows - 1 || grid[i + 1][j] == 0) perimeter++;
                    // Left
                    if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                    // Right
                    if (j == cols - 1 || grid[i][j + 1] == 0) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
