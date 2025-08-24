class Pair {
    int node;
    int time;

    public Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

public class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int time = current.time;

            if (time > dist[u]) {
                continue;
            }

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int travelTime = neighbor.time;
                if (dist[u] + travelTime < dist[v]) {
                    dist[v] = dist[u] + travelTime;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        
        return maxTime;
    }
}
