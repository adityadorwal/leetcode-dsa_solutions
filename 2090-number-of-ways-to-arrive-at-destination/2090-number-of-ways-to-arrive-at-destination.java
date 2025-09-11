class Solution {
    public int countPaths(int n, int[][] roads) {
        // Step 1: Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        final int MOD = 1_000_000_007;
        long[] dist = new long[n];              // shortest distances
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];              // number of ways to reach each node
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});             // {node, distance}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node]) continue;       // skip outdated entry

            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                long newDist = d + edge[1];

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{next, newDist});
                } else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}