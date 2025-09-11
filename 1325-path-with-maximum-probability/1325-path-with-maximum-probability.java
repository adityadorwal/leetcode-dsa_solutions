class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double result=1,max=0;
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());

        int k=0;
        for(int []i:edges) 
        {
            list.get(i[0]).add(new int[]{i[1],k});
            list.get(i[1]).add(new int[]{i[0],k});
            k++;
        }
        
        PriorityQueue<double[]> que = new PriorityQueue<>((a,b) -> Double.compare(b[1],a[1]));
        double []dist = new double[n];
        dist[start_node] = 1;
        que.offer(new double[]{start_node,1});

        while(!que.isEmpty())
        {
            double arr[] = que.poll();
            int i = (int)arr[0];
            double d = arr[1];

            if(i == end_node) return d;

            for(int []a:list.get(i))
            {
                int nei = a[0];
                double dis = succProb[a[1]];
                double new_d = d*dis;

                if(new_d>dist[nei])
                {
                    dist[nei] = new_d;
                    que.offer(new double[]{nei,new_d});
                }
            }
        }
        return 0;
    }
}