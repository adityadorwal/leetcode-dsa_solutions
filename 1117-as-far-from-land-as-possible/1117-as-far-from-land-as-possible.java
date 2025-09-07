class Solution {
    int [][]dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int calculate_direct(int[][] grid,Deque<int []> que, int m, int n)
    {
        if(que.isEmpty())return 0;
        int size=que.size();
        int max=0;
        for(int i=0;i<size;i++)
        {
            int arr[] = que.poll();
            int dist = (grid[arr[0]][arr[1]]==-1)?0:grid[arr[0]][arr[1]];
            for(int []k:dirs)
            {
                int a=arr[0]+k[0] , b=arr[1]+k[1];
                if(a>=0 && b>=0 && a<m && b<n && grid[a][b]==0)
                {
                    grid[a][b]=dist+1;
                    que.offer(new int[]{a,b});
                    max = Math.max(max,dist+1);
                }
            }
        }
        return Math.max(max,calculate_direct(grid,que,m,n));
    }
    public int maxDistance(int[][] grid) {
        Deque<int []> que = new ArrayDeque<>();
        int m=grid.length, n=grid[0].length;
        int count_0=0,max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1) 
                {
                    que.offer(new int[]{i,j});
                    grid[i][j]=-1;
                }
                else count_0++;
            }
        }
        if(que.isEmpty() || count_0==0)return -1;
        max = calculate_direct(grid,que,m,n);
        return max;
    }
}