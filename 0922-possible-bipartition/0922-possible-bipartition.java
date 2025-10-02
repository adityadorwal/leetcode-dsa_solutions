class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]); // undirected edges
        }

        int[] color = new int[n + 1]; // 0 = uncolored, 1 & 2 = groups

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;

            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            color[i] = 1;

            while (!stack.isEmpty()) {
                int curr = stack.pop();
                int currColor = color[curr];
                int nextColor = (currColor == 1) ? 2 : 1;

                for (int nei : graph[curr]) {
                    if (color[nei] == 0) {
                        color[nei] = nextColor;
                        stack.push(nei);
                    } else if (color[nei] == currColor) {
                        return false; // conflict found
                    }
                }
            }
        }

        return true;
    }
}
