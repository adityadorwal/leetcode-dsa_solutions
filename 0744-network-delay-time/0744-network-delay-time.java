class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=n;i++)list.add(new ArrayList<>());

        for(int []i:times)
        {
            int u=i[0],v=i[1],w=i[2];
            list.get(u).add(new int[]{v,w});
        }

        
        int max=0,max_int=Integer.MAX_VALUE;
        PriorityQueue<int []> que = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int []dist = new int[n+1];
        Arrays.fill(dist,max_int);
        dist[k]=0;
        que.offer(new int[]{k,0});

        while(!que.isEmpty())
        {
            int arr[] = que.poll();
            int u=arr[0],w=arr[1];

            if(w == dist[u])
            {
                for(int []edge : list.get(u))
                {
                    int v=edge[0],d=edge[1]+w;
                    if(d<dist[v])
                    {
                        dist[v]=d;
                        que.offer(new int[]{v,d});
                    }
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            int a = dist[i];
            if(a==max_int)return -1;
            max=Math.max(max,a);
        }
        return max;
    }
}