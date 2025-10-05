/*************************DFS Approch ********************* */

class Solution {
    int direct[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int[][] heights,boolean [][]visited , int i, int j, int r, int c)
    {
        visited[i][j]=true;
        for(int []arr:direct)
        {
            int a = arr[0]+i;
            int b = arr[1]+j;
            if(a>=0 && b>=0 && a<r && b<c && !visited[a][b] && heights[i][j]<=heights[a][b])
            {
                dfs(heights,visited,a,b,r,c);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int r=heights.length,c=heights[0].length;
        boolean [][]pacific = new boolean[r][c];
        boolean [][]atlantic = new boolean[r][c];
        
        for(int i=0;i<c;i++)
        {
            dfs(heights,pacific,0,i,r,c);
            dfs(heights,atlantic,r-1,i,r,c);
        }
        for(int i=0;i<r;i++)
        {
            dfs(heights,pacific,i,0,r,c);
            dfs(heights,atlantic,i,c-1,r,c);
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
}


/************************BFS   Approch****************** */

// class Solution {
//     int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

//     private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
//         int r = heights.length, c = heights[0].length;
//         while (!queue.isEmpty()) {
//             int[] cell = queue.poll();
//             int i = cell[0], j = cell[1];
//             for (int[] d : dirs) {
//                 int a = i + d[0];
//                 int b = j + d[1];
//                 if (a >= 0 && b >= 0 && a < r && b < c &&
//                     !visited[a][b] && heights[a][b] >= heights[i][j]) {
//                     visited[a][b] = true;
//                     queue.offer(new int[]{a,b});
//                 }
//             }
//         }
//     }

//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         int r = heights.length, c = heights[0].length;
//         boolean[][] pacific = new boolean[r][c];
//         boolean[][] atlantic = new boolean[r][c];
//         Queue<int[]> pacQueue = new ArrayDeque<>();
//         Queue<int[]> atlQueue = new ArrayDeque<>();

//         // Fill starting points
//         for (int i = 0; i < r; i++) {
//             pacific[i][0] = true; pacQueue.offer(new int[]{i,0});
//             atlantic[i][c-1] = true; atlQueue.offer(new int[]{i,c-1});
//         }
//         for (int j = 0; j < c; j++) {
//             pacific[0][j] = true; pacQueue.offer(new int[]{0,j});
//             atlantic[r-1][j] = true; atlQueue.offer(new int[]{r-1,j});
//         }

//         // BFS for both oceans
//         bfs(heights, pacific, pacQueue);
//         bfs(heights, atlantic, atlQueue);

//         List<List<Integer>> result = new ArrayList<>();
//         for (int i = 0; i < r; i++) {
//             for (int j = 0; j < c; j++) {
//                 if (pacific[i][j] && atlantic[i][j])
//                     result.add(Arrays.asList(i, j));
//             }
//         }
//         return result;
//     }
// }
