class Solution {
    Integer []memo;
    int []dist;
    List<List<int []>> list;
    public int count_path(int u , int n)
    {
        if(u==n)return 1;
        if(memo[u] != null)return memo[u];

        long count =0;
        for(int []k: list.get(u))
        {
            int v = k[0];
            if(dist[u] > dist[v])
            {
                count += count_path(v,n);
                count %= 1000000007;
            }
        }
        memo[u] = (int)count;
        return memo[u];
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        list = new ArrayList<>();
        for(int i=0;i<=n;i++)list.add(new ArrayList<>());
        for(int []i:edges)
        {
            int u=i[0],v=i[1],w=i[2];
            list.get(u).add(new int[]{v,w});
            list.get(v).add(new int[]{u,w});
        }

        PriorityQueue<int []> que = new PriorityQueue<>((a,b)->a[1]-b[1]);
        dist= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        que.offer(new int[]{n,0});
        dist[n] = 0;

        while(!que.isEmpty())
        {
            int arr[] = que.poll();
            int u=arr[0],d=arr[1];

            if(d != dist[u])continue;

            for(int []k:list.get(u))
            {
                int a=k[0],b=k[1]+d;
                if(dist[a]>b)
                {
                    que.offer(new int[]{a,b});
                    dist[a] = b;
                }
            }
        }
        memo = new Integer[n+1];
        return count_path(1,n);
    }
}