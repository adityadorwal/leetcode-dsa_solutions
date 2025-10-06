class Solution {
    PriorityQueue<int []> que;
    int direction[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    int max=0;
    public void dfs(int n , int[][] grid)
    {
        int arr[] = que.poll();
        int i=arr[1] , j=arr[2];
        max = Math.max(max,arr[0]);

        if(i==n && j==n)return;

        grid[i][j] = -1;

        for(int k[]:direction)
        {
            int a = i+k[0] , b = j+k[1];
            if(a>=0 && b>=0 && a<=n && b<=n && grid[a][b]!=-1)
            que.offer(new int[]{grid[a][b],a,b});
        }
        if(!que.isEmpty())
        dfs(n,grid);
    }
    public int swimInWater(int[][] grid) {
        que = new PriorityQueue<>((a,b)->a[0]-b[0]);
        que.offer(new int[]{grid[0][0],0,0});

        dfs(grid.length-1,grid);
        return max;
    }
}