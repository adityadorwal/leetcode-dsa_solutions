class Solution {
    List<List<Integer>> graph;
    boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Build adjacency list
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]); // undirected
        }

        // BFS using a queue
        visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == destination) return true;

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }

        return false;
    }
}
