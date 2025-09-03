class Solution {
    int arr[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> que = new ArrayDeque<>();

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j] == 0)que.offer(new int[]{i,j});
                else mat[i][j]=-1;
            }
        }
        
        while(!que.isEmpty())
        {
            int[] curr = que.poll();
            for(int i[]:arr)
            {
                int a=i[0]+curr[0] , b=i[1]+curr[1];
                if(a>=0 && b>=0 && a<mat.length && b<mat[0].length && mat[a][b]==-1 )
                {
                    mat[a][b] = mat[curr[0]][curr[1]] + 1;
                    que.offer(new int[]{a,b});
                }
            }
        }
        return mat;
    }
}