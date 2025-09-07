class Solution {
    int [][]dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new ArrayDeque<>();
        int m=grid.length,n=grid[0].length,no_of_fresh=0;

        for(int i=0;i<m;i++)for(int j=0;j<n;j++)
        {
            if(grid[i][j]==2)que.offer(new int[]{i,j});
            if(grid[i][j]==1)no_of_fresh++;
        }
        if(no_of_fresh==0)return 0;

        int min=0;
        while(!que.isEmpty())
        {
            boolean bool=false;
            int size=que.size();
            for(int i=0;i<size;i++)
            {
                int arr[]=que.poll();
                for(int []k:dirs)
                {
                    int a=k[0]+arr[0] , b=k[1]+arr[1];
                    if(a>=0 && b>=0 && a<m && b<n && grid[a][b]==1)
                    {
                        grid[a][b]=2;
                        que.offer(new int[]{a,b});
                        no_of_fresh--;
                        bool=true;
                    }
                }
            }
            if(bool)min++;
        }
        if(no_of_fresh != 0)return -1;
        return min;
    }
}