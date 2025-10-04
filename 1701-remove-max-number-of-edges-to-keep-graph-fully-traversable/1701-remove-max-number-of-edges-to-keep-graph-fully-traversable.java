class Solution {
    class DSU {
        int[] parent, rank;
        int count; // number of connected components

        DSU(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            count = n;
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false; // already connected
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
            count--;
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU dsuAlice = new DSU(n);
        DSU dsuBob = new DSU(n);

        int used = 0;

        // Step 1: Type 3 edges (both Alice & Bob)
        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean mergedAlice = dsuAlice.union(e[1], e[2]);
                boolean mergedBob = dsuBob.union(e[1], e[2]);
                if (mergedAlice || mergedBob) used++;
            }
        }

        // Step 2: Type 1 (Alice only)
        for (int[] e : edges) {
            if (e[0] == 1 && dsuAlice.union(e[1], e[2])) {
                used++;
            }
        }

        // Step 3: Type 2 (Bob only)
        for (int[] e : edges) {
            if (e[0] == 2 && dsuBob.union(e[1], e[2])) {
                used++;
            }
        }

        // Step 4: check connectivity
        if (dsuAlice.count > 1 || dsuBob.count > 1) return -1;

        return edges.length - used;
    }
}
