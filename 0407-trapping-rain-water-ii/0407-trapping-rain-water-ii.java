class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if(m<3 || n<3)return 0;
        PriorityQueue<int []> que = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<m;i++)
        {
            que.offer(new int[]{heightMap[i][0],i,0});
            que.offer(new int[]{heightMap[i][n-1],i,n-1});
            heightMap[i][0]=-1;
            heightMap[i][n-1]=-1;
        }
        for(int i=0;i<n;i++)
        {
            que.offer(new int[]{heightMap[0][i],0,i});
            que.offer(new int[]{heightMap[m-1][i],m-1,i});
            heightMap[0][i]=-1;
            heightMap[m-1][i]=-1;
        }
        
        int sum=0,max_num=0;
        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!que.isEmpty())
        {
            int arr[] = que.poll();
            int w=arr[0],i=arr[1],j=arr[2];
            max_num=Math.max(max_num,w);

            for(int []k:dir)
            {
                int a = i+k[0], b = j+k[1];
                if(a>0 && b>0 && a<m && b<n && heightMap[a][b]!=-1)
                {
                    int curr = heightMap[a][b];
                    if(curr<max_num) sum+= max_num-curr;
                    heightMap[a][b] = -1;
                    que.offer(new int[]{curr,a,b});
                }
            }
        }
        return sum;
    }
}