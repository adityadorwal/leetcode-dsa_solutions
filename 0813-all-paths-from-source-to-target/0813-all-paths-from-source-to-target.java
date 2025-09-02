class Solution {
    public void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> temp, int node) {
        temp.add(node);

        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(temp)); // store copy of path
        } else {
            for (int next : graph[node]) {
                dfs(graph, ans, temp, next);
            }
        }

        temp.remove(temp.size() - 1); // backtrack
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, ans, new ArrayList<>(), 0);
        return ans;
    }
}